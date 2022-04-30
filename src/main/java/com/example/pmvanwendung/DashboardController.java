package com.example.pmvanwendung;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class DashboardController {


    private static String currentUser;

    public static String getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(String currentUser) {
        DashboardController.currentUser = currentUser;
    }

    @FXML
    private void initialize(){
        loadToolbar();
        loadHomepage();
    }

    @FXML
    Button homeButton;

    @FXML
    Pane pane;

    @FXML
    Pane toolbarPane;

    @FXML
    public void homeButtonClicked() {
        loadHomepage();
    }

    private void loadToolbar(){
        try {
            Pane newPane = FXMLLoader.load(getClass().getResource("toolbar.fxml"));
            toolbarPane.getChildren().removeAll();
            toolbarPane.getChildren().add(newPane);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    private void loadHomepage(){
        try {
            Pane newPane = FXMLLoader.load(getClass().getResource("homepage.fxml"));
            pane.getChildren().removeAll();
            pane.getChildren().add(newPane);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
