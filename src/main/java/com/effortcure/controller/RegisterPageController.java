package com.effortcure.controller;

import com.effortcure.dto.response.ApiResponse;
import com.effortcure.service.implementation.AuthService;
import com.effortcure.service.interfaces.AuthServiceInterface;
import com.effortcure.util.BooleanWrapperUtil;
import com.effortcure.util.ControllersUtil;
import com.effortcure.util.JsonUtil;
import com.effortcure.util.ViewUtil;
import com.effortcure.util.SceneManager;
import com.fasterxml.jackson.core.JsonProcessingException;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class RegisterPageController {
    @FXML
    private AnchorPane root;

    @FXML
    private Pane firstContainer;

    @FXML
    private Pane leftImageContainer;

    @FXML
    private Rectangle leftImageRectangle;

    @FXML
    private Pane leftImageGradientContainer;

    @FXML
    private Pane leftContentContainer;

    @FXML
    private Label createAccountLabel;

    @FXML
    private Label enterYorDataLabel;

    @FXML
    private Button loginBtn;

    @FXML
    private Pane formContainer;

    @FXML
    private Pane nameContainer;

    @FXML
    private Label nameLabel;

    @FXML
    private TextField nameFeild;

    @FXML
    private Label nameErrorMsg;

    @FXML
    private ImageView nameIcon;

    @FXML
    private Pane emailContainer;

    @FXML
    private Label emailLabel;

    @FXML
    private TextField emailFeild;

    @FXML
    private Label emailErrorMsg;

    @FXML
    private ImageView emailIcon;

    @FXML
    private Pane passwordContainer;

    @FXML
    private Label passwordLabel;

    @FXML
    private Label passwordErrorMsg;

    @FXML
    private TextField passwordFeild;

    @FXML
    private ImageView hidePasswordIcon;

    @FXML
    private ImageView passwordIcon;

    @FXML
    private Pane confirmPasswordContainer;

    @FXML
    private Label confirmPasswordLabel;

    @FXML
    private Label confirmPasswordErrorMsg;

    @FXML
    private TextField confirmPasswordFeild;

    @FXML
    private ImageView hideConfirmPasswordIcon;

    @FXML
    private ImageView confirmPasswordIcon;

    @FXML
    private Button registerBtn;

    private AuthServiceInterface authService = new AuthService();

    private boolean isValidName;
    private boolean isValidEmail;
    private boolean isValidPassword;
    private boolean isValidConfirmPassword;
    private StringBuilder password = new StringBuilder();
    private StringBuilder confirmPassword = new StringBuilder();
    private BooleanWrapperUtil maskPasswordFeild = new BooleanWrapperUtil();
    private BooleanWrapperUtil maskConfirmPasswordFeild = new BooleanWrapperUtil();

    @FXML
    private void initialize() {
        ViewUtil.initiateResponsiveView(this);
        validateRegisterData();
        ControllersUtil.onMouseSelection(new TextField[] { passwordFeild, confirmPasswordFeild });
        ControllersUtil.disableTextFeildPasting(new TextField[] { passwordFeild, confirmPasswordFeild });
        ControllersUtil.getTypedTextOnKeyTypedOrDelete(passwordFeild, (typedText) -> {
            password = typedText;
        });
        ControllersUtil.getTypedTextOnKeyTypedOrDelete(confirmPasswordFeild, (typedText) -> {
            confirmPassword = typedText;
        });
        maskPasswordFeild.setBool(true);
        maskConfirmPasswordFeild.setBool(true);
        ViewUtil.maskTextFeildContent(passwordFeild, maskPasswordFeild);
        ViewUtil.maskTextFeildContent(confirmPasswordFeild, maskConfirmPasswordFeild);
    }

    @FXML
    private void register() {
        if (isValidRegisterData()) {
            Task<ApiResponse<Void>> task = new Task<>() {
                @Override
                protected ApiResponse<Void> call() throws Exception {
                    return authService.register(nameFeild.getText(), emailFeild.getText(), passwordFeild.getText(),
                            confirmPasswordFeild.getText());
                }
            };
            task.setOnSucceeded(e -> {
                ApiResponse<Void> response = task.getValue();
                try {
                    System.out.println(JsonUtil.toJson(response));
                } catch (JsonProcessingException e1) {
                    e1.printStackTrace();
                }
            });
            new Thread(task).start();
            EmailVerficationPageController.email = emailFeild.getText();
            EmailVerficationPageController.oldScene = "REGISTER";
            SceneManager.switchScene("/fxml/email-verfication-page.fxml");
        }
    }

    @FXML
    private void login() {
        SceneManager.switchScene("/fxml/login-page.fxml");
    }

    @FXML
    private void hideAndShowPassword() {
        if (maskPasswordFeild.getBool()) {
            hidePasswordIcon.setImage(new Image(getClass().getResource("/images/open-eye.png").toExternalForm()));
            maskPasswordFeild.setBool(false);
            int cursorPositionBeforeSettingFeild = passwordFeild.getCaretPosition();
            passwordFeild.setText(password.toString());
            passwordFeild.positionCaret(cursorPositionBeforeSettingFeild);

        } else {
            hidePasswordIcon.setImage(new Image(getClass().getResource("/images/locked-eye.png").toExternalForm()));
            maskPasswordFeild.setBool(true);
            int cursorPositionBeforeSettingFeild = passwordFeild.getCaretPosition();
            passwordFeild.setText(passwordFeild.getText() + " ");
            passwordFeild.positionCaret(cursorPositionBeforeSettingFeild);
        }
    }

    @FXML
    private void hideAndShowConfirmPassword() {
        if (maskConfirmPasswordFeild.getBool()) {
            hideConfirmPasswordIcon
                    .setImage(new Image(getClass().getResource("/images/open-eye.png").toExternalForm()));
            maskConfirmPasswordFeild.setBool(false);
            int cursorPositionBeforeSettingFeild = confirmPasswordFeild.getCaretPosition();
            confirmPasswordFeild.setText(confirmPassword.toString());
            confirmPasswordFeild.positionCaret(cursorPositionBeforeSettingFeild);
        } else {
            hideConfirmPasswordIcon
                    .setImage(new Image(getClass().getResource("/images/locked-eye.png").toExternalForm()));
            maskConfirmPasswordFeild.setBool(true);
            int cursorPositionBeforeSettingFeild = confirmPasswordFeild.getCaretPosition();
            confirmPasswordFeild.setText(confirmPasswordFeild.getText() + " ");
            confirmPasswordFeild.positionCaret(cursorPositionBeforeSettingFeild);
        }
    }

    private void validateRegisterData() {
        nameFeild.textProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue.isBlank()) {
                nameErrorMsg.setText("name is required *");
                ViewUtil.showHiddenErrorMessages(new Label[] { nameErrorMsg });
                nameFeild.getStyleClass().add("error-field");
                isValidName = false;
            } else if (!newValue.matches("^[A-Za-z\\s-]{1,25}$")) {
                nameErrorMsg.setText("only A-z, a-z, space, - are allowed *");
                if (newValue.length() > 25)
                    nameErrorMsg.setText("name must be less than 26 characters*");
                ViewUtil.showHiddenErrorMessages(new Label[] { nameErrorMsg });
                isValidName = false;
            } else {
                ViewUtil.hideErrorMessages(new Label[] { nameErrorMsg });
                nameFeild.getStyleClass().removeAll("error-field");
                isValidName = true;
            }
        });
        emailFeild.textProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue.isBlank()) {
                emailErrorMsg.setText("email is required *");
                ViewUtil.showHiddenErrorMessages(new Label[] { emailErrorMsg });
                emailFeild.getStyleClass().add("error-field");
                isValidEmail = false;
            } else if (!newValue.matches("^[a-z0-9]+(?:[._][a-z0-9]+)*(?:\\+[a-z0-9]+)?@gmail\\.com$")) {
                emailErrorMsg.setText("must match a-z, 0-9, [._%+-] @gmail.com *");
                ViewUtil.showHiddenErrorMessages(new Label[] { emailErrorMsg });
                emailFeild.getStyleClass().add("error-field");
                isValidEmail = false;
            } else {
                ViewUtil.hideErrorMessages(new Label[] { emailErrorMsg });
                emailFeild.getStyleClass().removeAll("error-field");
                isValidEmail = true;
            }
        });
        passwordFeild.textProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue.isBlank()) {
                if (!passwordErrorMsg.getText().equals("can't paste here *"))
                    passwordErrorMsg.setText("password is required *");
                ViewUtil.showHiddenErrorMessages(new Label[] { passwordErrorMsg });
                passwordFeild.getStyleClass().add("error-field");
                password.setLength(0);
                isValidPassword = false;
            } else if (!password.toString().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).{8,25}$")) {
                passwordErrorMsg.setText("must have A-Z, a-z, 0-9, special characters *");
                if (password.toString().length() < 8 || password.toString().length() > 25)
                    passwordErrorMsg.setText("must be between 8-25 characters *");
                ViewUtil.showHiddenErrorMessages(new Label[] { passwordErrorMsg });
                passwordFeild.getStyleClass().add("error-field");
                isValidPassword = false;
            } else {
                ViewUtil.hideErrorMessages(new Label[] { passwordErrorMsg });
                passwordFeild.getStyleClass().removeAll("error-field");
                isValidPassword = true;
            }
        });
        confirmPasswordFeild.textProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue.isBlank()) {
                if (!confirmPasswordErrorMsg.getText().equals("can't paste here *"))
                    confirmPasswordErrorMsg.setText("password is required *");
                ViewUtil.showHiddenErrorMessages(new Label[] { confirmPasswordErrorMsg });
                confirmPasswordFeild.getStyleClass().add("error-field");
                confirmPassword.setLength(0);
                isValidConfirmPassword = false;
            } else if (!password.toString().equals(confirmPassword.toString())) {
                confirmPasswordErrorMsg.setText("password mismatch*");
                ViewUtil.showHiddenErrorMessages(new Label[] { confirmPasswordErrorMsg });
                confirmPasswordFeild.getStyleClass().add("error-field");
                isValidConfirmPassword = false;
            } else {
                ViewUtil.hideErrorMessages(new Label[] { confirmPasswordErrorMsg });
                confirmPasswordFeild.getStyleClass().removeAll("error-field");
                isValidConfirmPassword = true;
            }
        });
    }

    private boolean isValidRegisterData() {
        return isValidName && isValidEmail && isValidPassword && isValidConfirmPassword;
    }

}
