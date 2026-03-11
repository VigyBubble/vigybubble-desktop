package com.effortcure.util;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class ResponsiveViewUtil {

    public static void convertToResponsiveView(Region root, Node[] nodes, Label[] errorMsgLabels,
            boolean hideErrorMessages) {
        double[] widthAndHightRatios = getScreenWidthAndHightRatios(root);
        if (errorMsgLabels != null) {
            if (hideErrorMessages)
                hideErrorMessages(errorMsgLabels, widthAndHightRatios[0], widthAndHightRatios[1]);
            else
                showHiddenErrorMessages(errorMsgLabels);
        }
        for (Node n : nodes) {
            if (n instanceof Region region) {
                if (region.isVisible()) {
                    resizeNodeWidthAndHight(n, widthAndHightRatios[0], widthAndHightRatios[1]);
                }
                relocateNodeXAndY(n, widthAndHightRatios[0], widthAndHightRatios[1]);
                resizeFont(region, widthAndHightRatios[0], widthAndHightRatios[1]);
            }
            if (n instanceof ImageView) {
                resizeNodeWidthAndHight(n, widthAndHightRatios[0], widthAndHightRatios[1]);
                relocateNodeXAndY(n, widthAndHightRatios[0], widthAndHightRatios[1]);
            }
            if (n instanceof Rectangle) {
                resizeNodeWidthAndHight(n, widthAndHightRatios[0], widthAndHightRatios[1]);
                relocateNodeXAndY(n, widthAndHightRatios[0], widthAndHightRatios[1]);
            }
        }
    }

    private static double[] getScreenWidthAndHightRatios(Region root) {
        double screenWidth = Double.valueOf(System.getProperty("os.screen.width"));
        double screenHight = Double.valueOf(System.getProperty("os.screen.hight"));
        double widthRatio = screenWidth / root.getPrefWidth();
        double hightRatio = screenHight / root.getPrefHeight();
        return new double[] { widthRatio, hightRatio };
    }

    private static void resizeNodeWidthAndHight(Node node, double widthRatio, double hightRatio) {
        if (node instanceof Region region) {
            region.setPrefWidth(region.getPrefWidth() * widthRatio);
            region.setPrefHeight(region.getPrefHeight() * hightRatio);
            region.setMinWidth(region.getPrefWidth());
            region.setMinHeight(region.getPrefHeight());
            region.setMaxWidth(region.getPrefWidth());
            region.setMaxHeight(region.getPrefHeight());
        }
        if (node instanceof ImageView imageView) {
            imageView.setFitWidth(imageView.getFitWidth() * widthRatio);
            imageView.setFitHeight(imageView.getFitHeight() * hightRatio);
        }
        if (node instanceof Rectangle rectangle) {
            rectangle.setWidth(rectangle.getWidth() * widthRatio);
            rectangle.setHeight(rectangle.getHeight() * hightRatio);
        }
    }

    private static void hideErrorMessages(Label[] errorMsgLabels, double widthRatio, double hightRatio) {
        for (Label label : errorMsgLabels) {
            label.setVisible(false);
            resizeNodeWidthAndHight(label, widthRatio, hightRatio);
        }
    }

    private static void showHiddenErrorMessages(Label[] errorMsgLabels) {
        for (Label label : errorMsgLabels) {
            label.setVisible(true);
        }
    }

    private static void relocateNodeXAndY(Node node, double widthRatio, double hightRatio) {
        if (node instanceof Region region) {
            if (region.getParent() != null) {
                Region parent = (Region) region.getParent();
                Region parentErrorMsgRegion = parent.getChildrenUnmodifiable()
                        .stream()
                        .filter(n -> n.getId() != null && n.getId().contains("ErrorMsg"))
                        .filter(n -> !n.isVisible() && n instanceof Region)
                        .map(n -> (Region) n)
                        .findFirst()
                        .orElse(null);
                region.setLayoutX(
                        region.getLayoutX() / (parent.getPrefWidth() / widthRatio) * parent.getPrefWidth());
                if (parentErrorMsgRegion == null || region.getId().contains("ErrorMsg")) {
                    region.setLayoutY(
                            region.getLayoutY() / (parent.getPrefHeight() / hightRatio) * parent.getPrefHeight());
                } else {
                    region.setLayoutY(
                            region.getLayoutY() / (parent.getPrefHeight() / hightRatio) *
                                    parent.getPrefHeight()
                                    + (parentErrorMsgRegion.getPrefHeight() / 2));
                }
            }
        }
        if (node instanceof ImageView imageView) {
            if (imageView.getParent() != null) {
                Region parent = (Region) imageView.getParent();
                Region parentErrorMsgRegion = parent.getChildrenUnmodifiable()
                        .stream()
                        .filter(n -> n.getId() != null && n.getId().contains("ErrorMsg"))
                        .filter(n -> !n.isVisible() && n instanceof Region)
                        .map(n -> (Region) n)
                        .findFirst()
                        .orElse(null);
                imageView.setLayoutX(
                        imageView.getLayoutX() / (parent.getPrefWidth() / widthRatio) * parent.getPrefWidth());
                if (parentErrorMsgRegion == null) {
                    imageView.setLayoutY(
                            imageView.getLayoutY() / (parent.getPrefHeight() / hightRatio)
                                    * parent.getPrefHeight());
                } else {
                    imageView.setLayoutY(
                            imageView.getLayoutY() / (parent.getPrefHeight() / hightRatio) *
                                    parent.getPrefHeight()
                                    + (parentErrorMsgRegion.getPrefHeight() / 2));
                }
            }
        }
        if (node instanceof Rectangle rectangle) {
            if (rectangle.getParent() != null) {
                Region parent = (Region) rectangle.getParent();
                Region parentErrorMsgRegion = parent.getChildrenUnmodifiable()
                        .stream()
                        .filter(n -> n.getId() != null && n.getId().contains("ErrorMsg"))
                        .filter(n -> !n.isVisible() && n instanceof Region)
                        .map(n -> (Region) n)
                        .findFirst()
                        .orElse(null);
                rectangle.setLayoutX(
                        rectangle.getLayoutX() / (parent.getPrefWidth() / widthRatio) * parent.getPrefWidth());
                if (parentErrorMsgRegion == null) {
                    rectangle.setLayoutY(
                            rectangle.getLayoutY() / (parent.getPrefHeight() / hightRatio)
                                    * parent.getPrefHeight());
                } else {
                    rectangle.setLayoutY(
                            rectangle.getLayoutY() / (parent.getPrefHeight() / hightRatio) *
                                    parent.getPrefHeight()
                                    + (parentErrorMsgRegion.getPrefHeight() / 2));
                }
            }
        }
    }

    private static void resizeFont(Region region, double widthRatio, double hightRatio) {
        double fontScale = Math.min(region.getPrefWidth() / (region.getPrefWidth() / widthRatio),
                region.getPrefHeight() / (region.getPrefHeight() / hightRatio));
        if (region instanceof Label label)
            label.setFont(new Font(label.getFont().getSize() * fontScale));
        if (region instanceof Button btn) {
            btn.setFont(new Font(btn.getFont().getSize() * fontScale));
            btn.setPadding(new Insets(0));
        }
        if (region instanceof TextField textField)
            textField.setFont(new Font(textField.getFont().getSize() * fontScale));
        if (region instanceof PasswordField passwordField)
            passwordField.setFont(new Font(passwordField.getFont().getSize() * fontScale));
    }
}
