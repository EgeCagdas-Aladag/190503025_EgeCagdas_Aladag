package com.example.pmvanwendung;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class Toolbar {

    @FXML
    ImageView userImage;

    @FXML
    Label usernameLabel;

    public void getUsernameLabel(){

    }

    public void setUsernameLabel(String s){
        usernameLabel.setText(s);
    }

    @FXML
    private void userImageClicked(){
        System.out.println("OK");
    }

    @FXML
    private void initialize(){
        setUsernameLabel(DashboardController.getCurrentUser());
    }


}
