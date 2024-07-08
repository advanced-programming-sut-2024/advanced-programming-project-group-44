package com.ap.gwentgame.model.gameElements;

public class PreGameCard extends Item{
    private final Card card;
    private int count;

    public PreGameCard(String name, Card card, int count) {
        super(name);
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
