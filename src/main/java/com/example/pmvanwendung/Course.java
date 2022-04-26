package com.example.pmvanwendung;

import java.util.ArrayList;

public class Course {

    private int courseId;
    private int price;
    private ArrayList<String> requiredInstruments;
    private ArrayList<int> sessions;

    //GET-SETS
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
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

    public ArrayList<int> getSessions() {
        return sessions;
    }

    public void setSessions(ArrayList<int> sessions) {
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
