package com.effortcure.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.UUID;

import com.effortcure.dto.request.CreateBubbleRequestDTO;
import com.effortcure.dto.response.ApiResponse;
import com.effortcure.dto.response.AppResponseDTO;
import com.effortcure.dto.response.BubbleDetailsResponseDTO;
import com.effortcure.enums.ModifyBubbleType;
import com.effortcure.service.implementation.AppsService;
import com.effortcure.service.implementation.BubbleService;
import com.effortcure.service.interfaces.AppsServiceInterface;
import com.effortcure.service.interfaces.BubbleServiceInterface;
import com.effortcure.util.ViewUtil;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Separator;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UpateAppLIstPopupController {

    @FXML
    private AnchorPane root;

    @FXML
    private Label updateAppListLabel;

    @FXML
    private ImageView close;

    @FXML
    private Separator separator;

    @FXML
    private Label selectApplicationLabel;

    @FXML
    private Label applicationListLabel;

    @FXML
    private Pane appListPane;

    @FXML
    private ScrollPane scrollPane1;

    @FXML
    private Pane innerApplistPane1;

    @FXML
    private ImageView appLOgo1;

    @FXML
    private Label appNameLbel;

    @FXML
    private ImageView closeIcon2;

    @FXML
    private Pane innerAppLIstPane;

    @FXML
    private ImageView appLogo2;

    @FXML
    private Label appNameLabel2;

    @FXML
    private ImageView closeIcon3;

    @FXML
    private Button cancelBtn;

    @FXML
    private Button doneBtn;

    @FXML
    private Pane secletAppPane;

    @FXML
    private Pane searchPane;

    @FXML
    private ImageView searchIcon;

    @FXML
    private TextField searcField;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox vbox;

    @FXML
    private VBox vbox1;

    @FXML
    private Pane selectedPane1;

    @FXML
    private CheckBox checkbox1;

    @FXML
    private ImageView appLogo3;

    @FXML
    private Label appNameLabel3;

    @FXML
    private Label recommendedLabel1;

    @FXML
    private Pane selectedPane2;

    @FXML
    private CheckBox checkbox2;

    @FXML
    private ImageView appLogo4;

    @FXML
    private Label appNameLabel4;

    @FXML
    private Label recommendedLabel2;

    public static UUID bubbleUuid;
    private AppsServiceInterface appsServiceInterface = new AppsService();
    private BubbleServiceInterface bubbleServiceInterface = new BubbleService();
    private CreateBubbleRequestDTO createBubbleRequestDTO = new CreateBubbleRequestDTO();

    @FXML
    private void initialize() throws Exception {
        ViewUtil.initiateResponsiveView(this);
        fillSelectedApps();
        fillApps();
    }

    private void fillSelectedApps() throws Exception {
        ApiResponse<BubbleDetailsResponseDTO> response = bubbleServiceInterface.getBubbleDetails(bubbleUuid);
        List<AppResponseDTO> apps = response.getData().getApplications();
        for (AppResponseDTO app : new ArrayList<>(new LinkedHashSet<>(apps))) {
            Pane selectedPane = FXMLLoader.load(getClass().getResource("/fxml/app-list-card.fxml"));
            if (app.getIcon() != null && !app.getIcon().isBlank())
                ((ImageView) selectedPane.lookup("#selectedappLogo1")).setImage(
                        new Image(new ByteArrayInputStream(Base64.getDecoder().decode(app.getIcon()))));
            ((Label) selectedPane.lookup("#SelectedAppnameLabel")).setText(app.getName());
            ((ImageView) selectedPane.lookup("#deleteBtn1")).setOnMouseClicked(ev -> {
                vbox1.getChildren().remove(selectedPane);
                createBubbleRequestDTO.getApplications().remove(app);
            });
            vbox1.getChildren().add(selectedPane);
            createBubbleRequestDTO.getApplications().add(app);
        }
    }

    private void fillApps() throws Exception {
        List<AppResponseDTO> apps = appsServiceInterface.getApps();
        for (AppResponseDTO app : apps) {
            Pane pane = FXMLLoader.load(getClass().getResource("/fxml/app-selection-card.fxml"));
            if (app.getIcon() != null && !app.getIcon().isBlank())
                ((ImageView) pane.lookup("#logo"))
                        .setImage(new Image(new ByteArrayInputStream(Base64.getDecoder().decode(app.getIcon()))));
            ((Label) pane.lookup("#appName")).setText(app.getName());
            ((Label) pane.lookup("#recommendedLabel")).setVisible(false);
            pane.setOnMouseEntered(e -> {
                pane.getStyleClass().add("hoveredCard");
            });
            pane.setOnMouseExited(e -> {
                pane.getStyleClass().removeAll("hoveredCard");
            });
            pane.setOnMouseClicked(e -> {
                try {
                    Pane selectedPane = FXMLLoader.load(getClass().getResource("/fxml/app-list-card.fxml"));
                    if (!app.getIcon().isBlank())
                        ((ImageView) selectedPane.lookup("#selectedappLogo1")).setImage(
                                new Image(new ByteArrayInputStream(Base64.getDecoder().decode(app.getIcon()))));
                    ((Label) selectedPane.lookup("#SelectedAppnameLabel")).setText(app.getName());
                    ((ImageView) selectedPane.lookup("#deleteBtn1")).setOnMouseClicked(ev -> {
                        vbox1.getChildren().remove(selectedPane);
                        createBubbleRequestDTO.getApplications().remove(app);
                    });
                    vbox1.getChildren().add(selectedPane);
                    createBubbleRequestDTO.getApplications().add(app);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            });
            vbox.getChildren().add(pane);
        }
    }

    @FXML
    private void cancel() {
        ((Stage) cancelBtn.getParent().getScene().getWindow()).close();
    }

    @FXML
    private void save() throws Exception {
        bubbleServiceInterface.modifyBubble(bubbleUuid, null, null,
                new ArrayList<>(new LinkedHashSet<>(createBubbleRequestDTO.getApplications())), null,
                ModifyBubbleType.APPLICATIONS_LIST);
        ((Stage) doneBtn.getParent().getScene().getWindow()).close();
    }
}