package com.example.pmvanwendung;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class DashboardController {


    private static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User _currentUser) {
        DashboardController.currentUser = _currentUser;
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
    Button usersButton;


    @FXML
    public void homeButtonClicked() {
        loadPage("homepage");
    }

    @FXML
    public void classesButtonClicked(){
        loadPage("classes");
    }

    @FXML
    public void studentsButtonClicked(){
        loadPage("students");
    }

    @FXML
    public void sessionsButtonClicked(){
        loadPage("sessions");
    }

    @FXML
    public void usersButtonClicked() { loadPage("users");}

    private void loadToolbar(){
        try {
            Toolbar.currentUser = this.currentUser;
            Toolbar.dashboardController = this;
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

            switch(fxmlName){
                case "students":
                    StudentsPageController.setDashboardController(this);
                    break;
                case "classes":
                    ClassesPageController.setDashboardController(this);
                    break;
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
