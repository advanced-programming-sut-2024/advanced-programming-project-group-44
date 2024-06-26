package com.ap.gwentgame;

import com.ap.gwentgame.model.User;
import javafx.stage.Stage;

import java.util.ArrayList;

public class App {
    private static ArrayList<User> allusers = new ArrayList<>();
    private static Stage stage;

    private static User loggedinUser;

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        App.stage = stage;
    }

    public static User getUserByName(String name){
        for(User user : allusers){
            if(user.getName().equals(name)){
                return user;
            }
        }
        return null;
    }

    public static void addUser(User user){
        allusers.add(user);
    }
    public static User getLoggedinUser(){
        return loggedinUser;
    }
    public static void setLoggedinUser(User user){
        loggedinUser = user;
    }
}
