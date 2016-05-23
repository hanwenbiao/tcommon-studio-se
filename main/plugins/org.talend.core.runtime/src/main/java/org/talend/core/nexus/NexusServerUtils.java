// ============================================================================
//
// Copyright (C) 2006-2016 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.core.nexus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.talend.commons.exception.ExceptionHandler;
import org.talend.commons.utils.network.NetworkUtil;
import org.talend.core.prefs.ITalendCorePrefConstants;
import org.talend.core.runtime.maven.MavenArtifact;
import org.talend.utils.ssl.SSLUtils;

/**
 * created by wchen on 2015-5-12 Detailled comment
 *
 */
public class NexusServerUtils {

    /**
     * 
     */
    public static final String ORG_TALEND_DESIGNER_CORE = "org.talend.designer.core"; //$NON-NLS-1$

    public static final int CONNECTION_OK = 200;

    // the max search result is 200 by defult from nexus
    private static final int MAX_SEARCH_COUNT = 200;

    /**
     * 
     * DOC check if the repository exist or not
     * 
     * @param nexusUrl
     * @param repositoryId
     * @param userName
     * @param password
     * @return
     */
    public static boolean checkConnectionStatus(String nexusUrl, String repositoryId, final String userName, final String password) {
        if (StringUtils.isEmpty(nexusUrl)) {
            return false;
        }
        final Authenticator defaultAuthenticator = NetworkUtil.getDefaultAuthenticator();
        if (userName != null && !"".equals(userName)) {
            Authenticator.setDefault(new Authenticator() {

                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(userName, password.toCharArray());
                }

            });
        }
        int status = -1;
        try {
            if (nexusUrl == null || "".equals(nexusUrl) || repositoryId == null || "".equals(repositoryId)) {
                return false;
            }
            String newUrl = nexusUrl;
            if (newUrl.endsWith(NexusConstants.SLASH)) {
                newUrl = newUrl.substring(0, newUrl.length() - 1);
            }
            String urlToCheck = newUrl + NexusConstants.CONTENT_REPOSITORIES + repositoryId;

            URL url = new URL(urlToCheck);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            if (urlConnection instanceof HttpsURLConnection) {
                String userDir = Platform.getInstallLocation().getURL().getPath();
                final SSLSocketFactory socketFactory = SSLUtils.getSSLContext(userDir).getSocketFactory();
                HttpsURLConnection httpsConnection = (HttpsURLConnection) urlConnection;
                httpsConnection.setSSLSocketFactory(socketFactory);
                httpsConnection.setHostnameVerifier(new HostnameVerifier() {

                    @Override
                    public boolean verify(String arg0, SSLSession arg1) {
                        return true;
                    }

                });
            }
            IEclipsePreferences node = InstanceScope.INSTANCE.getNode(ORG_TALEND_DESIGNER_CORE);
            int timeout = node.getInt(ITalendCorePrefConstants.NEXUS_TIMEOUT, 10000);

            urlConnection.setConnectTimeout(timeout);
            urlConnection.setReadTimeout(timeout);
            status = urlConnection.getResponseCode();
            if (status == CONNECTION_OK) {
                return true;
            }
        } catch (Exception e) {
            ExceptionHandler.process(e);
        } finally {
            Authenticator.setDefault(defaultAuthenticator);
        }
        return false;
    }

    public static List<MavenArtifact> search(String nexusUrl, String userName, String password, String repositoryId,
            String groupIdToSearch, String versionToSearch) throws Exception {
        List<MavenArtifact> artifacts = new ArrayList<MavenArtifact>();
        search(nexusUrl, userName, password, repositoryId, groupIdToSearch, null, versionToSearch, 0, MAX_SEARCH_COUNT, artifacts);

        return artifacts;

    }

    public static List<MavenArtifact> search(String nexusUrl, String userName, String password, String repositoryId,
            String groupIdToSearch, String artifactId, String versionToSearch) throws Exception {
        List<MavenArtifact> artifacts = new ArrayList<MavenArtifact>();
        search(nexusUrl, userName, password, repositoryId, groupIdToSearch, artifactId, versionToSearch, 0, MAX_SEARCH_COUNT,
                artifacts);

        return artifacts;

    }

    private static void search(String nexusUrl, final String userName, final String password, String repositoryId,
            String groupIdToSearch, String artifactId, String versionToSearch, int searchFrom, int searchCount,
            List<MavenArtifact> artifacts) throws Exception {
        HttpURLConnection urlConnection = null;
        int totalCount = 0;
        final Authenticator defaultAuthenticator = NetworkUtil.getDefaultAuthenticator();
        if (userName != null && !"".equals(userName)) {
            Authenticator.setDefault(new Authenticator() {

                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(userName, password.toCharArray());
                }

            });
        }
        try {
            String service = NexusConstants.SERVICES_SEARCH
                    + getSearchQuery(repositoryId, groupIdToSearch, artifactId, versionToSearch, searchFrom, searchCount);
            urlConnection = getHttpURLConnection(nexusUrl, service, userName, password);
            SAXReader saxReader = new SAXReader();

            InputStream inputStream = urlConnection.getInputStream();
            Document document = saxReader.read(inputStream);
            // test
            // writeDocument(document, new File("D:/search.txt"));
            Node countNode = document.selectSingleNode("/searchNGResponse/totalCount");
            if (countNode != null) {
                try {
                    totalCount = Integer.parseInt(countNode.getText());
                } catch (NumberFormatException e) {
                    totalCount = 0;
                }
            }

            List<Node> list = document.selectNodes("/searchNGResponse/data/artifact");//$NON-NLS-1$ 
            for (Node arNode : list) {
                MavenArtifact artifact = new MavenArtifact();
                artifacts.add(artifact);
                artifact.setGroupId(arNode.selectSingleNode("groupId").getText());//$NON-NLS-1$ 
                artifact.setArtifactId(arNode.selectSingleNode("artifactId").getText());//$NON-NLS-1$ 
                artifact.setVersion(arNode.selectSingleNode("version").getText());//$NON-NLS-1$ 
                Node descNode = arNode.selectSingleNode("description");//$NON-NLS-1$ 
                if (descNode != null) {
                    artifact.setDescription(descNode.getText());
                }
                Node urlNode = arNode.selectSingleNode("url");//$NON-NLS-1$ 
                if (urlNode != null) {
                    artifact.setUrl(urlNode.getText());
                }
                Node licenseNode = arNode.selectSingleNode("license");//$NON-NLS-1$ 
                if (licenseNode != null) {
                    artifact.setLicense(licenseNode.getText());
                }

                Node licenseUrlNode = arNode.selectSingleNode("licenseUrl");//$NON-NLS-1$ 
                if (licenseUrlNode != null) {
                    artifact.setLicenseUrl(licenseUrlNode.getText());
                }

                List<Node> artLinks = arNode.selectNodes("artifactHits/artifactHit/artifactLinks/artifactLink");//$NON-NLS-1$ 
                for (Node link : artLinks) {
                    Node extensionElement = link.selectSingleNode("extension");//$NON-NLS-1$ 
                    String extension = null;
                    String classifier = null;
                    if (extensionElement != null) {
                        if ("pom".equals(extensionElement.getText())) {//$NON-NLS-1$ 
                            continue;
                        }
                        extension = extensionElement.getText();
                    }
                    Node classifierElement = link.selectSingleNode("classifier");//$NON-NLS-1$ 
                    if (classifierElement != null) {
                        classifier = classifierElement.getText();
                    }
                    artifact.setType(extension);
                    artifact.setClassifier(classifier);
                }
            }
            int searchDone = searchFrom + searchCount;
            int count = MAX_SEARCH_COUNT;
            if (searchDone < totalCount) {
                if (totalCount - searchDone < MAX_SEARCH_COUNT) {
                    count = totalCount - searchDone;
                }
                search(nexusUrl, userName, password, repositoryId, groupIdToSearch, artifactId, versionToSearch, searchDone + 1,
                        count, artifacts);
            }

        } finally {
            Authenticator.setDefault(defaultAuthenticator);
            if (null != urlConnection) {
                urlConnection.disconnect();
            }
        }
    }

    public static String resolveSha1(String nexusUrl, final String userName, final String password, String repositoryId,
            String groupId, String artifactId, String version, String type) throws Exception {
        HttpURLConnection urlConnection = null;
        final Authenticator defaultAuthenticator = NetworkUtil.getDefaultAuthenticator();
        if (userName != null && !"".equals(userName)) {
            Authenticator.setDefault(new Authenticator() {

                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(userName, password.toCharArray());
                }

            });
        }
        try {
            String service = NexusConstants.SERVICES_RESOLVE + "a=" + artifactId + "&g=" + groupId + "&r=" + repositoryId + "&v="
                    + version + "&p=" + type;
            urlConnection = getHttpURLConnection(nexusUrl, service, userName, password);
            SAXReader saxReader = new SAXReader();

            InputStream inputStream = urlConnection.getInputStream();
            Document document = saxReader.read(inputStream);

            Node sha1Node = document.selectSingleNode("/artifact-resolution/data/sha1");
            String sha1 = null;
            if (sha1Node != null) {
                sha1 = sha1Node.getText();
            }
            return sha1;

        } catch (FileNotFoundException e) {
            // jar not existing on remote nexus
            return null;
        } finally {
            Authenticator.setDefault(defaultAuthenticator);
            if (null != urlConnection) {
                urlConnection.disconnect();
            }
        }
    }

    private static String getSearchQuery(String repositoryId, String groupId, String artifactId, String version, int from,
            int count) {
        String query = "";//$NON-NLS-1$ 
        if (repositoryId != null) {
            query = "repositoryId=" + repositoryId;//$NON-NLS-1$ 
        }
        if (groupId != null) {
            if (!"".equals(query)) {
                query = query + "&";
            }
            query = query + "g=" + groupId;//$NON-NLS-1$ 
        }
        if (artifactId != null) {
            if (!"".equals(query)) {
                query = query + "&";
            }
            query = query + "a=" + artifactId;//$NON-NLS-1$ 
        }

        if (version != null) {
            if (!"".equals(query)) {
                query = query + "&";
            }
            query = query + "v=" + version;//$NON-NLS-1$ 
        }

        return query + "&from=" + from + "&count=" + count;//$NON-NLS-1$ //$NON-NLS-2$ 
    }

    private static HttpURLConnection getHttpURLConnection(String nexusUrl, String restService, String userName, String password)
            throws Exception {
        if (!nexusUrl.endsWith(NexusConstants.SLASH)) {
            nexusUrl = nexusUrl + NexusConstants.SLASH;
        }
        URL url = new URL(nexusUrl + restService);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        if (urlConnection instanceof HttpsURLConnection) {
            String userDir = Platform.getInstallLocation().getURL().getPath();
            final SSLSocketFactory socketFactory = SSLUtils.getSSLContext(userDir).getSocketFactory();
            HttpsURLConnection httpsConnection = (HttpsURLConnection) urlConnection;
            httpsConnection.setSSLSocketFactory(socketFactory);
            httpsConnection.setHostnameVerifier(new HostnameVerifier() {

                @Override
                public boolean verify(String arg0, SSLSession arg1) {
                    return true;
                }

            });
        }
        IEclipsePreferences node = InstanceScope.INSTANCE.getNode(ORG_TALEND_DESIGNER_CORE);
        int timeout = node.getInt(ITalendCorePrefConstants.NEXUS_TIMEOUT, 10000);
        urlConnection.setConnectTimeout(timeout);
        return urlConnection;
    }

    private static void writeDocument(Document document, File file) throws IOException {
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        XMLWriter writer = null;
        try {
            writer = new XMLWriter(new FileWriter(file), format);
            writer.write(document);
        } finally {
            if (writer != null) {
                writer.close();
            }
        }

    }

}
