package com.effortcure.controller;

import com.effortcure.util.ViewUtil;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class SettingsController {

    @FXML private AnchorPane root;

    @FXML private ImageView bubble1;
    @FXML private ImageView bubble2;
    @FXML private ImageView bubble3;
    @FXML private ImageView bubble4;
    @FXML private ImageView bubble5;
    @FXML private ImageView bubble6;
    @FXML private ImageView bubble7;
    @FXML private ImageView bubble8;
    @FXML private ImageView bubble9;
    @FXML private ImageView bubble10;
    @FXML private ImageView bubble11;
    @FXML private ImageView bubble12;
    @FXML private ImageView bubble13;
    @FXML private ImageView bubble14;
    @FXML private ImageView bubble15;

    @FXML private ScrollPane scrollpane;
    @FXML private VBox vbox;

    @FXML private Pane maincontainer;
    @FXML private Pane mainpane;

    // About You
    @FXML private Label aboutlabel;
    @FXML private Pane aboutpane;
    @FXML private Label agelabel;
    @FXML private Label heightlabel;
    @FXML private Label weightlabel;

    @FXML private Spinner<Integer> spinner;

    @FXML private TextField hightfield;
    @FXML private TextField weightfield;

    @FXML private ComboBox<String> heightcombobox;
    @FXML private ComboBox<String> wheightcombobox;

    @FXML private ImageView editicon1;
    @FXML private ImageView editicon2;
    @FXML private ImageView editicon3;
    @FXML private ImageView aboutimg;

    // Chronic Diseases
    @FXML private Label chronicdiseaseslabel;
    
    @FXML private Pane chronicpane;
    @FXML private Pane chronicpane1;
    @FXML private Pane chronicpane2;
    @FXML private Pane chronicpane3;
    @FXML private Pane chronicpane4;

    @FXML private RadioButton chronicyes1;
    @FXML private RadioButton chronicno1;

    @FXML private RadioButton chronicyes2;
    @FXML private RadioButton chronicno2;

    @FXML private RadioButton chronicyes3;
    @FXML private RadioButton chronicno3;

    @FXML private RadioButton chronicyes4;
    @FXML private RadioButton chronicno4;

    // Eye Health
    @FXML private Label eyehealthlabel;

    @FXML private Pane eyehealthpane;

    @FXML private RadioButton eyeyes1;
    @FXML private RadioButton eyeno1;

    @FXML private RadioButton eyeyes2;
    @FXML private RadioButton eyeno2;

    @FXML private RadioButton eyeyes3;
    @FXML private RadioButton eyeno3;

    @FXML private RadioButton eyeyes4;
    @FXML private RadioButton eyeno4;

    // Respiratory Health
    @FXML private Label respiratoryhealthlabel;
    @FXML private Pane respiratoryhealthpane;

    @FXML private RadioButton respiratoryyes1;
    @FXML private RadioButton respiratoryno1;

    @FXML private RadioButton respiratoryyes2;
    @FXML private RadioButton respiratoryno2;

    // Other Medical Conditions
    @FXML private Pane otherpane;
    @FXML private Label otherlabel;

    @FXML private RadioButton otheryes1;
    @FXML private RadioButton otherno1;

    @FXML private RadioButton otheryes2;
    @FXML private RadioButton otherno2;

    @FXML private RadioButton otheryes3;
    @FXML private RadioButton otherno3;

    @FXML
    private void initialize() {
        ViewUtil.initiateResponsiveView(this);
    }
}


