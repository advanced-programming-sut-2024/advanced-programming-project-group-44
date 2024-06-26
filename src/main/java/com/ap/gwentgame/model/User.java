package com.ap.gwentgame.model;

import com.ap.gwentgame.enums.Question;
import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Game.GameData;


import java.util.ArrayList;

public class User {
    private final String name;
    private final String password;
    private final String nickName;
    private final String email;
    private final Question question;
    private final String answer;
    private final ArrayList<Card> deck;
    private final ArrayList<GameData> gameHistory;

    public User(String name, String password, String nickName, String email, Question question, String answer) {
        this.name = name;
        this.password = password;
        this.nickName = nickName;
        this.email = email;
        this.question = question;
        this.answer = answer;
        this.deck = new ArrayList<Card>();
        this.gameHistory = new ArrayList<GameData>();
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

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public ArrayList<GameData> getGameHistory() {
        return gameHistory;
    }
}
