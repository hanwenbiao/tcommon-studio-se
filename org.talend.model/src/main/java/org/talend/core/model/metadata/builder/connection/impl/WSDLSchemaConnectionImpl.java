/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.core.model.metadata.builder.connection.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.talend.core.model.metadata.builder.connection.ConnectionFactory;
import org.talend.core.model.metadata.builder.connection.ConnectionPackage;
import org.talend.core.model.metadata.builder.connection.WSDLSchemaConnection;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>WSDL Schema Connection</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.talend.core.model.metadata.builder.connection.impl.WSDLSchemaConnectionImpl#getWSDL <em>WSDL</em>}</li>
 * <li>{@link org.talend.core.model.metadata.builder.connection.impl.WSDLSchemaConnectionImpl#isNeedAuth <em>Need Auth</em>}</li>
 * <li>{@link org.talend.core.model.metadata.builder.connection.impl.WSDLSchemaConnectionImpl#getMethodName <em>Method Name</em>}</li>
 * <li>{@link org.talend.core.model.metadata.builder.connection.impl.WSDLSchemaConnectionImpl#getParameters <em>Parameters</em>}</li>
 * <li>{@link org.talend.core.model.metadata.builder.connection.impl.WSDLSchemaConnectionImpl#getUserName <em>User Name</em>}</li>
 * <li>{@link org.talend.core.model.metadata.builder.connection.impl.WSDLSchemaConnectionImpl#getPassword <em>Password</em>}</li>
 * <li>{@link org.talend.core.model.metadata.builder.connection.impl.WSDLSchemaConnectionImpl#isUseProxy <em>Use Proxy</em>}</li>
 * <li>{@link org.talend.core.model.metadata.builder.connection.impl.WSDLSchemaConnectionImpl#getProxyHost <em>Proxy Host</em>}</li>
 * <li>{@link org.talend.core.model.metadata.builder.connection.impl.WSDLSchemaConnectionImpl#getProxyPort <em>Proxy Port</em>}</li>
 * <li>{@link org.talend.core.model.metadata.builder.connection.impl.WSDLSchemaConnectionImpl#getProxyUser <em>Proxy User</em>}</li>
 * <li>{@link org.talend.core.model.metadata.builder.connection.impl.WSDLSchemaConnectionImpl#getProxyPassword <em>Proxy Password</em>}</li>
 * <li>{@link org.talend.core.model.metadata.builder.connection.impl.WSDLSchemaConnectionImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class WSDLSchemaConnectionImpl extends ConnectionImpl implements WSDLSchemaConnection {

    /**
     * The default value of the '{@link #getWSDL() <em>WSDL</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getWSDL()
     * @generated
     * @ordered
     */
    protected static final String WSDL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getWSDL() <em>WSDL</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getWSDL()
     * @generated
     * @ordered
     */
    protected String wsdl = WSDL_EDEFAULT;

    /**
     * The default value of the '{@link #isNeedAuth() <em>Need Auth</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #isNeedAuth()
     * @generated
     * @ordered
     */
    protected static final boolean NEED_AUTH_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isNeedAuth() <em>Need Auth</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #isNeedAuth()
     * @generated
     * @ordered
     */
    protected boolean needAuth = NEED_AUTH_EDEFAULT;

    /**
     * The default value of the '{@link #getMethodName() <em>Method Name</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getMethodName()
     * @generated
     * @ordered
     */
    protected static final String METHOD_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getMethodName() <em>Method Name</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getMethodName()
     * @generated
     * @ordered
     */
    protected String methodName = METHOD_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getParameters() <em>Parameters</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getParameters()
     * @generated
     * @ordered
     */
    protected static final ArrayList PARAMETERS_EDEFAULT = (ArrayList) ConnectionFactory.eINSTANCE.createFromString(
            ConnectionPackage.eINSTANCE.getList(), "");

    /**
     * The cached value of the '{@link #getParameters() <em>Parameters</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getParameters()
     */
    protected ArrayList parameters = (ArrayList) PARAMETERS_EDEFAULT.clone();

    protected HashMap properties = (HashMap) PROPERTIES_EDEFAULT.clone();

    /**
     * The default value of the '{@link #getUserName() <em>User Name</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getUserName()
     * @generated
     * @ordered
     */
    protected static final String USER_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getUserName() <em>User Name</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getUserName()
     * @generated
     * @ordered
     */
    protected String userName = USER_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getPassword() <em>Password</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getPassword()
     * @generated
     * @ordered
     */
    protected static final String PASSWORD_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPassword() <em>Password</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getPassword()
     * @generated
     * @ordered
     */
    protected String password = PASSWORD_EDEFAULT;

    /**
     * The default value of the '{@link #isUseProxy() <em>Use Proxy</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #isUseProxy()
     * @generated
     * @ordered
     */
    protected static final boolean USE_PROXY_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isUseProxy() <em>Use Proxy</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #isUseProxy()
     * @generated
     * @ordered
     */
    protected boolean useProxy = USE_PROXY_EDEFAULT;

    /**
     * The default value of the '{@link #getProxyHost() <em>Proxy Host</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getProxyHost()
     * @generated
     * @ordered
     */
    protected static final String PROXY_HOST_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getProxyHost() <em>Proxy Host</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getProxyHost()
     * @generated
     * @ordered
     */
    protected String proxyHost = PROXY_HOST_EDEFAULT;

    /**
     * The default value of the '{@link #getProxyPort() <em>Proxy Port</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getProxyPort()
     * @generated
     * @ordered
     */
    protected static final String PROXY_PORT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getProxyPort() <em>Proxy Port</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getProxyPort()
     * @generated
     * @ordered
     */
    protected String proxyPort = PROXY_PORT_EDEFAULT;

    /**
     * The default value of the '{@link #getProxyUser() <em>Proxy User</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getProxyUser()
     * @generated
     * @ordered
     */
    protected static final String PROXY_USER_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getProxyUser() <em>Proxy User</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getProxyUser()
     * @generated
     * @ordered
     */
    protected String proxyUser = PROXY_USER_EDEFAULT;

    /**
     * The default value of the '{@link #getProxyPassword() <em>Proxy Password</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getProxyPassword()
     * @generated
     * @ordered
     */
    protected static final String PROXY_PASSWORD_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getProxyPassword() <em>Proxy Password</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getProxyPassword()
     * @generated
     * @ordered
     */
    protected String proxyPassword = PROXY_PASSWORD_EDEFAULT;

    /**
     * The cached value of the '{@link #getValue() <em>Value</em>}' attribute list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getValue()
     * @generated
     * @ordered
     */
    protected EList value;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected WSDLSchemaConnectionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected EClass eStaticClass() {
        return ConnectionPackage.Literals.WSDL_SCHEMA_CONNECTION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getWSDL() {
        return wsdl;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setWSDL(String newWSDL) {
        String oldWSDL = wsdl;
        wsdl = newWSDL;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConnectionPackage.WSDL_SCHEMA_CONNECTION__WSDL, oldWSDL, wsdl));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean isNeedAuth() {
        return needAuth;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setNeedAuth(boolean newNeedAuth) {
        boolean oldNeedAuth = needAuth;
        needAuth = newNeedAuth;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConnectionPackage.WSDL_SCHEMA_CONNECTION__NEED_AUTH,
                    oldNeedAuth, needAuth));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setMethodName(String newMethodName) {
        String oldMethodName = methodName;
        methodName = newMethodName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConnectionPackage.WSDL_SCHEMA_CONNECTION__METHOD_NAME,
                    oldMethodName, methodName));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ArrayList getParameters() {
        return parameters;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setParameters(ArrayList newParameters) {
        ArrayList oldParameters = parameters;
        parameters = newParameters;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConnectionPackage.WSDL_SCHEMA_CONNECTION__PARAMETERS,
                    oldParameters, parameters));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setUserName(String newUserName) {
        String oldUserName = userName;
        userName = newUserName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConnectionPackage.WSDL_SCHEMA_CONNECTION__USER_NAME,
                    oldUserName, userName));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getPassword() {
        return password;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setPassword(String newPassword) {
        String oldPassword = password;
        password = newPassword;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConnectionPackage.WSDL_SCHEMA_CONNECTION__PASSWORD,
                    oldPassword, password));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean isUseProxy() {
        return useProxy;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setUseProxy(boolean newUseProxy) {
        boolean oldUseProxy = useProxy;
        useProxy = newUseProxy;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConnectionPackage.WSDL_SCHEMA_CONNECTION__USE_PROXY,
                    oldUseProxy, useProxy));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getProxyHost() {
        return proxyHost;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setProxyHost(String newProxyHost) {
        String oldProxyHost = proxyHost;
        proxyHost = newProxyHost;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConnectionPackage.WSDL_SCHEMA_CONNECTION__PROXY_HOST,
                    oldProxyHost, proxyHost));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getProxyPort() {
        return proxyPort;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setProxyPort(String newProxyPort) {
        String oldProxyPort = proxyPort;
        proxyPort = newProxyPort;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConnectionPackage.WSDL_SCHEMA_CONNECTION__PROXY_PORT,
                    oldProxyPort, proxyPort));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getProxyUser() {
        return proxyUser;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setProxyUser(String newProxyUser) {
        String oldProxyUser = proxyUser;
        proxyUser = newProxyUser;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConnectionPackage.WSDL_SCHEMA_CONNECTION__PROXY_USER,
                    oldProxyUser, proxyUser));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getProxyPassword() {
        return proxyPassword;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setProxyPassword(String newProxyPassword) {
        String oldProxyPassword = proxyPassword;
        proxyPassword = newProxyPassword;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConnectionPackage.WSDL_SCHEMA_CONNECTION__PROXY_PASSWORD,
                    oldProxyPassword, proxyPassword));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList getValue() {
        if (value == null) {
            value = new EDataTypeUniqueEList(String.class, this, ConnectionPackage.WSDL_SCHEMA_CONNECTION__VALUE);
        }
        return value;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__WSDL:
            return getWSDL();
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__NEED_AUTH:
            return isNeedAuth() ? Boolean.TRUE : Boolean.FALSE;
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__METHOD_NAME:
            return getMethodName();
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__PARAMETERS:
            return getParameters();
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__USER_NAME:
            return getUserName();
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__PASSWORD:
            return getPassword();
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__USE_PROXY:
            return isUseProxy() ? Boolean.TRUE : Boolean.FALSE;
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__PROXY_HOST:
            return getProxyHost();
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__PROXY_PORT:
            return getProxyPort();
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__PROXY_USER:
            return getProxyUser();
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__PROXY_PASSWORD:
            return getProxyPassword();
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__VALUE:
            return getValue();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__WSDL:
            setWSDL((String) newValue);
            return;
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__NEED_AUTH:
            setNeedAuth(((Boolean) newValue).booleanValue());
            return;
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__METHOD_NAME:
            setMethodName((String) newValue);
            return;
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__PARAMETERS:
            setParameters((ArrayList) newValue);
            return;
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__USER_NAME:
            setUserName((String) newValue);
            return;
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__PASSWORD:
            setPassword((String) newValue);
            return;
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__USE_PROXY:
            setUseProxy(((Boolean) newValue).booleanValue());
            return;
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__PROXY_HOST:
            setProxyHost((String) newValue);
            return;
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__PROXY_PORT:
            setProxyPort((String) newValue);
            return;
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__PROXY_USER:
            setProxyUser((String) newValue);
            return;
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__PROXY_PASSWORD:
            setProxyPassword((String) newValue);
            return;
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__VALUE:
            getValue().clear();
            getValue().addAll((Collection) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void eUnset(int featureID) {
        switch (featureID) {
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__WSDL:
            setWSDL(WSDL_EDEFAULT);
            return;
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__NEED_AUTH:
            setNeedAuth(NEED_AUTH_EDEFAULT);
            return;
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__METHOD_NAME:
            setMethodName(METHOD_NAME_EDEFAULT);
            return;
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__PARAMETERS:
            setParameters(PARAMETERS_EDEFAULT);
            return;
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__USER_NAME:
            setUserName(USER_NAME_EDEFAULT);
            return;
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__PASSWORD:
            setPassword(PASSWORD_EDEFAULT);
            return;
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__USE_PROXY:
            setUseProxy(USE_PROXY_EDEFAULT);
            return;
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__PROXY_HOST:
            setProxyHost(PROXY_HOST_EDEFAULT);
            return;
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__PROXY_PORT:
            setProxyPort(PROXY_PORT_EDEFAULT);
            return;
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__PROXY_USER:
            setProxyUser(PROXY_USER_EDEFAULT);
            return;
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__PROXY_PASSWORD:
            setProxyPassword(PROXY_PASSWORD_EDEFAULT);
            return;
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__VALUE:
            getValue().clear();
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__WSDL:
            return WSDL_EDEFAULT == null ? wsdl != null : !WSDL_EDEFAULT.equals(wsdl);
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__NEED_AUTH:
            return needAuth != NEED_AUTH_EDEFAULT;
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__METHOD_NAME:
            return METHOD_NAME_EDEFAULT == null ? methodName != null : !METHOD_NAME_EDEFAULT.equals(methodName);
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__PARAMETERS:
            return PARAMETERS_EDEFAULT == null ? parameters != null : !PARAMETERS_EDEFAULT.equals(parameters);
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__USER_NAME:
            return USER_NAME_EDEFAULT == null ? userName != null : !USER_NAME_EDEFAULT.equals(userName);
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__PASSWORD:
            return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__USE_PROXY:
            return useProxy != USE_PROXY_EDEFAULT;
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__PROXY_HOST:
            return PROXY_HOST_EDEFAULT == null ? proxyHost != null : !PROXY_HOST_EDEFAULT.equals(proxyHost);
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__PROXY_PORT:
            return PROXY_PORT_EDEFAULT == null ? proxyPort != null : !PROXY_PORT_EDEFAULT.equals(proxyPort);
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__PROXY_USER:
            return PROXY_USER_EDEFAULT == null ? proxyUser != null : !PROXY_USER_EDEFAULT.equals(proxyUser);
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__PROXY_PASSWORD:
            return PROXY_PASSWORD_EDEFAULT == null ? proxyPassword != null : !PROXY_PASSWORD_EDEFAULT.equals(proxyPassword);
        case ConnectionPackage.WSDL_SCHEMA_CONNECTION__VALUE:
            return value != null && !value.isEmpty();
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String toString() {
        if (eIsProxy())
            return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (WSDL: ");
        result.append(wsdl);
        result.append(", needAuth: ");
        result.append(needAuth);
        result.append(", methodName: ");
        result.append(methodName);
        result.append(", parameters: ");
        result.append(parameters);
        result.append(", UserName: ");
        result.append(userName);
        result.append(", Password: ");
        result.append(password);
        result.append(", useProxy: ");
        result.append(useProxy);
        result.append(", proxyHost: ");
        result.append(proxyHost);
        result.append(", proxyPort: ");
        result.append(proxyPort);
        result.append(", proxyUser: ");
        result.append(proxyUser);
        result.append(", proxyPassword: ");
        result.append(proxyPassword);
        result.append(", Value: ");
        result.append(value);
        result.append(')');
        return result.toString();
    }

} // WSDLSchemaConnectionImpl
