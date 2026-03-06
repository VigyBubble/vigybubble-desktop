package com.effortcure;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage)  throws Exception  {
             Parent root = FXMLLoader.load(getClass().getResource("/fxml/email-verfication-page.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Vigybubble Desktop");
        stage.setMaximized(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}