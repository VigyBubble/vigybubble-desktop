package com.effortcure.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;

public class CreateBubbleP3Controller {
    @FXML private AnchorPane paneContainer;

// Top controls
@FXML private ImageView arrowBtn;
@FXML private ImageView progressImg;
@FXML private Button saveBtn;

// Bubbles
@FXML private ImageView bubbleImg1;
@FXML private ImageView bubbleImg2;
@FXML private ImageView bubbleImg3;

// URL Section
@FXML private Pane enterUrlPane;
@FXML private ImageView urlIcon;
@FXML private TextField urlField;
@FXML private Button addBtn;

// Select buttons
@FXML private Button selectFolderBtn;
@FXML private ImageView selectIcon1;
@FXML private Button selectFileBtn;
@FXML private ImageView selectIcon2;

// Scroll + container
@FXML private ScrollPane scrollPane;
@FXML private VBox resourcesContainer;

// Item 1
@FXML private Pane itemPane1;
@FXML private ImageView icon1;
@FXML private Label textLabel1;
@FXML private Label typeLabel1;
@FXML private ImageView removeIcon1;
@FXML private Separator separator1;

// Item 2
@FXML private Pane itemPane2;
@FXML private ImageView icon2;
@FXML private Label textLabel2;
@FXML private Label typeLabel2;
@FXML private ImageView removeIcon2;
@FXML private Separator separator2;

// Item 3
@FXML private Pane itemPane3;
@FXML private ImageView icon3;
@FXML private Label textLabel3;
@FXML private Label typeLabel3;
@FXML private ImageView removeIcon3;
@FXML private Separator separator3;

// Item 4
@FXML private Pane itemPane4;
@FXML private ImageView icon4;
@FXML private Label textLabel4;
@FXML private Label typeLabel4;
@FXML private ImageView removeIcon4;
@FXML private Separator separator4;

// Item 5
@FXML private Pane itemPane5;
@FXML private ImageView icon5;
@FXML private Label textLabel5;
@FXML private Label typeLabel5;
@FXML private ImageView removeIcon5;
@FXML private Separator separator5;
}
