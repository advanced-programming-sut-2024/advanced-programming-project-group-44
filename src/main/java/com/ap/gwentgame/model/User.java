package com.ap.gwentgame.model;

import com.ap.gwentgame.enums.Question;
import com.ap.gwentgame.model.gameElements.Card;


import java.util.ArrayList;

public class User {
    private  String name;
    private  String password;
    private  String nickName;
    private  String email;
    private int gamesPlayed;
    private int highestPoint;
    private int rank;
    private int wins;
    private int draws;
    private int losses;
    private final Question question;
    private final String answer;
    private final ArrayList<Card> deck;
    private final ArrayList<GameLog> gameHistory;

    public User(String name, String password, String nickName, String email, Question question, String answer) {
        this.name = name;
        this.password = password;
        this.nickName = nickName;
        this.email = email;
        this.question = question;
        this.answer = answer;
        this.gamesPlayed = 0;
        this.highestPoint = 0;
        this.rank = 0;
        this.wins = 0;
        this.draws = 0;
        this.losses = 0;
        this.deck = new ArrayList<Card>();
        this.gameHistory = new ArrayList<GameLog>();
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getNickName() {
        return nickName;
    }

    public String getEmail() {
        return email;
    }

    public Question getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getHighestPoint() {
        return highestPoint;
    }

    public int getRank() {
        return rank;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getLosses() {
        return losses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public void setHighestPoint(int highestPoint) {
        this.highestPoint = highestPoint;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public ArrayList<GameLog> getGameHistory() {
        return gameHistory;
    }
}
