package com.effortcure.navigator;

import java.io.IOException;
import java.util.function.Consumer;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PopupManager {

    public static <T> void showPopup(String fxml, Consumer<T> setupAction) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    PopupManager.class.getResource(fxml));

            Parent root = loader.load();
            T controller = loader.getController();
            if (setupAction != null) {
                setupAction.accept(controller);
            }
            Stage popup = new Stage();
            Scene scene = new Scene(root);

            popup.setScene(scene);
            popup.sizeToScene();

            scene.setFill(Color.TRANSPARENT);
            popup.initStyle(StageStyle.TRANSPARENT);
            popup.initModality(Modality.APPLICATION_MODAL);
            popup.setX((Double.valueOf(System.getProperty("os.screen.width")) / 2 - ((Pane) root).getPrefWidth() / 2));
            popup.setY((Double.valueOf(System.getProperty("os.screen.hight")) / 2 - ((Pane) root).getPrefHeight() / 2));
            popup.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load popup", e);
        }
    }
}
