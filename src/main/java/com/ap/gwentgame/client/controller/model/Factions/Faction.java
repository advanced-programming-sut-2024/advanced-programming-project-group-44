package com.ap.gwentgame.client.controller.model.Factions;

import com.ap.gwentgame.client.controller.model.ItemContainer;
import com.ap.gwentgame.client.controller.model.Cards.Item;
import com.ap.gwentgame.client.controller.model.Cards.PreGameCard;
import com.ap.gwentgame.client.controller.model.Leaders.Leader;
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
