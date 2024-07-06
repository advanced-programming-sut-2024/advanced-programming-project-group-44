package com.ap.gwentgame.client.model;

import javafx.stage.Stage;

import java.util.ArrayList;

public class Session {
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




}
