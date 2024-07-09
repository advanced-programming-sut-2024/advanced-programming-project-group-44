package com.ap.gwentgame.server;

import com.ap.gwentgame.client.model.gameElements.Board;
import com.ap.gwentgame.client.model.gameElements.Player;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class GameManager {
    private static final HashMap<Integer, Board> allGames = new HashMap<>();
    private static int gameCount = 0;
    private static final Queue<Player> randomGameQueue = new LinkedList<>();

    public static Board createNewBoard(Player player1, Player player2){
        Board board = new Board(player1, player2);
        allGames.put(gameCount, board);
        return board;
    }

    public synchronized static int submitRandomPlay(Player player){
        randomGameQueue.add(player);
        if (randomGameQueue.size() == 2){
            createNewBoard(randomGameQueue.poll(), randomGameQueue.poll());
            return gameCount++;
        }
        return -1;
    }
}
