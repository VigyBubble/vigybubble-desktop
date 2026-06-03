
package com.effortcure.controller;
import com.effortcure.util.ViewUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class AboutYouController {

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
    private StackPane diseeasePane;

    @FXML
    private ImageView diseaseIcon;

    @FXML
    private Pane line4;

    @FXML
    private Pane line5;

    @FXML
    private Pane line6;

    @FXML
    private StackPane eyepane;

    @FXML
    private ImageView eyeicon;

    @FXML
    private Pane line7;

    @FXML
    private Pane line8;

    @FXML
    private Pane line9;

    @FXML
    private StackPane respiratorypane;

    @FXML
    private ImageView respiratoryicon;

    @FXML
    private Pane line10;

    @FXML
    private Pane line11;

    @FXML
    private Pane line12;

    @FXML
    private StackPane pluspane;

    @FXML
    private ImageView plusicon;

    @FXML
    private Button skipbutton;

    @FXML
    private ImageView skipicon;

    @FXML
    private Pane abotpane;

    @FXML
    private Label aboutlabel;

    @FXML
    private Label agelabel;

    @FXML
    private ImageView aboutimg;

    @FXML
    private Spinner<Integer> spinner;

    @FXML
    private TextField hightfield;

    @FXML
    private Label heightlabel;

    @FXML
    private ComboBox<String> heightcombobox;

    @FXML
    private TextField weightfield;

    @FXML
    private Label weightlabel;

    @FXML
    private ComboBox<String> wheightcombobox;

    @FXML
    private Button nextbutton;
    
    @FXML
    private void initialize() {
        ViewUtil.initiateResponsiveView(this);
    }
}