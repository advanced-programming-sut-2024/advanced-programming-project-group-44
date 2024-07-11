package com.ap.gwentgame.client.model.Game;

import com.ap.gwentgame.client.model.Cards.Weather;
import com.ap.gwentgame.client.model.ItemContainer;

import java.util.ArrayList;
import java.util.Date;

public class Board {
    private final Player player1;
    private final Player player2;
    private Player Winner;
    private Player currentPlayer;
    private Player opponentPlayer;

    private final ItemContainer<Weather> weatherCards;

    private final Date creationDate;

    public Board(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.opponentPlayer = player2;
        this.creationDate = new Date();
        this.weatherCards = new ItemContainer<>();
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

    public ItemContainer<Weather> getWeatherCards() {
        return weatherCards;
    }

    public void setWeatherCards(Weather weatherCards) {
        this.weatherCards.add(weatherCards);
    }

    public Date getCreationDate() {
        return creationDate;
    }
}
