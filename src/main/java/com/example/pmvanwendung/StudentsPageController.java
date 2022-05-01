package com.example.pmvanwendung;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;

public class StudentsPageController {
    @FXML
    private TableView studentsTableView;

    private ObservableList<Person> studentsList = FXCollections.observableArrayList();

    private void studentsTableViewSetUp(){
        Person person = Database.getUser(1);
        studentsList.add(person);


    }

    @FXML
    private void initialize(){
        studentsTableViewSetUp();
        studentsTableView.setItems(studentsList);
        studentsTableView.refresh();
    }

}
