package com.effortcure;

import com.effortcure.auth.RefreshTokenManager;
import com.effortcure.navigator.SceneManager;
import com.effortcure.service.implementation.AuthService;
import com.effortcure.service.interfaces.AuthServiceInterface;
import com.effortcure.util.ViewUtil;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

    AuthServiceInterface authServiceInterface = new AuthService();

    @Override
    public void start(Stage stage) throws Exception {
        ViewUtil.LoadFonts(new String[] { "/fonts/K2D-Regular.ttf", "/fonts/K2D-SemiBold.ttf", "/fonts/K2D-Bold.ttf" });
        double[] screenDimensions = ViewUtil.getPlatformFullScreenViewDimensions();
        System.setProperty("os.screen.width", String.valueOf(screenDimensions[0]));
        System.setProperty("os.screen.hight", String.valueOf(screenDimensions[1]));
        SceneManager.setStage(stage);
          if (RefreshTokenManager.getRefreshToken() != null) {
           authServiceInterface.refreshAccessAndRefreshTokens();
           SceneManager.switchScene("/fxml/main-template.fxml", null);
        } else
            SceneManager.switchScene("/fxml/login-page.fxml", null);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
