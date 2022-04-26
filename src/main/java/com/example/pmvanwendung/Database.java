package com.example.pmvanwendung;

import java.sql.*;

public class Database {

    private static final String location = Database.class.getResource("database.db").toExternalForm();

    public static Connection connect(){
        Connection connection;
        String dbPrefix = "jdbc:sqlite:";

        try {
            connection = DriverManager.getConnection(dbPrefix + location);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        System.out.println("Connected to SQLite database.");
        return connection;
    }

}
