package com.effortcure.controller;

import com.effortcure.util.ViewUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class BubbleCardController {
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
    private Pane actualdurationPane;

    @FXML
    private Pane InnerActualDurationPane;

    @FXML
    private Label ActualDurationlabel;

    @FXML
    private TextFlow dayPane;

    @FXML
    private Text NumofDayLabel;

    @FXML
    private Text dLabel;

    @FXML
    private TextFlow hourPane;

    @FXML
    private Text hoursLabel;

    @FXML
    private Text hLabel;

    @FXML
    private TextFlow minutesPane;

    @FXML
    private Text minutesLabel;

    @FXML
    private Text mLabel;

    @FXML
    private Pane estimatedDurationPane;

    @FXML
    private Pane InnerEstimatedDurationPane;

    @FXML
    private Label estimatedDurationLabel;

    @FXML
    private  TextFlow estimatedDaysInnerPane;

    @FXML
    private  Text estimatedNumofdaysLabel;

    @FXML
    private Text d2label;

    @FXML
    private TextFlow hourPane2;

    @FXML
    private Text hoursLabel2;

    @FXML
    private Text hLabel2;

    @FXML
    private TextFlow minutesPane2;

    @FXML
    private Text minutesLabel2;

    @FXML
    private Text mLabel2;

    @FXML
    private Label dateLabel;

    @FXML
    private Label bubbleUuid;

    @FXML
    private void initialize() {
        ViewUtil.initiateResponsiveView(this);
    }
}
