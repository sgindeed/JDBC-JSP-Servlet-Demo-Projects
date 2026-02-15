package com.bank.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

    private static final String URL = "jdbc:derby:C:\\Users\\91912\\hospitaldb;create=true";

    public static Connection getConnection() throws Exception {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}