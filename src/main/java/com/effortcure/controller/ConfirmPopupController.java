package com.effortcure.controller;


import com.effortcure.util.ViewUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ConfirmPopupController {
    @FXML
    private AnchorPane root;

    @FXML
    private Label title;

    @FXML
    private ImageView close;

    @FXML
    private Separator separator;

    @FXML
    private Label content;

    @FXML
    private Button cancelBtn;

    @FXML
    private Button confirmBtn;

    @FXML
    private void initialize() {
        ViewUtil.initiateResponsiveView(this);
    }

}
