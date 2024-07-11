package com.ap.gwentgame.client.controller.model.Leaders;

import com.ap.gwentgame.client.controller.enums.FactionType;
import com.ap.gwentgame.client.controller.model.Game.Board;

public class DaisyOfTheValley extends Leader{
    public DaisyOfTheValley(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(Board board){
        //TODO at the beginning of the game
        //TODO implement here
    }
}
