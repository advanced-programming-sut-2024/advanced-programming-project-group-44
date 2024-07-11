package com.ap.gwentgame.server;

import com.ap.gwentgame.client.model.gameElements.Board;

import java.util.ArrayList;

public class TournamentHandler {
    private ArrayList<UserHandler> players;
    private ArrayList<BoardHandler> games;

    public TournamentHandler(ArrayList<UserHandler> players){
        this.players = players;
    }

    public void startTournament(){
        for(int i = 0; i < players.size(); i++){
            for(int j = i + 1; j < players.size(); j++){
                BoardHandler boardHandler = new BoardHandler(players.get(i), players.get(j), games.size());
                games.add(boardHandler);
                players.get(i).sendResponse("GAME started", boardHandler.getCurrentBoard());
                players.get(j).sendResponse("GAME started", boardHandler.getCurrentBoard());
            }
        }
    }
}
