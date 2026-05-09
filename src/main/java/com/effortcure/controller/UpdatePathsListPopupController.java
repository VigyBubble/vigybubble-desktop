package com.effortcure.controller;

import com.effortcure.util.ViewUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;

public class UpdatePathsListPopupController {
    @FXML
    private AnchorPane root;

    @FXML
    private Label update;

    @FXML
    private Separator separator;

    @FXML
    private ImageView close;

    @FXML
    private Pane pane1;

    @FXML
    private ImageView img2;

    @FXML
    private Button button;

    @FXML
    private TextField urlField;

    @FXML
    private Button selectFolderBtn;

    @FXML
    private Button selectFileBtn;

    @FXML
    private ImageView folderIcon;

    @FXML
    private ImageView fileIcon;

    @FXML
    private Button cancelBtn;

    @FXML
    private Button doneBtn;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox resourcesContainer;

    @FXML
    private void initialize() {
        ViewUtil.initiateResponsiveView(this);
    }
}
