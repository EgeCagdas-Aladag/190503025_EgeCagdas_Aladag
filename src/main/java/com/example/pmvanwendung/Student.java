package com.example.pmvanwendung;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Student extends Person{

    private int studentId;
    private ObservableList<Course> registeredCourses = FXCollections.observableArrayList();
    private int totalFees;
    private String registeredCoursesString;
    private String registeredCoursesStringParsed;

    //CONSTRUCTORS

    public Student(String name, String surname) {
        super(name, surname);
    }

    public Student(String name, String surname, String registeredCoursesString) {
        this.name = name;
        this.surname = surname;
        this.registeredCoursesString = registeredCoursesString;
    }

    public Student(int studentId, String name, String surname){
        this.studentId = studentId;
        this.name = name;
        this.surname = surname;
        this.registeredCoursesString = "";
    }
    public Student(int studentId, String name, String surname, String registeredCourses){
        this.studentId = studentId;
        this.name = name;
        this.surname = surname;

        this.registeredCoursesString = registeredCourses;
    }

    //GET&SET

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public ObservableList<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void setRegisteredCourses(ObservableList<Course> _registeredCourses) {
        this.registeredCourses = _registeredCourses;
    }

    public int getTotalFees() {
        return totalFees;
    }

    public void setTotalFees(int totalFees) {
        this.totalFees = totalFees;
    }

    public String getRegisteredCoursesString() {
        return registeredCoursesString;
    }

    public void setRegisteredCoursesString(String registeredCoursesString) {
        this.registeredCoursesString = registeredCoursesString;
    }

    public String getRegisteredCoursesStringParsed() {
        if (registeredCoursesString == null || registeredCoursesString.equals("")){
            return "";
        }
        String[] parsedArray = registeredCoursesString.split(",");
        String resultString = "";

        for(String s : parsedArray){
            if (Pattern.matches("[a-zA-Z]+", s) == false && !s.equals("") && s != null){
                //System.out.println(s);
                resultString += Database.getCourseById(Integer.parseInt(s)).getCourseName() + " | " ;
            }

        }
        return resultString;
    }

    public void setRegisteredCoursesStringParsed(String registeredCoursesStringParsed) {
        this.registeredCoursesStringParsed = registeredCoursesStringParsed;
    }

    //FUNCTIONS
    public void addFee(int amount){
        if (amount > 0){
            this.setTotalFees(totalFees + amount);
        }
        else {
            //TODO throw exception
        }
    }

    public void subtractFee(int amount){
        if (amount > 0){
            this.setTotalFees(totalFees - amount);
        }
        else {
            //TODO throw exception
        }
    }

    public void addCourse(Course course){
        if (!this.getRegisteredCourses().contains(course)){
            this.getRegisteredCourses().add(course);
            Database.addCourseToStudent(this, course); //TODO
            System.out.println("Adding course '" + course.getCourseName() + "' to Student '" + this.getName() + " " + this.getSurname() + ".");
        }
        else {
            //TODO exception
        }
    }

    public void removeCourse(Course course){
        System.out.println("Removing course '" + course.getCourseName() + "' from Student '" + this.getName() + " " + this.getSurname() + ".");
        Database.removeCourseFromStudent(this,course);

    }
}
