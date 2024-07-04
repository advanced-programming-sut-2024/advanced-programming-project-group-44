package com.ap.gwentgame.model;

import com.ap.gwentgame.model.View.CardViewContainer;
import com.ap.gwentgame.model.View.PreGameCardView;

public class Faction extends Item {
    protected final CardViewContainer<Leader> leaders;
    protected final CardViewContainer<PreGameCardView> cards;

    public Faction(String name) {
        super(name);
        leaders = new CardViewContainer<>();
        cards = new CardViewContainer<>();
    }

    public CardViewContainer<Leader> getLeaders() {
        return leaders;
    }

    public CardViewContainer<PreGameCardView> getCards() {
        return cards;
    }
}
