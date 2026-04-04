package com.effortcure.navigator;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

public class ContentManager {
    private static StackPane stackPane;

    public static void setStackPane(StackPane stackPane) {
        ContentManager.stackPane = stackPane;
    }

    public static void switchContent(String fxml) {
        try {
            Parent view = FXMLLoader.load(ContentManager.class.getResource(fxml));
            stackPane.getChildren().setAll(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
