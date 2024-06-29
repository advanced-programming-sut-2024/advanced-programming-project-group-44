package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.Game.Player;

import java.util.ArrayList;

public class KingOfTheWildHunt extends Leader{
    public KingOfTheWildHunt(String name){
        super(name);
    }

    @Override
    public void executeAbility(Board board){
        Player player = board.getCurrentPlayer();
        ArrayList<Card> discardPileCards = player.getDiscardPile();
        //TODO choose the card and the rest
    }
}
