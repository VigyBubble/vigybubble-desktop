package com.effortcure.controller;

import com.effortcure.util.ViewUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class BubbleCardController {
    @FXML
    private Pane root;

    @FXML
    private Pane bubbleCardPane;

    @FXML
    private ImageView closeIcon;

    @FXML
    private Label titleLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label teamLabel;

    @FXML
    private Pane actualdurationPane;

    @FXML
    private Label actualLabel;

    @FXML
    private Label actualDuration;

    @FXML
    private Pane estimatedPane;

    @FXML
    private Label estimatedLabel;

    @FXML
    private Label estimatedDuration;

    @FXML
    private Label createdAtLabel;

    @FXML
    private Label bubbleUuid;

    @FXML
    private Separator actualSeparator;

    @FXML
    private Separator estimatedSeparator;

    @FXML
    private void initialize() {
        ViewUtil.initiateResponsiveView(this);
    }
}
