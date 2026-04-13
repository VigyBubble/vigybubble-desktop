package com.effortcure.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.ImageView;

public class CreateBubbleP1Controller {
    @FXML
    private AnchorPane painContainer;

    @FXML
    private ImageView arrowBtn;

    @FXML
    private Label nameLabel;

    @FXML
    private TextField bubbleNameField;

    @FXML
    private Label descriptionLabel;

    @FXML
    private TextArea bubbleDescriptionField;

    @FXML
    private Button nextBtn;

    @FXML
    private ImageView progressImg;

    @FXML
    private ImageView bubbleImg;

    @FXML
    private Label typeLabel;

    @FXML
    private ComboBox<String> comboBox;
}
