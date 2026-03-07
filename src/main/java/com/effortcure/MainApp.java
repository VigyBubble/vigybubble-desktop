package com.effortcure;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/register.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Vigybubble Desktop");
        stage.setMaximized(true);
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

            double screenWidth = screenBounds.getWidth();
            double screenHeight = screenBounds.getHeight();
            System.out.println(screenWidth);
            System.out.println(screenHeight);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}