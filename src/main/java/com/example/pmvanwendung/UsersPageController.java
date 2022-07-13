package com.example.pmvanwendung;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class UsersPageController {

    @FXML
    TableView usersTableView;

    @FXML
    TableColumn userIdColumn;

    @FXML
    TableColumn usernameColumn;

    @FXML
    TableColumn nameColumn;

    @FXML
    TableColumn surnameColumn;

    @FXML
    Button editButton;

    @FXML
    Button addButton;

    @FXML
    Button removeButton;

    @FXML
    TextField usernameField;

    @FXML
    TextField nameField;

    @FXML
    TextField surnameField;

    @FXML
    PasswordField passwordField;

    @FXML
    PasswordField passwordConfirmField;

    @FXML
    Label passwordMatchAlertLabel;

    @FXML
    private void editButtonClicked(){
        if (usernameField.getText().equals("") || nameField.getText().equals("") || surnameField.getText().equals("") || passwordField.getText().equals("") || passwordConfirmField.getText().equals("")){
            return;
        }
        else {
            if (passwordField.getText().equals(passwordConfirmField.getText())) {
                Database.editUser((User) usersTableView.getSelectionModel().getSelectedItem(), new User(usernameField.getText(), passwordField.getText(), nameField.getText(), surnameField.getText()));
                usersTableViewSetup();
            } else {
                passwordMatchAlertLabel.setVisible(true);
            }
        }
    }

    @FXML
    private void addButtonClicked(){
        if (usernameField.getText().equals("") || nameField.getText().equals("") || surnameField.getText().equals("") || passwordField.getText().equals("") || passwordConfirmField.getText().equals("")){
            return;
        }
        else {
            if (passwordField.getText().equals(passwordConfirmField.getText())){
                System.out.println("editing user");
                Database.addUser(new User(usernameField.getText(), passwordField.getText(), nameField.getText(), surnameField.getText()));
                usersTableViewSetup();
            }
            else {
                passwordMatchAlertLabel.setVisible(true);
            }
        }
    }

    @FXML
    private void removeButtonClicked(){
        Database.removeUser((User) usersTableView.getSelectionModel().getSelectedItem());
        usersTableViewSetup();
    }

    private void usersTableViewSetup(){
        ObservableList usersList = Database.getUsersList();
        userIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));

        usersTableView.setItems(usersList);
        usersTableView.refresh();
    }

    @FXML
    private void initialize(){
        usersTableViewSetup();
    }

    @FXML
    private void usersTableClicked(){
        if (usersTableView.getSelectionModel().getSelectedItem() != null){
            User selectedUser = (User) usersTableView.getSelectionModel().getSelectedItem();

            usernameField.setText(selectedUser.getUsername());
            nameField.setText(selectedUser.getName());
            surnameField.setText(selectedUser.getSurname());
        }
    }

}
