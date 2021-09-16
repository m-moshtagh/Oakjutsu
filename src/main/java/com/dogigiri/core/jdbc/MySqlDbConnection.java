package com.dogigiri.core.jdbc;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

public class MySqlDbConnection {
    private static BasicDataSource dataSource = new BasicDataSource();
    private static final Logger logger = LoggerFactory.getLogger(MySqlDbConnection.class);
    private static final Properties properties = new Properties();
    static {
        try {
            properties.load(new FileInputStream("src/main/resources/dbconfig.properties"));
        } catch (Exception exception) {
            exception.printStackTrace();
            logger.debug("DB configuration file not found!");
        }
        dataSource.setDriverClassName((String)properties.get("driverClassName"));
        dataSource.setUrl((String)properties.get("url"));
        dataSource.setUsername((String)properties.get("username"));
        dataSource.setPassword((String)properties.get("password"));
        dataSource.setMaxTotal(50);
        dataSource.setMaxIdle(5);
    }

    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (Exception exception) {
            exception.printStackTrace();
            logger.info("\nCan't connect to Database, please check your DB credentials as well as " +
                    " your DB instance status.");
            return null;
        }
    }
}
