package com.effortcure.controller;

import java.util.function.Consumer;

import com.effortcure.util.ViewUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SessionModePopupController {
    @FXML
    private AnchorPane root;

    @FXML
    private Label startsessionlabel;
    @FXML
    private Label errorMsg;
    @FXML
    private Separator separator;

    @FXML
    private ImageView closeicon;

    @FXML
    private Pane patterndetectonpane;

    @FXML
    private Label patterndetectionlabel;

    @FXML
    private Label description1label;

    @FXML
    private Pane VigyInforcepane;

    @FXML
    private Label enforcelabel;

    @FXML
    private Label description2label;

    @FXML
    private Pane VigyRecommendationPane;

    @FXML
    private Label VigyRecommendationlabel;

    @FXML
    private Label description3label;

    @FXML
    private Button startbutton;

    @FXML
    private Pane EstimateDurationPane;

    @FXML
    private Label EstimateDurationLabel;
    @FXML
    private TextField hourField;
    @FXML
    private TextField minuteField;
    @FXML
    private Separator separator1;
    @FXML
    private Separator separator2;
    @FXML
    private Separator separator3;
    @FXML
    private Separator separator4;

    private Runnable onClose;
    private Pane selectedPane = null;
    private Consumer<String> onStart;

    @FXML
    private void initialize() {
        ViewUtil.initiateResponsiveView(this);
        closeicon.setOnMouseClicked(e -> handleClose());
        setupField(hourField, 23, "The maximum value of hours is 23*");
        setupField(minuteField, 59, " The maximum value of minutes is 59*");
        setupPaneSelection(patterndetectonpane, "selected-detection");
        setupPaneSelection(VigyInforcepane, "selected-enforce");
        setupPaneSelection(VigyRecommendationPane, "selected-recommendation");

        startbutton.setOnAction(e -> {
            String mode = getSelectedMode();
            if (hourField.getText().isEmpty() || minuteField.getText().isEmpty()) {
                showError("Please enter session duration*");
                return;
            }
            if (mode == null) {
                showError("Please select a mode first*");
                return;
            }
            if (onStart != null) {
                onStart.accept(mode);
            }

            closePopup();
        });
        hourField.textProperty().addListener(e -> errorMsg.setVisible(false));
        minuteField.textProperty().addListener(e -> errorMsg.setVisible(false));
    }

    private void showError(String message) {
        errorMsg.setText(message);
        errorMsg.setVisible(true);
    }

    public void setOnStart(Consumer<String> onStart) {
        this.onStart = onStart;
    }

    private void closePopup() {
        Stage stage = (Stage) startbutton.getScene().getWindow();
        stage.close();
    }

    private void setupField(TextField field, int max, String message) {
        field.textProperty().addListener((obs, oldVal, newVal) -> {

            if (newVal.isEmpty())
                return;

            if (!newVal.matches("\\d*")) {
                field.setText(oldVal);
                return;
            }

            int value = Integer.parseInt(newVal);

            if (value > max) {
                field.setText(oldVal);
                showError(message); 
            }
        });
    }

    private void setupPaneSelection(Pane pane, String styleClass) {
        pane.setOnMouseClicked(e -> {

            if (selectedPane != null) {
                selectedPane.getStyleClass().removeAll(
                        "selected-detection",
                        "selected-enforce",
                        "selected-recommendation");
            }

            selectedPane = pane;
            selectedPane.getStyleClass().add(styleClass);
        });
    }

    private String getSelectedMode() {
        if (selectedPane == patterndetectonpane)
            return "PATTERN";
        if (selectedPane == VigyInforcepane)
            return "ENFORCE";
        if (selectedPane == VigyRecommendationPane)
            return "RECOMMENDATION";
        return null;
    }

    public void setOnClose(Runnable onClose) {
        this.onClose = onClose;
    }

    @FXML
    private void handleClose() {
        if (onClose != null) {
            onClose.run();
        }
        ((Stage) (closeicon.getScene().getWindow())).close();
    }
}
