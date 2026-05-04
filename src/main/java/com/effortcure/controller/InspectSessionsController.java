package com.effortcure.controller;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.effortcure.auth.AccessTokenManager;
import com.effortcure.dto.response.ApiResponse;
import com.effortcure.dto.response.LoggedNotificationResponseDTO;
import com.effortcure.dto.response.SessionBriefResponseDTO;
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
    private Pane sessionsGridPane;
    @FXML
    private Pane notificationPane;

    @FXML
    private Pane sessionPane1;
    @FXML
    private Pane sessionPane2;
    @FXML
    private Pane sessionPane3;
    @FXML
    private Pane sessionPane4;
    @FXML
    private Pane sessionPane5;
    @FXML
    private Pane sessionPane6;
    @FXML
    private Pane sessionPane7;
    @FXML
    private Pane sessionPane8;
    @FXML
    private Pane sessionPane9;
    @FXML
    private Pane sessionPane10;
    @FXML
    private Pane sessionPane11;
    @FXML
    private Pane sessionPane12;
    @FXML
    private Pane sessionPane13;
    @FXML
    private Pane sessionPane14;
    @FXML
    private Pane sessionPane15;
    @FXML
    private Pane sessionPane16;
    @FXML
    private Pane sessionPane17;
    @FXML
    private Pane sessionPane18;
    @FXML
    private Pane sessionPane19;
    @FXML
    private Pane sessionPane20;
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
        getNotifications();
    }

    @FXML
    private void backToCreateSession() {
        ContentManager.setAnchorPane(root);
        ContentManager.switchContent("/fxml/create-session.fxml");
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

    private void loadSessionData() throws Exception {
        ApiResponse<SessionBriefResponseDTO> response = sessionsServiceInterface.getSessionDetails(sessionUuid);
        if (response != null && response.getStatus() == 200) {
            SessionBriefResponseDTO sessionDetails = response.getData();
            setMode(sessionDetails.getMode().toString());
            // dwpLabel.setText(sessionDetails.getDwp());
            if (sessionDetails.getStatusUpdatedAt() != null) {
                pausedAtLabel.setText(sessionDetails.getStatusUpdatedAt().toString());
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