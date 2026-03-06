package com.effortcure;

import java.io.IOException;

import com.effortcure.navigator.SceneManager;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        SceneManager.setStage(stage);
        SceneManager.switchScene("/fxml/register-page.fxml");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}