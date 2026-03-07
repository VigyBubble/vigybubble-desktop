package com.effortcure.util;

import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ScreenDimensionsUtil {

    public static double[] getPlatformFullScreenViewDimensions() {
        Rectangle2D screen = Screen.getPrimary().getVisualBounds();
        double width = screen.getWidth();
        double hight = screen.getHeight();
        getPlatformTitleBarSize();
        String readContent = FilesUtil.readFromFile(System.getProperty("user.home"), "Vigy Bubble",
                "Platform Titlebar Size.txt");
        hight = readContent != null ? hight - Double.valueOf(readContent) : hight;
        return new double[] { width, hight };
    }

    private static void getPlatformTitleBarSize() {
        Stage temp = new Stage();
        Scene scene = new Scene(new Pane(), 0, 0);
        temp.setScene(scene);
        temp.setX(0);
        temp.setY(0);
        temp.show();
        Platform.runLater(() -> {
            Platform.runLater(() -> {
                double titleBarHeight = temp.getHeight() - scene.getHeight();
                FilesUtil.writeToFile(System.getProperty("user.home"), "Vigy Bubble", "Platform Titlebar Size.txt",
                        String.valueOf(titleBarHeight));
                temp.close();
            });
        });
    }

}
