package com.ap.gwentgame.client.model.Leaders;

import com.ap.gwentgame.client.enums.FactionType;
import com.ap.gwentgame.client.model.gameElements.Board;
import com.ap.gwentgame.client.model.gameElements.Player;
import com.ap.gwentgame.client.model.gameElements.Leader;

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
