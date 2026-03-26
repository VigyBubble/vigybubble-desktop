package com.effortcure.controller;

import com.effortcure.dto.response.ApiResponse;
import com.effortcure.service.implementation.AuthService;
import com.effortcure.service.interfaces.AuthServiceInterface;
import com.effortcure.util.BooleanWrapperUtil;
import com.effortcure.util.ControllersUtil;
import com.effortcure.util.JsonUtil;
import com.effortcure.util.SceneManager;
import com.effortcure.util.ViewUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
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
    private Label emailErrorMsg;

    @FXML
    private Pane passwordContainer;

    @FXML
    private Label labelPassword;

    @FXML
    private TextField passwordField;

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

    private AuthServiceInterface authService = new AuthService();


    private boolean isValidEmail;
    private boolean isValidPassword;
    private StringBuilder password = new StringBuilder();
    private BooleanWrapperUtil maskPasswordFeild = new BooleanWrapperUtil();



    @FXML
    private void initialize() {
        ViewUtil.initiateResponsiveView(this);
        validateLoginData();
        ControllersUtil.onMouseSelection(new TextField[] { passwordField });
        ControllersUtil.disableTextFeildPasting(new TextField[] { passwordField });
        ControllersUtil.getTypedTextOnKeyTypedOrDelete(passwordField, (typedText) -> {
            password = typedText;
        });
        maskPasswordFeild.setBool(true);
        ViewUtil.maskTextFeildContent(passwordField, maskPasswordFeild);
    }

      @FXML
    private void login(){
   
    }

    @FXML
    private void register() {
        SceneManager.switchScene("/fxml/new-password-page.fxml");
    }

    @FXML
    private void hideAndShowPassword() {
        if (maskPasswordFeild.getBool()) {
            locklIcon.setImage(new Image(getClass().getResource("/images/open-eye.png").toExternalForm()));
            maskPasswordFeild.setBool(false);
            int cursorPositionBeforeSettingFeild = passwordField.getCaretPosition();
            passwordField.setText(password.toString());
            passwordField.positionCaret(cursorPositionBeforeSettingFeild);

        } else {
            locklIcon.setImage(new Image(getClass().getResource("/images/locked-eye.png").toExternalForm()));
            maskPasswordFeild.setBool(true);
            int cursorPositionBeforeSettingFeild = passwordField.getCaretPosition();
            passwordField.setText(passwordField.getText() + " ");
            passwordField.positionCaret(cursorPositionBeforeSettingFeild);
        }
    }

    private void validateLoginData() {
        textFieldEmail.textProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue.isBlank()) {
                emailErrorMsg.setText("email is required *");
                ViewUtil.showHiddenErrorMessages(new Label[] { emailErrorMsg });
                textFieldEmail.getStyleClass().add("error-field");
                isValidEmail = false;
            } else if (!newValue.matches("^[a-z0-9]+(?:[._][a-z0-9]+)*(?:\\+[a-z0-9]+)?@gmail\\.com$")) {
                emailErrorMsg.setText("must match a-z, 0-9, [._%+-] @gmail.com *");
                ViewUtil.showHiddenErrorMessages(new Label[] { emailErrorMsg });
                textFieldEmail.getStyleClass().add("error-field");
                isValidEmail = false;
            } else {
                ViewUtil.hideErrorMessages(new Label[] { emailErrorMsg });
                textFieldEmail.getStyleClass().removeAll("error-field");
                isValidEmail = true;
            }
        });
        passwordField.textProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue.isBlank()) {
                if (!passwordErrorMsg.getText().equals("can't paste here *"))
                    passwordErrorMsg.setText("password is required *");
                ViewUtil.showHiddenErrorMessages(new Label[] { passwordErrorMsg });
                passwordField.getStyleClass().add("error-field");
                password.setLength(0);
                isValidPassword = false;
            } else if (!password.toString().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).{8,25}$")) {
                passwordErrorMsg.setText("must have A-Z, a-z, 0-9, special characters *");
                if (password.toString().length() < 8 || password.toString().length() > 25)
                    passwordErrorMsg.setText("must be between 8-25 characters *");
                ViewUtil.showHiddenErrorMessages(new Label[] { passwordErrorMsg });
                passwordField.getStyleClass().add("error-field");
                isValidPassword = false;
            } else {
                ViewUtil.hideErrorMessages(new Label[] { passwordErrorMsg });
                passwordField.getStyleClass().removeAll("error-field");
                isValidPassword = true;
            }
        });
    }
    private boolean isValidLoginData() {
        return isValidEmail && isValidPassword ;
    }
}



