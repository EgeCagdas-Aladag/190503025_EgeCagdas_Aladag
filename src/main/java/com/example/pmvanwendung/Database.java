package com.example.pmvanwendung;

import java.sql.*;

public class Database {

    private static final String location = Database.class.getResource("database.db").toExternalForm();

    private static Connection connection;
    private static Statement statement;

    private static ResultSet resultSet;


    public static Connection connect(){
        //Connection connection;
        String dbPrefix = "jdbc:sqlite:";

        try {
            connection = DriverManager.getConnection(dbPrefix + location);
            statement = connection.createStatement();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        System.out.println("Connected to SQLite database.");
        return connection;
    }

    public static boolean checkLogin(String username, String password){
        String query = "SELECT username, password FROM users"
                + " WHERE username = " + "'" + username + "'" + " AND password = " + "'" +  password + "'" + ";";

        try{
            resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                System.out.println("Login validated!");
                return true;
            }
            return false;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        return false;
    }

}
