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

    ///////////////////////////////

    public static void addUser(User user) {
        String query = "INSERT INTO users (username,password,name,surname) VALUES (?,?,?,?) ";
        System.out.println("User insert done.");


        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3, user.getName());
            preparedStatement.setString(4, user.getSurname());
            preparedStatement.executeUpdate();

            while (resultSet.next()) {

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return;
    }

    public static User getUserById(int id){
        String query = "SELECT username, password,name,surname FROM users WHERE userId = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                User user = new User(username, password, name, surname);
                //break; //this will be removed
                return user;
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static User getUserByUsername(String _username){
        String query = "SELECT userId, username, password,name,surname FROM users WHERE username = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,_username);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int userId = resultSet.getInt("userId");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                User user = new User(userId,username, password, name, surname);
                //break; //this will be removed
                return user;
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void removeUser(User user){
        String query = "DELETE FROM users WHERE name = ? AND surname = ?";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getSurname());
            //preparedStatement.executeUpdate();
            preparedStatement.execute();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void editUser(User oldUser, User newUser){
        String query = "UPDATE users SET username = ?, password = ?, name = ?, surname = ? WHERE userId = ?";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,newUser.getUsername());
            preparedStatement.setString(2,newUser.getPassword());
            preparedStatement.setString(3,newUser.getName());
            preparedStatement.setString(4,newUser.getSurname());
            preparedStatement.setInt(5,oldUser.getId());
            //preparedStatement.executeUpdate();
            preparedStatement.execute();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static ObservableList<User> getUsersList(){
        String query = "SELECT * FROM users";
        ObservableList<User> usersObservableList = FXCollections.observableArrayList();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                usersObservableList.add(new User(resultSet.getInt("userId"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("name"),
                        resultSet.getString("surname")));
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        return usersObservableList;
    }

    ///////////////////////////////

    public static void addStudent(Student student){
        String query = "INSERT INTO students (name, surname, registeredCourses) VALUES (?,?,?) ";
        System.out.println("Student insert done.");

        String registeredCourses = student.getRegisteredCoursesString();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setString(3, registeredCourses);
            preparedStatement.executeUpdate();

            while (resultSet.next()){

            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return;
    }

    public static void removeStudent(Student student){
        String query = "DELETE FROM students WHERE name = ? AND surname = ?";

        String name = student.getName();
        String surname = student.getSurname();

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

    public static Student getStudentByName(String name, String surname){
        String query = "SELECT studentId,name,surname,registeredCourses FROM students WHERE name = ? AND surname = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,surname);

            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                return new Student(resultSet.getInt("studentId"),resultSet.getString("name"),resultSet.getString("surname"),resultSet.getString("registeredCourses"));
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
                studentsObservableList.add(new Student(resultSet.getInt("studentId"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("registeredCourses")));
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        return studentsObservableList;
    }

    public static void addCourseToStudent(Student student, Course course){
        String query = "UPDATE students SET registeredCourses = ? WHERE name = ? AND surname = ?";  //TODO QUERY

        String newCoursesString = student.getRegisteredCoursesString() + course.getCourseId() + ","; //TODO This will be the new string with the new course appended into the previous ones.
        student.setRegisteredCoursesString(newCoursesString);


        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newCoursesString);
            preparedStatement.setString(2,student.getName());
            preparedStatement.setString(3,student.getSurname());
            preparedStatement.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return;
    }

    ///////////////////////////////

    public static void addCourse(Course course){
        String query = "INSERT INTO courses (courseName) VALUES (?) ";
        System.out.println("Course insert done.");



        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,course.getCourseName());
            preparedStatement.executeUpdate();

            while (resultSet.next()){

            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return;
    }

    public static void removeCourse(Course course){
        String query = "DELETE FROM courses WHERE courseId = ? AND courseName = ?";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, course.getCourseId());
            preparedStatement.setString(2,course.getCourseName());
            //preparedStatement.executeUpdate();
            preparedStatement.execute();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static ObservableList<Course> getCoursesList(){
        String query = "SELECT * FROM courses";
        ObservableList<Course> coursesObservableList = FXCollections.observableArrayList();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                coursesObservableList.add(new Course(resultSet.getInt("courseId"), resultSet.getString("courseName")));
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        return coursesObservableList;
    }

    public static Course getCourseByName(String courseName){
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

    public static Course getCourseById(int id){
        String query = "SELECT * FROM courses WHERE courseId = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
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

    public static ObservableList<Student> getStudentsListForCourse(Course course){
        String query = "SELECT * FROM students WHERE registeredCourses LIKE '%" + course.getCourseId() + ",%'" ;
        ObservableList<Student> studentsObservableList = FXCollections.observableArrayList();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                studentsObservableList.add(new Student(resultSet.getInt("studentId"), resultSet.getString("name"),resultSet.getString("surname"),resultSet.getString("registeredCourses")));
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        return studentsObservableList;
    }


    //NOT WORKING
    public static void removeCourseFromStudent(Student student, Course course){
        String query = "UPDATE students SET registeredCourses = REPLACE(registeredCourses, ?, '') WHERE name = ? AND surname = ? AND registeredCourses LIKE ('%?,%')";
        String modifiedCourseId;
        //String newRegisteredCourses;


        if (student.getRegisteredCoursesString().indexOf(course.getCourseId() + ",") == 0){
            //newRegisteredCourses = student.getRegisteredCoursesString().replace(course.getCourseId() + ",", "");
            modifiedCourseId = "" + course.getCourseId() + ",";
            query = "UPDATE students SET registeredCourses = REPLACE(registeredCourses, ?, '') WHERE name = ? AND surname = ? AND registeredCourses LIKE ('%" + course.getCourseId() + ",%')";
            System.out.println("if " + modifiedCourseId);
        }
        else{
            //newRegisteredCourses = student.getRegisteredCoursesString().replace("," + course.getCourseId() + ",", ",");
            modifiedCourseId = "," + course.getCourseId() + ",";
            query = "UPDATE students SET registeredCourses = REPLACE(registeredCourses, ?, ',') WHERE name = ? AND surname = ? AND registeredCourses LIKE ('%," + course.getCourseId() +",%')";
            System.out.println("else " + course.getCourseId());
        }


        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,modifiedCourseId);
            preparedStatement.setInt(2, course.getCourseId());
            preparedStatement.setString(3,student.getSurname());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
