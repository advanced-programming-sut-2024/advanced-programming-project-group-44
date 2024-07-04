package com.ap.gwentgame.model.Game;

import java.util.Date;

public class GameLog {
    private final String OponnentName;
    private final Date date;
    private final int playerScore;
    private final int oponnentScore;
    private final int[] playerScores;
    private final int[] oponnentScores;
    private final String winner;

    public GameLog(String oponnentName, Date date, int playerScore, int oponnentScore, int[] playerScores, int[] oponnentScores, String winner) {
        OponnentName = oponnentName;
        this.date = date;
        this.playerScore = playerScore;
        this.oponnentScore = oponnentScore;
        this.playerScores = playerScores;
        this.oponnentScores = oponnentScores;
        this.winner = winner;
    }

    public String getOponnentName() {
        return OponnentName;
    }

    public Date getDate() {
        return date;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getOponnentScore() {
        return oponnentScore;
    }

    public int[] getPlayerScores() {
        return playerScores;
    }

    public int[] getOponnentScores() {
        return oponnentScores;
    }

    public String getWinner() {
        return winner;
    }
}
