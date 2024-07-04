package com.ap.gwentgame.model.gameElements;

import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.enums.Placement;

public class SpecialCard extends Card{
    public SpecialCard(String name, Placement placement, FactionType factionType){
        super(name, placement, factionType);
    }
}
