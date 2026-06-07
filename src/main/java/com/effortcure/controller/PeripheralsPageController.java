package com.effortcure.controller;

import com.effortcure.util.ViewUtil;
import javafx.util.Duration;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;

public class PeripheralsPageController {

    @FXML
    private AnchorPane root;

    @FXML
    private ImageView bubble1;

    @FXML
    private ImageView bubble2;

    @FXML
    private ImageView bubble3;

    @FXML
    private ImageView bubble4;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox vbox;

    @FXML
    private Pane deviceStatusPane;

    @FXML
    private ImageView deviceImg;

    @FXML
    private Label deviceName;

    @FXML
    private Label deviceStatusLabel;

    @FXML
    private ImageView closeIcon;

    @FXML
    private Button searchBtn;

    @FXML
    private ImageView searchIcon;

    @FXML
    private ImageView backicon;

    @FXML
    private void initialize() {
        ViewUtil.initiateResponsiveView(this);
        animateBubble(bubble1, 20, 3);
        animateBubble(bubble2, 15, 4);
        animateBubble(bubble3, 25, 5);
        animateBubble(bubble4, 18, 3.5);
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