package com.effortcure.controller;

import com.effortcure.controller.AboutYouController.NavigationData;
import com.effortcure.navigator.PopupManager;
import com.effortcure.navigator.SceneManager;
import com.effortcure.util.ViewUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.image.ImageView;

public class OtherMedicalConditionsController {

    @FXML
    private AnchorPane root;

    @FXML
    private ScrollPane scrollpane;
    @FXML
    private VBox vbox;
    @FXML
    private Pane mainpane;

    @FXML
    private StackPane aboutPane;
    @FXML
    private ImageView aboutIcon;

    @FXML
    private Pane line1;
    @FXML
    private Pane line2;
    @FXML
    private Pane line3;
    @FXML
    private Pane line4;
    @FXML
    private Pane line7;
    @FXML
    private Pane line10;
    @FXML
    private Pane line11;

    @FXML
    private StackPane diseeasePane;
    @FXML
    private ImageView diseaseIcon;

    @FXML
    private StackPane eyepane;
    @FXML
    private ImageView eyeicon;

    @FXML
    private StackPane respiratorypane;
    @FXML
    private ImageView respiratoryicon;

    @FXML
    private StackPane pluspane;
    @FXML
    private ImageView plusicon;

    @FXML
    private Button skipbutton;
    @FXML
    private ImageView skipicon;

    @FXML
    private Pane othermedicalconditionspane;
    @FXML
    private Label othermedicalconditionslabel;

    @FXML
    private Pane pane1;
    @FXML
    private Label question1;
    @FXML
    private RadioButton yes1;
    @FXML
    private RadioButton no1;

    @FXML
    private Pane pane2;
    @FXML
    private Label qustioon2;
    @FXML
    private RadioButton yes2;
    @FXML
    private RadioButton no2;

    @FXML
    private Pane pane3;
    @FXML
    private Label question3;
    @FXML
    private RadioButton yes3;
    @FXML
    private RadioButton no3;

    @FXML
    private ImageView othermedicalconditionsimg;

    @FXML
    private Button backbtn;
    @FXML
    private Button donebtn;
    @FXML
    private Pane overlay;

    @FXML
    public void initialize() {
        ViewUtil.initiateResponsiveView(this);
        skipbutton.setOnAction(e -> {
            NavigationData.nextPage = "/fxml/main-template.fxml";
            GaussianBlur blur = new GaussianBlur(5);
            root.setEffect(blur);
            overlay.setVisible(true);
            PopupManager.showPopup("/fxml/quick-questions-popup.fxml", controller -> {
                QuickQuestionPopupController ctrl = (QuickQuestionPopupController) controller;
                ctrl.setOnConfirm(() -> {
                    root.setEffect(null);
                    overlay.setVisible(false);
                    SceneManager.switchScene(NavigationData.nextPage, null);
                });
                ctrl.setOnCancel(() -> {
                    root.setEffect(null);
                    overlay.setVisible(false);
                });
            });
        });
        ToggleGroup group1 = new ToggleGroup();
        yes1.setToggleGroup(group1);
        no1.setToggleGroup(group1);

        ToggleGroup group2 = new ToggleGroup();
        yes2.setToggleGroup(group2);
        no2.setToggleGroup(group2);

        ToggleGroup group3 = new ToggleGroup();
        yes3.setToggleGroup(group3);
        no3.setToggleGroup(group3);
    }

    @FXML
    private void moveToHome() {
        SceneManager.switchScene("/fxml/main-template.fxml", null);
    }

    @FXML
    private void backToRespiratoryQues() {
        SceneManager.switchScene("/fxml/respiratory-health.fxml", null);
    }
}
