package com.example.pmvanwendung;

public class Person {
    protected int id;
    protected String name;
    protected String surname;

    //GET-SETS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    //CONSTRUCTORS
    public Person(){

    }

    public Person(int id, String name, String surname){
        this.setId(id);
        this.setName(name);
        this.setSurname(surname);
    }

    public Person(String name, String surname){
        this.setName(name);
        this.setSurname(surname);
    }

    //OTHER FUNCTIONS


}
