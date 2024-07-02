package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.controller.Utilities;
import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Cards.UnitCard;
import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.Game.Player;

public class QueenOfDolBlathanna extends Leader{
    public QueenOfDolBlathanna(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(Board board){

    }
}
