package com.effortcure.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ViewUtil {

    public static double[] getPlatformFullScreenViewDimensions() {
        Rectangle2D screen = Screen.getPrimary().getVisualBounds();
        double width = screen.getWidth();
        double hight = screen.getHeight();
        getPlatformTitleBarSize();
        String readContent = FilesUtil.readFromFile(System.getProperty("user.home"), "Vigy Bubble",
                "Platform Titlebar Size.txt");
        hight = readContent != null ? hight - Double.valueOf(readContent) : hight;
        return new double[] { width, hight };
    }

    private static void getPlatformTitleBarSize() {
        Stage temp = new Stage();
        Scene scene = new Scene(new Pane(), 0, 0);
        temp.setScene(scene);
        temp.setX(0);
        temp.setY(0);
        temp.show();
        Platform.runLater(() -> {
            Platform.runLater(() -> {
                double titleBarHeight = temp.getHeight() - scene.getHeight();
                FilesUtil.writeToFile(System.getProperty("user.home"), "Vigy Bubble", "Platform Titlebar Size.txt",
                        String.valueOf(titleBarHeight));
                temp.close();
            });
        });
    }

    public static void initiateResponsiveView(Object object) {
        Node[] allNodes = ControllersUtil.getInjectedNodes(object);
        double[] widthAndHightRatios = ViewUtil.evaluateScreenWidthAndHightRatios((Region) allNodes[0]);
        for (Node node : allNodes) {
            ViewUtil.resizeNodeWidthAndHight(node, widthAndHightRatios[0], widthAndHightRatios[1]);
            ViewUtil.relocateNodeXAndY(node, widthAndHightRatios[0], widthAndHightRatios[1]);
            ViewUtil.resizeFont(node, widthAndHightRatios[0], widthAndHightRatios[1]);
            if (node.getId().contains("ErrorMsg") && node instanceof Label label)
                hideErrorMessages(new Label[] { label });
        }
    }

    private static double[] evaluateScreenWidthAndHightRatios(Region root) {
        double screenWidth = Double.valueOf(System.getProperty("os.screen.width"));
        double screenHight = Double.valueOf(System.getProperty("os.screen.hight"));
        double widthRatio = screenWidth / 1440.0;
        double hightRatio = screenHight / 1024.0;
        return new double[] { widthRatio, hightRatio };
    }

    private static void resizeNodeWidthAndHight(Node node, double widthRatio, double hightRatio) {
        if (node instanceof Region region && !(node instanceof VBox)) {
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
        if (node instanceof Circle circle) {
            circle.setCenterX(circle.getCenterX() * widthRatio);
            circle.setCenterY(circle.getCenterY() * hightRatio);
            circle.setRadius(circle.getRadius() * Math.min(widthRatio, hightRatio));
        }
        if (node instanceof TextFlow textFlow) {
            textFlow.setPrefWidth(textFlow.getPrefWidth() * widthRatio);
            textFlow.setPrefHeight(textFlow.getPrefHeight() * hightRatio);
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
            if (region instanceof Hyperlink hyperlink)
                hyperlink.setFont(new Font(hyperlink.getFont().getSize() * fontScale));
            if (region instanceof CheckBox checkBox)
                checkBox.setFont(new Font(checkBox.getFont().getSize() * fontScale));
            if (region instanceof ComboBox comboBox)
                comboBox.setStyle("-fx-font-size: " + getFontSizeFromStyle(comboBox.getStyle()) * fontScale + "px;");
            if (region instanceof TextArea textArea)
                textArea.setFont(new Font(textArea.getFont().getSize() * fontScale));
            if (region instanceof DatePicker datePicker)
                datePicker
                        .setStyle("-fx-font-size: " + getFontSizeFromStyle(datePicker.getStyle()) * fontScale + "px;");
        }
        if (n instanceof Text text) {
            TextFlow textFlow = (TextFlow) text.getParent();
            double fontScale = Math.min(textFlow.getPrefWidth() / (textFlow.getPrefWidth() / widthRatio),
                    textFlow.getPrefHeight() / (textFlow.getPrefHeight() / hightRatio));
            text.setFont(new Font(text.getFont().getSize() * fontScale));
        }
    }

    public static void LoadFonts(String[] fontFilesPaths) {
        for (String fontPath : fontFilesPaths)
            Font.loadFont(ViewUtil.class.getResourceAsStream(fontPath), 12);
    }

    public static void hideErrorMessages(Label[] errorMsgLabels) {
        for (Label label : errorMsgLabels) {
            if (label.isVisible()) {
                label.setVisible(false);
                Node parentNode = label.getParent();
                if (parentNode instanceof Parent parent) {
                    ObservableList<Node> children = ControllersUtil.getModifiableChildren(parent);
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
                    ObservableList<Node> children = ControllersUtil.getModifiableChildren(parent);
                    for (Node child : children) {
                        child.setLayoutY(child.getLayoutY() - label.getHeight() / 2);
                    }
                }
            }
        }
    }

    public static void maskTextFeildContent(TextField textField, BooleanWrapperUtil mask) {
        textField.textProperty().addListener((obs, oldValue, newValue) -> {
            if (mask.getBool())
                textField.setText("\u25CF".repeat(textField.getText().stripTrailing().length()));
        });
    }

    public static double getFontSizeFromStyle(String style) {
        Pattern pattern = Pattern.compile("-fx-font-size:\\s*(\\d+(\\.\\d+)?)px");
        Matcher matcher = pattern.matcher(style);

        double fontSize = 0;

        if (matcher.find()) {
            fontSize = Double.parseDouble(matcher.group(1));
        }
        return fontSize;
    }
}
