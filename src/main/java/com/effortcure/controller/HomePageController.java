package com.effortcure.controller;

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
    @FXML
    private AnchorPane paneContainer;

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
    private Separator searchSeparator;
    @FXML
    private TextField searchField;
    @FXML
    private ImageView searchIcon;

    @FXML
    private ComboBox<String> typeComboBox;

    @FXML
    private Button addBtn;
    @FXML
    private ImageView addIcon;

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox resourcesContainer;

    @FXML
    private Pane bubbleCard;
    @FXML
    private ImageView closeIcon;
    @FXML
    private Label titleLabel;
    @FXML
    private Label descriptionLabel;
    @FXML
    private Label teamLabel;
    @FXML
    private Label datePane;

    @FXML
    private Pane actualDurationPane;
    @FXML
    private Label actualLabel;
    @FXML
    private Label actualDaysValue;
    @FXML
    private Label actualHoursValue;
    @FXML
    private Separator actualSeparator1;
    @FXML
    private Label actualDaysLabel;
    @FXML
    private Label actualHoursLabel;
    @FXML
    private Separator actualSeparator2;
    @FXML
    private Label actualMinutesValue;
    @FXML
    private Label actualMinutesLabel;

    @FXML
    private Pane estimatedDurationPane;
    @FXML
    private Label estimatedLabel;
    @FXML
    private Label estimatedDaysValue;
    @FXML
    private Label estimatedHoursValue;
    @FXML
    private Separator estimatedSep1;
    @FXML
    private Label estimatedDaysLabel;
    @FXML
    private Label estimatedHoursLabel;
    @FXML
    private Separator estimatedSep2;
    @FXML
    private Label estimatedMinutesValue;
    @FXML
    private Label estimatedMinutesLabel;

}
