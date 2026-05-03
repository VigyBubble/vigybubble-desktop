package com.effortcure.controller;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.effortcure.dto.response.ApiResponse;
import com.effortcure.dto.response.BubbleSessionsResponseDTO;
import com.effortcure.navigator.ContentManager;
import com.effortcure.navigator.PopupManager;
import com.effortcure.service.implementation.BubbleSessionService;
import com.effortcure.service.interfaces.BubbleSessionServiceInterface;
import com.effortcure.util.ViewUtil;
import javafx.util.Duration;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;
import javafx.scene.control.Separator;
import javafx.scene.effect.GaussianBlur;

public class CreateSessionController {

    @FXML
    private AnchorPane root;
    @FXML
    private ImageView back;
    @FXML
    private ImageView bubble1;
    @FXML
    private ImageView bubble2;
    @FXML
    private ImageView bubble3;
    @FXML
    private ImageView bubble4;
    @FXML
    private Pane searchpane;
    @FXML
    private Separator separator;
    @FXML
    private Label daylabel;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Pane sessionspane;
    @FXML
    private Label startlabel;
    @FXML
    private ScrollPane scrolpane;
    @FXML
    private VBox vbox;
    @FXML
    private Button startsessionBtn;
    @FXML
    private ImageView addIcon;
    @FXML
    private Pane overlay;

    public static UUID bubbleUuid;
    private BubbleSessionServiceInterface bubbleSessionServiceInterface = new BubbleSessionService();

    @FXML
    private void initialize() throws Exception {
        ViewUtil.initiateResponsiveView(this);
        getSessions();
        animateBubble(bubble1, 20, 3);
        animateBubble(bubble2, 15, 4);
        animateBubble(bubble3, 25, 5);
        animateBubble(bubble4, 18, 3.5);
    }

    @FXML
    private void backToInspectBubble() {
        ContentManager.setAnchorPane(root);
        ContentManager.switchContent("/fxml/inspect-bubble.fxml");
    }

    @FXML
    private void startSession() {
        GaussianBlur blur = new GaussianBlur(5);
        root.setEffect(blur);
        overlay.setVisible(true);
        SessionModePopupController.bubbleUuid = bubbleUuid;
        PopupManager.showPopup("/fxml/session-mode-popup.fxml", controller -> {

            SessionModePopupController popup = (SessionModePopupController) controller;

            popup.setOnStart(mode -> {

                try {
                    root.setEffect(null);
                    overlay.setVisible(false);

                    InspectSessionsController inspectController = ContentManager
                            .switchContentWithController("/fxml/inspect-session.fxml");
                    inspectController.setMode(mode);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });

            popup.setOnClose(() -> {
                root.setEffect(null);
                overlay.setVisible(false);
            });
        });
    }

    private void getSessions() throws Exception {
        ApiResponse<Set<BubbleSessionsResponseDTO>> response = bubbleSessionServiceInterface
                .getBubbleSession(bubbleUuid);
        if (response != null) {
            Set<BubbleSessionsResponseDTO> sessions = response.getData() != null ? response.getData() : new HashSet<>();
            for (BubbleSessionsResponseDTO bubbleSessionsResponseDTO : sessions) {
                Pane pane = FXMLLoader.load(getClass().getResource("/fxml/session-card.fxml"));
                ((Label) pane.lookup("#name")).setText(bubbleSessionsResponseDTO.getCreator());
                ((Label) pane.lookup("#dwp")).setText(bubbleSessionsResponseDTO.getDwp() == null ? "DWP: 0.0%"
                        : "DWP: " + bubbleSessionsResponseDTO.getDwp() + "%");
                ((Text) pane.lookup("#pauseDate"))
                        .setText(bubbleSessionsResponseDTO.getStatusUpdatedAt() != null
                                ? bubbleSessionsResponseDTO.getStatusUpdatedAt().toString()
                                : null);
                if (bubbleSessionsResponseDTO.getStatusUpdatedAt() == null)
                    ((Text) pane.lookup("#pausedatText")).setVisible(false);
                ((Text) pane.lookup("#creationDate")).setText(bubbleSessionsResponseDTO.getCreatedAt() != null
                        ? bubbleSessionsResponseDTO.getCreatedAt().toString()
                        : null);
                ((Label) pane.lookup("#status")).setText(bubbleSessionsResponseDTO.getSessionStatus() != null
                        ? bubbleSessionsResponseDTO.getSessionStatus().toString()
                        : null);
                ((Label) pane.lookup("#uuid")).setText(bubbleSessionsResponseDTO.getUuid().toString());
                pane.setOnMouseClicked(e -> {
                    InspectSessionsController.sessionUuid = bubbleSessionsResponseDTO.getUuid();
                    ContentManager.setAnchorPane(root);
                    ContentManager.switchContent("/fxml/inspect-session.fxml");
                });
                vbox.getChildren().add(pane);
            }
        }

    }

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
