package com.effortcure.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import javafx.util.Duration;

import com.effortcure.dto.request.DirectoryRequestDTO;
import com.effortcure.dto.response.ApiResponse;
import com.effortcure.dto.response.BubbleDetailsResponseDTO;
import com.effortcure.enums.DirectoryType;
import com.effortcure.navigator.ContentManager;
import com.effortcure.service.implementation.BubbleService;
import com.effortcure.service.interfaces.BubbleServiceInterface;
import com.effortcure.util.ViewUtil;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class InspectBubbleController {

    @FXML
    private AnchorPane root;

    @FXML
    private ImageView back;

    @FXML
    private ImageView bubble1;

    @FXML
    private ImageView bubble2;

    @FXML
    private ImageView bubble3;

    @FXML
    private ImageView bubble4;

    @FXML
    private ImageView bubble5;

    @FXML
    private ImageView bubble6;

    @FXML
    private ImageView bubble7;

    @FXML
    private ImageView editicon1;

    @FXML
    private ImageView editicon2;

    @FXML
    private ImageView editicon3;

    @FXML
    private ImageView editicon4;

    @FXML
    private ScrollPane scrolpane;

    @FXML
    private VBox mainVBox;

    @FXML
    private Pane mainpane;

    @FXML
    private ScrollPane pathscrollpane;

    @FXML
    private Pane namepane;

    @FXML
    private Pane descriptionpane;

    @FXML
    private Pane applistpane;

    @FXML
    private Pane pathlistpane;

    @FXML
    private Pane actualdurationPane;

    @FXML
    private Pane estimatedPane;

    @FXML
    private Label namelabel;

    @FXML
    private Label bubblelabel;

    @FXML
    private Label descriotionlabel;

    @FXML
    private Label bubblediscriotionlabel;

    @FXML
    private Label applistlabel;

    @FXML
    private Label pathlistlabel;

    @FXML
    private Label teamlabel;

    @FXML
    private Label actualLabel;

    @FXML
    private Label actualDuration;

    @FXML
    private Label estimatedLabel;

    @FXML
    private Label estimatedDuration;

    @FXML
    private Separator separator;

    @FXML
    private Separator separator1;

    @FXML
    private Separator separator2;

    @FXML
    private Separator separator3;

    @FXML
    private Separator actualSeparator;

    @FXML
    private Separator estimatedSeparator;

    @FXML
    private Button deletebutton;

    @FXML
    private Button sessionsdetailsbutton;

    @FXML
    private ScrollPane appsListScrollPane;

    @FXML
    private VBox appsListVBox;

    @FXML
    private VBox pathsVBox;

    public static UUID bubbleUuid;
    private BubbleServiceInterface bubbleServiceInterface = new BubbleService();

    @FXML
    private void initialize() {
        ViewUtil.initiateResponsiveView(this);
        scrolpane.vvalueProperty().addListener((observable, oldValue, newValue) -> {
            double contentHeight = scrolpane.getContent().getBoundsInLocal().getHeight();
            double viewportHeight = scrolpane.getViewportBounds().getHeight();
            double maxScroll = contentHeight - viewportHeight;
            double scrollY = newValue.doubleValue() * maxScroll;
            back.setLayoutY(40 + scrollY);
        });
        animateBubble(bubble1, 20, 3);
        animateBubble(bubble2, 15, 4);
        animateBubble(bubble3, 25, 5);
        animateBubble(bubble4, 18, 3.5);
        animateBubble(bubble5, 18, 3.5);
        animateBubble(bubble6, 15, 3.5);
        animateBubble(bubble7, 18, 3.5);
        loadBubbleData();
    }

    @FXML
    private void backToHome() {
        ContentManager.setAnchorPane(root);
        ContentManager.switchContent("/fxml/home-page.fxml");
    }
     @FXML
    private void goToSesssionDetails() {
        ContentManager.setAnchorPane(root);
        ContentManager.switchContent("/fxml/inspect-session.fxml");
    }

    private void loadBubbleData() {
        try {
            ApiResponse<BubbleDetailsResponseDTO> response = bubbleServiceInterface.getBubbleDetails(bubbleUuid);

            if (response != null && response.getStatus() == 200) {
                BubbleDetailsResponseDTO bubble = response.getData();
                bubblelabel.setText(bubble.getName());
                bubblediscriotionlabel.setText(bubble.getDescription());
                actualDuration.setText(bubble.getActualDuration());
                estimatedDuration.setText(bubble.getEstimatedDuration());
                fillPaths(response.getData().getDirectoriesList());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fillPaths(List<DirectoryRequestDTO> directories) throws IOException {
        for (DirectoryRequestDTO dir : directories) {
            Parent parent = FXMLLoader.load(getClass().getResource("/fxml/inspect-bubble-path-card.fxml"));
            Pane pane = (Pane) parent;
            ((ImageView) pane.lookup("#Icon")).setImage(
                    new Image(dir.getType() == DirectoryType.FILE ? "/images/file-icon.png" : "/images/url2-icon"));
            ((Label) pane.lookup("#path")).setText(dir.getPath());
            ((Label) pane.lookup("#typeLabel")).setText(dir.getType().toString());
            pathsVBox.getChildren().add(pane);
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