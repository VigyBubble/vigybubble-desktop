package com.effortcure.util;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class ResponsiveViewUtil {

    public static void initiateResponsiveView(Object object) {
        Node[] allNodes = ControllersUtil.getInjectedNodes(object);
        double[] widthAndHightRatios = ResponsiveViewUtil.evaluateScreenWidthAndHightRatios((Region) allNodes[0]);
        for (Node node : allNodes) {
            ResponsiveViewUtil.resizeNodeWidthAndHight(node, widthAndHightRatios[0], widthAndHightRatios[1]);
            ResponsiveViewUtil.relocateNodeXAndY(node, widthAndHightRatios[0], widthAndHightRatios[1]);
            ResponsiveViewUtil.resizeFont(node, widthAndHightRatios[0], widthAndHightRatios[1]);
            if (node.getId().contains("ErrorMsg") && node instanceof Label label)
                hideErrorMessages(new Label[] { label });
        }
    }

    private static double[] evaluateScreenWidthAndHightRatios(Region root) {
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

    private static void relocateNodeXAndY(Node node, double widthRatio, double hightRatio) {
        if (node.getParent() != null) {
            Region parent = (Region) node.getParent();
            node.setLayoutX(
                    node.getLayoutX() / (parent.getPrefWidth() / widthRatio) * parent.getPrefWidth());
            node.setLayoutY(
                    node.getLayoutY() / (parent.getPrefHeight() / hightRatio) * parent.getPrefHeight());
        }
    }

    private static void resizeFont(Node n, double widthRatio, double hightRatio) {
        if (n instanceof Region region) {
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

    public static void hideErrorMessages(Label[] errorMsgLabels) {
        for (Label label : errorMsgLabels) {
            if (label.isVisible()) {
                label.setVisible(false);
                Node parentNode = label.getParent();
                if (parentNode instanceof Parent parent) {
                    ObservableList<Node> children = getModifiableChildren(parent);
                    for (Node child : children) {
                        child.setLayoutY(child.getLayoutY() + label.getHeight() / 2);
                    }
                }
            }
        }
    }

    public static void showHiddenErrorMessages(Label[] errorMsgLabels) {
        for (Label label : errorMsgLabels) {
            if (!label.isVisible()) {
                label.setVisible(true);
                Node parentNode = label.getParent();
                if (parentNode instanceof Parent parent) {
                    ObservableList<Node> children = getModifiableChildren(parent);
                    for (Node child : children) {
                        child.setLayoutY(child.getLayoutY() - label.getHeight() / 2);
                    }
                }
            }
        }
    }

    private static ObservableList<Node> getModifiableChildren(Parent parent) {
        if (parent instanceof Pane pane) {
            return pane.getChildren();
        }
        if (parent instanceof Group group) {
            return group.getChildren();
        }
        throw new IllegalArgumentException(
                "Parent type does not support modifiable children: " + parent.getClass().getName());
    }
}
