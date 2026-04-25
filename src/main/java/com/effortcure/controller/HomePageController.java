package com.effortcure.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javafx.util.Duration;

import com.effortcure.dto.request.CreateBubbleRequestDTO;
import com.effortcure.dto.response.AccountBubblesResponseDTO;
import com.effortcure.dto.response.ApiResponse;
import com.effortcure.navigator.ContentManager;
import com.effortcure.service.implementation.BubbleService;
import com.effortcure.service.interfaces.BubbleServiceInterface;
import com.effortcure.util.ViewUtil;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
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
    private List<AccountBubblesResponseDTO> allBubbles = new ArrayList<>();

    @FXML
    private void initialize() throws Exception {
        ViewUtil.initiateResponsiveView(this);
        vboxContainer.setPadding(new Insets(20, 0, 0, 0));
        getBubbles();
        typeComboBox.getItems().addAll("All", "Local");
        typeComboBox.setOnAction(e -> {
            applyFilters();
        });
        datePicker.setOnAction(e -> {
            applyFilters();
        });
        datePicker.getEditor().textProperty().addListener((obs, oldVal, newVal) -> {
            try {
                showBubbles(allBubbles);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        animateBubble(bubbleImg1, 20, 3);
        animateBubble(bubbleImg2, 15, 4);
        animateBubble(bubbleImg3, 25, 5);
        animateBubble(bubbleImg4, 18, 3.5);
        animateBubble(bubbleImg5, 18, 3.5);
    }

    @FXML
    private void addBubble() {
        CreateBubbleController.createBubbleRequestDTO = new CreateBubbleRequestDTO();
        ContentManager.setAnchorPane(root);
        ContentManager.switchContent("/fxml/create-bubble-page-p1.fxml");
    }

    private void getBubbles() throws Exception {
        ApiResponse<List<AccountBubblesResponseDTO>> response = bubbleServiceInterface.getAccountBubbles();
        if (response != null) {
            allBubbles = response.getData();
            showBubbles(allBubbles);
        }
    }

    private void showBubbles(List<AccountBubblesResponseDTO> bubbles) throws Exception {
        vboxContainer.getChildren().clear();
        for (AccountBubblesResponseDTO accountBubblesResponseDTO : bubbles) {
            Parent parent = FXMLLoader.load(getClass().getResource("/fxml/bubble-card.fxml"));
            Pane pane = (Pane) parent.lookup("#bubbleCardPane");
            for (Node node : pane.getChildren()) {
                if (node.getId().equals("bubbleUuid"))
                    ((Label) node).setText(accountBubblesResponseDTO.getUuid().toString());
                if (node.getId().equals("viewBubble")) {
                    ((ImageView) node).setOnMouseClicked(e -> {
                        InspectBubbleController.bubbleUuid = UUID
                                .fromString(((Label) ((Pane) node.getParent()).lookup("#bubbleUuid")).getText());
                        ContentManager.setAnchorPane(root);
                        ContentManager.switchContent("/fxml/inspect-bubble.fxml");
                    });
                }
                if (node.getId().equals("titleLabel"))
                    ((Label) node).setText(accountBubblesResponseDTO.getName());
                if (node.getId().equals("descriptionLabel"))
                    ((Label) node).setText(accountBubblesResponseDTO.getDescription());
                if (node.getId().equals("teamLabel"))
                    ((Label) node).setText(accountBubblesResponseDTO.getType().toString());
                if (node.getId().equals("createdAtLabel"))
                    ((Label) node).setText(accountBubblesResponseDTO.getCreatedAt().toString());
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
                if (node.getId().equals("closeIcon"))
                    ((ImageView) node).setOnMouseClicked(e -> {
                        try {
                            bubbleServiceInterface.deleteBubble(UUID
                                    .fromString(((Label) ((Pane) node.getParent()).lookup("#bubbleUuid")).getText()));
                            vboxContainer.getChildren().remove(parent);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    });
            }
            vboxContainer.getChildren().add(parent);
        }
    }

    private void applyFilters() {
        try {
            LocalDate selectedDate = datePicker.getValue();
            String selectedType = typeComboBox.getValue();
            List<AccountBubblesResponseDTO> filtered = new ArrayList<>();
            for (AccountBubblesResponseDTO bubble : allBubbles) {
                boolean matchesDate = true;
                boolean matchesType = true;
                if (selectedDate != null) {
                    LocalDate bubbleDate = bubble.getCreatedAt().toLocalDate();
                    matchesDate = bubbleDate.equals(selectedDate);
                }
                if (selectedType != null && !selectedType.equalsIgnoreCase("all")) {
                    matchesType = bubble.getType().toString().equalsIgnoreCase(selectedType);
                }
                if (matchesDate && matchesType) {
                    filtered.add(bubble);
                }
            }
            showBubbles(filtered);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void animateBubble(ImageView bubble, double moveY, double duration) {
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(bubble);
        transition.setDuration(Duration.seconds(duration));
        transition.setByY(-moveY);
        transition.setByX(10);
        transition.setAutoReverse(true);
        transition.setCycleCount(TranslateTransition.INDEFINITE);
        transition.play();
    }

}
