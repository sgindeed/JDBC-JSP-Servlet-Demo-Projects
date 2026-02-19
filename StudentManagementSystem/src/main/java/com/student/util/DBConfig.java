package com.student.util;
import java.sql.*;

public class DBConfig {
    private static final String URL = "jdbc:derby:studentDB;create=true";

    public static Connection getConnection() throws Exception {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        return DriverManager.getConnection(URL);
    }

    public static void initializeDB() {
        try (Connection conn = getConnection(); Statement st = conn.createStatement()) {
            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, "STUDENT", null);
            if (!tables.next()) {
                st.executeUpdate("CREATE TABLE STUDENT (STUD_ID INT, NAME VARCHAR(50), ADDRESS VARCHAR(100), BRANCH VARCHAR(20))");
            }
        } catch (Exception e) { e.printStackTrace(); }
    }
}