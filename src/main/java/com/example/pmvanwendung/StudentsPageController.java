package com.example.pmvanwendung;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class StudentsPageController {

    AddStudentPopupController addStudentPopupController;

    //"1,2,3" split(',') 1 2 3 parseInt

    @FXML
    private TableView studentsTableView;

    @FXML
    private TableColumn nameColumn;

    @FXML
    private TableColumn surnameColumn;

    @FXML
    private TableColumn registeredCoursesColumn;

    private ObservableList<Student> studentsList = FXCollections.observableArrayList();

    private static DashboardController dashboardController;

    public static DashboardController getDashboardController() {
        return dashboardController;
    }

    public static void setDashboardController(DashboardController dashboardController) {
        StudentsPageController.dashboardController = dashboardController;
    }

    public void studentsTableViewSetUp(){
        studentsList = Database.getStudentsList();
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        registeredCoursesColumn.setCellValueFactory(new PropertyValueFactory<>("registeredCoursesStringParsed"));

        studentsTableView.setItems(studentsList);


    }

    @FXML
    private void initialize(){
        studentsTableViewSetUp();
        //studentsTableView.refresh(); //Gereksiz
    }

    @FXML
    private void addButtonClicked(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("addstudentpopup.fxml"));
            Scene scene = new Scene(root);

            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setTitle("New Student");
            stage.setAlwaysOnTop(true);
            stage.setScene(scene);
            stage.show();

            AddStudentPopupController.studentsPageController = this;

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void viewButtonClicked(){
        Student studentToBeViewed = (Student) studentsTableView.getSelectionModel().getSelectedItem();
        StudentProfilePageController.viewedStudent = studentToBeViewed;

        dashboardController.loadPage("StudentProfilePage");
    }


    @FXML
    private void removeButtonClicked(){
        Student studentToBeRemoved = (Student) studentsTableView.getSelectionModel().getSelectedItem();
        Database.removeStudent(studentToBeRemoved);
        studentsTableViewSetUp();
        studentsTableView.refresh();
    }

}
