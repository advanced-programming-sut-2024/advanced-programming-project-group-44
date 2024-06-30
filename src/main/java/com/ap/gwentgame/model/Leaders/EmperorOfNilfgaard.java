package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.Game.Player;

public class EmperorOfNilfgaard extends Leader{
    public EmperorOfNilfgaard(String name){
        super(name);
    }

    @Override
    public void executeAbility(Board board){
        Player opponent = board.getOpponentPlayer();
        opponent.setLeader(null);
    }
}
