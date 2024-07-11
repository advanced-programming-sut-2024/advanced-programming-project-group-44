package com.ap.gwentgame.client.model.gameElements;

import com.ap.gwentgame.client.enums.FactionType;
import com.ap.gwentgame.client.enums.Placement;

public class SpecialCard extends Card{
    public SpecialCard(String name, Placement placement, FactionType factionType){
        super(name, placement, factionType);
    }
}
