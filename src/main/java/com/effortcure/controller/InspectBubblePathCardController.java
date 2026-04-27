package com.effortcure.controller;

import com.effortcure.util.ViewUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class InspectBubblePathCardController {
    @FXML
    private Pane pathCardofInspectBubble;

    @FXML
    private ImageView Icon;

    @FXML
    private Label path;

    @FXML
    private Label typeLabel;

    @FXML
    private void initialize() {
        ViewUtil.initiateResponsiveView(this);
    }
}
