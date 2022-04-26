package com.example.pmvanwendung;
import java.time.*;
import java.util.*;

public class Teacher extends Person {
    private int teacherId;
    private LocalDate workStart;
    private ArrayList<int> offeredCourses;
    private List<String> instruments;
    private String infoText;
    private boolean isAdmin;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public LocalDate getWorkStart() {
        return workStart;
    }

    public void setWorkStart(LocalDate workStart) {
        this.workStart = workStart;
    }

    public ArrayList<int> getOfferedCourses() {
        return offeredCourses;
    }

    public void setOfferedCourses(ArrayList<int> offeredCourses) {
        this.offeredCourses = offeredCourses;
    }

    public List<String> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<String> instruments) {
        this.instruments = instruments;
    }

    public String getInfoText() {
        return infoText;
    }

    public void setInfoText(String infoText) {
        this.infoText = infoText;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    //CONSTRUCTORS
    public Teacher(int id, String name, String surname){
        super(id, name, surname);
    }

    public Teacher (String name, String surname){
        super(name, surname);
    }

    //FUNCTIONS

    public void addInstrument(String instrument){
        if (!this.getInstruments().contains(instrument)){
            this.getInstruments().add(instrument);
        }
        else {
            //TODO exception
        }
    }

    public void removeInstrument(String instrument){
        if(this.getInstruments().contains(instrument)){
            this.getInstruments().remove(instrument);
        }
        else{
            //TODO exception
        }
    }

    public void addCourse(int courseId){
        if (!this.getOfferedCourses().contains(courseId)){
            this.getOfferedCourses().add(courseId);
        }
        else {
            //TODO exception
        }
    }

    public void removeCourse(int courseId){
        if (this.getOfferedCourses().contains(courseId)){
            this.getOfferedCourses().remove(courseId);
        }
        else {
            //TODO exception
        }
    }

    public void makeAdmin(){
        if (!this.isAdmin()){
            this.setAdmin(true);
        }
        else {
            //TODO Alert user
        }
    }

    public void removeAdmin(){
        if (this.isAdmin()){
            this.setAdmin(false);
        }
        else {
            //TODO Alert user
        }
    }
}
