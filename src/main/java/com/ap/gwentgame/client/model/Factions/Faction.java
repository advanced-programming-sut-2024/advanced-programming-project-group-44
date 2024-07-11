package com.ap.gwentgame.client.model.Factions;

import com.ap.gwentgame.client.model.ItemContainer;
import com.ap.gwentgame.client.model.Cards.Item;
import com.ap.gwentgame.client.model.Cards.PreGameCard;
import com.ap.gwentgame.client.model.Leaders.Leader;
import javafx.scene.Node;

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
