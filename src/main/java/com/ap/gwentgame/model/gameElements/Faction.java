package com.ap.gwentgame.model.gameElements;

import com.ap.gwentgame.model.gameElementViews.CardViewContainer;
import com.ap.gwentgame.model.gameElementViews.PreGameCardView;

import java.util.ArrayList;

public class Faction extends Item {
    protected final ArrayList<Leader> leaders;
    protected final CardViewContainer<PreGameCardView, Card> cards;

    public Faction(String name) {
        super(name);
        leaders = new ArrayList<>();
        cards = new CardViewContainer<>();
    }

    public ArrayList<Leader> getLeaders() {
        return leaders;
    }

    public CardViewContainer<PreGameCardView, Card> getCards() {
        return cards;
    }
}
