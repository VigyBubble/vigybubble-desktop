package com.effortcure.controller;

import java.lang.reflect.Field;

import com.effortcure.dto.response.ApiResponse;
import com.effortcure.service.implementation.AuthService;
import com.effortcure.service.interfaces.AuthServiceInterface;
import com.effortcure.util.ControllersUtil;
import com.effortcure.util.JsonUtil;
import com.effortcure.util.ResponsiveViewUtil;
import com.effortcure.util.SceneManager;
import com.fasterxml.jackson.core.JsonProcessingException;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
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
    private boolean showPassword;
    private boolean showConfirmPassword;
    private Integer mouseSelectedStart;
    private Integer mouseSelectedEnd;

    @FXML
    private void initialize() {
        ResponsiveViewUtil.initiateResponsiveView(this);
        validateRegisterData();
        ControllersUtil.disableTextFeildPasting(passwordFeild, passwordErrorMsg, "can't paste *");
        hidePassword(passwordFeild, 1);
        hidePassword(confirmPasswordFeild, 2);
    }

    @FXML
    private void login() {
        SceneManager.switchScene("/fxml/login-page.fxml");
    }

    @FXML
    private void hideAndShowPassword() {
        if (!showPassword) {
            hidePasswordIcon.setImage(new Image(getClass().getResource("/images/open-eye.png").toExternalForm()));
            showPassword = true;
            passwordFeild.setText(password.toString());
        } else {
            hidePasswordIcon.setImage(new Image(getClass().getResource("/images/locked-eye.png").toExternalForm()));
            showPassword = false;
            passwordFeild.setText(passwordFeild.getText() + " ");
        }
    }

    @FXML
    private void hideAndShowConfirmPassword() {
        if (!showConfirmPassword) {
            hideConfirmPasswordIcon
                    .setImage(new Image(getClass().getResource("/images/open-eye.png").toExternalForm()));
            showConfirmPassword = true;
            confirmPasswordFeild.setText(confirmPassword.toString());
        } else {
            hideConfirmPasswordIcon
                    .setImage(new Image(getClass().getResource("/images/locked-eye.png").toExternalForm()));
            showConfirmPassword = false;
            confirmPasswordFeild.setText(confirmPasswordFeild.getText() + " ");
        }
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
            SceneManager.switchScene("/fxml/email-verfication-page.fxml");
        }
    }

    private void validateRegisterData() {
        nameFeild.textProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue.isBlank()) {
                nameErrorMsg.setText("name is required *");
                ResponsiveViewUtil.showHiddenErrorMessages(new Label[] { nameErrorMsg });
                nameFeild.getStyleClass().add("error-field");
                isValidName = false;
            } else if (!newValue.matches("^[A-Za-z\\s-]{1,25}$")) {
                nameErrorMsg.setText("only A-z, a-z, space, - are allowed *");
                if (newValue.length() > 25)
                    nameErrorMsg.setText("name must be less than 26 characters*");
                ResponsiveViewUtil.showHiddenErrorMessages(new Label[] { nameErrorMsg });
                isValidName = false;
            } else {
                ResponsiveViewUtil.hideErrorMessages(new Label[] { nameErrorMsg });
                nameFeild.getStyleClass().removeAll("error-field");
                isValidName = true;
            }
        });
        emailFeild.textProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue.isBlank()) {
                emailErrorMsg.setText("email is required *");
                ResponsiveViewUtil.showHiddenErrorMessages(new Label[] { emailErrorMsg });
                emailFeild.getStyleClass().add("error-field");
                isValidEmail = false;
            } else if (!newValue.matches("^[a-z0-9]+(?:[._][a-z0-9]+)*(?:\\+[a-z0-9]+)?@gmail\\.com$")) {
                emailErrorMsg.setText("must match a-z, 0-9, [._%+-] @gmail.com *");
                ResponsiveViewUtil.showHiddenErrorMessages(new Label[] { emailErrorMsg });
                emailFeild.getStyleClass().add("error-field");
                isValidEmail = false;
            } else {
                ResponsiveViewUtil.hideErrorMessages(new Label[] { emailErrorMsg });
                emailFeild.getStyleClass().removeAll("error-field");
                isValidEmail = true;
            }
        });
        passwordFeild.textProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue.isBlank()) {
                passwordErrorMsg.setText("password is required *");
                ResponsiveViewUtil.showHiddenErrorMessages(new Label[] { passwordErrorMsg });
                passwordFeild.getStyleClass().add("error-field");
                isValidPassword = false;
            } else if (!password.toString().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).{8,25}$")) {
                passwordErrorMsg.setText("must have A-Z, a-z, 0-9, special characters *");
                if (password.toString().length() < 8 || password.toString().length() > 25)
                    passwordErrorMsg.setText("must be between 8-25 characters *");
                ResponsiveViewUtil.showHiddenErrorMessages(new Label[] { passwordErrorMsg });
                passwordFeild.getStyleClass().add("error-field");
                isValidPassword = false;
            } else {
                ResponsiveViewUtil.hideErrorMessages(new Label[] { passwordErrorMsg });
                passwordFeild.getStyleClass().removeAll("error-field");
                isValidPassword = true;
            }
        });
        confirmPasswordFeild.textProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue.isBlank()) {
                confirmPasswordErrorMsg.setText("password is required *");
                ResponsiveViewUtil.showHiddenErrorMessages(new Label[] { confirmPasswordErrorMsg });
                confirmPasswordFeild.getStyleClass().add("error-field");
                isValidConfirmPassword = false;
            } else if (!newValue.equals(passwordFeild.getText())) {
                confirmPasswordErrorMsg.setText("password mismatch*");
                ResponsiveViewUtil.showHiddenErrorMessages(new Label[] { confirmPasswordErrorMsg });
                confirmPasswordFeild.getStyleClass().add("error-field");
                isValidConfirmPassword = false;
            } else {
                ResponsiveViewUtil.hideErrorMessages(new Label[] { confirmPasswordErrorMsg });
                confirmPasswordFeild.getStyleClass().removeAll("error-field");
                isValidConfirmPassword = true;
            }
        });
    }

    private boolean isValidRegisterData() {
        return isValidName && isValidEmail && isValidPassword && isValidConfirmPassword;
    }

    private void hidePassword(TextField textField, int type) {
        ControllersUtil.onMouseSelection(textField, (start, end) -> {
            mouseSelectedStart = start;
            mouseSelectedEnd = end;
        });
        textField.textProperty().addListener((obs, oldValue, newValue) -> {
            textField.setOnKeyTyped(e -> {
                if (type == 1) {
                    if (e.getCharacter().equals("\b") && password.length() >= 1) {
                        if (mouseSelectedStart - mouseSelectedEnd == 0) {
                            password.deleteCharAt(textField.getCaretPosition());
                        } else {
                            for (int i = mouseSelectedStart; i <= mouseSelectedEnd - 1; i++) {
                                password.deleteCharAt(mouseSelectedStart);
                            }
                        }
                    } else {
                        if (textField.getCaretPosition() != 0)
                            password.insert(textField.getCaretPosition() - 1, e.getCharacter());
                    }
                } else {
                    if (e.getCharacter().equals("\b") && confirmPassword.length() >= 1) {
                        if (mouseSelectedStart - mouseSelectedEnd == 0) {
                            confirmPassword.deleteCharAt(textField.getCaretPosition());
                        } else {
                            for (int i = mouseSelectedStart; i <= mouseSelectedEnd - 1; i++) {
                                confirmPassword.deleteCharAt(mouseSelectedStart);
                            }
                        }
                    } else {
                        if (textField.getCaretPosition() != 0)
                            confirmPassword.insert(textField.getCaretPosition() - 1, e.getCharacter());
                    }
                }
            });
            if (!showPassword && type == 1)
                textField.setText("•".repeat(textField.getText().stripTrailing().length()));
            if (!showConfirmPassword && type != 1)
                textField.setText("•".repeat(textField.getText().stripTrailing().length()));
            if (textField.getText().equals(""))
                password.setLength(0);

        });
    }

}
