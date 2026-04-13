package com.effortcure.controller;

import com.effortcure.util.ViewUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;

public class MainTemplateController {
    @FXML
    private AnchorPane root;

    @FXML
    private Pane navbarPane;

    @FXML
    private Pane userCard;

    @FXML
    private Label userNameLabel;

    @FXML
    private Label dwsLabel;

    @FXML
    private Pane profileImgContainer;

    @FXML
    private ImageView profileImg;

    @FXML
    private Pane rightControlsContainer;

    @FXML
    private Pane planPane;

    @FXML
    private Label planLabel;

    @FXML
    private Pane settingsBtn;

    @FXML
    private ImageView settingsIcon;

    @FXML
    private Pane notificationBtn;

    @FXML
    private Pane navBar;

    @FXML
    private Pane homeTab;

    @FXML
    private Hyperlink homeLink;

    @FXML
    private Pane peripheralsTab;

    @FXML
    private Hyperlink peripheralsLink;

    @FXML
    private Pane analyticsTab;

    @FXML
    private Hyperlink analyticsLink;

    @FXML
    private Pane teamsTab;

    @FXML
    private Hyperlink teamsLink;

    @FXML
    private AnchorPane anchorPaneBody;

    @FXML
    private Button notificationsBtn;

    @FXML
    private ImageView bellIcon;
    
    @FXML
    private Button settingBtn;

    @FXML
    private ImageView settingIcon;
    
    @FXML
    private Button teamsBtn;

    @FXML
    private Button analyticsBtn;

    @FXML
    private Button peripheralsBtn;

    @FXML
    private Button homeBtn;

    @FXML
    private void initialize() {
        ViewUtil.initiateResponsiveView(this);
    }

}
