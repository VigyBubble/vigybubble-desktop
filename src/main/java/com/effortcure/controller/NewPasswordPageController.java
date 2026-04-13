package com.effortcure.controller;

import com.effortcure.dto.response.ApiResponse;
import com.effortcure.navigator.SceneManager;
import com.effortcure.service.implementation.AccountService;
import com.effortcure.service.interfaces.AccountServiceInterface;
import com.effortcure.util.BooleanWrapperUtil;
import com.effortcure.util.ControllersUtil;
import com.effortcure.util.ViewUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class NewPasswordPageController {
    @FXML
    private AnchorPane root;

    @FXML
    private Pane mainContainer;

    @FXML
    private ImageView backIcon;

    @FXML
    private ImageView vigyLogo;

    @FXML
    private Separator separator;

    @FXML
    private Pane passwordPane;

    @FXML
    private Label passwordLabel;

    @FXML
    private ImageView passwordIcon;

    @FXML
    private TextField passwordField;

    @FXML
    private Label passwordErrorMsg;

    @FXML
    private ImageView passwordLock;

    @FXML
    private Pane confirmPasswordPane;

    @FXML
    private Label confirmPasswordLabel;

    @FXML
    private TextField confirmPasswordField;

    @FXML
    private ImageView confirmpasswordIcon;

    @FXML
    private Label confirmpasswordErrorMsg;

    @FXML
    private ImageView confirmPasswordLock;

    @FXML
    private Label successChangedPassword;

    @FXML
    private ImageView infoIcon;

    @FXML
    private Button saveButton;

    private AccountServiceInterface accountServiceInterface = new AccountService();

    private boolean isValidPassword;
    private boolean isValidConfirmPassword;
    private StringBuilder password = new StringBuilder();
    private StringBuilder confirmPassword = new StringBuilder();
    private BooleanWrapperUtil maskPasswordFeild = new BooleanWrapperUtil();
    private BooleanWrapperUtil maskConfirmPasswordFeild = new BooleanWrapperUtil();

    @FXML
    private void initialize() {
        ViewUtil.initiateResponsiveView(this);
        infoIcon.setVisible(false);
        successChangedPassword.setVisible(false);
        ValidateNewPasswordData();
        ControllersUtil.onMouseSelection(new TextField[] { passwordField, confirmPasswordField });
        ControllersUtil.disableTextFeildPasting(new TextField[] { passwordField, confirmPasswordField });
        ControllersUtil.getTypedTextOnKeyTypedOrDelete(passwordField, (typedText) -> {
            password = typedText;
        });
        ControllersUtil.getTypedTextOnKeyTypedOrDelete(confirmPasswordField, (typedText) -> {
            confirmPassword = typedText;
        });
        maskPasswordFeild.setBool(true);
        maskConfirmPasswordFeild.setBool(true);
        ViewUtil.maskTextFeildContent(passwordField, maskPasswordFeild);
        ViewUtil.maskTextFeildContent(confirmPasswordField, maskConfirmPasswordFeild);
    }

    @FXML
    private void save() throws Exception {
        if (isValidNewPasswordData()) {
            ApiResponse<Void> response = accountServiceInterface.changePassword(password.toString(),
                    confirmPassword.toString());
            if (response != null) {
                if (response.getStatus() == 200) {
                    infoIcon.setVisible(true);
                    successChangedPassword.setVisible(true);
                }
            }
        } else {
            passwordField.setText(passwordField.getText() + " ");
            passwordField.setText(passwordField.getText().trim());
            confirmPasswordField.setText(confirmPasswordField.getText() + " ");
            confirmPasswordField.setText(confirmPasswordField.getText().trim());
        }
    }

    @FXML
    private void back() {
        if (successChangedPassword.isVisible())
            SceneManager.switchScene("/fxml/login-page.fxml", null);
        else
            SceneManager.switchScene("/fxml/main-template.fxml", null);
    }

    @FXML
    private void hideAndShowPassword() {
        if (maskPasswordFeild.getBool()) {
            passwordLock.setImage(new Image(getClass().getResource("/images/open-eye.png").toExternalForm()));
            maskPasswordFeild.setBool(false);
            int cursorPositionBeforeSettingFeild = passwordField.getCaretPosition();
            passwordField.setText(password.toString());
            passwordField.positionCaret(cursorPositionBeforeSettingFeild);

        } else {
            passwordLock.setImage(new Image(getClass().getResource("/images/locked-eye.png").toExternalForm()));
            maskPasswordFeild.setBool(true);
            int cursorPositionBeforeSettingFeild = passwordField.getCaretPosition();
            passwordField.setText(passwordField.getText() + " ");
            passwordField.positionCaret(cursorPositionBeforeSettingFeild);
        }
    }

    @FXML
    private void hideAndShowConfirmPassword() {
        if (maskConfirmPasswordFeild.getBool()) {
            confirmPasswordLock.setImage(new Image(getClass().getResource("/images/open-eye.png").toExternalForm()));
            maskConfirmPasswordFeild.setBool(false);
            int cursorPositionBeforeSettingFeild = confirmPasswordField.getCaretPosition();
            confirmPasswordField.setText(confirmPassword.toString());
            confirmPasswordField.positionCaret(cursorPositionBeforeSettingFeild);
        } else {
            confirmPasswordLock.setImage(new Image(getClass().getResource("/images/locked-eye.png").toExternalForm()));
            maskConfirmPasswordFeild.setBool(true);
            int cursorPositionBeforeSettingFeild = confirmPasswordField.getCaretPosition();
            confirmPasswordField.setText(confirmPasswordField.getText() + " ");
            confirmPasswordField.positionCaret(cursorPositionBeforeSettingFeild);
        }
    }

    private void ValidateNewPasswordData() {
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
        confirmPasswordField.textProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue.isBlank()) {
                if (!confirmpasswordErrorMsg.getText().equals("can't paste here *"))
                    confirmpasswordErrorMsg.setText("password is required *");
                ViewUtil.showHiddenErrorMessages(new Label[] { confirmpasswordErrorMsg });
                confirmPasswordField.getStyleClass().add("error-field");
                confirmPassword.setLength(0);
                isValidConfirmPassword = false;
            } else if (!password.toString().equals(confirmPassword.toString())) {
                confirmpasswordErrorMsg.setText("password mismatch*");
                ViewUtil.showHiddenErrorMessages(new Label[] { confirmpasswordErrorMsg });
                confirmPasswordField.getStyleClass().add("error-field");
                isValidConfirmPassword = false;
            } else {
                ViewUtil.hideErrorMessages(new Label[] { confirmpasswordErrorMsg });
                confirmPasswordField.getStyleClass().removeAll("error-field");
                isValidConfirmPassword = true;
            }
        });
    }

    private boolean isValidNewPasswordData() {
        return isValidConfirmPassword && isValidPassword;
    }
}
