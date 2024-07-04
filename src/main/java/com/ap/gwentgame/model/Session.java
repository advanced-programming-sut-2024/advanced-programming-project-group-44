package com.ap.gwentgame.model;

import javafx.stage.Stage;

import java.util.ArrayList;

public class Session {
    private static ArrayList<User> allusers = new ArrayList<>();

    private static Stage stage;
    private static User loggedinUser;
    private static int gameId;

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        Session.stage = stage;
    }

    public static int getGameId() {
        return gameId;
    }

    public static void setGameId(int gameId) {
        Session.gameId = gameId;
    }

    public static User getLoggedInUser(){
        return loggedinUser;
    }

    public static void setLoggedInUser(User user){
        loggedinUser = user;
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




}
