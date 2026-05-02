package com.effortcure.navigator;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class ContentManager {
    private static AnchorPane anchorPane;

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

    //ده لو احتاجت استخدم controller
    public static <T> T switchContentWithController(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(ContentManager.class.getResource(fxml));
        Parent content = loader.load();
        anchorPane.getChildren().setAll(content);
        return loader.getController();
    }
}
