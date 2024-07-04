package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.model.gameElements.Board;
import com.ap.gwentgame.model.gameElements.Player;
import com.ap.gwentgame.model.gameElements.Leader;

public class TheTreacherous extends Leader {
    public TheTreacherous(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(Board board){
        Player player = board.getCurrentPlayer();
        Player opponent = board.getOpponentPlayer();
        doubleSpyPower(player);
        doubleSpyPower(opponent);
    }
//TODO spy?
    private void doubleSpyPower(Player player) {

    }

}
