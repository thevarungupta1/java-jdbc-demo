package com.thevarungupta;

import java.sql.*;
import java.util.*;

public class ConnectionFactory {
    private static Connection con = null;

    public static Connection getConnection() throws SQLException {
        if(con ==null){
            ResourceBundle bundle = ResourceBundle.getBundle("JDBCDemo/dbConfig");
            String dc = bundle.getString("driverClass");
            String url = bundle.getString("url");
            String username = bundle.getString("username");
            String password =  bundle.getString("password");

            con = DriverManager.getConnection(url, username, password);
        }
        return con;
    }
}
