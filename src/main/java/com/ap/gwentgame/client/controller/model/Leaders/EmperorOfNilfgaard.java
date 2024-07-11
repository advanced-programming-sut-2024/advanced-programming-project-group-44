package com.ap.gwentgame.client.controller.model.Leaders;

import com.ap.gwentgame.client.controller.enums.FactionType;
import com.ap.gwentgame.client.controller.model.Game.Board;
import com.ap.gwentgame.client.controller.model.Game.Player;

public class EmperorOfNilfgaard extends Leader{
    public EmperorOfNilfgaard(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(Board board){
        Player opponent = board.getOpponentPlayer();
        opponent.setLeader(null);
    }
}
