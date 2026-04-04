package com.effortcure.navigator;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PopupManager {
    public static void showPopup(String fxml) {
        try {
            Parent root = FXMLLoader.load(PopupManager.class.getResource(fxml));
            Stage popup = new Stage();
            popup.setScene(new Scene(root));
            popup.initModality(Modality.APPLICATION_MODAL);
            popup.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
