package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.Game.Player;
import com.ap.gwentgame.model.ItemContainer;

import java.util.ArrayList;

public class TheWhiteFlame extends Leader{
    public TheWhiteFlame(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(Board board){
        Player player = board.getCurrentPlayer();
        ItemContainer<Card> deckCards = player.getDeck();
        for(Card card : deckCards.getItems()){
            if(card.getName().contains("rain")){
                card.executeAction(board);
                //TODO check the name
            }
        }
    }
}
