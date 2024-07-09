package com.ap.gwentgame.client.model.Leaders;

import com.ap.gwentgame.client.enums.FactionType;
import com.ap.gwentgame.client.model.gameElements.Board;
import com.ap.gwentgame.client.model.gameElements.Leader;

public class TheWhiteFlame extends Leader {
    public TheWhiteFlame(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(Board board){
    }
}
