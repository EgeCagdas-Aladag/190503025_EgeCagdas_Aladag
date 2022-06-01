package com.example.pmvanwendung;

import java.util.ArrayList;

public class Course {

    private int courseId;
    private String courseName;
    private int price;
    private ArrayList<String> requiredInstruments;
    private ArrayList<Integer> sessions;

    //CONSTRUCTORS

    public Course(String courseName){
        this.courseName = courseName;
    }

    public Course(int courseId, String courseName){
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public Course(int courseId, String courseName, int price){
        this.courseId = courseId;
        this.courseName = courseName;
        this.price = price;
    }

    //GET-SETS
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ArrayList<String> getRequiredInstruments() {
        return requiredInstruments;
    }

    public void setRequiredInstruments(ArrayList<String> requiredInstruments) {
        this.requiredInstruments = requiredInstruments;
    }

    public ArrayList<Integer> getSessions() {
        return sessions;
    }

    public void setSessions(ArrayList<Integer> sessions) {
        this.sessions = sessions;
    }

    //OTHER FUNCTIONS
    public void addInstrument(String instrument){
        instrument = instrument.toLowerCase();

        if (!this.requiredInstruments.contains(instrument)){
            this.requiredInstruments.add(instrument);
        }
        else {
            //TODO throw exception?
        }
    }

    public void removeInstrument(String instrument){
        if (this.requiredInstruments.contains(instrument)){
            this.requiredInstruments.remove(instrument);
        }
        else {
            //TODO throw exception?
        }
    }
}
