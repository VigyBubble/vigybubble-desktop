package com.effortcure.navigator;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class ContentManager {
    private static AnchorPane anchorPane;
    private static Pane pane;

    public static void setPane(Pane pane) {
        ContentManager.pane = pane;
    }

    public static void setAnchorPane(AnchorPane anchorPane) {
        ContentManager.anchorPane = anchorPane;
    }

    public static void switchContent(String fxml) {
        try {
            Parent view = FXMLLoader.load(ContentManager.class.getResource(fxml));
            anchorPane.getChildren().setAll(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ده لو احتاجت استخدم controller
    public static <T> T switchContentWithController(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(ContentManager.class.getResource(fxml));
        Parent content = loader.load();
        anchorPane.getChildren().setAll(content);
        return loader.getController();
    }

    public static void switchPaneContent(String fxml) {
        try {
            Parent view = FXMLLoader.load(ContentManager.class.getResource(fxml));
            pane.getChildren().setAll(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
