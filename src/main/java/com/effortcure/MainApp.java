package com.effortcure;

import java.io.IOException;

import com.effortcure.navigator.SceneManager;
import com.effortcure.util.ScreenDimensionsUtil;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        double[] screenDimensions = ScreenDimensionsUtil.getPlatformFullScreenViewDimensions();
        System.setProperty("os.screen.width", String.valueOf(screenDimensions[0]));
        System.setProperty("os.screen.hight", String.valueOf(screenDimensions[1]));
        SceneManager.setStage(stage);
        SceneManager.switchScene("/fxml/register-page.fxml");
    }

    public static void main(String[] args) {
        launch(args);
    }
}