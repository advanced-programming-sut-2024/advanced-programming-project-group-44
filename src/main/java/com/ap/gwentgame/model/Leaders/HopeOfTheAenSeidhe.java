package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.Game.Player;

import java.util.ArrayList;

public class HopeOfTheAenSeidhe extends Leader{
    public HopeOfTheAenSeidhe(String name){
        super(name);
    }

    @Override
    public void executeAbility(Board board){
        Player player = board.getCurrentPlayer();
        ArrayList<Card> agileCards = player.getRows()[0];
        agileCards.addAll(player.getRows()[1]);
        //TODO hmmm?
    }
}
