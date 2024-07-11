package com.ap.gwentgame.client.model;

import com.ap.gwentgame.client.model.gameElements.Board;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Session {
    private static Stage stage;
    private static User loggedinUser;
    private static int gameId;
    private static Board currentBoard;
    private static ArrayList<GameLog> gameLogs = new ArrayList<>();

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

    public static Board getCurrentBoard() {
        return currentBoard;
    }

    public static void setCurrentBoard(Board currentBoard) {
        Session.currentBoard = currentBoard;
    }

    public static ArrayList<GameLog> getGameLogs() {
        return gameLogs;
    }

    public static void addGameLog(GameLog gameLog) {
        gameLogs.add(gameLog);
    }
}
