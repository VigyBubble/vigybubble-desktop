package com.effortcure.controller;

import com.effortcure.util.ViewUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class InspectBubbleAppCardController {
    @FXML
    private Pane appCardofInspectBubble;

    @FXML
    private Label name;

    @FXML
    private ImageView icon;

    @FXML
    private void initialize() {
        ViewUtil.initiateResponsiveView(this);
    }
}
