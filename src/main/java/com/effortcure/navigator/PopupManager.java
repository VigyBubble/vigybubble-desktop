package com.effortcure.navigator;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PopupManager {
    public static void showPopup(String fxml) {
        try {
            Parent root = FXMLLoader.load(PopupManager.class.getResource(fxml));
            Stage popup = new Stage();
            ((ImageView) root.lookup("#close")).setOnMouseClicked(e -> {
                popup.close();
            });
            Scene scene = new Scene(root);
            popup.setScene(scene);
            scene.setFill(Color.TRANSPARENT);
            popup.initStyle(StageStyle.TRANSPARENT);
            popup.initModality(Modality.APPLICATION_MODAL);
            popup.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
