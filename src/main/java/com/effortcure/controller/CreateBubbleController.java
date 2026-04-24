package com.effortcure.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.effortcure.dto.request.CreateBubbleRequestDTO;
import com.effortcure.dto.request.DirectoryRequestDTO;
import com.effortcure.enums.BubbleType;
import com.effortcure.enums.DirectoryType;
import com.effortcure.navigator.ContentManager;
import com.effortcure.service.implementation.BubbleService;
import com.effortcure.service.interfaces.BubbleServiceInterface;
import com.effortcure.util.DirectoryPickerUtil;
import com.effortcure.util.ViewUtil;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CreateBubbleController {
    @FXML
    private AnchorPane root;

    @FXML
    private ImageView arrowBtn;

    @FXML
    private Label nameLabel;

    @FXML
    private TextField bubbleNameField;

    @FXML
    private Label descriptionLabel;

    @FXML
    private TextArea bubbleDescriptionField;

    @FXML
    private Button nextBtn;

    @FXML
    private ImageView progressImg;

    @FXML
    private ImageView bubbleImg;

    @FXML
    private Label typeLabel;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private AnchorPane root2;

    @FXML
    private ImageView arrowBtn2;

    @FXML
    private Button nextBtn2;

    @FXML
    private ImageView progressImg2;

    @FXML
    private ImageView bubbleImg1;

    @FXML
    private ImageView bubbleImg2;

    @FXML
    private Label selectLabel;

    @FXML
    private Label appListLabel;

    @FXML
    private Pane applicationsContainer;

    @FXML
    private ScrollPane scrollApplications;

    @FXML
    private VBox vBoxAppsContainer;

    @FXML
    private Pane searchPane;

    @FXML
    private ImageView serchIcon;

    @FXML
    private TextField searcField;

    @FXML
    private Button addBtn;

    @FXML
    private Pane appPane1;

    @FXML
    private CheckBox checkBoxBtn1;

    @FXML
    private ImageView appLogo1;

    @FXML
    private Label appNameLabel1;

    @FXML
    private Label recommendedLabel1;

    @FXML
    private Pane appPane2;

    @FXML
    private CheckBox checkBox2;

    @FXML
    private ImageView appLogo2;

    @FXML
    private Label appNameLabel2;

    @FXML
    private Label recommendedLabe2;

    @FXML
    private Pane appPane3;

    @FXML
    private CheckBox checkbox3;

    @FXML
    private ImageView appLogo3;

    @FXML
    private Label appNameLabel3;

    @FXML
    private Pane appPane4;

    @FXML
    private CheckBox checkbox4;

    @FXML
    private ImageView appLogo4;

    @FXML
    private Label appNameLabel4;

    @FXML
    private Pane listofAppsPane;

    @FXML
    private Pane appItemPane1;

    @FXML
    private ImageView selectedappLogo1;

    @FXML
    private Label SelectedAppnameLabel;

    @FXML
    private ImageView deleteBtn1;

    @FXML
    private Pane seslectedAppPane2;

    @FXML
    private ImageView selectedappLogo2;

    @FXML
    private Label SelectedAppnameLabel2;

    @FXML
    private ImageView deleteBtn2;

    @FXML
    private AnchorPane root3;

    @FXML
    private ImageView arrowBtn3;

    @FXML
    private ImageView progressImg3;

    @FXML
    private Button saveBtn;

    @FXML
    private ImageView bubbleImg11;

    @FXML
    private ImageView bubbleImg22;

    @FXML
    private ImageView bubbleImg3;

    @FXML
    private Pane enterUrlPane;

    @FXML
    private TextField urlField;

    @FXML
    private Button addBtn2;

    @FXML
    private ImageView urlIcon;

    @FXML
    private Button selectFolderBtn;

    @FXML
    private Button selectFileBtn;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox resourcesContainer;

    @FXML
    private Pane itemPane1;

    @FXML
    private ImageView icon1;

    @FXML
    private Label textLabel1;

    @FXML
    private Label typeLabel1;

    @FXML
    private ImageView removeIcon1;

    @FXML
    private Pane itemPane2;

    @FXML
    private ImageView icon2;

    @FXML
    private Label textLabel2;

    @FXML
    private Label typeLabel2;

    @FXML
    private ImageView removeIcon2;

    @FXML
    private Pane itemPane3;

    @FXML
    private ImageView icon3;

    @FXML
    private Label textLabel3;

    @FXML
    private Label typeLabel3;

    @FXML
    private ImageView removeIcon3;

    @FXML
    private Pane itemPane4;

    @FXML
    private ImageView icon4;

    @FXML
    private Label textLabel4;

    @FXML
    private Label typeLabel4;

    @FXML
    private ImageView removeIcon4;

    @FXML
    private ScrollPane scrollApplications1;

    public static CreateBubbleRequestDTO createBubbleRequestDTO;
    private BubbleServiceInterface bubbleServiceInterface = new BubbleService();

    @FXML
    private void initialize() throws IOException {
        ViewUtil.initiateResponsiveView(this);
        collectBubbleData();
        retreiveData();
        if (comboBox != null)
            comboBox.getItems().add("Local");
    }

    @FXML
    private void backToHome() {
        ContentManager.setAnchorPane(root);
        ContentManager.switchContent("/fxml/home-page.fxml");
    }

    @FXML
    private void backToCB1() {
        ContentManager.setAnchorPane(root2);
        ContentManager.switchContent("/fxml/create-bubble-page-p1.fxml");
    }

    @FXML
    private void backToCB2() {
        ContentManager.setAnchorPane(root3);
        ContentManager.switchContent("/fxml/create-bubble-page-p2.fxml");
    }

    @FXML
    private void next1() {
        if (validateBubbleData()) {
            ContentManager.setAnchorPane(root);
            ContentManager.switchContent("/fxml/create-bubble-page-p2.fxml");
        } else {
            if (createBubbleRequestDTO.getName() == null || createBubbleRequestDTO.getName().isBlank())
                bubbleNameField.getStyleClass().add("error-field");
            if (createBubbleRequestDTO.getType() == null)
                comboBox.getStyleClass().add("error-field");
        }
    }

    @FXML
    private void next2() {
        List<String> apps = new ArrayList<>();
        // We need to fill apps
        createBubbleRequestDTO.setApplicationsNameList(apps);
        ContentManager.setAnchorPane(root2);
        ContentManager.switchContent("/fxml/create-bubble-page-p3.fxml");
    }

    @FXML
    private void save() throws Exception {
        bubbleServiceInterface.createBubble(createBubbleRequestDTO);
        ContentManager.setAnchorPane(root3);
        ContentManager.switchContent("/fxml/home-page.fxml");
    }

    @FXML
    private void addDirectory() throws IOException {
        if (!urlField.getText().isBlank()) {
            Parent parent = FXMLLoader.load(getClass().getResource("/fxml/path-card.fxml"));
            Pane pane = (Pane) parent;
            for (Node n : pane.getChildren()) {
                if (n.getId().equals("textLabel1"))
                    ((Label) n).setText(urlField.getText());
                if (n.getId().equals("removeIcon1"))
                    ((ImageView) n).setOnMouseClicked(e -> {
                        createBubbleRequestDTO.getDirectoriesList().remove(new DirectoryRequestDTO(
                                ((Label) pane.lookup("#textLabel1")).getText(), DirectoryType.URL));
                        resourcesContainer.getChildren().remove(pane);
                    });
            }
            if (!createBubbleRequestDTO.getDirectoriesList()
                    .contains(new DirectoryRequestDTO(urlField.getText(), DirectoryType.URL))) {
                resourcesContainer.getChildren().add(pane);
                createBubbleRequestDTO.getDirectoriesList()
                        .add(new DirectoryRequestDTO(urlField.getText(), DirectoryType.URL));
            }
        }
    }

    @FXML
    private void selectFolder() throws IOException {
        String folder = DirectoryPickerUtil.pickAFolder((Stage) selectFolderBtn.getScene().getWindow());
        if (folder != null) {
            Parent parent = FXMLLoader.load(getClass().getResource("/fxml/path-card.fxml"));
            Pane pane = (Pane) parent;
            ((Label) pane.lookup("#textLabel1")).setText(folder);
            ((ImageView) pane.lookup("#icon1"))
                    .setImage(new Image(getClass().getResource("/images/folder-icon.png").toExternalForm()));
            ((Label) pane.lookup("#typeLabel1")).setText(DirectoryType.FOLDER.toString());
            ((ImageView) pane.lookup("#removeIcon1")).setOnMouseClicked(e -> {
                createBubbleRequestDTO.getDirectoriesList().remove(new DirectoryRequestDTO(
                        ((Label) pane.lookup("#textLabel1")).getText(), DirectoryType.FOLDER));
                resourcesContainer.getChildren().remove(pane);
            });
            if (!createBubbleRequestDTO.getDirectoriesList()
                    .contains(new DirectoryRequestDTO(folder, DirectoryType.FOLDER))) {
                resourcesContainer.getChildren().add(pane);
                createBubbleRequestDTO.getDirectoriesList().add(new DirectoryRequestDTO(folder, DirectoryType.FOLDER));
            }
        }
    }

    @FXML
    private void selectFiles() throws IOException {
        Set<String> files = DirectoryPickerUtil.pickFiles((Stage) selectFileBtn.getScene().getWindow());
        for (String file : files) {
            if (file != null) {
                Parent parent = FXMLLoader.load(getClass().getResource("/fxml/path-card.fxml"));
                Pane pane = (Pane) parent;
                ((Label) pane.lookup("#textLabel1")).setText(file);
                ((ImageView) pane.lookup("#icon1"))
                        .setImage(new Image(getClass().getResource("/images/file-icon.png").toExternalForm()));
                ((Label) pane.lookup("#typeLabel1")).setText(DirectoryType.FILE.toString());
                ((ImageView) pane.lookup("#removeIcon1")).setOnMouseClicked(e -> {
                    createBubbleRequestDTO.getDirectoriesList().remove(new DirectoryRequestDTO(
                            ((Label) pane.lookup("#textLabel1")).getText(), DirectoryType.FILE));
                    resourcesContainer.getChildren().remove(pane);
                });
                if (!createBubbleRequestDTO.getDirectoriesList()
                        .contains(new DirectoryRequestDTO(file, DirectoryType.FILE))) {
                    resourcesContainer.getChildren().add(pane);
                    createBubbleRequestDTO.getDirectoriesList()
                            .add(new DirectoryRequestDTO(file, DirectoryType.FILE));
                }
            }
        }
    }

    private void collectBubbleData() {
        if (bubbleNameField != null)
            bubbleNameField.textProperty().addListener((obs, oldValue, newValue) -> {
                createBubbleRequestDTO.setName(newValue);
                bubbleNameField.getStyleClass().removeAll("error-field");
            });
        if (bubbleDescriptionField != null)
            bubbleDescriptionField.textProperty().addListener((obs, oldValue, newValue) -> {
                createBubbleRequestDTO.setDescription(newValue);
            });
        if (comboBox != null)
            comboBox.setOnAction(e -> {
                if (comboBox.getValue() != null) {
                    createBubbleRequestDTO
                            .setType(comboBox.getValue().toString() == "Local" ? BubbleType.LOCAL : BubbleType.TEAM);
                    comboBox.getStyleClass().removeAll("error-field");
                }
            });
    }

    private void retreiveData() throws IOException {
        if (bubbleNameField != null)
            bubbleNameField.setText(createBubbleRequestDTO.getName());
        if (bubbleDescriptionField != null)
            bubbleDescriptionField.setText(createBubbleRequestDTO.getDescription());
        if (comboBox != null)
            comboBox.getSelectionModel().select(
                    createBubbleRequestDTO.getType() != null ? createBubbleRequestDTO.getType().toString() : null);
        if (resourcesContainer != null) {
            for (DirectoryRequestDTO directoryRequestDTO : createBubbleRequestDTO.getDirectoriesList()) {
                Parent parent = FXMLLoader.load(getClass().getResource("/fxml/path-card.fxml"));
                Pane pane = (Pane) parent;
                ((Label) pane.lookup("#textLabel1")).setText(directoryRequestDTO.getPath());
                ((Label) pane.lookup("#typeLabel1")).setText(directoryRequestDTO.getType().toString());
                if (directoryRequestDTO.getType() != DirectoryType.URL)
                    ((ImageView) pane.lookup("#icon1"))
                            .setImage(new Image(getClass().getResource(
                                    (directoryRequestDTO.getType() == DirectoryType.FILE) ? "/images/file-icon.png"
                                            : "/images/folder-icon.png")
                                    .toExternalForm()));
                resourcesContainer.getChildren().add(pane);
            }
        }
    }

    private boolean validateBubbleData() {
        return ((bubbleNameField.getText() == null ? false
                : !bubbleNameField.getText().isBlank())
                && (comboBox.getValue() == null ? false
                        : !comboBox.getValue().isBlank()));
    }
}
