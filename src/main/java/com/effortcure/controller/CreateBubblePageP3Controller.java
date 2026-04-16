
package com.effortcure.controller;

import com.effortcure.util.ViewUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class CreateBubblePageP3Controller {

    @FXML
    private AnchorPane root;

    @FXML
    private ImageView arrowBtn;

    @FXML
    private ImageView progressImg;

    @FXML
    private Button saveBtn;

    @FXML
    private ImageView bubbleImg1;

    @FXML
    private ImageView bubbleImg2;

    @FXML
    private ImageView bubbleImg3;

    @FXML
    private Pane enterUrlPane;

    @FXML
    private TextField urlField;

    @FXML
    private Button addBtn;

    @FXML
    private ImageView urlIcon;

    @FXML
    private Button selectFolderBtn;

    @FXML
    private Button selectFileBtn;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox resourcesContainer;

    @FXML
    private Pane itemPane1;

    @FXML
    private ImageView icon1;

    @FXML
    private Label textLabel1;

    @FXML
    private Label typeLabel1;

    @FXML
    private ImageView removeIcon1;

    @FXML
    private Pane itemPane2;

    @FXML
    private ImageView icon2;

    @FXML
    private Label textLabel2;

    @FXML
    private Label typeLabel2;

    @FXML
    private ImageView removeIcon2;

    @FXML
    private Pane itemPane3;

    @FXML
    private ImageView icon3;

    @FXML
    private Label textLabel3;

    @FXML
    private Label typeLabel3;

    @FXML
    private ImageView removeIcon3;

    @FXML
    private Pane itemPane4;

    @FXML
    private ImageView icon4;

    @FXML
    private Label textLabel4;

    @FXML
    private Label typeLabel4;

    @FXML
    private ImageView removeIcon4;
     @FXML
    private void initialize() {

     ViewUtil.initiateResponsiveView(this);}

}
   