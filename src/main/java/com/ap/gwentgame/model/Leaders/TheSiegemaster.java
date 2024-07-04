package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.model.Game.GameData;
import com.ap.gwentgame.model.Leader;

public class TheSiegemaster extends Leader {
    public TheSiegemaster(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(GameData gameData){

    }
}
