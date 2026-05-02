package com.effortcure.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.UUID;
import javafx.util.Duration;

import com.effortcure.dto.request.DirectoryRequestDTO;
import com.effortcure.dto.response.ApiResponse;
import com.effortcure.dto.response.AppResponseDTO;
import com.effortcure.dto.response.BubbleDetailsResponseDTO;
import com.effortcure.enums.DirectoryType;
import com.effortcure.enums.ModifyBubbleType;
import com.effortcure.navigator.ContentManager;
import com.effortcure.navigator.PopupManager;
import com.effortcure.service.implementation.BubbleService;
import com.effortcure.service.interfaces.BubbleServiceInterface;
import com.effortcure.util.ViewUtil;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.GaussianBlur;
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

    @FXML
    private Pane overlay;

    @FXML
    private ImageView saveIcon1;

    @FXML
    private ImageView saveIcon2;

    @FXML
    private TextField nameField;

    @FXML
    private TextArea descriotionField;

    public static UUID bubbleUuid;
    private BubbleServiceInterface bubbleServiceInterface = new BubbleService();

    @FXML
    private void initialize() {
        ViewUtil.initiateResponsiveView(this);
        initializeHiddenComponents();
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
        onEditingName();
        onEditingDescription();
    }

    @FXML
    private void backToHome() {
        ContentManager.setAnchorPane(root);
        ContentManager.switchContent("/fxml/home-page.fxml");
    }

    @FXML
    private void goToSesssionDetails() {
        CreateSessionController.bubbleUuid = bubbleUuid;
        ContentManager.setAnchorPane(root);
        ContentManager.switchContent("/fxml/create-session.fxml");
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
                teamlabel.setText(bubble.getType().toString());
                fillApps(response.getData().getApplications());
                fillPaths(response.getData().getDirectoriesList());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fillPaths(List<DirectoryRequestDTO> directories) throws IOException {
        for (DirectoryRequestDTO dir : directories = new ArrayList<>(new LinkedHashSet<>(directories))) {
            Pane pane = FXMLLoader.load(getClass().getResource("/fxml/inspect-bubble-path-card.fxml"));
            ((ImageView) pane.lookup("#Icon")).setImage(
                    new Image(dir.getType() == DirectoryType.FILE ? "/images/file-icon.png" : "/images/url2-icon.png"));
            ((Label) pane.lookup("#path")).setText(dir.getPath());
            ((Label) pane.lookup("#typeLabel")).setText(dir.getType().toString());
            pathsVBox.getChildren().add(pane);
        }
    }

    private void fillApps(List<AppResponseDTO> apps) throws IOException {
        for (AppResponseDTO app : new ArrayList<>(new LinkedHashSet<>(apps))) {
            Pane pane = FXMLLoader.load(getClass().getResource("/fxml/inspect-bubble-app-card.fxml"));
            if (app.getIcon() != null && !app.getIcon().isBlank())
                ((ImageView) pane.lookup("#icon"))
                        .setImage(new Image(new ByteArrayInputStream(Base64.getDecoder().decode(app.getIcon()))));
            ((Label) pane.lookup("#name")).setText(app.getName());
            appsListVBox.getChildren().add(pane);
        }
    }

    @FXML
    private void handleDelete() {
        GaussianBlur blur = new GaussianBlur(5);
        root.setEffect(blur);
        overlay.setVisible(true);

        PopupManager.showPopup("/fxml/confirm-popups.fxml", controller -> {
            ((ConfirmPopupController) controller).setupDeleteMode();

            ((ConfirmPopupController) controller).setOnConfirm(() -> {
                try {
                    bubbleServiceInterface.deleteBubble(bubbleUuid);
                    ContentManager.setAnchorPane(root);
                    ContentManager.switchContent("/fxml/home-page.fxml");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                root.setEffect(null);
                overlay.setVisible(false);
            });

            ((ConfirmPopupController) controller).setOnCancel(() -> {
                root.setEffect(null);
                overlay.setVisible(false);
            });
        });
    }

    @FXML
    private void editAppsList() throws Exception {
        UpateAppLIstPopupController.bubbleUuid = bubbleUuid;
        PopupManager.showPopup("/fxml/update-application-list.fxml");
        appsListVBox.getChildren().clear();
        fillApps(new ArrayList<>(
                new LinkedHashSet<>(bubbleServiceInterface.getBubbleDetails(bubbleUuid).getData().getApplications())));
    }

    @FXML
    private void editDirectoriesList() {
        PopupManager.showPopup("/fxml/update-paths-list.fxml");
    }

    private void initializeHiddenComponents() {
        nameField.setVisible(false);
        saveIcon1.setVisible(false);
        saveIcon2.setVisible(false);
        descriotionField.setVisible(false);
    }

    private void onEditingName() {
        editicon1.setOnMouseClicked(e -> {
            if (bubblelabel.isVisible()) {
                editicon1.setImage(new Image("/images/close-icon.png"));
                bubblelabel.setVisible(false);
                nameField.setText(bubblelabel.getText());
                nameField.setVisible(true);
                saveIcon1.setVisible(true);
                nameField.requestFocus();
            } else {
                editicon1.setImage(new Image("/images/edit-icon.png"));
                bubblelabel.setVisible(true);
                nameField.setVisible(false);
                saveIcon1.setVisible(false);
            }
        });
        saveIcon1.setOnMouseClicked(e -> {
            if (!nameField.getText().equals(bubblelabel.getText())) {
                try {
                    bubblelabel.setText(nameField.getText());
                    bubbleServiceInterface.modifyBubble(bubbleUuid, nameField.getText(), null, null, null,
                            ModifyBubbleType.NAME);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
            editicon1.setImage(new Image("/images/edit-icon.png"));
            bubblelabel.setVisible(true);
            nameField.setVisible(false);
            saveIcon1.setVisible(false);
        });
    }

    private void onEditingDescription() {
        editicon2.setOnMouseClicked(e -> {
            if (bubblediscriotionlabel.isVisible()) {
                editicon2.setImage(new Image("/images/close-icon.png"));
                bubblediscriotionlabel.setVisible(false);
                descriotionField.setText(bubblediscriotionlabel.getText());
                descriotionField.setVisible(true);
                saveIcon2.setVisible(true);
                descriotionField.requestFocus();
            } else {
                editicon2.setImage(new Image("/images/edit-icon.png"));
                bubblediscriotionlabel.setVisible(true);
                descriotionField.setVisible(false);
                saveIcon2.setVisible(false);
            }
        });
        saveIcon2.setOnMouseClicked(e -> {
            if (!descriotionField.getText().equals(bubblediscriotionlabel.getText())) {
                try {
                    bubblediscriotionlabel.setText(descriotionField.getText());
                    bubbleServiceInterface.modifyBubble(bubbleUuid, null, descriotionField.getText(), null, null,
                            ModifyBubbleType.DESCRIPTION);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
            editicon2.setImage(new Image("/images/edit-icon.png"));
            bubblediscriotionlabel.setVisible(true);
            descriotionField.setVisible(false);
            saveIcon2.setVisible(false);
        });
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