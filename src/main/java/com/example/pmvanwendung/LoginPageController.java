package com.example.pmvanwendung;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.Glow;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginPageController {

    @FXML
    TextField usernameField;

    @FXML
    PasswordField passwordField;

    @FXML
    Button loginButton;

    @FXML
    public void loginButtonHoverStart(){
        Glow glow = new Glow();
        glow.setLevel(0.4);
        loginButton.setEffect(glow);
    }

    @FXML
    public void loginButtonHoverEnd(){
        Glow glow = new Glow();
        glow.setLevel(0.0);
        loginButton.setEffect(glow);
    }

    @FXML
    public void loginButtonClicked(){
        String username = usernameField.getText();
        String password = passwordField.getText();

        try {
            if (Database.checkLogin(username,password)){
                DashboardController.setCurrentUser(username);
                switchToDashboard();
            }
        }
        catch (Exception e){
            System.out.println("Exception caught:" + e.getMessage());
        }
    }


    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToDashboard() throws IOException {
        root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        stage =(Stage)(loginButton.getScene().getWindow());
        stage.setTitle("Dashboard");
        //stage.setResizable(false); TODO: Decide if you want it resizable
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void switchToLoginPage() throws IOException {
        root = FXMLLoader.load(getClass().getResource("loginpageloginpage.fxml"));
        stage =(Stage)(loginButton.getScene().getWindow());
        stage.setTitle("Login");
        stage.setResizable(false);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}