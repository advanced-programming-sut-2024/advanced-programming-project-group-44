package com.ap.gwentgame.model.Game;

import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.View.CardViewContainer;
import com.ap.gwentgame.model.View.PreGameCardView;
import com.ap.gwentgame.model.Faction;
import com.ap.gwentgame.model.Leader;
import com.ap.gwentgame.model.User;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {
    private final User user;
    private final Faction faction;
    private Leader leader;
    private int currentScore;
    private final int[] scores = new int[3];
    private int remainingHealth;
    private final ArrayList<Card> deck;
    private final ArrayList<Card> hand;
    private final ArrayList<Card> discardPile;
    private final ArrayList<Card>[] rows;
    private final ArrayList<Card>[] specialCards;
    private boolean hasPassed;

    public Player(User user, Faction faction, Leader leader, CardViewContainer<PreGameCardView> addedCards) {
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
        this.specialCards = new ArrayList[3];
        this.specialCards[0] = new ArrayList<Card>();
        this.specialCards[1] = new ArrayList<Card>();
        this.specialCards[2] = new ArrayList<Card>();

        for (PreGameCardView preGameCardView : addedCards.getCardViews()) {
            this.deck.add(preGameCardView.getCard());
        }
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

    public void setLeader(Leader leader) {
        this.leader = leader;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public int getRowScore(int row) {
        return scores[row];
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

    public ArrayList<Card> getDiscardPile() {
        return discardPile;
    }

    public ArrayList<Card> getRow(int row) {
        return rows[row];
    }

    public ArrayList<Card>[] getRows() {
        return rows;
    }

    public ArrayList<Card> getRowSpecialCards(int row) {
        return specialCards[row];
    }

    public ArrayList<Card>[] getSpecialCards() {
        return specialCards;
    }

    public boolean hasPassed() {
        return hasPassed;
    }

    public void setPassed(boolean hasPassed) {
        this.hasPassed = hasPassed;
    }
}
