package com.kirill.app.controllers;

import org.springframework.stereotype.Repository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Admin on 08.07.2015.
 */
@Repository
public class MySQLConnector {

    private static String URL = "jdbc:mysql://localhost:3306/user_db";
    private static String USER = "root";
    private static String PASSWORD = "toor";
    private static Connection conn;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private MySQLConnector() {

    }

    public static Connection getConn() {
        return conn;
    }

    public static void closeConn() {

        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

//    private static Properties prop;
//    private static Connection conn;
//
//    static {
//        InputStream is = null;
//        try {
//            prop = new Properties();
//            is = ClassLoader.class.getResourceAsStream("/config.properties");
//            prop.load(is);
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection(prop.getProperty("URL"),prop.getProperty("username"), prop.getProperty("password"));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private MySQLConnector() {
//
//    }
//
//    public static Connection getConn() {
//        return conn;
//    }
//
//    public static void closeConn() {
//
//        try {
//            conn.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
}
