package com.effortcure.controller;

import com.effortcure.util.ViewUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Separator;

public class EmailVerficationPageController {
    @FXML
    private AnchorPane root;

    @FXML
    private Pane verficationContainer;

    @FXML
    private ImageView backBtn;

    @FXML
    private ImageView logoImg;

    @FXML
    private Pane contentContainer;

    @FXML
    private Label verficationLabel;

    @FXML
    private Label subtitleLabel;

    @FXML
    private Pane otpContainer;

    @FXML
    private TextField otpField1;

    @FXML
    private TextField otpField2;

    @FXML
    private TextField otpField3;

    @FXML
    private TextField otpField4;

    @FXML
    private Pane resendContainer;

    @FXML
    private Label resendLabel;

    @FXML
    private Hyperlink resendLink;

    @FXML
    private Separator separator;

    @FXML
    private Pane btnContainer;

    @FXML
    private Button verifyBtn;

    @FXML
    private void initialize() {
        ViewUtil.initiateResponsiveView(this);
    }
}
