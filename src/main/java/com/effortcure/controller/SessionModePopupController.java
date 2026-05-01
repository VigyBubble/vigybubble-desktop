package com.effortcure.controller;

import com.effortcure.util.ViewUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SessionModePopupController {
    @FXML
    private AnchorPane root;

    @FXML
    private Label startsessionlabel;

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

    @FXML
    private void initialize() {
        ViewUtil.initiateResponsiveView(this);
        patterndetectionlabel.setFont(
                Font.font("System", FontWeight.BOLD, 25));
        enforcelabel.setFont(
                Font.font("System", FontWeight.BOLD, 25));
        VigyRecommendationlabel.setFont(
                Font.font("System", FontWeight.BOLD,25));
    closeicon.setOnMouseClicked(e -> handleClose());
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
