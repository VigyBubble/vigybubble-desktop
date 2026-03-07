package com.effortcure;

import java.io.IOException;

import com.effortcure.navigator.SceneManager;
import com.effortcure.util.ScreenDimensionsUtil;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        System.out.println(ScreenDimensionsUtil.getPlatformFullScreenViewDimensions()[0] + " "
                + ScreenDimensionsUtil.getPlatformFullScreenViewDimensions()[1]);
        SceneManager.setStage(stage);
        SceneManager.switchScene("/fxml/register.fxml");
    }

    public static void main(String[] args) {
        launch(args);
    }
}