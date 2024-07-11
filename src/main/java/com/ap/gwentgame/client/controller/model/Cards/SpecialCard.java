package com.ap.gwentgame.client.controller.model.Cards;

import com.ap.gwentgame.client.controller.enums.FactionType;
import com.ap.gwentgame.client.controller.enums.Placement;

public class SpecialCard extends Card{
    public SpecialCard(String name, Placement placement, FactionType factionType){
        super(name, placement, factionType);
    }
}
