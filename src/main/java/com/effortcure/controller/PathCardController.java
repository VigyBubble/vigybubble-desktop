package com.effortcure.controller;

import com.effortcure.util.ViewUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class PathCardController {
    @FXML
    private Pane itemPane1;

    @FXML
    private ImageView icon1;

    @FXML
    private Label textLabel1;

    @FXML
    private Label typeLabel1;

    @FXML
    private ImageView removeIcon1;

    @FXML
    private void initialize() {
        ViewUtil.initiateResponsiveView(this);
    }
}
