package com.ap.gwentgame.client.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "game_log")
public class GameLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "opponent_name")
    private String opponentName;

    @Column(name = "game_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "player_score")
    private int playerScore;

    @Column(name = "opponent_score")
    private int opponentScore;

    @Column(name = "player_score_round1")
    private int playerScoreRound1;

    @Column(name = "player_score_round2")
    private int playerScoreRound2;

    @Column(name = "player_score_round3")
    private int playerScoreRound3;

    @Column(name = "opponent_score_round1")
    private int opponentScoreRound1;

    @Column(name = "opponent_score_round2")
    private int opponentScoreRound2;

    @Column(name = "opponent_score_round3")
    private int opponentScoreRound3;

    @Column(name = "winner")
    private String winner;

    public GameLog() {
    }

    public GameLog(String opponentName, Date date, int playerScore, int opponentScore, int[] playerScores, int[] opponentScores, String winner) {
        this.opponentName = opponentName;
        this.date = date;
        this.playerScore = playerScore;
        this.opponentScore = opponentScore;
        this.playerScoreRound1 = playerScores[0];
        this.playerScoreRound2 = playerScores[1];
        this.playerScoreRound3 = playerScores[2];
        this.opponentScoreRound1 = opponentScores[0];
        this.opponentScoreRound2 = opponentScores[1];
        this.opponentScoreRound3 = opponentScores[2];
        this.winner = winner;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public String getOpponentName() {
        return opponentName;
    }

    public void setOpponentName(String opponentName) {
        this.opponentName = opponentName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public int getOpponentScore() {
        return opponentScore;
    }

    public void setOpponentScore(int opponentScore) {
        this.opponentScore = opponentScore;
    }

    public int getPlayerScoreRound1() {
        return playerScoreRound1;
    }

    public void setPlayerScoreRound1(int playerScoreRound1) {
        this.playerScoreRound1 = playerScoreRound1;
    }

    public int getPlayerScoreRound2() {
        return playerScoreRound2;
    }

    public void setPlayerScoreRound2(int playerScoreRound2) {
        this.playerScoreRound2 = playerScoreRound2;
    }

    public int getPlayerScoreRound3() {
        return playerScoreRound3;
    }

    public void setPlayerScoreRound3(int playerScoreRound3) {
        this.playerScoreRound3 = playerScoreRound3;
    }

    public int getOpponentScoreRound1() {
        return opponentScoreRound1;
    }

    public void setOpponentScoreRound1(int opponentScoreRound1) {
        this.opponentScoreRound1 = opponentScoreRound1;
    }

    public int getOpponentScoreRound2() {
        return opponentScoreRound2;
    }

    public void setOpponentScoreRound2(int opponentScoreRound2) {
        this.opponentScoreRound2 = opponentScoreRound2;
    }

    public int getOpponentScoreRound3() {
        return opponentScoreRound3;
    }

    public void setOpponentScoreRound3(int opponentScoreRound3) {
        this.opponentScoreRound3 = opponentScoreRound3;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}
