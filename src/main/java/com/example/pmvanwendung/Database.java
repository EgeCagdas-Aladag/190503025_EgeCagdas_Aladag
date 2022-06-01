package com.example.pmvanwendung;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

    public static ObservableList<Student> getStudentsList(){
        String query = "SELECT * FROM students";
        ObservableList<Student> studentsObservableList = FXCollections.observableArrayList();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                studentsObservableList.add(new Student(resultSet.getInt("studentId"), resultSet.getString("name"),resultSet.getString("surname")));
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        return studentsObservableList;
    }

    public static void removeStudent(String name, String surname){
        String query = "DELETE FROM students WHERE name = ? AND surname = ?";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,surname);
            //preparedStatement.executeUpdate();
            preparedStatement.execute();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static Course getCourse(String courseName){
        String query = "SELECT * FROM courses WHERE courseName = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, courseName);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                return new Course(resultSet.getInt("courseId"),resultSet.getString("courseName"));
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Course addStudent(Student student){
        String query = "INSERT INTO students (name, surname, registeredCourses) VALUES (?,?,?) ";
        System.out.println("Insert done.");

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            //TODO: preparedStatement.setString(); courses
            preparedStatement.executeUpdate();

            while (resultSet.next()){

            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
