package com.example.pmvanwendung;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CoursePageController {

    @FXML
    TableView registeredStudentsTableView;

    @FXML
    Label courseNameLabel;

    @FXML
    TableColumn studentsNameColumn;

    @FXML
    TableColumn studentsSurnameColumn;

    @FXML
    Button addStudentButton;

    @FXML
    Button removeStudentButton;

    @FXML
    TextField nameField;

    @FXML
    TextField surnameField;

    public static Course activeCourse;

    private ObservableList studentsList = FXCollections.observableArrayList();

    public void studentsTableViewSetUp(){
        studentsList = Database.getStudentsListForCourse(activeCourse);

        studentsNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        studentsSurnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));

        registeredStudentsTableView.setItems(studentsList);

    }


    @FXML
    public void initialize(){
        courseNameLabel.setText(activeCourse.getCourseName());
        studentsTableViewSetUp();
    }

    @FXML
    public void addStudentButtonClicked(){
        String studentName = nameField.getText();
        String studentSurname = surnameField.getText();

        Student selectedStudent = Database.getStudentByName(studentName,studentSurname);

        selectedStudent.addCourse(activeCourse);
        studentsTableViewSetUp();
    }

    @FXML
    public void removeStudentButtonClicked(){
        Student selectedStudent = (Student) registeredStudentsTableView.getSelectionModel().getSelectedItem();

        selectedStudent.removeCourse(activeCourse);
        studentsTableViewSetUp();
    }

}
