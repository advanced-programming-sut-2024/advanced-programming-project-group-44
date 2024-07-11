package com.ap.gwentgame.client.controller.model.Leaders;

import com.ap.gwentgame.client.controller.enums.FactionType;
import com.ap.gwentgame.client.controller.model.Cards.Card;
import com.ap.gwentgame.client.controller.model.Game.Board;
import com.ap.gwentgame.client.controller.model.Game.Player;
import com.ap.gwentgame.client.controller.model.ItemContainer;

public class KingOfTheWildHunt extends Leader{
    public KingOfTheWildHunt(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(Board board){
        Player player = board.getCurrentPlayer();
        ItemContainer<Card> discardPileCards = player.getDiscardPile();
        /*TODO choose the card and the rest , card not hero
        Player player = board.getCurrentPlayer();
        Card choosenCard = chosencard???
        player.addCardToHandFromDiscardPile(card);*/
    }
}
