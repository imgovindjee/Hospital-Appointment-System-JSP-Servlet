package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection connection;

    public static Connection getConnection() {
        try {
//             ESTABLISHING THE DRIVER CLASS
            Class.forName("com.mysql.cj.jdbc.Driver");

//            CREATING A CONNECTION
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/doctorappointmentbooking", "root", "$Govindjee123_");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }
}
