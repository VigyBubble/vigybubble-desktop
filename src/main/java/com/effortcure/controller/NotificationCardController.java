package com.effortcure.controller;

import com.effortcure.util.ViewUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class NotificationCardController {
    @FXML
    private AnchorPane root;
    @FXML
    private Label notificationTitle;
    @FXML
    private Label content;
    @FXML
    private Label date;

    @FXML
    private void initialize() {
        ViewUtil.initiateResponsiveView(this);
    }
}
