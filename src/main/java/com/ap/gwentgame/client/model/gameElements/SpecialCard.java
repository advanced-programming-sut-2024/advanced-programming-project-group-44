package com.ap.gwentgame.client.model.gameElements;

import com.ap.gwentgame.client.enums.FactionType;
import com.ap.gwentgame.client.enums.Placement;

import java.io.Serializable;

public class SpecialCard extends Card implements Serializable {
    public SpecialCard(String name, Placement placement, FactionType factionType){
        super(name, placement, factionType);
    }
}
