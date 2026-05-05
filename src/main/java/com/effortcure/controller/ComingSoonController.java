package com.effortcure.controller;

import javafx.util.Duration;

import com.effortcure.util.ViewUtil;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ComingSoonController {
    @FXML
    private AnchorPane root;

    @FXML
    private ImageView img1;

    @FXML
    private ImageView img2;

    @FXML
    private ImageView img3;

    @FXML
    private ImageView img4;

    @FXML
    private Label comingLabel;

    @FXML
    private void initialize() {
        ViewUtil.initiateResponsiveView(this);
        animateBubble(img1, 20, 3);
        animateBubble(img2, 15, 4);
        animateBubble(img3, 25, 5);
        animateBubble(img4, 18, 3.5);
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
