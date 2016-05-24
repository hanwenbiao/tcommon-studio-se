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
package org.talend.core.database.conn;

import static org.junit.Assert.*;

import org.junit.Test;
import org.talend.core.model.metadata.builder.connection.ConnectionFactory;
import org.talend.core.model.metadata.builder.connection.DatabaseConnection;
import org.talend.core.model.metadata.connection.hive.HiveModeInfo;

/**
 * created by cmeng on May 20, 2016
 * Detailled comment
 *
 */
@SuppressWarnings("nls")
public class DatabaseConnStrUtilTest {

    private static final String HIVE2_STANDARDLONE_URL = "jdbc:hive2://server:10000/default";

    private DatabaseConnection createDatabaseConnection() {
        DatabaseConnection databaseConnection = null;

        databaseConnection = ConnectionFactory.eINSTANCE.createDatabaseConnection();

        databaseConnection.getParameters().put(ConnParameterKeys.CONN_PARA_KEY_USE_KRB, "false");

        return databaseConnection;
    }

    @Test
    public void testGetURLStringForStandardalone() {
        String server = "server";
        String port = "10000";
        String sidOrDatabase = "default";
        String trustStorePath = "/home/user/truststore";
        String trustStorePassword = "pwd123";
        String additionalJDBCSettings = "additionalJDBCSettings123";
        String expectValue = "jdbc:hive2://" + server + ":" + port + "/" + sidOrDatabase + ";ssl=true;sslTrustStore="
                + trustStorePath + ";trustStorePassword=encrypted;" + additionalJDBCSettings;
        DatabaseConnection dc = createDatabaseConnection();
        dc.getParameters().put(ConnParameterKeys.CONN_PARA_KEY_USE_SSL, "true");
        dc.getParameters().put(ConnParameterKeys.CONN_PARA_KEY_SSL_TRUST_STORE_PATH, trustStorePath);
        dc.getParameters().put(ConnParameterKeys.CONN_PARA_KEY_SSL_TRUST_STORE_PASSWORD, trustStorePassword);
        dc.getParameters().put(ConnParameterKeys.CONN_PARA_KEY_HIVE_ADDITIONAL_JDBC_SETTINGS, additionalJDBCSettings);
        String realValue = DatabaseConnStrUtil.getHiveURLStringForStandardalone(expectValue, dc, server, port, sidOrDatabase);
        assertTrue(expectValue.equals(realValue));

        dc.getParameters().put(ConnParameterKeys.CONN_PARA_KEY_HIVE_ADDITIONAL_JDBC_SETTINGS, "");
        expectValue = "jdbc:hive2://" + server + ":" + port + "/" + sidOrDatabase + ";ssl=true;sslTrustStore=" + trustStorePath
                + ";trustStorePassword=encrypted";
        realValue = DatabaseConnStrUtil.getHiveURLStringForStandardalone(expectValue, dc, server, port, sidOrDatabase);
        assertTrue(expectValue.equals(realValue));

        dc.getParameters().put(ConnParameterKeys.CONN_PARA_KEY_USE_SSL, "false");
        expectValue = "jdbc:hive2://" + server + ":" + port + "/" + sidOrDatabase;
        realValue = DatabaseConnStrUtil.getHiveURLStringForStandardalone(expectValue, dc, server, port, sidOrDatabase);
        assertTrue(expectValue.equals(realValue));

        dc.getParameters().put(ConnParameterKeys.CONN_PARA_KEY_HIVE_ADDITIONAL_JDBC_SETTINGS, additionalJDBCSettings);
        expectValue = "jdbc:hive2://" + server + ":" + port + "/" + sidOrDatabase + ";" + additionalJDBCSettings;
        realValue = DatabaseConnStrUtil.getHiveURLStringForStandardalone(expectValue, dc, server, port, sidOrDatabase);
        assertTrue(expectValue.equals(realValue));

    }

    @Test
    public void testGetHiveURLString() {
        String server = "server";
        String port = "10000";
        String sidOrDatabase = "default";
        String trustStorePath = "/home/user/truststore";
        String trustStorePassword = "pwd123";
        String additionalJDBCSettings = "additionalJDBCSettings123";
        String expectValue = "jdbc:hive2://" + server + ":" + port + "/" + sidOrDatabase + ";ssl=true;sslTrustStore="
                + trustStorePath + ";trustStorePassword=" + trustStorePassword + ";" + additionalJDBCSettings;

        DatabaseConnection dc = createDatabaseConnection();
        dc.getParameters().put(ConnParameterKeys.CONN_PARA_KEY_USE_SSL, "true");
        dc.getParameters().put(ConnParameterKeys.CONN_PARA_KEY_SSL_TRUST_STORE_PATH, trustStorePath);
        dc.getParameters().put(ConnParameterKeys.CONN_PARA_KEY_SSL_TRUST_STORE_PASSWORD, trustStorePassword);
        dc.getParameters().put(ConnParameterKeys.CONN_PARA_KEY_HIVE_ADDITIONAL_JDBC_SETTINGS, additionalJDBCSettings);
        dc.getParameters().put(ConnParameterKeys.CONN_PARA_KEY_HIVE_MODE, HiveModeInfo.STANDALONE.getName());

        String realValue = DatabaseConnStrUtil.getHiveURLString(dc, server, port, sidOrDatabase, HIVE2_STANDARDLONE_URL);
        assertTrue(expectValue.equals(realValue));

        dc.getParameters().put(ConnParameterKeys.CONN_PARA_KEY_HIVE_ADDITIONAL_JDBC_SETTINGS, "");
        expectValue = "jdbc:hive2://" + server + ":" + port + "/" + sidOrDatabase + ";ssl=true;sslTrustStore=" + trustStorePath
                + ";trustStorePassword=" + trustStorePassword;
        realValue = DatabaseConnStrUtil.getHiveURLString(dc, server, port, sidOrDatabase, HIVE2_STANDARDLONE_URL);
        assertTrue(expectValue.equals(realValue));

        dc.getParameters().put(ConnParameterKeys.CONN_PARA_KEY_USE_SSL, "false");
        expectValue = "jdbc:hive2://" + server + ":" + port + "/" + sidOrDatabase;
        realValue = DatabaseConnStrUtil.getHiveURLString(dc, server, port, sidOrDatabase, HIVE2_STANDARDLONE_URL);
        assertTrue(expectValue.equals(realValue));

        dc.getParameters().put(ConnParameterKeys.CONN_PARA_KEY_HIVE_ADDITIONAL_JDBC_SETTINGS, additionalJDBCSettings);
        expectValue = "jdbc:hive2://" + server + ":" + port + "/" + sidOrDatabase + ";" + additionalJDBCSettings;
        realValue = DatabaseConnStrUtil.getHiveURLString(dc, server, port, sidOrDatabase, HIVE2_STANDARDLONE_URL);
        assertTrue(expectValue.equals(realValue));
    }
}
