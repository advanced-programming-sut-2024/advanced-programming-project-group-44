package com.ap.gwentgame.client.model.gameElements;

import java.io.Serializable;

public class PreGameCard extends Item implements Serializable {
    private final Card card;
    private int count;

    public PreGameCard(Card card, int count) {
        super(card.getName());
        this.card = card;
        this.count = count;
    }

    public Card getCard() {
        return card;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
