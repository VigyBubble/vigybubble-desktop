package com.effortcure.controller;

import com.effortcure.util.ViewUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import javafx.scene.image.ImageView;
import javafx.scene.control.Separator;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;


public class UpateAppLIstPopupController {

    @FXML
    private AnchorPane root;

    @FXML
    private Label updateAppListLabel;

    @FXML
    private ImageView closeIcon1;

    @FXML
    private Separator separator;

    @FXML
    private Label selectApplicationLabel;

    @FXML
    private Label applicationListLabel;

    @FXML
    private Pane appListPane;

    @FXML
    private Pane innerApplistPane1;

    @FXML
    private ImageView appLOgo1;

    @FXML
    private Label appNameLbel;

    @FXML
    private ImageView closeIcon2;

    @FXML
    private Pane innerAppLIstPane;

    @FXML
    private ImageView appLogo2;

    @FXML
    private Label appNameLabel2;

    @FXML
    private ImageView closeIcon3;

    @FXML
    private Button cancelBtn;

    @FXML
    private Button donrBtn;

    @FXML
    private Pane secletAppPane;

    @FXML
    private Pane searchPane;

    @FXML
    private ImageView searchIcon;

    @FXML
    private Button addBtn;

    @FXML
    private TextField searcField;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox vbox;

    @FXML
    private Pane selectedPane1;

    @FXML
    private CheckBox checkbox1;

    @FXML
    private ImageView appLogo3;

    @FXML
    private Label appNameLabel3;

    @FXML
    private Label recommendedLabel1;

    @FXML
    private Pane selectedPane2;

    @FXML
    private CheckBox checkbox2;

    @FXML
    private ImageView appLogo4;

    @FXML
    private Label appNameLabel4;

    @FXML
    private Label recommendedLabel2;
    @FXML
    private void initialize() {

     ViewUtil.initiateResponsiveView(this);}


       
}