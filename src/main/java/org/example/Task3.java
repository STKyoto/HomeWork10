package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        String fileText = ReadFile("Task3.txt");
        System.out.println(WordFrequency(fileText));
    }

    public static String ReadFile(String filePath) {
        StringBuilder sb = new StringBuilder();
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            Scanner scanner = new Scanner(fileInputStream);
            while (scanner.hasNext()) {
                sb.append(scanner.nextLine()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static Map<String, Integer> WordFrequency(String text) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        String[] words = text.split("\\s+");
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
        return wordFrequency;
    }
}
