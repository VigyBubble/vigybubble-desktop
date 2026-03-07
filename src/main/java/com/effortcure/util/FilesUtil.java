package com.effortcure.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesUtil {

    public static void writeToFile(String rootPath, String folderName, String fileName, String content) {
        Path folderPath = Paths.get(rootPath, folderName);
        Path filePath = folderPath.resolve(fileName);
        try {
            if (!Files.exists(folderPath)) {
                Files.createDirectories(folderPath);
            }
            Files.writeString(filePath, content, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFromFile(String rootPath, String folderName, String fileName) {
        Path folderPath = Paths.get(rootPath, folderName);
        Path filePath = folderPath.resolve(fileName);
        try {
            if (!Files.exists(filePath)) {
                System.out.println("File does not exist: " + filePath);
                return null;
            }
            return Files.readString(filePath, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
