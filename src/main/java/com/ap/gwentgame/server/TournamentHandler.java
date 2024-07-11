package com.ap.gwentgame.server;

import com.ap.gwentgame.client.model.User;
import com.ap.gwentgame.client.model.gameElements.Board;
import com.ap.gwentgame.client.model.gameElements.Player;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TournamentHandler {
    private ArrayList<UserHandler> players;
    private Queue<UserHandler> waitingPlayers;
    private Queue<UserHandler> finishedPlayers;
    private ArrayList<BoardHandler> games;
    private int currentGameID = 0;

    public TournamentHandler(ArrayList<UserHandler> players) {
        this.players = players;
        this.waitingPlayers = new LinkedList<>();
        this.finishedPlayers = new LinkedList<>();
    }

    public void startTournament() {
        for (int i = 0; i < players.size(); i++) {
            for (int j = i + 1; j < players.size(); j++) {
                BoardHandler boardHandler = new BoardHandler(players.get(i), players.get(j), currentGameID++);
                games.add(boardHandler);
                players.get(i).sendResponse("GAME started", boardHandler.getCurrentBoard());
                players.get(j).sendResponse("GAME started", boardHandler.getCurrentBoard());
            }
        }
    }

    public void endGame(int ID) {
        for (BoardHandler game : games) {
            if (game.getCurrentBoard().getID() == ID) {
                games.remove(game);
                waitingPlayers.add(findUserHandler(game.getCurrentBoard().getWinner().getUser()));
                Player loser = game.getCurrentBoard().getWinner().equals(game.getCurrentBoard().getPlayer1()) ? game.getCurrentBoard().getPlayer2() : game.getCurrentBoard().getPlayer1();
                finishedPlayers.add(findUserHandler(loser.getUser()));

                if (finishedPlayers.size() == 7){
                    for (UserHandler userHandler : players) {
                        userHandler.sendResponse("TOURNAMENT finished", null);
                    }
                }

                if (waitingPlayers.size() >= 2) {
                    UserHandler player1 = waitingPlayers.poll();
                    UserHandler player2 = waitingPlayers.poll();
                    BoardHandler boardHandler = new BoardHandler(player1, player2, currentGameID++);
                    games.add(boardHandler);
                    player1.sendResponse("GAME started", boardHandler.getCurrentBoard());
                    player2.sendResponse("GAME started", boardHandler.getCurrentBoard());
                }

                break;
            }
        }
    }

    public UserHandler findUserHandler(User user) {
        for (UserHandler userHandler : players) {
            if (userHandler.getPlayer().getUser().equals(user)) {
                return userHandler;
            }
        }
        return null;
    }
}
