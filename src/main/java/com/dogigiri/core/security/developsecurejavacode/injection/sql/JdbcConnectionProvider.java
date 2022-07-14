package com.dogigiri.core.security.developsecurejavacode.injection.sql;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class JdbcConnectionProvider {

    private final Yaml ymlFile = new Yaml();
    private Connection connection;

    public JdbcConnectionProvider() {
        try {
            var yml = readYml();
            connection = DriverManager.getConnection(yml.get("url"), yml.get("username"),
                    yml.get("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public Map<String, String> readYml() {
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("db-config.yml");
        return ymlFile.load(inputStream);
    }
}
