package com.example.pmvanwendung;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.*;

import java.io.IOException;

public class PMVApp extends Application {

    private StageStyle stageStyle;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PMVApp.class.getResource("loginpage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Music School Management");
        stage.setScene(scene);

        stageStyle = stage.getStyle();
        stage.setResizable(false);

        stage.show();

        //SQLITE
        Database.connect();
    }

    public static void main(String[] args) {
        launch();
    }
}