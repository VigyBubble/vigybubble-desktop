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

    private Runnable onConfirm;
    private Runnable onCancel;

    public static String comesFrom;

    @FXML
    private void initialize() {
        ViewUtil.initiateResponsiveView(this);
        if (comesFrom != null && comesFrom.equals("INSPECT_SESSION_CONTROLLER")) {
            confirmBtn.setOnAction(e -> {
                InspectSessionsController.pauseAction = true;
                ((Stage) confirmBtn.getScene().getWindow()).close();
            });
            cancelBtn.setOnAction(e -> {
                InspectSessionsController.pauseAction = false;
                ((Stage) cancelBtn.getScene().getWindow()).close();
            });
            comesFrom = null;
        }

    }

    public void setupDeleteMode() {
        title.setText("Delete Bubble");
        content.setText("Are you sure you want to delete this bubble?");
        confirmBtn.setText("Delete");
        confirmBtn.getStyleClass().add("delete-btn");
    }

    public void setupDeleteMode(String newTitle, String message) {
        title.setText(newTitle);
        content.setText(message);
        confirmBtn.setText("Delete");
        confirmBtn.getStyleClass().add("delete-btn");
    }

    public void setOnConfirm(Runnable action) {
        this.onConfirm = action;
    }

    public void setOnCancel(Runnable action) {
        this.onCancel = action;
    }

    @FXML
    private void handleConfirm() {
        if (onConfirm != null)
            onConfirm.run();
        ((Stage) (confirmBtn.getScene().getWindow())).close();
    }

    @FXML
    private void handleCancel() {
        if (onCancel != null)
            onCancel.run();
        ((Stage) (cancelBtn.getScene().getWindow())).close();
    }
}
