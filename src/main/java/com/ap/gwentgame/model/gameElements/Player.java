package com.ap.gwentgame.model.gameElements;

import com.ap.gwentgame.model.gameElementViews.CardViewContainer;
import com.ap.gwentgame.model.gameElementViews.PreGameCardView;
import com.ap.gwentgame.model.User;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {
    private final User user;
    private final Faction faction;
    private final Leader leader;
    private int remainingHealth;
    private final ArrayList<Card> deck;
    private final ArrayList<Card> hand;
    private final ArrayList<Card> discardPile;
    private final ArrayList<Card>[] rows;
    private final ArrayList<Card>[] specialCards;
    private boolean hasPassed;

    public Player(User user, Faction faction, Leader leader, CardViewContainer<PreGameCardView, Card> addedCards) {
        this.user = user;
        this.faction = faction;
        this.leader = leader;
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
            this.hand.add((Card) preGameCardView.getItem());
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

    public int getCurrentScore() {
        return getRowScore(0) + getRowScore(1) + getRowScore(2);
    }

    public int getRowScore(int row) {
        int score = 0;
        for (Card card : rows[row]) {
            if (card instanceof UnitCard unitCard){
                score += unitCard.getScore();
            }
        }
        return score;
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

    public ArrayList<Card>[] getRows() {
        return rows;
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
