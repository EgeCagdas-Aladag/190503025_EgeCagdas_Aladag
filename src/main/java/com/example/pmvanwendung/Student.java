package com.example.pmvanwendung;

import java.util.ArrayList;

public class Student extends Person{

    private int studentId;
    private ArrayList<Integer> registeredCourses;
    private int totalFees;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public ArrayList<Integer> getRegisteredCourses() {
        return registeredCourses;
    }

    public void setRegisteredCourses(ArrayList<Integer> registeredCourses) {
        this.registeredCourses = registeredCourses;
    }

    public int getTotalFees() {
        return totalFees;
    }

    public void setTotalFees(int totalFees) {
        this.totalFees = totalFees;
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

    public void addCourse(int courseId){
        if (!this.getRegisteredCourses().contains(courseId)){
            this.getRegisteredCourses().add(courseId);
        }
        else {
            //TODO exception
        }
    }

    public void removeCourse(int courseId){
        if (this.getRegisteredCourses().contains(courseId)){
            this.getRegisteredCourses().remove(courseId);
        }
        else {
            //TODO exception
        }
    }
}
