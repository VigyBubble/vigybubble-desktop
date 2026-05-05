package com.effortcure.controller;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.effortcure.auth.AccessTokenManager;
import com.effortcure.dto.response.ApiResponse;
import com.effortcure.dto.response.LoggedNotificationResponseDTO;
import com.effortcure.dto.response.PerformanceMetricsResponseDTO;
import com.effortcure.dto.response.SessionBriefResponseDTO;
import com.effortcure.enums.SessionStatus;
import com.effortcure.navigator.ContentManager;
import com.effortcure.navigator.PopupManager;
import com.effortcure.service.implementation.SessionsService;
import com.effortcure.service.interfaces.SessionsServiceInterface;
import com.effortcure.util.ViewUtil;
import javafx.util.Duration;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class InspectSessionsController {

    @FXML
    private AnchorPane root;
    @FXML
    private ScrollPane scrolpane;
    @FXML
    private VBox rootVBox;
    @FXML
    private Pane mainPane;
    @FXML
    private Pane contentPane;

    @FXML
    private ImageView bubble1;
    @FXML
    private ImageView bubble2;
    @FXML
    private ImageView bubble3;
    @FXML
    private ImageView bubble4;
    @FXML
    private ImageView bubble5;
    @FXML
    private ImageView bubble6;

    @FXML
    private Label modeLabel;
    @FXML
    private Label dwpLabel;
    @FXML
    private Label pausedAtLabel;
    @FXML
    private Label notificationLabel;
    @FXML
    private Label dateLabel;

    @FXML
    private ImageView pauseBtn;
    @FXML
    private ImageView doneBtn;
    @FXML
    private Button deleteBtn;

    @FXML
    private Pane gridPane;
    @FXML
    private Pane dwpPane;
    @FXML
    private Pane pausedPane;
    @FXML
    private ScrollPane metricsScroll;
    @FXML
    private VBox metricsVBox;
    @FXML
    private Pane metricsContainer;
    @FXML
    private Pane notificationPane;

    @FXML
    private Pane pane0;
    @FXML
    private Pane pane1;
    @FXML
    private Pane pane2;
    @FXML
    private Pane pane3;
    @FXML
    private Pane pane4;
    @FXML
    private Pane pane5;
    @FXML
    private Pane pane6;
    @FXML
    private Pane pane7;
    @FXML
    private Pane pane8;
    @FXML
    private Pane pane9;
    @FXML
    private Pane pane10;
    @FXML
    private Pane pane11;
    @FXML
    private Pane pane12;
    @FXML
    private Pane pane13;
    @FXML
    private Pane pane14;
    @FXML
    private Pane pane15;
    @FXML
    private Pane pane16;
    @FXML
    private Pane pane17;
    @FXML
    private Pane pane18;
    @FXML
    private Pane pane19;

    @FXML
    private ScrollPane notificationScroll;
    @FXML
    private VBox notificationVBox;
    @FXML
    private Separator separator;
    @FXML
    private ImageView back;
    @FXML
    private Pane overlay;

    public static UUID sessionUuid;
    private SessionsServiceInterface sessionsServiceInterface = new SessionsService();
    private boolean isPaused = false;
    private Image pauseImage;
    private Image playImage;

    @FXML
    public void initialize() throws Exception {
        ViewUtil.initiateResponsiveView(this);
        animateBubble(bubble1, 20, 3);
        animateBubble(bubble2, 15, 4);
        animateBubble(bubble3, 25, 5);
        animateBubble(bubble4, 18, 3.5);
        animateBubble(bubble5, 18, 3.5);
        animateBubble(bubble6, 15, 3.5);
        back.toFront();
        if (sessionUuid != null) {
            loadSessionData();
        }
        viewPerformanceMetrics();
        getNotifications();
        pauseImage = new Image(getClass().getResource("/images/pause-icon.png").toExternalForm());
        playImage = new Image(getClass().getResource("/images/play-button.png").toExternalForm());
        loadSessionStatus();
        pauseBtn.setOnMouseClicked(e -> {
            try {
                togglePlayPause();
                ContentManager.setAnchorPane(root);
                ContentManager.switchContent("/fxml/create-session.fxml");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        doneBtn.setOnMouseClicked(e -> {
            try {
                sessionsServiceInterface.ModifySessionStatus(sessionUuid, SessionStatus.DONE);
                ContentManager.setAnchorPane(root);
                ContentManager.switchContent("/fxml/create-session.fxml"); 
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
    }

    private void loadSessionStatus() {
        try {
            SessionStatus currentStatus = sessionsServiceInterface.getSessionDetails(sessionUuid).getData().getStatus();
            isPaused = (currentStatus == SessionStatus.PAUSED);
            pauseBtn.setImage(isPaused ? playImage : pauseImage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void togglePlayPause() {

        try {
            if (!isPaused) {
                sessionsServiceInterface.ModifySessionStatus(sessionUuid, SessionStatus.PAUSED);
            } else {
                sessionsServiceInterface.ModifySessionStatus(sessionUuid, SessionStatus.IN_PROGRESS);
            }
            isPaused = !isPaused;
            pauseBtn.setImage(isPaused ? playImage : pauseImage);
              loadSessionData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void backToCreateSession() {
        ContentManager.setAnchorPane(root);
        ContentManager.switchContent("/fxml/create-session.fxml");
    }

    private void loadSessionData() throws Exception {
         System.out.println(sessionUuid);
         System.out.println(AccessTokenManager.getInstance().getAccessToken());
        ApiResponse<SessionBriefResponseDTO> response = sessionsServiceInterface.getSessionDetails(sessionUuid);
        ApiResponse<PerformanceMetricsResponseDTO> metricsResponse = sessionsServiceInterface
                .getPerformanceMetrics(sessionUuid);
        if (response != null && response.getStatus() == 200 && metricsResponse != null
                && metricsResponse.getStatus() == 200) {
            SessionBriefResponseDTO sessionDetails = response.getData();
            PerformanceMetricsResponseDTO performanceMetrics = metricsResponse.getData();

            setMode(sessionDetails.getMode().toString());
            dwpLabel.setText(performanceMetrics.getDwp() == null ? "DWP: 0.0%"
                    : "DWP: " + performanceMetrics.getDwp() + "%");
            if (sessionDetails.getStatusUpdatedAt() != null) {
                pausedAtLabel.setText("Paused at : " + sessionDetails.getStatusUpdatedAt().toString());
                pausedAtLabel.setVisible(true);
            } else {
                pausedAtLabel.setVisible(false);
            }

            dateLabel.setText(sessionDetails.getCreatedAt().toString());
        }
    }

    private void getNotifications() throws Exception {
        ApiResponse<Set<LoggedNotificationResponseDTO>> response = sessionsServiceInterface
                .getLoggedNotifications(sessionUuid);

        if (response != null) {
            Set<LoggedNotificationResponseDTO> notifications = response.getData() != null ? response.getData()
                    : new HashSet<>();

            for (LoggedNotificationResponseDTO dto : notifications) {

                Pane pane = FXMLLoader.load(
                        getClass().getResource("/fxml/notification-log-card.fxml"));

                ((Label) pane.lookup("#notificationTitle")).setText(
                        dto.getTitle() != null ? dto.getTitle() : null);

                ((Label) pane.lookup("#content")).setText(
                        dto.getDescription() != null ? dto.getDescription() : null);

                ((Label) pane.lookup("#date")).setText(
                        dto.getLoggedAt() != null ? dto.getLoggedAt().toString() : "");

                notificationVBox.getChildren().add(pane);
            }
        }
    }

    @FXML
    private void handleDelete() {
        GaussianBlur blur = new GaussianBlur(5);
        root.setEffect(blur);
        overlay.setVisible(true);

        PopupManager.showPopup("/fxml/confirm-popups.fxml", controller -> {
            ((ConfirmPopupController) controller).setupDeleteMode("Delete Session",
                    "Are you sure you want to delete this session?");

            ((ConfirmPopupController) controller).setOnConfirm(() -> {
                try {
                    sessionsServiceInterface.DeleteSession(sessionUuid);
                    ContentManager.setAnchorPane(root);
                    ContentManager.switchContent("/fxml/create-session.fxml");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                root.setEffect(null);
                overlay.setVisible(false);
            });

            ((ConfirmPopupController) controller).setOnCancel(() -> {
                root.setEffect(null);
                overlay.setVisible(false);
            });
        });
    }

    @FXML
    public void setMode(String mode) {
        switch (mode) {
            case "PATTERN_DETECTION":
                modeLabel.setText("Pattern Detection");
                modeLabel.setStyle("-fx-background-color: rgba(38, 166, 113, 0.8);" + "-fx-text-fill: white;");
                contentPane.setStyle("-fx-effect:innershadow(gaussian, #26a671, 10, 0.3, 0, 0);");
                break;

            case "VIGY_ENFORCE":
                modeLabel.setText("Vigy Enforce");
                modeLabel.setStyle("-fx-background-color:rgba(178, 33, 33, 0.48);" + "-fx-text-fill: white;");
                contentPane.setStyle("-fx-effect:innershadow(gaussian, #b22121, 10, 0.3, 0, 0);");
                break;

            case "VIGY_RECOMMENDATION":
                modeLabel.setText("Vigy Recommendation");
                modeLabel.setStyle("-fx-background-color: rgba(112, 34, 185, 0.5);" + "-fx-text-fill: white;");
                contentPane.setStyle(" -fx-effect:innershadow(gaussian, #7022B9, 10, 0.2, 0, 0)");
                break;
        }
    }

    private void viewPerformanceMetrics() throws Exception {
        ApiResponse<PerformanceMetricsResponseDTO> response = sessionsServiceInterface
                .getPerformanceMetrics(sessionUuid);
        if (response != null) {
            for (int i = 0; i < 20; i++) {
                ContentManager.setPane((Pane) metricsContainer.lookup("#pane" + i));
                ContentManager.switchPaneContent("/fxml/progress-circle-card.fxml");
            }
        }
    }

    @FXML
    private void animateBubble(ImageView bubble, double moveY, double duration) {
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(bubble);
        transition.setDuration(Duration.seconds(duration));
        transition.setByY(-moveY);
        transition.setByX(10);
        transition.setAutoReverse(true);
        transition.setCycleCount(TranslateTransition.INDEFINITE);
        transition.play();
    }

}