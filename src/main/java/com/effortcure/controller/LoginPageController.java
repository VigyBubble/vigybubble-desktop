package com.effortcure.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.ImageView;

public class LoginPageController {
    @FXML
private AnchorPane root;

    @FXML
    private Pane mainpane;

    @FXML
    private Pane rightImageContainer;

    @FXML
    private Rectangle rightImageRectangle;

    @FXML
    private Pane rightImageGradientContainer;

    @FXML
    private Pane rightContentContainer;

    @FXML
    private Label labelWelcome;

    @FXML
    private Label labelInfo;

    @FXML
    private Button buttonRegister;

    @FXML
    private Pane formContainer;

    @FXML
    private Pane emailContainer;

    @FXML
    private Label labelEmail;

    @FXML
    private ImageView emailIcon;

    @FXML
    private TextField textFieldEmail;

    @FXML
    private Pane passwordContainer;

    @FXML
    private Label labelPassword;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ImageView passwordlIcon;

    @FXML
    private Label passwordErrorMsg;

    @FXML
    private ImageView locklIcon;

    @FXML
    private CheckBox checkRememberMe;

    @FXML
    private Hyperlink linkForgotPassword;

    @FXML
    private Button buttonLogin;
}
