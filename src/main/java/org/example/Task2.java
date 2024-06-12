package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        File file = new File("Users.txt");
        ArrayList<User> users = ReadUser(file);
        MakeFile(ToJson(users));
    }
    public static ArrayList<User> ReadUser(File file) {
        ArrayList<User> usersList = new ArrayList<>();
        try(FileInputStream fileInputStream = new FileInputStream(file)){
            Scanner scanner = new Scanner(fileInputStream);
            scanner.nextLine();
            while (scanner.hasNext()){
                String[] wordsArray = scanner.nextLine().split(" ");
                User user = new User(wordsArray[0], Integer.parseInt(wordsArray[1]));
                usersList.add(user);
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return usersList;
    }
    public static String ToJson(ArrayList<User> usersList){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(gson.toJson(usersList));
        return stringBuilder.toString();
    }
    public static void MakeFile(String text){
        File file = new File("fileJson");
        try(FileWriter fileWriter = new FileWriter(file)){
            fileWriter.write(text);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
