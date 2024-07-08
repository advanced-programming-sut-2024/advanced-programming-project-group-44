package com.ap.gwentgame.model.Game;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "game_data")
public class GameData implements Serializable {
    private static final long serialVersionUID = 1L;

    //    private int[] playerScores;
//
//    private int[] opponentScores;
    @Column(name = "playerScoreRound1")
    private int playerScoreRound1;
    @Column(name = "playerScoreRound2")
    private int playerScoreRound2;
    @Column(name = "playerScoreRound3")
    private int playerScoreRound3;
    @Column(name = "opponentScoreRoun1")
    private int opponentScoreRound1;
    @Column(name = "opponentScoreRoun2")
    private int opponentScoreRound2;
    @Column(name = "opponentScoreRoun3")
    private int opponentScoreRound3;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "player_name")
    private String playerName;

    @Column(name = "opponent_name")
    private String opponentName;

    @Column(name = "game_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "player_score")
    private int playerScore;

    @Column(name = "opponent_score")
    private int opponentScore;

    @Column(name = "winner")
    private String winner;

    public GameData() {
        // Default constructor required by JPA
    }

    public GameData(String playerName, String opponentName, Date date, int playerScore,
                    int opponentScore, int[] playerScores, int[] opponentScores, String winner) {
        this.playerName = playerName;
        this.opponentName = opponentName;
        this.date = date;
        this.playerScore = playerScore;
        this.opponentScore = opponentScore;
//        this.playerScores = playerScores;
//        this.opponentScores = opponentScores;
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

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
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

    public int[] getPlayerScores() {
        return new int[]{playerScoreRound1, playerScoreRound2, playerScoreRound3};
    }

    public void setPlayerScores(int[] playerScores) {
//        this.playerScores = playerScores;
        this.playerScoreRound1 = playerScores[0];
        this.playerScoreRound2 = playerScores[1];
        this.playerScoreRound3 = playerScores[2];
    }

    public int[] getOpponentScores() {
//        return opponentScores;
        return new int[]{opponentScoreRound1, opponentScoreRound2, opponentScoreRound3};
    }

    public void setOpponentScores(int[] opponentScores) {
//        this.opponentScores = opponentScores;
        this.opponentScoreRound1 = opponentScores[0];
        this.opponentScoreRound2 = opponentScores[1];
        this.opponentScoreRound3 = opponentScores[2];
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}
