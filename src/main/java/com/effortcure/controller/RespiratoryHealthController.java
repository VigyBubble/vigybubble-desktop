package com.effortcure.controller;

import com.effortcure.navigator.SceneManager;
import com.effortcure.util.ViewUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.image.ImageView;

public class RespiratoryHealthController {

    @FXML
    private AnchorPane root;

    @FXML
    private StackPane aboutPane;
    @FXML
    private ImageView aboutIcon;

    @FXML
    private Pane line1;
    @FXML
    private Pane line2;
    @FXML
    private Pane line3;
    @FXML
    private Pane line4;
    @FXML
    private Pane line7;
    @FXML
    private Pane line10;
    @FXML
    private Pane line11;
    @FXML
    private Pane line12;

    @FXML
    private StackPane diseeasePane;
    @FXML
    private ImageView diseaseIcon;

    @FXML
    private StackPane eyepane;
    @FXML
    private ImageView eyeicon;

    @FXML
    private StackPane respiratorypane;
    @FXML
    private ImageView respiratoryicon;

    @FXML
    private StackPane pluspane;
    @FXML
    private ImageView plusicon;

    @FXML
    private Button skipbutton;
    @FXML
    private ImageView skipicon;

    @FXML
    private Pane respiratoryhealthpane;
    @FXML
    private Label respiratoryhealthlabel;

    @FXML
    private Pane pane1;
    @FXML
    private Label question1;
    @FXML
    private RadioButton yes1;
    @FXML
    private RadioButton no1;

    @FXML
    private Pane pane2;
    @FXML
    private Label qustioon2;
    @FXML
    private RadioButton yes2;
    @FXML
    private RadioButton no2;

    @FXML
    private ImageView eyehealthimg;

    @FXML
    private Button backbtn;
    @FXML
    private Button nextbtn;

    @FXML
    public void initialize() {
        ViewUtil.initiateResponsiveView(this);

    }

    @FXML
    private void moveToOtherQues() {
        SceneManager.switchScene("/fxml/other-medical-conditions.fxml", null);
    }

    @FXML
    private void backTodEyeQues() {
        SceneManager.switchScene("/fxml/eye-health.fxml", null);
    }
}
