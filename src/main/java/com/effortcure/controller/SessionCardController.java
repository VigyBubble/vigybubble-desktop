package com.effortcure.controller;

import com.effortcure.util.ViewUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class SessionCardController {
    @FXML
    private Pane root;

    @FXML
    private ImageView usericon1;

    @FXML
    private Circle circleProfile1;

    @FXML
    private Label uuid;

    @FXML
    private Label name;

    @FXML
    private TextFlow pausedTextflow1;

    @FXML
    private Text pausedatText;

    @FXML
    private Text pauseDate;

    @FXML
    private Label status;

    @FXML
    private TextFlow cteateTextflow1;

    @FXML
    private Text createdatText1;

    @FXML
    private Text creationDate;

    @FXML
    private Label dwp;

    @FXML
    private void initialize() {
        ViewUtil.initiateResponsiveView(this);
    }
}
