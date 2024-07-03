package com.ap.gwentgame.model.Game;

import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Cards.PreGameCard;
import com.ap.gwentgame.model.Factions.Faction;
import com.ap.gwentgame.model.ItemContainer;
import com.ap.gwentgame.model.Leaders.Leader;
import com.ap.gwentgame.model.User;

public class Player {
    private final User user;
    private final Faction faction;
    private Leader leader;
    private int currentScore;
    private final int[] scores = new int[3];
    private int remainingHealth;
    private final ItemContainer<Card> deck;
    private final ItemContainer<Card> hand;
    private final ItemContainer<Card> discardPile;
    private final ItemContainer<Card>[] rows;
    private final Card[] specialCards;
    private boolean hasPassed;

    public Player(User user, Faction faction, Leader leader, ItemContainer<PreGameCard> addedCards) {
        this.user = user;
        this.faction = faction;
        this.leader = leader;
        this.currentScore = 0;
        this.remainingHealth = 2;
        this.deck = new ItemContainer<Card>();
        this.hand = new ItemContainer<Card>();
        this.discardPile = new ItemContainer<Card>();
        this.rows = new ItemContainer[3];
        this.rows[0] = new ItemContainer<Card>();
        this.rows[1] = new ItemContainer<Card>();
        this.rows[2] = new ItemContainer<Card>();
        this.specialCards = new Card[3];

        for (PreGameCard preGameCard : addedCards.getItems()) {
            this.deck.add(preGameCard.getCard());
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

    public int[] getScores() {
        return scores;
    }

    public int getRemainingHealth() {
        return remainingHealth;
    }

    public void setRemainingHealth(int remainingHealth) {
        this.remainingHealth = remainingHealth;
    }

    public ItemContainer getDeck() {
        return deck;
    }

    public ItemContainer<Card> getHand() {
        return hand;
    }


    public void addCardToHandFromDeck(Card card) {
        this.hand.add(card);
        this.deck.remove(card);
    }


    public void addCardToHandFromDiscardPile(Card card) {
        this.hand.add(card);
        this.discardPile.remove(card);
    }


    public void addCardToDeckFromDiscardPile(Card card) {
        this.deck.add(card);
        this.discardPile.remove(card);
    }


    public void addCardToDiscardPile(Card card, int numOfRow) {
        this.discardPile.add(card);
        ItemContainer<Card> cardsOfTheSpecificRow = this.rows[numOfRow];
        cardsOfTheSpecificRow.remove(card);
    }


    public void addCardToDiscardPileFromHand(Card card) {
        this.discardPile.add(card);
        this.hand.remove(card);
    }


    public void addWeatherCardToDiscardPile(Card card) {
        this.discardPile.add(card);
    }

    public ItemContainer<Card> getDiscardPile() {
        return discardPile;
    }

    public ItemContainer<Card>[] getRows() {
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
