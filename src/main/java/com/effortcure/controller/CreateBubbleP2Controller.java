package com.effortcure.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.image.ImageView;

public class CreateBubbleP2Controller {
    @FXML private AnchorPane paneContainer;


@FXML private ImageView arrowBtn;
@FXML private Button nextBtn;
@FXML private ImageView progressImg;

@FXML private ImageView bubbleImg1;
@FXML private ImageView bubbleImg2;


@FXML private Label selectLabel;
@FXML private Label appListLabel;

@FXML private Pane applicationsContainer;
@FXML private ScrollPane scrollApplications;
@FXML private VBox vBoxAppsContainer;

@FXML private Pane softwareItemPane;
@FXML private CheckBox checkBoxBtn;
@FXML private ImageView softwareImg;
@FXML private Label appNameLabel;
@FXML private Label recommendedLabel;

@FXML private Pane addAppField;
@FXML private TextField urlField;
@FXML private Button addBtn;

@FXML private Pane listContainer;

@FXML private Pane appItemPane1;
@FXML private ImageView anacondaIcon;
@FXML private Label anacondaNameLabel;
@FXML private ImageView deleteBtn1;

@FXML private Pane appItemPane2;
@FXML private ImageView pycharmIcon;
@FXML private Label pycharmNameLabel;
@FXML private ImageView deleteBtn2;
}
