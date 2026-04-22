package com.effortcure.util;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class DirectoryPickerUtil {
    public static Set<String> pickFiles(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Files Only");
        List<File> selectedFiles = fileChooser.showOpenMultipleDialog(stage);
        Set<String> result = new HashSet<>();
        if (selectedFiles != null) {
            for (File file : selectedFiles) {
                if (file.isDirectory()) {
                    continue;
                }
                result.add(file.getAbsolutePath());
            }
        }
        return result;
    }

    public static String pickAFolder(Stage stage) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select a Folder");
        File selectedDirectory = directoryChooser.showDialog(stage);
        return selectedDirectory.getAbsolutePath();
    }
}
