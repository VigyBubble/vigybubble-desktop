package com.effortcure.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;

public class DeletePopupsController {
 
 @FXML private Pane popupRoot;

@FXML private Label deleteLabel;

@FXML private ImageView closeIcon;

@FXML private Separator separatorLine;

@FXML private Label questionLabel;

@FXML private Button cancelBtn;

@FXML private Button confirmBtn;   
    

@FXML
public void initialize() {
    Rectangle clip = new Rectangle();
    clip.setArcWidth(50);
    clip.setArcHeight(50);

    clip.widthProperty().bind(popupRoot.widthProperty());
    clip.heightProperty().bind(popupRoot.heightProperty());

    popupRoot.setClip(clip);
}



}
