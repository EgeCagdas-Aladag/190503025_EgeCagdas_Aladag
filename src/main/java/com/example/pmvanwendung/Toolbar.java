package com.example.pmvanwendung;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Toolbar {

    public static DashboardController dashboardController;

    public static LoginPageController loginPageController;

    public static UserProfilePageController userProfilePageController;

    public static Stage stage;

    public static User currentUser;

    @FXML
    ImageView userImage;

    @FXML
    Label usernameLabel;

    @FXML
    Button logoutButton;

    /*public void getUsernameLabel(){

    }*/

    public void setUsernameLabel(String s){
        usernameLabel.setText(s);
    }

    public void setCurrentUser(User user){
        currentUser = user;
    }

    @FXML
    private void userImageClicked(){
        userProfilePageController.currentUser = currentUser;
        userProfilePageController.toolbarController = this;
        dashboardController.loadPage("userprofile");
    }

    @FXML
    private void initialize(){
        setUsernameLabel(DashboardController.getCurrentUser().getName());
        //this.stage = (Stage)(usernameLabel.getScene().getWindow());
    }

    @FXML
    private void logoutButtonClicked(){
        try {
            loginPageController.switchToLoginPage();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}



