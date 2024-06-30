package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.Game.Player;

import java.util.ArrayList;

public class TheWhiteFlame extends Leader{
    public TheWhiteFlame(String name){
        super(name);
    }

    @Override
    public void executeAbility(Board board){
        Player player = board.getCurrentPlayer();
        ArrayList<Card> deckCards = player.getDeck();
        for(Card card : deckCards){
            if(card.getName().contains("rain")){
                card.executeAction(board);
                //TODO check the name
            }
        }
    }
}
