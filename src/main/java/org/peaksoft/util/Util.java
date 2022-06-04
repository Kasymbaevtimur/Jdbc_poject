package org.peaksoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД

    private static final String  url="jdbc:postgresql://localhost:5432/jdbc_project";
    private static final String userName="postgres";
    private static final String posword="timurlan0797";

    public static Connection connection(){
        Connection connection = null;
        try {
            connection= DriverManager.getConnection(url,userName,posword);
            System.out.println("Sucsesfully connected to Daaatabase !!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}