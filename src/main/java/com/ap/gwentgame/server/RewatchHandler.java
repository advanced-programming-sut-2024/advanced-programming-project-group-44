package com.ap.gwentgame.server;

import com.ap.gwentgame.client.model.gameElements.Board;

import java.util.ArrayList;

public class RewatchHandler {
    private final Board board;
    private final UserHandler userHandler;
    private final ArrayList<String> commands = new ArrayList<>();

    public RewatchHandler(Board board, UserHandler userHandler) {
        this.board = board;
        this.userHandler = userHandler;
        rewatchGame();
    }

    public void rewatchGame() {
        userHandler.sendResponse("GAME rewatch started", board);
        for (String command : commands) {
            userHandler.sendResponse(command, board);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
