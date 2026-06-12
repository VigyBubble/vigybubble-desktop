package com.effortcure.controller;

import com.effortcure.controller.AboutYouController.NavigationData;
import com.effortcure.navigator.ContentManager;
import com.effortcure.navigator.PopupManager;
import com.effortcure.navigator.SceneManager;
import com.effortcure.util.ViewUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;


public class QuestionsBeforeSessionsController {

    @FXML
    private AnchorPane root;

    @FXML
    private Pane waterpane;

    @FXML
    private Label drinkquestion;

    @FXML
    private Spinner<Double> spinner;

    @FXML
    private ComboBox<String> mlcombobox;

    @FXML
    private ImageView waterimg;

    @FXML
    private Pane mealpane;

    @FXML
    private RadioButton radiobtn1;
    @FXML
    private RadioButton radiobtn2;
    @FXML
    private RadioButton radiobtn3;
    @FXML
    private RadioButton radiobtn4;
    @FXML
    private RadioButton radiobtn5;
    @FXML
    private RadioButton radiobtn6;

    @FXML
    private ImageView mealimg;

    @FXML
    private Button donebtn;

    @FXML
    private Button skipbutton;
    @FXML
    private Pane overlay;

    @FXML
    public void initialize() {
        ViewUtil.initiateResponsiveView(this);
        ToggleGroup group1 = new ToggleGroup();
        radiobtn1.setToggleGroup(group1);
        radiobtn2.setToggleGroup(group1);
        radiobtn3.setToggleGroup(group1);
        radiobtn4.setToggleGroup(group1);
        radiobtn5.setToggleGroup(group1);
        radiobtn6.setToggleGroup(group1);
        mlcombobox.getItems().addAll("mL", "L");
        mlcombobox.setValue("mL");
        SpinnerValueFactory.DoubleSpinnerValueFactory valueFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(
                0, 1000000, 0, 1);
        spinner.setValueFactory(valueFactory);
        spinner.setEditable(true);
        spinner.getEditor().clear();
        TextFormatter<String> formatter = new TextFormatter<>(change -> {
            String newText = change.getControlNewText();

            if (newText.matches("\\d*(\\.\\d*)?")) {
                return change;
            }

            return null;
        });

        spinner.getEditor().setTextFormatter(formatter);

        mlcombobox.valueProperty().addListener((obs, oldUnit, newUnit) -> {
            String text = spinner.getEditor().getText();
            if (text == null || text.isBlank()
                    || oldUnit == null) {
                return;
            }
            double currentValue = Double.parseDouble(text);
            double convertedValue = currentValue;

            if ("L".equals(newUnit)
                    && "mL".equals(oldUnit)) {

                convertedValue = currentValue / 1000.0;

            } else if ("mL".equals(newUnit)
                    && "L".equals(oldUnit)) {
                convertedValue = currentValue * 1000.0;
            }
            spinner.getEditor().setText(
                    String.valueOf(convertedValue));
        });
        skipbutton.setOnAction(e -> {
            NavigationData.nextPage = "/fxml/create-session.fxml";
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
    }

    @FXML
    private void handleDoneBtn() {
        ContentManager.setAnchorPane(root);
        ContentManager.switchContent("/fxml/inspect-session.fxml");
    }
}
