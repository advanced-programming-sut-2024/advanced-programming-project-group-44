package com.ap.gwentgame.client.model;

import com.ap.gwentgame.client.model.gameElements.Board;
import com.ap.gwentgame.client.model.gameElements.Player;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class GameManager {
    private static final HashMap<Integer, Board> allGames = new HashMap<>();
    private static int gameCount = 0;
    private static final Queue<Player> players = new LinkedList<>();

    public static Board createNewBoard(Player player1, Player player2){
        Board board = new Board(player1, player2);
        allGames.put(gameCount, board);
        return board;
    }

    public static int addPlayerToQueue(Player player){
        players.add(player);
        if (players.size() == 2){
            createNewBoard(players.poll(), players.poll());
            return gameCount++;
        }
        return -1;
    }

    public static Board getGameDataById(int id){
        return allGames.get(id);
    }
}
