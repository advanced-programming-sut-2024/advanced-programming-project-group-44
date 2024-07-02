package com.ap.gwentgame.model.Game;

import com.ap.gwentgame.model.*;
import com.ap.gwentgame.model.Factions.Faction;
import com.ap.gwentgame.model.Leaders.Leader;

import java.util.Queue;


public class Game {
    private static Board currentBoard;
    private Queue<Player> players;

    public void createNewBoard(Player player1, Player player2){
        currentBoard = new Board(player1, player2);
    }

    public void addPlayerToQueue(Player player){
        players.add(player);
        if (players.size() == 2){
            createNewBoard(players.poll(), players.poll());
        }
    }

    public Board getCurrentBoard() {
        return currentBoard;
    }
}
