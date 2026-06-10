package com.effortcure.controller;

import com.effortcure.dto.response.ApiResponse;
import com.effortcure.dto.response.BreifAccountInfoResponseDTO;
import com.effortcure.navigator.ContentManager;
import com.effortcure.navigator.SceneManager;
import com.effortcure.service.implementation.AccountService;
import com.effortcure.service.implementation.AuthService;
import com.effortcure.service.interfaces.AccountServiceInterface;
import com.effortcure.service.interfaces.AuthServiceInterface;
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
    private Button settingBtn;

    @FXML
    private ImageView settingsIcon;

    @FXML
    private Button notificationBtn;

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
    @FXML
    private Button logOutBtn;
    @FXML
    private ImageView logOutIcon;

    private AccountServiceInterface accountServiceInterface = new AccountService();
    private AuthServiceInterface authServiceInterface = new AuthService();

    @FXML
    private void initialize() throws Exception {
        Task<Void> task = new Task<>() {
            @Override
            protected Void call() throws Exception {
                ApiResponse<BreifAccountInfoResponseDTO> response = accountServiceInterface.getBreifAccountInfo();
                if (response != null) {
                    if (response.getStatus() == 200) {
                        userNameLabel.setText(response.getData().getUsername());
                        valueText.setText(
                                (response.getData().getDws()) != null ? response.getData().getDws().toString() : null);
                        String plan = response.getData().getPlan();

                        if (plan == null || plan.isEmpty()) {
                            planLabel.setVisible(false);
                        } else {
                            planLabel.setText(plan);
                            planLabel.setVisible(true);
                        }
                    }
                }
                return null;
            }
        };
        new Thread(task).run();
        ViewUtil.initiateResponsiveView(this);
        ContentManager.setAnchorPane(anchorPaneBody);
        ContentManager.switchContent("/fxml/home-page.fxml");
        homeBtn.getStyleClass().add("activeNavTabs");
        navigationToggle();
        logOut();
    }

    private void logOut() {

        logOutBtn.setOnAction(e -> {
            try {
                // authServiceInterface.logout();
                SceneManager.switchScene("/fxml/about-you.fxml", null);//login
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });


    }

    private void navigationToggle() {
        homeBtn.setOnMouseClicked(e -> {
            homeBtn.getStyleClass().add("activeNavTabs");
            peripheralsBtn.getStyleClass().removeAll("activeNavTabs");
            analyticsBtn.getStyleClass().removeAll("activeNavTabs");
            teamsBtn.getStyleClass().removeAll("activeNavTabs");
            ContentManager.setAnchorPane(anchorPaneBody);
            ContentManager.switchContent("/fxml/home-page.fxml");
        });
        peripheralsBtn.setOnMouseClicked(e -> {
            homeBtn.getStyleClass().removeAll("activeNavTabs");
            peripheralsBtn.getStyleClass().add("activeNavTabs");
            analyticsBtn.getStyleClass().removeAll("activeNavTabs");
            teamsBtn.getStyleClass().removeAll("activeNavTabs");
            ContentManager.setAnchorPane(anchorPaneBody);
            ContentManager.switchContent("/fxml/peripherals-page.fxml");
        });
        analyticsBtn.setOnMouseClicked(e -> {
            homeBtn.getStyleClass().removeAll("activeNavTabs");
            peripheralsBtn.getStyleClass().removeAll("activeNavTabs");
            analyticsBtn.getStyleClass().add("activeNavTabs");
            teamsBtn.getStyleClass().removeAll("activeNavTabs");
            ContentManager.setAnchorPane(anchorPaneBody);
            ContentManager.switchContent("/fxml/coming-soon.fxml");
        });
        teamsBtn.setOnMouseClicked(e -> {
            homeBtn.getStyleClass().removeAll("activeNavTabs");
            peripheralsBtn.getStyleClass().removeAll("activeNavTabs");
            analyticsBtn.getStyleClass().removeAll("activeNavTabs");
            teamsBtn.getStyleClass().add("activeNavTabs");
            ContentManager.setAnchorPane(anchorPaneBody);
            ContentManager.switchContent("/fxml/coming-soon.fxml");
        });

        notificationBtn.setOnMouseClicked(e -> {
            ContentManager.setAnchorPane(anchorPaneBody);
            ContentManager.switchContent("/fxml/coming-soon.fxml");
        });
    }

}
