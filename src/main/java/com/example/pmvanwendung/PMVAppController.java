package com.example.pmvanwendung;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.Glow;
import javafx.stage.Stage;

import java.io.IOException;

public class PMVAppController {

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
        try {
            switchToHomepage();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }


    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToHomepage() throws IOException {
        root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        stage =(Stage)(loginButton.getScene().getWindow());
        stage.setTitle("Dashboard");
        //stage.setResizable(false); TODO: Decide if you want it resizable
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToLoginPage() throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage =(Stage)(loginButton.getScene().getWindow());
        stage.setTitle("Login");
        stage.setResizable(false);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}