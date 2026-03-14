package com.effortcure;

import java.io.IOException;

import com.effortcure.util.SceneManager;
import com.effortcure.util.ScreenDimensionsUtil;

import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
    Font.loadFont(getClass().getResourceAsStream("/fonts/K2D-Regular.ttf"), 12);
    Font.loadFont(getClass().getResourceAsStream("/fonts/K2D-SemiBold.ttf"), 12);
    Font.loadFont(getClass().getResourceAsStream("/fonts/K2D-Bold.ttf"), 12);

        double[] screenDimensions = ScreenDimensionsUtil.getPlatformFullScreenViewDimensions();
        System.setProperty("os.screen.width", String.valueOf(screenDimensions[0]));
        System.setProperty("os.screen.hight", String.valueOf(screenDimensions[1]));
        SceneManager.setStage(stage);
        SceneManager.switchScene("/fxml/email-verfication-page.fxml");
    }
    public static void main(String[] args) {
        launch(args);
    }
}

