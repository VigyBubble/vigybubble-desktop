package com.effortcure.controller;

import com.effortcure.util.ViewUtil;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class AppSelectionCardController {
    @FXML
    private Pane root;

    @FXML
    private CheckBox checkBox;

    @FXML
    private ImageView logo;

    @FXML
    private Label appName;

    @FXML
    private Label recommendedLabel;

    @FXML
    private void initialize() {
        ViewUtil.initiateResponsiveView(this);

    }
}
