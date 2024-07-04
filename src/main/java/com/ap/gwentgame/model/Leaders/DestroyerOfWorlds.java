package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.model.Game.GameData;
import com.ap.gwentgame.model.Leader;

public class DestroyerOfWorlds extends Leader {
    public DestroyerOfWorlds(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(GameData gameData){

    }
}
