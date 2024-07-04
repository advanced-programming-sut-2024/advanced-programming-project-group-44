package com.ap.gwentgame.model.Game;

import com.ap.gwentgame.model.Cards.Weather;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class GameData implements Serializable {
    private final Player player1;
    private final Player player2;
    private Player Winner;
    private Player currentPlayer;
    private Player opponentPlayer;

    private final ArrayList<Weather> weatherCards;

    private final Date creationDate;

    public GameData(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.opponentPlayer = player2;
        this.creationDate = new Date();
        this.weatherCards = new ArrayList<>();
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Player getWinner() {
        return Winner;
    }

    public void setWinner(Player winner) {
        Winner = winner;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Player getOpponentPlayer() {
        return opponentPlayer;
    }

    public void setOpponentPlayer(Player opponentPlayer) {
        this.opponentPlayer = opponentPlayer;
    }

    public ArrayList<Weather> getWeatherCards() {
        return weatherCards;
    }

    public Date getCreationDate() {
        return creationDate;
    }
}
