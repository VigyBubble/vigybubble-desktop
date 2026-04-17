package com.effortcure.controller;

import com.effortcure.util.ViewUtil;

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


public class CreateBubblePageP2Controller {
    
    @FXML private AnchorPane root;

    
    @FXML 
    private ImageView arrowBtn;
    @FXML
     private Button nextBtn;
    @FXML
     private ImageView progressImg;
    @FXML
     private ImageView bubbleImg1;
    @FXML 
    private ImageView bubbleImg2;

    
    @FXML
     private Label selectLabel;
    @FXML
     private Label appListLabel;

  
    @FXML
     private Pane applicationsContainer;
    @FXML
     private ScrollPane scrollApplications;
    @FXML 
    private VBox vBoxAppsContainer;

    @FXML
     private Pane searchPane;
    @FXML
     private ImageView serchIcon;
    @FXML
     private TextField searcField;
    @FXML
     private Button addBtn;

    @FXML 
    private Pane appPane1;
    @FXML 
    private CheckBox checkBoxBtn1;
    @FXML
     private ImageView appLogo1;
    @FXML 
    private Label appNameLabel1;
    @FXML 
    private Label recommendedLabel1;

    @FXML
     private Pane appPane2;
    @FXML
     private CheckBox checkBox2;
    @FXML
     private ImageView appLogo2;
    @FXML
     private Label appNameLabel2;
    @FXML
     private Label recommendedLabe2;


    @FXML 
    private Pane appPane3;
    @FXML
     private CheckBox checkbox3;
    @FXML
     private ImageView appLogo3;
    @FXML 
    private Label appNameLabel3;

    @FXML
     private Pane appPane4;
    @FXML
     private CheckBox checkbox4;
    @FXML
     private ImageView appLogo4;
    @FXML 
    private Label appNameLabel4;

    @FXML
     private Pane listofAppsPane;

    @FXML 
    private Pane appItemPane1;
    @FXML
     private ImageView selectedappLogo1;
    @FXML
     private Label SelectedAppnameLabel;
    @FXML
     private ImageView deleteBtn1;

    @FXML
     private Pane seslectedAppPane2;
    @FXML
     private ImageView selectedappLogo2;
    @FXML 
    private Label SelectedAppnameLabel2;
    @FXML 
    private ImageView deleteBtn2;
     @FXML
    private void initialize() {

     ViewUtil.initiateResponsiveView(this);}

}
