package com.ap.gwentgame.client.model.Leaders;

import com.ap.gwentgame.client.enums.FactionType;
import com.ap.gwentgame.client.model.Cards.Card;
import com.ap.gwentgame.client.model.Game.Board;
import com.ap.gwentgame.client.model.Game.Player;
import com.ap.gwentgame.client.model.ItemContainer;

public class TheSiegemaster extends Leader{
    public TheSiegemaster(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(Board board){
        Player player = board.getCurrentPlayer();
        ItemContainer<Card> deckCards = player.getDeck();
        for(Card card : deckCards.getItems()){
            if(card.getName().contains("fog")){
                card.executeAction(board);
            }
        }
    }
}
