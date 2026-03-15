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

    public static String email;
    public static String oldScene;
    private StringBuilder verficationCode = new StringBuilder("    ");

    @FXML
    private void initialize() {
        ViewUtil.initiateResponsiveView(this);
        setupOtpFields();
        System.out.println(email);
        System.out.println(oldScene);
    }

    private void setupOtpFields() {

        TextField[] fields = { otpField1, otpField2, otpField3, otpField4 };

        for (int i = 0; i < fields.length; i++) {
            int index = i;
            TextField current = fields[i];
            TextField previous = (i > 0) ? fields[i - 1] : null;
            TextField next = (i < fields.length - 1) ? fields[i + 1] : null;

            current.textProperty().addListener((obs, oldValue, newValue) -> {

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
                //لعمل paste للكود
                if (newValue.length() > 1 && newValue.length() >= fields.length - index) {
                    char[] digits = newValue.toCharArray();
                    for (int j = 0; j < digits.length && (index + j) < fields.length; j++) {
                        fields[index + j].setText(String.valueOf(digits[j]));
                    }
                    fields[fields.length - 1].requestFocus();
                    return;
                }
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

    @FXML
    private void handleVerify() {

        String code = verficationCode.toString().trim();

        if (code.isEmpty()) {
            System.out.println("Verification code is empty");
            return;
        }

        if (!code.matches("\\d{4}")) {
            System.out.println("Verification code must be 4 digits");
            return;
        }
        System.out.println("Verification code: " + code);
    }

}
