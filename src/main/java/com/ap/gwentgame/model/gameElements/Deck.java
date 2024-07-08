package com.ap.gwentgame.model.gameElements;

import java.util.ArrayList;

public class Deck {
    private ArrayList<PreGameCard> PreGameCards;
    private Leader leader;
    private Faction faction;

    public Deck(ArrayList<PreGameCard> PreGameCards, Leader leader, Faction faction) {
        this.PreGameCards = PreGameCards;
        this.leader = leader;
        this.faction = faction;
    }
}
