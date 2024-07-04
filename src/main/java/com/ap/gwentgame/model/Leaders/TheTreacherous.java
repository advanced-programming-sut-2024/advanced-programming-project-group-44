package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.model.Game.GameData;
import com.ap.gwentgame.model.Game.Player;
import com.ap.gwentgame.model.Leader;

public class TheTreacherous extends Leader {
    public TheTreacherous(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(GameData gameData){
        Player player = gameData.getCurrentPlayer();
        Player opponent = gameData.getOpponentPlayer();
        doubleSpyPower(player);
        doubleSpyPower(opponent);
    }
//TODO spy?
    private void doubleSpyPower(Player player) {

    }

}
