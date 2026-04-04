package com.effortcure.controller;

import com.effortcure.dto.response.ApiResponse;
import com.effortcure.navigator.SceneManager;
import com.effortcure.service.implementation.AuthService;
import com.effortcure.service.interfaces.AuthServiceInterface;
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
    private Label verificationErrorMsg;

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

    public static String email;
    public static String oldScene;
    private StringBuilder verficationCode = new StringBuilder("    ");
    AuthServiceInterface authService = new AuthService();

    @FXML
    private void initialize() {
        ViewUtil.initiateResponsiveView(this);
        setupOtpFields();
    }

    @FXML
    private void handleVerify() throws Exception {
        TextField[] otpFeilds = new TextField[] { otpField1, otpField2, otpField3, otpField4 };
        for (TextField otpFeild : otpFeilds) {
            if (otpFeild.getText().isBlank())
                otpFeild.getStyleClass().add("otpFieldsError");
        }
        if (!verficationCode.toString().trim().isBlank() && email != null) {
            ApiResponse<Void> response = authService.verifyEmail(email, verficationCode.toString().trim());
            if (response.getStatus() == 200)
                SceneManager.switchScene("/fxml/login-page.fxml");
            if (response.getStatus() == 400) {
                verificationErrorMsg.setText(response.getMessage() + " *");
                verificationErrorMsg.setVisible(true);
                for (TextField otpFeild : otpFeilds) {
                    if (otpFeild.getText().isBlank())
                        otpFeild.getStyleClass().add("otpFieldsError");
                }
            }
            if (response.getStatus() == 401) {
                verificationErrorMsg.setText(response.getMessage() + " *");
                verificationErrorMsg.setVisible(true);
                for (TextField otpFeild : otpFeilds)
                    otpFeild.getStyleClass().add("otpFieldsError");
            }
        }
    }

    @FXML
    private void resendCode() {

    }

    @FXML
    private void back() {
        if (oldScene.equals("REGISTER"))
            SceneManager.switchScene("/fxml/register-page.fxml");
    }

    private void setupOtpFields() {

        TextField[] fields = { otpField1, otpField2, otpField3, otpField4 };

        for (int i = 0; i < fields.length; i++) {
            int index = i;
            TextField current = fields[i];
            TextField previous = (i > 0) ? fields[i - 1] : null;
            TextField next = (i < fields.length - 1) ? fields[i + 1] : null;

            current.textProperty().addListener((obs, oldValue, newValue) -> {
                verificationErrorMsg.setVisible(false);
                current.getStyleClass().removeAll("otpFieldsError");
                // ارقام فقط يمنع إدخال الحروف أو الرموز
                if (!newValue.matches("\\d*")) {
                    current.setText(newValue.replaceAll("[^\\d]", ""));
                }

                // يمنع إدخال أكثر من رقم
                if (newValue.length() > 1) {
                    current.setText(String.valueOf(newValue.charAt(0)));
                    return;
                }
                // ينتقل تلقائي
                if (newValue.length() == 1 && next != null) {
                    next.requestFocus();
                }
                // لعمل paste للكود
                if (newValue.length() > 1 && newValue.length() >= fields.length - index) {
                    char[] digits = newValue.toCharArray();
                    for (int j = 0; j < digits.length && (index + j) < fields.length; j++) {
                        fields[index + j].setText(String.valueOf(digits[j]));
                    }
                    fields[fields.length - 1].requestFocus();
                    return;
                }
                // لتحديث الكود في ال StringBuilder
                if (!newValue.isEmpty()) {
                    verficationCode.setCharAt(index, newValue.charAt(0));
                } else {
                    verficationCode.setCharAt(index, ' ');
                }
            });

            current.setOnKeyPressed(e -> {
                switch (e.getCode()) {

                    case BACK_SPACE:
                        if (current.getText().isEmpty() && previous != null) {
                            previous.requestFocus();
                        }
                        break;

                    default:
                        break;
                }
            });

        }
    }
}
