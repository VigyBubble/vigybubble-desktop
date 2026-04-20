package com.effortcure.controller;

import java.util.List;

import com.effortcure.dto.response.AccountBubblesResponseDTO;
import com.effortcure.dto.response.ApiResponse;
import com.effortcure.service.implementation.BubbleService;
import com.effortcure.service.interfaces.BubbleServiceInterface;
import com.effortcure.util.ViewUtil;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;

public class HomePageController {

    @FXML
    private AnchorPane root;

    @FXML
    private ImageView bubbleImg1;

    @FXML
    private ImageView bubbleImg2;

    @FXML
    private ImageView bubbleImg3;

    @FXML
    private ImageView bubbleImg4;

    @FXML
    private ImageView bubbleImg5;

    @FXML
    private Pane searchPane;

    @FXML
    private Label dayLabel;

    @FXML
    private TextField searchField;

    @FXML
    private ImageView searchIcon;

    @FXML
    private Separator searchSeparator;

    @FXML
    private Button addBtn;

    @FXML
    private ImageView addIcon;

    @FXML
    private ComboBox<String> typeComboBox;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox vboxContainer;

    private BubbleServiceInterface bubbleServiceInterface = new BubbleService();

    @FXML
    private void initialize() throws Exception {
        ViewUtil.initiateResponsiveView(this);
        getBubbles();
    }

    private void getBubbles() throws Exception {
        ApiResponse<List<AccountBubblesResponseDTO>> response = bubbleServiceInterface.getAccountBubbles();
        if (response != null) {

        }
        Pane margiPan = new Pane();
        margiPan.setPrefHeight(5);
        margiPan.setPrefWidth(5);
        vboxContainer.getChildren().add(margiPan);
        for (int x = 0; x < 5; x++) {
            Parent pane = FXMLLoader.load(getClass().getResource("/fxml/bubble-card.fxml"));
            // ObservableList<Node> childs = pane.getChildren();
            // for(Node child :childs){

            // }
            vboxContainer.getChildren().add(pane);
            Pane margiPane = new Pane();
            margiPane.setPrefHeight(50);
            margiPane.setPrefWidth(5);
            vboxContainer.getChildren().add(margiPane);
        }
    }

}
