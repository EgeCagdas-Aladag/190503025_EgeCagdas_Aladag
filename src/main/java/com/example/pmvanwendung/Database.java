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
            System.out.println("Connected to SQLite database.");
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return connection;
    }

    public static boolean checkLogin(String username, String password){
        String query = "SELECT username, password FROM users WHERE username = ? AND password = ?;";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);


            resultSet = preparedStatement.executeQuery();

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


    //TODO: Change below function from username & password to name & surname after Database changes
    public static Person getUser(int id){
        String query = "SELECT username, password FROM users WHERE userId = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                Person person = new Person(username, password);
                //break; //this will be removed
                return person;
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

}
