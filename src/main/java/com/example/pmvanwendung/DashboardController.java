package com.example.pmvanwendung;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
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
        loadPage("homepage");
    }

    @FXML
    Pane pane;

    @FXML
    Pane toolbarPane;

    @FXML
    Button homeButton;

    @FXML
    Button classesButton;

    @FXML
    Button studentsButton;

    @FXML
    Button sessionsButton;



    @FXML
    public void homeButtonClicked() {
        loadPage("homepage");
    }

    @FXML
    public void classesButtonClicked(){
        loadPage("classespage");
    }

    @FXML
    public void studentsButtonClicked(){
        loadPage("students");
    }

    @FXML
    public void sessionsButtonClicked(){
        loadPage("sessions");
    }

    private void loadToolbar(){
        try {
            Parent newParent = FXMLLoader.load(getClass().getResource("toolbar.fxml"));
            toolbarPane.getChildren().clear();
            toolbarPane.getChildren().add(newParent);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public void loadPage(String fxmlName){
        Parent root = null;
        try {
            if (fxmlName.equals("students")){           //TODO Maybe a switch case here.
                StudentsPageController.setDashboardController(this);
            }

            root = FXMLLoader.load(getClass().getResource(fxmlName + ".fxml"));
            pane.getChildren().clear();
            pane.getChildren().add(root);


        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
