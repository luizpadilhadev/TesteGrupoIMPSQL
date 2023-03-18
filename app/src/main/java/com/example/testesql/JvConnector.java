package com.example.testesql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JvConnector {

    public JvConnector() throws SQLException {
    }

    public static Connection connection(){
       Connection conn = null;
        return conn;
    }
    Class.forName("com.mysql.jdbc.Driver");
    String url = "jdbc:mysql://localhost:3306/ 192.168.1.6";
    String username = "root";
    String password = "admin123";
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", root, Admin123);
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM mytable");

}
