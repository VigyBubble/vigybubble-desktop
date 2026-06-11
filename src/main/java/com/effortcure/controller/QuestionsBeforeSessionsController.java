package com.effortcure.controller;

import com.effortcure.util.ViewUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
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
    private Spinner<Integer> spinner;

    @FXML
    private ComboBox<String>mlcombobox;

    @FXML
    private ImageView waterimg;

    @FXML
    private Pane mealpane;

    @FXML private RadioButton radiobtn1;
    @FXML private RadioButton radiobtn2;
    @FXML private RadioButton radiobtn3;
    @FXML private RadioButton radiobtn4;
    @FXML private RadioButton radiobtn5;
    @FXML private RadioButton radiobtn6;

    @FXML
    private ImageView mealimg;

    @FXML private Button donebtn;

    @FXML private Button skipbutton;

    @FXML
    public void initialize() {
        ViewUtil.initiateResponsiveView(this);

    }
}
