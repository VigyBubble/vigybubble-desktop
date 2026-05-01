package com.effortcure.controller;

import com.effortcure.util.ViewUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class AppListCardController {
    @FXML
    private Pane appListCard;

    @FXML
    private ImageView selectedappLogo1;

    @FXML
    private Label SelectedAppnameLabel;

    @FXML
    private ImageView deleteBtn1;

    @FXML
    private void initialize() {
        ViewUtil.initiateResponsiveView(this);
    }
}
