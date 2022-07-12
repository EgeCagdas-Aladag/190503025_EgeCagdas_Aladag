package com.example.pmvanwendung;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ClassesPageController {

    private static DashboardController dashboardController;

    private ObservableList<Course> coursesList = FXCollections.observableArrayList();
    @FXML
    TableColumn numberOfStudentsColumn;

    @FXML
    TableColumn courseNameColumn;

    @FXML
    TableView coursesTableView;

    @FXML
    Button viewButton;

    @FXML
    Button addButton;

    @FXML
    Button removeButton;

    public static DashboardController getDashboardController() {
        return dashboardController;
    }

    public static void setDashboardController(DashboardController dashboardController) {
        ClassesPageController.dashboardController = dashboardController;
    }

    @FXML
    private void initialize(){
        coursesTableViewSetup();
    }

    @FXML
    private void viewButtonClicked(){
        CoursePageController.activeCourse = (Course) coursesTableView.getSelectionModel().getSelectedItem();
        dashboardController.loadPage("coursePage");
    }

    @FXML
    private void addButtonClicked(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("addcoursepopup.fxml"));
            Scene scene = new Scene(root);

            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setTitle("New Course");
            stage.setAlwaysOnTop(true);
            stage.setScene(scene);
            stage.show();

            AddCoursePopupController.classesPageController = this;

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void removeButtonClicked(){
        Course courseToBeRemoved = (Course) coursesTableView.getSelectionModel().getSelectedItem();

        Database.removeCourse(courseToBeRemoved);
        coursesTableViewSetup();
    }

    public void coursesTableViewSetup(){
        coursesTableView.setItems(Database.getCoursesList());
        courseNameColumn.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        numberOfStudentsColumn.setCellValueFactory(new PropertyValueFactory<>(null)); //TODO
        coursesTableView.refresh();
    }

}
