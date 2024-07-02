package com.ap.gwentgame.model.Factions;

import com.ap.gwentgame.model.ItemContainer;
import com.ap.gwentgame.model.Cards.Item;
import com.ap.gwentgame.model.Cards.PreGameCard;
import com.ap.gwentgame.model.Leaders.Leader;

public class Faction extends Item {
    protected final ItemContainer<Leader> leaders;
    protected final ItemContainer<PreGameCard> cards;

    public Faction(String name) {
        super(name);
        leaders = new ItemContainer<>();
        cards = new ItemContainer<>();
    }

    public ItemContainer<Leader> getLeaders() {
        return leaders;
    }

    public ItemContainer<PreGameCard> getCards() {
        return cards;
    }
}
