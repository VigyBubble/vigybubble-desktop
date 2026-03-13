package com.effortcure.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.effortcure.callback.MouseSelectionCallback;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

public class ControllersUtil {

    public static void onMouseSelection(TextField textField, MouseSelectionCallback callback) {
        textField.setOnMouseReleased(mr -> {
            int start = textField.getSelection().getStart();
            int end = textField.getSelection().getEnd();
            callback.onSelection(start, end);
        });
    }

    public static void disableTextFeildPasting(TextField textField, Label errorLabel, String errorMsg) {
        textField.setOnKeyPressed(kp -> {
            if (new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_DOWN).match(kp) ||
                    new KeyCodeCombination(KeyCode.INSERT, KeyCombination.SHIFT_DOWN).match(kp)) {
                textField.setText("");
                if (errorLabel != null)
                    errorLabel.setText(errorMsg);
            }
        });
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
}
