package com.effortcure.controller;

// import com.effortcure.controller.AboutYouController.NavigationData;
// import com.effortcure.navigator.SceneManager;
import com.effortcure.util.ViewUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;

public class QuickQuestionPopupController {
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

    public void setOnConfirm(Runnable onConfirm) {
        this.onConfirm = onConfirm;
    }

    public void setOnCancel(Runnable onCancel) {
        this.onCancel = onCancel;
    }

    @FXML
    private void initialize() {
        ViewUtil.initiateResponsiveView(this);

        confirmBtn.setOnAction(e -> {
            Stage popupStage = (Stage) confirmBtn.getScene().getWindow();
            popupStage.close();
            if (onConfirm != null) {
                onConfirm.run();
            }
        });

        cancelBtn.setOnAction(e -> {
            Stage popupStage = (Stage) cancelBtn.getScene().getWindow();
            popupStage.close();
            if (onCancel != null) {
                onCancel.run();
            }
        });
        close.setOnMouseClicked(e -> {
            Stage popupStage = (Stage) close.getScene().getWindow();
            popupStage.close();
            if (onCancel != null) {
                onCancel.run();
            }
        });

    }
}
