package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.Game.Player;

import java.util.ArrayList;

public class PureBloodElf extends Leader{
    public PureBloodElf(String name) {
        super(name);
    }

    @Override
    public void executeAbility(Board board){
        Player player = board.getCurrentPlayer();
        ArrayList<Card> deckCards = player.getDeck();
        for(Card card : deckCards){
            if(card.getName().contains("frost")){
                card.executeAction(board);
                //TODO choose card
            }
        }
    }
}
