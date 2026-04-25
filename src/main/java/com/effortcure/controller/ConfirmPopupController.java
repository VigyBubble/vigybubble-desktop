package com.effortcure.controller;

import com.effortcure.util.ViewUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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

    public static boolean doAction;

    @FXML
    private void initialize() {
        ViewUtil.initiateResponsiveView(this);
        doAction = false;
    }

    @FXML
    private void doAction() {
        doAction = true;
        ((Stage) (confirmBtn.getScene().getWindow())).close();
    }

    @FXML
    private void cancelAction() {
        doAction = false;
        ((Stage) (cancelBtn.getScene().getWindow())).close();

    }
}
