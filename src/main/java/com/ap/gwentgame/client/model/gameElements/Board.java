package com.ap.gwentgame.client.model.gameElements;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Board implements Serializable {
    private final Player player1;
    private final Player player2;
    private Player Winner;
    private Player currentPlayer;
    private Player opponentPlayer;

    private Board initialBoard;
    private ArrayList<String> commands;

    private final int ID;

    private final ArrayList<WeatherCard> weatherCardCards;

    private final Date creationDate;

    public Board(Player player1, Player player2, int ID){
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.opponentPlayer = player2;
        this.creationDate = new Date();
        this.weatherCardCards = new ArrayList<>();
        this.ID = ID;
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

    public ArrayList<WeatherCard> getWeatherCards() {
        return weatherCardCards;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void addCommand(String command){
        commands.add(command);
    }

    public int getID(){
        return ID;
    }
}
