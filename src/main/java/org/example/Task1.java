package org.example;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
    private static final String regex = "^\\(?\\d{3}\\)?[- ]\\d{3}-\\d{4}$";
    private static final Pattern pattern = Pattern.compile(regex);

    public static void main(String[] args) {
        readFile("PhoneBook.txt");
    }
    public static void readFile(String filePath){
            try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
                Scanner scanner = new Scanner(fileInputStream);
                while (scanner.hasNext()) {
                    String phone = scanner.nextLine();
                    Matcher matcher = pattern.matcher(phone);
                    if (matcher.find()) {
                        System.out.println(phone);
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

