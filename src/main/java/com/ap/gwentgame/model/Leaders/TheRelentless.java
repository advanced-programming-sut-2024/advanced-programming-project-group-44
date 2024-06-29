package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.Game.Player;

import java.util.ArrayList;

public class TheRelentless extends Leader{
    public TheRelentless(String name){
        super(name);
    }

    @Override
    public void executeAbility(Board board){
        Player opponent = board.getOpponentPlayer();
        ArrayList<Card> discardPileCards = opponent.getDiscardPile();
        //TODO the rest
    }
}
