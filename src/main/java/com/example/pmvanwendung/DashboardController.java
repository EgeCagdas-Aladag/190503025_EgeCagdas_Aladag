package com.example.pmvanwendung;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class DashboardController {

    public static String currentUser;

    @FXML
    Button homeButton;

    @FXML
    Pane pane;

    @FXML
    public void homeButtonClicked() {
        loadHomepage();
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
