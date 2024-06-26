package com.ap.gwentgame.model.Factions;

import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Cards.Item;
import com.ap.gwentgame.model.Leaders.Leader;


import java.util.ArrayList;
import java.util.HashMap;

public class Faction extends Item {
    protected final ArrayList<Leader> leaders;
    protected final HashMap<Card, Integer> cards;
    public Faction(String name) {
        super(name);
        this.leaders = new ArrayList<Leader>();
        this.cards = new HashMap<Card, Integer>();
    }

    public ArrayList<Leader> getLeaders() {
        return leaders;
    }

    public HashMap<Card, Integer> getCards() {
        return cards;
    }
}
