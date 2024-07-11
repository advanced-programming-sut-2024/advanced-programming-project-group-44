package com.ap.gwentgame.client.model.Leaders;

import com.ap.gwentgame.client.enums.FactionType;
import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import com.ap.gwentgame.client.model.gameElements.Leader;

public class DaisyOfTheValley extends Leader {
    public DaisyOfTheValley(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(BoardView boardView, int index) {
        //TODO at the beginning of the game
        //TODO implement here
    }

}
