package com.ap.gwentgame.model.Game;

import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Factions.Faction;
import com.ap.gwentgame.model.Leaders.Leader;
import com.ap.gwentgame.model.User;

import java.util.ArrayList;

public class Player{
    private final User user;
    private final Faction faction;
    private final Leader leader;
    private int currentScore;
    private final int[] scores = new int[3];
    private int remainingHealth;
    private final ArrayList<Card> deck;
    private final ArrayList<Card> hand;
    private final ArrayList<Card> discardPile;
    private final ArrayList<Card>[] rows;
    private final Card[] specialCards;
    private boolean hasPassed;

    public Player(User user, Faction faction, Leader leader){
        this.user = user;
        this.faction = faction;
        this.leader = leader;
        this.currentScore = 0;
        this.remainingHealth = 2;
        this.deck = new ArrayList<Card>();
        this.hand = new ArrayList<Card>();
        this.discardPile = new ArrayList<Card>();
        this.rows = new ArrayList[3];
        this.rows[0] = new ArrayList<Card>();
        this.rows[1] = new ArrayList<Card>();
        this.rows[2] = new ArrayList<Card>();
        this.specialCards = new Card[3];
    }

    public User getUser() {
        return user;
    }

    public Faction getFaction() {
        return faction;
    }

    public Leader getLeader() {
        return leader;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public int[] getScores() {
        return scores;
    }

    public int getRemainingHealth() {
        return remainingHealth;
    }

    public void setRemainingHealth(int remainingHealth) {
        this.remainingHealth = remainingHealth;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }
    public void addCardToHand(Card card){
        this.hand.add(card);
        this.deck.remove(card);
    }
    public void addCardToDiscardPile(Card card , int numOfRow){
        this.discardPile.add(card);
        ArrayList cardsOfTheSpecificRow = this.rows[numOfRow];
        cardsOfTheSpecificRow.remove(card);

    }

    public ArrayList<Card> getDiscardPile() {
        return discardPile;
    }

    public ArrayList<Card>[] getRows() {
        return rows;
    }

    public Card[] getSpecialCards() {
        return specialCards;
    }

    public boolean hasPassed() {
        return hasPassed;
    }

    public void setPassed(boolean hasPassed) {
        this.hasPassed = hasPassed;
    }


}
