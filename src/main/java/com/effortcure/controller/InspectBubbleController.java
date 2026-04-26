package com.effortcure.controller;

import java.util.UUID;

import com.effortcure.navigator.ContentManager;
import com.effortcure.util.ViewUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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

    public static UUID bubbleUuid;

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
    }

  @FXML
     private void backToHome() {
        ContentManager.setAnchorPane(root);
        ContentManager.switchContent("/fxml/home-page.fxml");
    }
}