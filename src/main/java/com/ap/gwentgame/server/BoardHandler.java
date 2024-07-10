package com.ap.gwentgame.server;

import com.ap.gwentgame.client.model.gameElements.Board;

import java.util.ArrayList;

public class BoardHandler {
    private UserHandler player1;
    private UserHandler player2;
    private final ArrayList<UserHandler> spectators;
    private Board currentBoard;
    private boolean turn;

    public BoardHandler(UserHandler player1, UserHandler player2){
        this.player1 = player1;
        this.player2 = player2;
        this.spectators = new ArrayList<>();
        this.currentBoard = new Board(player1.getPlayer(), player2.getPlayer());
    }

    public Board getCurrentBoard(){
        return currentBoard;
    }

    public void addSpectator(UserHandler spectator){
        spectators.add(spectator);
    }

    public void submitCommand(String command, Board updatedBoard){
        currentBoard = updatedBoard;
        player1.sendResponse(command);
        player2.sendResponse(command);
        for(UserHandler spectator : spectators){
            spectator.sendResponse(command);
        }
        turn = !turn;
    }
}
