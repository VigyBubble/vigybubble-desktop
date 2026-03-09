package com.effortcure.controller;

import com.effortcure.dto.response.ApiResponse;
import com.effortcure.navigator.SceneManager;
import com.effortcure.service.implementation.AuthService;
import com.effortcure.service.interfaces.AuthServiceInterface;
import com.effortcure.util.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

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
        responiveView(new Node[] {
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
                passwordErrorMsg,
                passwordFeild,
                hidePasswordIcon,
                passwordIcon,
                confirmPasswordContainer,
                confirmPasswordLabel,
                confirmPasswordErrorMsg,
                confirmPasswordFeild,
                hideConfirmPasswordIcon,
                confirmPasswordIcon,
                registerBtn });

        disableErrorMessages(new Node[] { nameErrorMsg, emailErrorMsg,
                passwordErrorMsg, confirmPasswordErrorMsg });
        registerBtn.setOnAction(event -> {
            try {
                handleRegister();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void disableErrorMessages(Node[] nodes) {
        for (Node n : nodes) {
            if (n instanceof Label label) {
                label.setVisible(false);
            }
        }
    }

    private void responiveView(Node[] nodes) {
        double screenWidth = Double.valueOf(System.getProperty("os.screen.width"));
        double screenHight = Double.valueOf(System.getProperty("os.screen.hight"));
        double widthRatio = screenWidth / root.getPrefWidth();
        double hightRatio = screenHight / root.getPrefHeight();
        resizeNodes(nodes, widthRatio, hightRatio);
    }

    private void resizeNodes(Node[] nodes, double widthRatio, double hightRatio) {
        for (Node n : nodes) {
            if (n instanceof Region region) {
                region.setPrefWidth(region.getPrefWidth() * widthRatio);
                region.setPrefHeight(region.getPrefHeight() * hightRatio);
                region.setMinWidth(region.getPrefWidth());
                region.setMinHeight(region.getPrefHeight());
                region.setMaxWidth(region.getPrefWidth());
                region.setMaxHeight(region.getPrefHeight());
                if (region.getParent() != null) {
                    Region parent = (Region) region.getParent();
                    Region parentErrorMsgRegion = parent.getChildrenUnmodifiable()
                            .stream()
                            .filter(node -> node.getId() != null && node.getId().contains("ErrorMsg"))
                            .filter(node -> node.isVisible() && node instanceof Region)
                            .map(node -> (Region) node)
                            .findFirst()
                            .orElse(null);
                    region.setLayoutX(
                            region.getLayoutX() / (parent.getPrefWidth() / widthRatio) * parent.getPrefWidth());
                    if (parentErrorMsgRegion == null) {
                        region.setLayoutY(
                                region.getLayoutY() / (parent.getPrefHeight() / hightRatio) * parent.getPrefHeight());
                    } else {
                        region.setLayoutY(
                                region.getLayoutY() / (parent.getPrefHeight() / hightRatio) * parent.getPrefHeight()
                                        + (parentErrorMsgRegion.getPrefHeight() / 2));
                    }
                }
                double fontScale = Math.min(region.getPrefWidth() / (region.getPrefWidth() / widthRatio),
                        region.getPrefHeight() / (region.getPrefHeight() / hightRatio));
                if (region instanceof Label label)
                    label.setFont(new Font(label.getFont().getSize() * fontScale));
                if (region instanceof Button btn) {
                    btn.setFont(new Font(btn.getFont().getSize() * fontScale));
                    btn.setPadding(new Insets(0));
                }
                if (region instanceof TextField textField)
                    textField.setFont(new Font(textField.getFont().getSize() * fontScale));
                if (region instanceof PasswordField passwordField)
                    passwordField.setFont(new Font(passwordField.getFont().getSize() * fontScale));
            }
            if (n instanceof ImageView imageView) {
                imageView.setFitWidth(imageView.getFitWidth() * widthRatio);
                imageView.setFitHeight(imageView.getFitHeight() * hightRatio);
                if (imageView.getParent() != null) {
                    Region parent = (Region) imageView.getParent();
                    Region parentErrorMsgRegion = parent.getChildrenUnmodifiable()
                            .stream()
                            .filter(node -> node.getId() != null && node.getId().contains("ErrorMsg"))
                            .filter(node -> node.isVisible() && node instanceof Region)
                            .map(node -> (Region) node)
                            .findFirst()
                            .orElse(null);
                    imageView.setLayoutX(
                            imageView.getLayoutX() / (parent.getPrefWidth() / widthRatio) * parent.getPrefWidth());
                    if (parentErrorMsgRegion == null) {
                        imageView.setLayoutY(
                                imageView.getLayoutY() / (parent.getPrefHeight() / hightRatio)
                                        * parent.getPrefHeight());
                    } else {
                        imageView.setLayoutY(
                                imageView.getLayoutY() / (parent.getPrefHeight() / hightRatio) * parent.getPrefHeight()
                                        + (parentErrorMsgRegion.getPrefHeight() / 2));
                    }
                }
            }
            if (n instanceof Rectangle rectangle) {
                rectangle.setWidth(rectangle.getWidth() * widthRatio);
                rectangle.setHeight(rectangle.getHeight() * hightRatio);
                if (rectangle.getParent() != null) {
                    Region parent = (Region) rectangle.getParent();
                    Region parentErrorMsgRegion = parent.getChildrenUnmodifiable()
                            .stream()
                            .filter(node -> node.getId() != null && node.getId().contains("ErrorMsg"))
                            .filter(node -> node.isVisible() && node instanceof Region)
                            .map(node -> (Region) node)
                            .findFirst()
                            .orElse(null);
                    rectangle.setLayoutX(
                            rectangle.getLayoutX() / (parent.getPrefWidth() / widthRatio) * parent.getPrefWidth());
                    if (parentErrorMsgRegion == null) {
                        rectangle.setLayoutY(
                                rectangle.getLayoutY() / (parent.getPrefHeight() / hightRatio)
                                        * parent.getPrefHeight());
                    } else {
                        rectangle.setLayoutY(
                                rectangle.getLayoutY() / (parent.getPrefHeight() / hightRatio) * parent.getPrefHeight()
                                        + (parentErrorMsgRegion.getPrefHeight() / 2));
                    }
                }
            }
        }
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
