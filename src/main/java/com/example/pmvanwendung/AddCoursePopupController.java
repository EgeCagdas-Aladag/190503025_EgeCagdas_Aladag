package com.example.pmvanwendung;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.util.Duration;

public class AddCoursePopupController {

    public static ClassesPageController classesPageController;

    private FadeTransition fadeTransition = new FadeTransition(Duration.millis(3000));

    @FXML
    TextField nameField;

    @FXML
    Button saveButton;

    @FXML
    public void saveButtonClicked(){
        String courseName = nameField.getText();

        Course courseToBeAdded = new Course(courseName);

        Database.addCourse(courseToBeAdded);
        classesPageController.coursesTableViewSetup();

        return;
    }
    /*
    private void setupFadeTransition(){
        fadeTransition.setNode(invalidCourseAlertLabel);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.setCycleCount(1);
        fadeTransition.setAutoReverse(false);
    }
    */
    @FXML
    public void saveButtonHoverStart(){
        Glow glow = new Glow();
        glow.setLevel(0.4);
        saveButton.setEffect(glow);
    }

    @FXML
    public void saveButtonHoverEnd(){
        Glow glow = new Glow();
        glow.setLevel(0.0);
        saveButton.setEffect(glow);
    }

}
