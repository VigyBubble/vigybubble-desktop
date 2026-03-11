package com.effortcure.controller;

import com.effortcure.dto.response.ApiResponse;
import com.effortcure.navigator.SceneManager;
import com.effortcure.service.implementation.AuthService;
import com.effortcure.service.interfaces.AuthServiceInterface;
import com.effortcure.util.JsonUtil;
import com.effortcure.util.ResponsiveViewUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
    private PasswordField passwordFeild;

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
    private PasswordField confirmPasswordFeild;

    @FXML
    private ImageView hideConfirmPasswordIcon;

    @FXML
    private ImageView confirmPasswordIcon;

    @FXML
    private Button registerBtn;

    private AuthServiceInterface authService = new AuthService();

    @FXML
    private void initialize() {
        ResponsiveViewUtil.convertToResponsiveView(root, new Node[] {
                root,
                firstContainer,
                leftImageContainer,
                leftImageRectangle,
                leftImageGradientContainer,
                leftContentContainer,
                createAccountLabel,
                enterYorDataLabel,
                loginBtn,
                formContainer,
                nameContainer,
                nameLabel,
                nameFeild,
                nameErrorMsg,
                nameIcon,
                emailContainer,
                emailLabel,
                emailFeild,
                emailErrorMsg,
                emailIcon,
                passwordContainer,
                passwordLabel,
                passwordFeild,
                passwordErrorMsg,
                hidePasswordIcon,
                passwordIcon,
                confirmPasswordContainer,
                confirmPasswordLabel,
                confirmPasswordErrorMsg,
                confirmPasswordFeild,
                hideConfirmPasswordIcon,
                confirmPasswordIcon,
                registerBtn }, new Label[] { nameErrorMsg, emailErrorMsg, confirmPasswordErrorMsg, passwordErrorMsg },
                true);
    }

    @FXML
    private void register() {
        ResponsiveViewUtil.convertToResponsiveView(root, new Node[] {
                root,
                firstContainer,
                leftImageContainer,
                leftImageRectangle,
                leftImageGradientContainer,
                leftContentContainer,
                createAccountLabel,
                enterYorDataLabel,
                loginBtn,
                formContainer,
                nameContainer,
                nameLabel,
                nameFeild,
                nameErrorMsg,
                nameIcon,
                emailContainer,
                emailLabel,
                emailFeild,
                emailErrorMsg,
                emailIcon,
                passwordContainer,
                passwordLabel,
                passwordFeild,
                passwordErrorMsg,
                hidePasswordIcon,
                passwordIcon,
                confirmPasswordContainer,
                confirmPasswordLabel,
                confirmPasswordErrorMsg,
                confirmPasswordFeild,
                hideConfirmPasswordIcon,
                confirmPasswordIcon,
                registerBtn },
                new Label[] { nameErrorMsg, emailErrorMsg, confirmPasswordErrorMsg, passwordErrorMsg },
                false);
        System.out.println("clicked");
    }

    private void handleRegister() throws Exception {
        String name = this.nameFeild.getText();
        String email = this.emailFeild.getText();
        String password = this.passwordFeild.getText();
        String confirmPassword = this.confirmPasswordFeild.getText();

        Task<ApiResponse<Void>> task = new Task<>() {
            @Override
            protected ApiResponse<Void> call() throws Exception {
                return authService.register(name, email, password, confirmPassword);
            }
        };

        task.setOnSucceeded(e -> {
            ApiResponse<Void> response = task.getValue();
            if (response.getStatus() == 201)
                SceneManager.switchScene("/fxml/email-verfication-page.fxml");
            try {
                System.out.println(JsonUtil.toJson(response));
            } catch (JsonProcessingException e1) {
                e1.printStackTrace();
            }
        });
        new Thread(task).start();
    }

}
