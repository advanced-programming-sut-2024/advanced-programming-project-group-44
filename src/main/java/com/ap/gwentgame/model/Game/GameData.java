package com.ap.gwentgame.model.Game;

import java.io.Serializable;
import java.util.Date;

public class GameData implements Serializable {
    //private static final long serialVersionUID = 1L;

    private final String playerName;
    private final String opponentName;
    private final Date date;
    private final int playerScore;
    private final int opponentScore;
    private final int[] playerScores;
    private final int[] opponentScores;
    private final String winner;

    public GameData(String playerName, String opponentName, Date date, int playerScore, int opponentScore, int[] playerScores, int[] opponentScores, String winner) {
        this.playerName = playerName;
        this.opponentName = opponentName;
        this.date = date;
        this.playerScore = playerScore;
        this.opponentScore = opponentScore;
        this.playerScores = playerScores;
        this.opponentScores = opponentScores;
        this.winner = winner;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getOpponentName() {
        return opponentName;
    }

    public Date getDate() {
        return date;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getOpponentScore() {
        return opponentScore;
    }

    public int[] getPlayerScores() {
        return playerScores;
    }

    public int[] getOpponentScores() {
        return opponentScores;
    }

    public String getWinner() {
        return winner;
    }
}
