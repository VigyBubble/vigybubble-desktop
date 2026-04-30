package com.effortcure.controller;

import com.effortcure.util.ViewUtil;
import javafx.util.Duration;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
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
    private Label recommendationLabel;
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
    public void initialize() {
        ViewUtil.initiateResponsiveView(this);
        animateBubble(bubble1, 20, 3);
        animateBubble(bubble2, 15, 4);
        animateBubble(bubble3, 25, 5);
        animateBubble(bubble4, 18, 3.5);
        animateBubble(bubble5, 18, 3.5);
        animateBubble(bubble6, 15, 3.5);
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