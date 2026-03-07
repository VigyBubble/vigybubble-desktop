package com.effortcure.controller;

import com.effortcure.dto.response.ApiResponse;
import com.effortcure.navigator.SceneManager;
import com.effortcure.service.implementation.AuthService;
import com.effortcure.service.interfaces.AuthServiceInterface;
import com.effortcure.util.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterPageController {
    @FXML
    private TextField name;
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirmPassword;
    @FXML
    private Button showPasswordBtn;
    @FXML
    private Button showConfirmPasswordBtn;
    @FXML
    private Button registerBtn;

    private AuthServiceInterface authService = new AuthService();

    @FXML
    private void initialize() {
        registerBtn.setOnAction(event -> {
            try {
                handleRegister();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void handleRegister() throws Exception {
        String name = this.name.getText();
        String email = this.email.getText();
        String password = this.password.getText();
        String confirmPassword = this.confirmPassword.getText();

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
