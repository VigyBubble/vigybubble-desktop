package com.effortcure.navigator;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {
    private static Stage stage;

    public static void setStage(Stage stage) {
        SceneManager.stage = stage;
    }

    public static void switchScene(String fxml, Runnable onClose) {
        try {
            Parent root = FXMLLoader.load(SceneManager.class.getResource(fxml));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Vigybubble Desktop");
            stage.setMaximized(true);
            stage.setOnCloseRequest(event -> {
                if (onClose != null) {
                    onClose.run();
                }
            });
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
