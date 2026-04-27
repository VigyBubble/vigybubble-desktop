package com.effortcure.controller;

import com.effortcure.util.ViewUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class InspectSessionsController {

    @FXML
    private ScrollPane scrolpane;

    @FXML
    private VBox rootVBox; // لو حابة تتحكمي في الـ VBox لو احتجتي لاحقًا

    // Main panes
    @FXML
    private Pane mainPane;

    // Header elements
    @FXML
    private Label recommendationLabel;

    // Control buttons in top right
    @FXML
    private ImageView pauseBtn;

    @FXML
    private ImageView doneBtn;

    // Info labels
    @FXML
    private Label dwpLabel;

    @FXML
    private Label pausedAtLabel;

    // Grid container pane (cards container)
    @FXML
    private Pane gridPane;

    // Notification section
    @FXML
    private Pane notificationPane;

    @FXML
    private ScrollPane notificationScroll;

    @FXML
    private VBox notificationVBox;

    @FXML
    private Label notificationLabel;

    // Bottom controls
    @FXML
    private Button deleteButton;

    @FXML
    private Label dateLabel;

    // bubbles (optional if you need them)
    @FXML
    private ImageView bubble1;

    @FXML
    private ImageView bubble2;

    @FXML
    private ImageView bubble3;

    @FXML
    private ImageView bubble4;

    @FXML
    private ImageView bubble5;

    @FXML
    private ImageView bubble6;

    @FXML
    private ImageView bubble7;

    @FXML
    public void initialize() {
        ViewUtil.initiateResponsiveView(this);
    }

}