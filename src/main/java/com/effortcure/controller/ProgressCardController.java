package com.effortcure.controller;

import com.effortcure.util.ViewUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;

public class ProgressCardController {
    @FXML
    private Pane root;
    @FXML
    private StackPane stackPane;
    @FXML
    private Label progressLabel;
    @FXML
    private Circle progressCircle;
    @FXML
    private Label metricLabel;

    @FXML
    public void initialize() throws Exception {
        ViewUtil.initiateResponsiveView(this);
    }
}
