package com.effortcure.controller;

import com.effortcure.navigator.ContentManager;
import com.effortcure.navigator.PopupManager;
import com.effortcure.util.ViewUtil;
import javafx.util.Duration;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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

    @FXML
    private void initialize() {

        ViewUtil.initiateResponsiveView(this);
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
