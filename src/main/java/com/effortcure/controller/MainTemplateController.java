package com.effortcure.controller;

import com.effortcure.dto.response.ApiResponse;
import com.effortcure.dto.response.BreifAccountInfoResponseDTO;
import com.effortcure.navigator.ContentManager;
import com.effortcure.service.implementation.AccountService;
import com.effortcure.service.interfaces.AccountServiceInterface;
import com.effortcure.util.ViewUtil;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.image.ImageView;

public class MainTemplateController {
    @FXML
    private AnchorPane root;

    @FXML
    private Pane navbarPane;

    @FXML
    private Pane userCard;

    @FXML
    private Label userNameLabel;

    @FXML
    private Pane profileImgContainer;

    @FXML
    private ImageView profileImg;

    @FXML
    private Pane rightControlsContainer;

    @FXML
    private Pane planPane;

    @FXML
    private Label planLabel;

    @FXML
    private Pane settingsBtn;

    @FXML
    private ImageView settingsIcon;

    @FXML
    private Pane notificationBtn;

    @FXML
    private Pane navBar;

    @FXML
    private Pane homeTab;

    @FXML
    private Hyperlink homeLink;

    @FXML
    private Pane peripheralsTab;

    @FXML
    private Hyperlink peripheralsLink;

    @FXML
    private Pane analyticsTab;

    @FXML
    private Hyperlink analyticsLink;

    @FXML
    private Pane teamsTab;

    @FXML
    private Hyperlink teamsLink;

    @FXML
    private AnchorPane anchorPaneBody;

    @FXML
    private Button notificationsBtn;

    @FXML
    private ImageView bellIcon;

    @FXML
    private Button settingBtn;

    @FXML
    private ImageView settingIcon;

    @FXML
    private Label teamsBtn;

    @FXML
    private Label analyticsBtn;

    @FXML
    private Label peripheralsBtn;

    @FXML
    private Label homeBtn;

    @FXML
    private Circle circleProfile;

    @FXML
    private ImageView profileImageView;

    @FXML
    private Text labelText;

    @FXML
    private Text valueText;

    @FXML
    private TextFlow dwsLabel;

    @FXML
    private Pane rightControlsPane;

    private AccountServiceInterface accountServiceInterface = new AccountService();

    @FXML
    private void initialize() {
        Task<Void> task = new Task<>() {
            @Override
            protected Void call() throws Exception {
                ApiResponse<BreifAccountInfoResponseDTO> response = accountServiceInterface.getBreifAccountInfo();
                if (response != null) {
                    if (response.getStatus() == 200) {
                        userNameLabel.setText(response.getData().getUsername());
                        valueText.setText(
                                (response.getData().getDws()) != null ? response.getData().getDws().toString() : null);
                        planLabel.setText(response.getData().getPlan());
                    }
                }
                return null;
            }
        };
        new Thread(task).run();
        ViewUtil.initiateResponsiveView(this);
        ContentManager.setAnchorPane(anchorPaneBody);
        ContentManager.switchContent("/fxml/home-page.fxml");
    }

}
