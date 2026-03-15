package com.effortcure.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.effortcure.callback.TypedTextCallback;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;

public class ControllersUtil {

    public static void onMouseSelection(TextField[] textFields) {
        for (TextField textField : textFields) {
            textField.setOnMouseReleased(mr -> {
                int start = textField.getSelection().getStart();
                int end = textField.getSelection().getEnd();
                System.setProperty("mouse.selected.start-index", String.valueOf(start));
                System.setProperty("mouse.selected.end-index", String.valueOf(end));
            });
        }
    }

    public static void getTypedTextOnKeyTypedOrDelete(TextField textField, TypedTextCallback callback) {
        StringBuilder typedText = new StringBuilder();
        textField.setOnKeyTyped(e -> {
            if (e.getCharacter().equals("\b") && typedText.length() >= 1) {
                if (Integer.valueOf(System.getProperty("mouse.selected.start-index"))
                        - Integer.valueOf(System.getProperty("mouse.selected.end-index")) == 0) {
                    typedText.deleteCharAt(textField.getCaretPosition());
                } else {
                    for (int i = Integer.valueOf(System.getProperty("mouse.selected.start-index")); i <= Integer
                            .valueOf(System.getProperty("mouse.selected.end-index")) - 1; i++) {
                        typedText.deleteCharAt(Integer.valueOf(System.getProperty("mouse.selected.start-index")));
                    }
                }
            } else {
                if (textField.getCaretPosition() != 0) {
                    typedText.insert(textField.getCaretPosition() - 1, e.getCharacter());
                }
            }
            callback.onKeyTypedOrDelete(typedText);
            int cursorPositionBeforeSettingFeild = textField.getCaretPosition();
            textField.setText(textField.getText() + " ");
            textField.setText(textField.getText().stripTrailing());
            textField.positionCaret(cursorPositionBeforeSettingFeild);
        });
    }

    public static void disableTextFeildPasting(TextField[] textFields) {
        for (TextField textField : textFields) {
            textField.setOnKeyPressed(kp -> {
                if (new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_DOWN).match(kp) ||
                        new KeyCodeCombination(KeyCode.INSERT, KeyCombination.SHIFT_DOWN).match(kp)) {
                    textField.setText("");
                    Node parentNode = textField.getParent();
                    if (parentNode instanceof Parent parent) {
                        ObservableList<Node> children = getModifiableChildren(parent);
                        if (children != null) {
                            for (Node child : children) {
                                if (child.getId().contains("ErrorMsg") && child instanceof Label) {
                                    ((Label) child).setText("can't paste here *");
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    public static Node[] getInjectedNodes(Object controller) {
        List<Node> nodes = new ArrayList<>();
        Field[] fields = controller.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(FXML.class) &&
                    Node.class.isAssignableFrom(field.getType())) {
                try {
                    field.setAccessible(true);
                    Node node = (Node) field.get(controller);
                    if (node != null) {
                        nodes.add(node);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return nodes.toArray(new Node[0]);
    }

    public static ObservableList<Node> getModifiableChildren(Parent parent) {
        if (parent instanceof Pane pane) {
            return pane.getChildren();
        }
        if (parent instanceof Group group) {
            return group.getChildren();
        }
        return null;
    }
}
