package com.effortcure.controller;

import com.effortcure.util.ViewUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.image.ImageView;

public class EyeHealthDiseaseController {
    @FXML private AnchorPane root;
@FXML private ScrollPane scrollpane;
@FXML private VBox vbox;
@FXML private Pane mainpane;

@FXML private StackPane aboutPane;
@FXML private ImageView aboutIcon;

@FXML private Pane line1;
@FXML private Pane line2;

@FXML private StackPane diseeasePane;
@FXML private ImageView diseaseIcon;

@FXML private Pane line3;
@FXML private Pane line4;

@FXML private StackPane eyepane;
@FXML private ImageView eyeicon;

@FXML private Pane line7;
@FXML private Pane line8;
@FXML private Pane line9;

@FXML private StackPane respiratorypane;
@FXML private ImageView respiratoryicon;

@FXML private Pane line10;
@FXML private Pane line11;
@FXML private Pane line12;

@FXML private StackPane pluspane;
@FXML private ImageView plusicon;

@FXML private Button skipbutton;
@FXML private ImageView skipicon;

@FXML private Pane eyehealthpane;
@FXML private Label eyehealthlabel;

@FXML private Pane pane1;
@FXML private Label question1;
@FXML private RadioButton yes1;
@FXML private RadioButton no1;

@FXML private Pane pane2;
@FXML private Label qustioon2;
@FXML private RadioButton yes2;
@FXML private RadioButton no2;

@FXML private Pane pane3;
@FXML private Label question3;
@FXML private RadioButton yes3;
@FXML private RadioButton no3;

@FXML private Pane pane4;
@FXML private Label question4;
@FXML private RadioButton yes4;
@FXML private RadioButton no4;

@FXML private ImageView eyehealthimg;

@FXML private Button backbtn;
@FXML private Button nextbtn;

 @FXML
    public void initialize() {
        ViewUtil.initiateResponsiveView(this);

    }


}
