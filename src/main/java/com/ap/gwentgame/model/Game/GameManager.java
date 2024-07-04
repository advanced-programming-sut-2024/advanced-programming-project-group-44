package com.ap.gwentgame.model.Game;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class GameManager {
    private static final HashMap<Integer, GameData> allGames = new HashMap<>();
    private static int gameCount = 0;
    private static final Queue<Player> players = new LinkedList<>();

    public static void createNewBoard(Player player1, Player player2){
        GameData gameData = new GameData(player1, player2);
        allGames.put(gameCount, gameData);
        gameCount++;
    }

    public static void addPlayerToQueue(Player player){
        players.add(player);
        if (players.size() == 2){
            createNewBoard(players.poll(), players.poll());
        }
    }

    public static GameData getGameDataById(int id){
        return allGames.get(id);
    }
}
