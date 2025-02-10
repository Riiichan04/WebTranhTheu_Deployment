package com.example.webtranhtheu_ltweb_nlu_nhom26.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBProperties {
//    private static Properties properties = new Properties();
    Connection connection = null;

    //Load connection
//    static {
//        try {
//            properties.load(DBProperties.class.getClassLoader().getResourceAsStream("db.properties"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    //Singleton
    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                createConnection();
            }
            return connection;
        } catch (SQLException e) {
            return null;
        }
    }

    private void createConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + DBProperties.getHost() + ":" + DBProperties.getPort() + "/" + DBProperties.getDbName() + "?" + DBProperties.getOption(),
                    DBProperties.getUsername(), DBProperties.getPassword());
        } catch (ClassNotFoundException e) {
            return;
        }
    }

    public static String getHost() {
        return System.getenv("db.host");
    }

    public static String getPort() {
        return System.getenv("db.port");
    }

    public static String getUsername() {
        return System.getenv("db.username");
    }

    public static String getPassword() {
        return System.getenv("db.password");
    }

    public static String getDbName() {
        return System.getenv("db.name");
    }

    public static String getOption() {
        return System.getenv("db.options");
    }
}

