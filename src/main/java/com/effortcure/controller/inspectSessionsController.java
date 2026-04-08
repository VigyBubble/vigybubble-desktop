package com.effortcure.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeLineCap;

import java.util.Random;

public class inspectSessionsController {

    @FXML private Circle progressCircle1;
    @FXML private Label progressLabel1;
    @FXML private Circle progressCircle2;
    @FXML private Label progressLabel2;
    @FXML private Circle progressCircle3;
    @FXML private Label progressLabel3;
    @FXML private Circle progressCircle4;
    @FXML private Label progressLabel4;
    @FXML private Circle progressCircle5;
    @FXML private Label progressLabel5;
    @FXML private Circle progressCircle6;
    @FXML private Label progressLabel6;
    @FXML private Circle progressCircle7;
    @FXML private Label progressLabel7;
    @FXML private Circle progressCircle8;
    @FXML private Label progressLabel8;
    @FXML private Circle progressCircle9;
    @FXML private Label progressLabel9;
    @FXML private Circle progressCircle10;
    @FXML private Label progressLabel10;
    @FXML private Circle progressCircle11;
    @FXML private Label progressLabel11;
    @FXML private Circle progressCircle12;
    @FXML private Label progressLabel12;
    @FXML private Circle progressCircle13;
    @FXML private Label progressLabel13;
    @FXML private Circle progressCircle14;
    @FXML private Label progressLabel14;
    @FXML private Circle progressCircle15;
    @FXML private Label progressLabel15;
    @FXML private Circle progressCircle16;
    @FXML private Label progressLabel16;
    @FXML private Circle progressCircle17;
    @FXML private Label progressLabel17;
    @FXML private Circle progressCircle18;
    @FXML private Label progressLabel18;
    @FXML private Circle progressCircle19;
    @FXML private Label progressLabel19;
    @FXML private Circle progressCircle20;
    @FXML private Label progressLabel20;

    public void initialize() {
        Random rand = new Random();
        setProgress(progressCircle1, progressLabel1, rand.nextInt(101));
        setProgress(progressCircle2, progressLabel2, rand.nextInt(101));
        setProgress(progressCircle3, progressLabel3, rand.nextInt(101));
        setProgress(progressCircle4, progressLabel4, rand.nextInt(101));
        setProgress(progressCircle5, progressLabel5, rand.nextInt(101));
        setProgress(progressCircle6, progressLabel6, rand.nextInt(101));
        setProgress(progressCircle7, progressLabel7, rand.nextInt(101));
        setProgress(progressCircle8, progressLabel8, rand.nextInt(101));
        setProgress(progressCircle9, progressLabel9, rand.nextInt(101));
        setProgress(progressCircle10, progressLabel10, rand.nextInt(101));
        setProgress(progressCircle11, progressLabel11, rand.nextInt(101));
        setProgress(progressCircle12, progressLabel12, rand.nextInt(101));
        setProgress(progressCircle13, progressLabel13, rand.nextInt(101));
        setProgress(progressCircle14, progressLabel14, rand.nextInt(101));
        setProgress(progressCircle15, progressLabel15, rand.nextInt(101));
        setProgress(progressCircle16, progressLabel16, rand.nextInt(101));
        setProgress(progressCircle17, progressLabel17, rand.nextInt(101));
        setProgress(progressCircle18, progressLabel18, rand.nextInt(101));
        setProgress(progressCircle19, progressLabel19, rand.nextInt(101));
        setProgress(progressCircle20, progressLabel20, rand.nextInt(101));
    }

    private void setProgress(Circle circle, Label label, double percent) {
        double circumference = 2 * Math.PI * circle.getRadius();
        circle.getStrokeDashArray().setAll(circumference);
        circle.setStrokeDashOffset(circumference * (1 - percent / 100));
        circle.setStrokeLineCap(StrokeLineCap.ROUND);

        label.setText(String.format("%.0f%%", percent));

        if (percent == 0) circle.setStroke(Color.LIGHTGRAY);
        else if (percent < 50) circle.setStroke(Color.RED);
        else if (percent < 80) circle.setStroke(Color.ORANGE);
        else circle.setStroke(Color.GREEN);
    }
}