package com.example.pmvanwendung;

import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.effect.Glow;
import javafx.util.Duration;
import org.w3c.dom.Text;

public class AddStudentPopupController {

    public static StudentsPageController studentsPageController;

    @FXML
    TextField nameField;

    @FXML
    TextField surnameField;

    @FXML
    TextField courseNameField;

    @FXML
    ListView coursesListView;

    @FXML
    Button addCourseButton;

    @FXML
    Button saveButton;

    @FXML
    Label invalidCourseAlertLabel;

    private ObservableList<Course> coursesList = FXCollections.observableArrayList();

    private ObservableList<String> courseNamesList = FXCollections.observableArrayList();

    private FadeTransition fadeTransition = new FadeTransition(Duration.millis(3000));

    @FXML
    private void initialize(){setupFadeTransition();}

    private void setupFadeTransition(){
        fadeTransition.setNode(invalidCourseAlertLabel);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.setCycleCount(1);
        fadeTransition.setAutoReverse(false);
    }

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

    @FXML
    public void addCourseButtonClicked(){
        String courseName = courseNameField.getText();
        Course courseToBeAdded = Database.getCourse(courseName);

        if (courseToBeAdded != null){
            System.out.println("Course exists!");
            coursesList.add(courseToBeAdded);
            coursesListViewSetup();
        }
        else {
            invalidCourseAlertLabel.setVisible(true);
            System.out.println("Wrong course name entered.");
            fadeTransition.play();
        }

    }

    private void coursesListViewSetup(){
        courseNamesList = FXCollections.observableArrayList(); //we clear out all entries to avoid repeated adding of courses
        for (Course course : coursesList){
            courseNamesList.add(course.getCourseName());
        }

        coursesListView.setItems(courseNamesList);
        coursesListView.refresh();
    }

    @FXML
    public void saveButtonClicked(){
        if (!nameField.getText().equals("") && !surnameField.getText().equals("")) {
            Student studentToBeAdded = new Student(nameField.getText(), surnameField.getText());
            Database.addStudent(studentToBeAdded);
        }

        studentsPageController.studentsTableViewSetUp();

        return;
    }

}
