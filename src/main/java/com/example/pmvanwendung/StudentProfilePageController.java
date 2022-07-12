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

    @FXML
    Label coursesLabel;

    public static Student viewedStudent;

    @FXML
    private void initialize(){
        nameLabel.setText(viewedStudent.getName());
        surnameLabel.setText(viewedStudent.getSurname());

        coursesLabelSetup();
    }

    private void coursesLabelSetup(){
        int counter = 0;
        coursesLabel.setText("");
        if (viewedStudent.getRegisteredCoursesString() == null || viewedStudent.getRegisteredCoursesString().equals("")){
            return;
        }

        String[] parsedCourses = viewedStudent.getRegisteredCoursesString().split(",");

        for (String s : parsedCourses){
            if (counter != parsedCourses.length - 1){
                coursesLabel.setText(coursesLabel.getText() + Database.getCourseById(Integer.parseInt(s)).getCourseName() + ", ");
            }
            else {
                coursesLabel.setText(coursesLabel.getText() + Database.getCourseById(Integer.parseInt(s)).getCourseName());
            }
            counter++;
        }
    }

}
