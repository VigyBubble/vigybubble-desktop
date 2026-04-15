package com.effortcure.controller;

import com.effortcure.util.ViewUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;

public class HomePageController {


    @FXML private AnchorPane root;
    @FXML
    private ImageView bubbleImg1;
    @FXML
    private ImageView bubbleImg2;
    @FXML
    private ImageView bubbleImg3;
    @FXML
    private ImageView bubbleImg4;
    @FXML
    private ImageView bubbleImg5;
    @FXML
    private Pane searchPane;
    @FXML
    private Label dayLabel;
    @FXML
    private TextField searchField;
    @FXML
    private ImageView searchIcon;
    @FXML
    private Separator searchSeparator;
    @FXML
    private Button addBtn;
    @FXML
    private ImageView addIcon;
    @FXML
    private ComboBox<String> typeComboBox;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox vboxContainer;
    @FXML
    private Pane bubbleCardPane;
    @FXML
    private ImageView closeIcon;
    @FXML
    private Label titleLabel;
    @FXML
    private Label descriptionLabel;
    @FXML
    private Label teamLabel;
    @FXML
    private Label dateLabel;
    @FXML
    private Pane actualdurationPane;
    @FXML
    private Pane InnerActualDurationPane;
    @FXML
    private Label ActualDurationlabel;
    @FXML
    private Pane dayPane;
    @FXML
    private Label NumofDayLabel;
    @FXML
    private Label dLabel;
    @FXML
    private Pane hourPane;
    @FXML
    private Label hoursLabel;
    @FXML
    private Label hLabel;
    @FXML
    private Pane minutesPane;
    @FXML
    private Label minutesLabel;
    @FXML
    private Label mLabel;
    @FXML
    private Pane estimatedDurationPane;
    @FXML
    private Pane InnerEstimatedDurationPane;
    @FXML
    private Label estimatedDurationLabel;
    @FXML
    private Pane estimatedDaysInnerPane;
    @FXML
    private Label estimatedNumofdaysLabel;
    @FXML
    private Label d2label;
    @FXML
    private Pane hourPane2;
    @FXML
    private Label hoursLabel2;
    @FXML
    private Label hLabel2;
    @FXML
    private Pane minutesPane2;
    @FXML
    private Label minutesLabel2;
    @FXML
    private Label mLabel2;
    @FXML
    private Pane dateofBubblePane;
     @FXML
     
    private void initialize() {
        ViewUtil.initiateResponsiveView(this);}

    }