package com.ap.gwentgame.client.controller.model.Leaders;

import com.ap.gwentgame.client.controller.enums.FactionType;
import com.ap.gwentgame.client.controller.model.Cards.Card;
import com.ap.gwentgame.client.controller.model.Game.Board;
import com.ap.gwentgame.client.controller.model.Game.Player;
import com.ap.gwentgame.client.controller.model.ItemContainer;

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
