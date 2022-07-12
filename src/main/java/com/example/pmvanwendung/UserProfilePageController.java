package com.example.pmvanwendung;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class UserProfilePageController {

    public static Toolbar toolbarController;

    @FXML
    Label nameLabel;

    @FXML
    Label surnameLabel;

    @FXML
    Label usernameLabel;

    @FXML
    Button editButton;

    @FXML
    Button saveButton;

    @FXML
    TextField nameField;

    @FXML
    TextField surnameField;

    @FXML
    TextField usernameField;

    @FXML
    PasswordField passwordField;

    @FXML
    PasswordField passwordConfirmField;

    public static User currentUser;

    boolean areFieldsVisible = false;

    @FXML
    private void initialize(){
        profileLabelsSetup();

    }

    @FXML
    private void editButtonClicked(){
        areFieldsVisible = !areFieldsVisible;
        nameField.setVisible(areFieldsVisible);
        surnameField.setVisible(areFieldsVisible);
        usernameField.setVisible(areFieldsVisible);
        passwordField.setVisible(areFieldsVisible);
        passwordConfirmField.setVisible(areFieldsVisible);
        saveButton.setVisible(areFieldsVisible);
    }

    @FXML
    private void saveButtonClicked(){
        if (!passwordField.getText().equals("") && passwordField.getText() != passwordConfirmField.getText()){
            User newUser = new User(usernameField.getText(), passwordField.getText(), nameField.getText(), surnameField.getText());
            Database.editUser(currentUser,newUser);
            currentUser = Database.getUserByUsername(newUser.getUsername());
            toolbarController.setCurrentUser(currentUser);
            toolbarController.setUsernameLabel(currentUser.getName());
            profileLabelsSetup();
        }
        else{
            System.out.println("Else");
        }
    }

    private void profileLabelsSetup(){
        nameLabel.setText(currentUser.getName());
        surnameLabel.setText(currentUser.getSurname());
        usernameLabel.setText(currentUser.getUsername());
    }
}
