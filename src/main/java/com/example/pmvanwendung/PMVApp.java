package com.example.pmvanwendung;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.*;

import java.io.IOException;

public class PMVApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PMVApp.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Music School Management App");
        stage.setScene(scene);
        stage.show();

        //SQLITE
        Database.connect();
    }

    public static void main(String[] args) {
        launch();
    }
}