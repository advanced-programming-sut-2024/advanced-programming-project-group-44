package com.ap.gwentgame.model.Cards;

import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.enums.Placement;

public class SpecialCard extends Card{
    public SpecialCard(String name, Placement placement, FactionType factionType){
        super(name, placement, factionType);
    }
}
