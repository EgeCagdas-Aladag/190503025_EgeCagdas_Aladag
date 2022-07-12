package com.example.pmvanwendung;

public class User extends Person{


    private String username;
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //Constructors

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String name, String surname){
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public User(int id, String username, String password, String name, String surname){
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }
}
