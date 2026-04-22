package com.effortcure.controller;

import java.util.List;

import com.effortcure.dto.response.AccountBubblesResponseDTO;
import com.effortcure.dto.response.ApiResponse;
import com.effortcure.navigator.ContentManager;
import com.effortcure.service.implementation.BubbleService;
import com.effortcure.service.interfaces.BubbleServiceInterface;
import com.effortcure.util.ViewUtil;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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
    private DatePicker datePicker;

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
        Pane margiPane = new Pane();
        margiPane.setPrefHeight(5);
        margiPane.setPrefWidth(5);
        vboxContainer.getChildren().add(margiPane);
        getBubbles();
    }

    @FXML
    private void addBubble() {
        ContentManager.setAnchorPane(root);
        ContentManager.switchContent("/fxml/create-bubble-page-p1.fxml");
    }

    private void getBubbles() throws Exception {
        ApiResponse<List<AccountBubblesResponseDTO>> response = bubbleServiceInterface.getAccountBubbles();
        if (response != null) {
            for (AccountBubblesResponseDTO accountBubblesResponseDTO : response.getData()) {
                Parent parent = FXMLLoader.load(getClass().getResource("/fxml/bubble-card.fxml"));
                Pane pane = (Pane) parent;
                for (Node node : pane.getChildren()) {
                    /*
                     * private LocalDateTime createdAt;
                     */
                    if (node.getId().equals("bubbleUuid"))
                        ((Label) node).setText(accountBubblesResponseDTO.getUuid().toString());
                    if (node.getId().equals("titleLabel"))
                        ((Label) node).setText(accountBubblesResponseDTO.getName());
                    if (node.getId().equals("descriptionLabel"))
                        ((Label) node).setText(accountBubblesResponseDTO.getDescription());
                    if (node.getId().equals("teamLabel"))
                        ((Label) node).setText(accountBubblesResponseDTO.getType().toString());
                    if (node.getId().equals("actualdurationPane")) {
                        for (Node child : ((Pane) node).getChildren()) {
                            if (child.getId().equals("actualDuration"))
                                ((Label) child).setText(accountBubblesResponseDTO.getActualDuration());
                        }
                    }
                    if (node.getId().equals("estimatedPane")) {
                        for (Node child : ((Pane) node).getChildren()) {
                            if (child.getId().equals("estimatedDuration"))
                                ((Label) child).setText(accountBubblesResponseDTO.getEstimatedDuration());
                        }
                    }
                }
                vboxContainer.getChildren().add(pane);
                Pane margiPane = new Pane();
                margiPane.setPrefHeight(25);
                margiPane.setPrefWidth(5);
                vboxContainer.getChildren().add(margiPane);
            }
        }
    }
}
