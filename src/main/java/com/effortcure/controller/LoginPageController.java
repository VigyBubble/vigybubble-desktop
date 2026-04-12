package com.effortcure.controller;

import com.effortcure.dto.response.ApiResponse;
import com.effortcure.dto.response.LoginResponseDTO;
import com.effortcure.navigator.SceneManager;
import com.effortcure.service.implementation.AuthService;
import com.effortcure.service.interfaces.AuthServiceInterface;
import com.effortcure.util.BooleanWrapperUtil;
import com.effortcure.util.ControllersUtil;
import com.effortcure.util.ViewUtil;

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
    private void login() throws Exception {
        if (isValidLoginData()) {
            ApiResponse<LoginResponseDTO> response = authService.login(textFieldEmail.getText(), password.toString());
            if (response.getStatus() == 200) {
                SceneManager.switchScene("/fxml/main-template.fxml");
            }
            if (response.getStatus() == 401) {
                passwordErrorMsg.setText(response.getMessage() + " *");
                ViewUtil.showHiddenErrorMessages(new Label[] { passwordErrorMsg });
                passwordField.getStyleClass().add("error-field");
            }
            if (response.getStatus() == 403) {
                EmailVerficationPageController.email = textFieldEmail.getText();
                EmailVerficationPageController.oldScene = "LOGIN";
                SceneManager.switchScene("/fxml/email-verfication-page.fxml");
            }
            if (response.getStatus() == 404) {
                emailErrorMsg.setText("Email doesn't exist *");
                ViewUtil.showHiddenErrorMessages(new Label[] { emailErrorMsg });
                textFieldEmail.getStyleClass().add("error-field");
            }
        } else {
            if (!isValidEmail) {
                textFieldEmail.setText(textFieldEmail.getText() + " ");
                textFieldEmail.setText(textFieldEmail.getText().trim());
            }
            if (!isValidPassword) {
                passwordField.setText(passwordField.getText() + " ");
                passwordField.setText(passwordField.getText().trim());
            }
        }
    }

    @FXML
    private void forgotPassword() throws Exception {
        if (isValidEmail) {
            ApiResponse<Void> response = authService.checkEmailExistance(textFieldEmail.getText());
            if (response.getStatus() == 409) {
                Task<ApiResponse<Void>> task = new Task<ApiResponse<Void>>() {
                    @Override
                    protected ApiResponse<Void> call() throws Exception {
                        return authService.forgotPassword(textFieldEmail.getText());
                    }
                };
                new Thread(task).start();
                EmailVerficationPageController.email = textFieldEmail.getText();
                EmailVerficationPageController.oldScene = "FORGOT_PASSWORD";
                SceneManager.switchScene("/fxml/email-verfication-page.fxml");
            } else {
                emailErrorMsg.setText("Email doesn't exist *");
                ViewUtil.showHiddenErrorMessages(new Label[] { emailErrorMsg });
                textFieldEmail.getStyleClass().add("error-field");
            }
        } else {
            textFieldEmail.setText(textFieldEmail.getText() + " ");
            textFieldEmail.setText(textFieldEmail.getText().trim());
        }
    }

    @FXML
    private void register() {
        SceneManager.switchScene("/fxml/register-page.fxml");
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
            } else if (!newValue.matches("^[a-zA-Z0-9]+(?:[._][a-zA-Z0-9]+)*(?:\\+[a-zA-Z0-9]+)?@gmail\\.com$")) {
                emailErrorMsg.setText("only a-z, A-Z, 0-9, [._%+-] @gmail.com *");
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
            } else {
                ViewUtil.hideErrorMessages(new Label[] { passwordErrorMsg });
                passwordField.getStyleClass().removeAll("error-field");
                isValidPassword = true;
            }
        });
    }

    private boolean isValidLoginData() {
        return isValidEmail && isValidPassword;
    }
}
