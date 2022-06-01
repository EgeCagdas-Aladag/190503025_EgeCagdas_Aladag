package com.example.pmvanwendung;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class StudentProfilePageController {

    @FXML
    Label nameLabel;

    @FXML
    Label surnameLabel;

    @FXML
    Label aboutText;

    public static Student viewedStudent;

    @FXML
    private void initialize(){


        nameLabel.setText(viewedStudent.getName());
        surnameLabel.setText(viewedStudent.getSurname());
    }

}
