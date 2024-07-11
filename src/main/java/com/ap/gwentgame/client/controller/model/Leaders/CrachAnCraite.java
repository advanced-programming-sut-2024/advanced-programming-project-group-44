package com.ap.gwentgame.client.controller.model.Leaders;

import com.ap.gwentgame.client.controller.enums.FactionType;
import com.ap.gwentgame.client.controller.model.Cards.Card;
import com.ap.gwentgame.client.controller.model.Cards.UnitCard;
import com.ap.gwentgame.client.controller.model.Game.Board;
import com.ap.gwentgame.client.controller.model.Game.Player;
import com.ap.gwentgame.client.controller.model.ItemContainer;

public class CrachAnCraite extends Leader {
    public CrachAnCraite(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(Board board) {
        //TODO bor zadan?
        Player player = board.getCurrentPlayer();
        ItemContainer<Card> discardPileCards = player.getDiscardPile();
        for (Card card : discardPileCards.getItems()) {
            if (card instanceof UnitCard) {
                if (!((UnitCard) card).isHero()) {
                    player.changeContainer(player.getDiscardPile() , player.getDeck() , card);
                    //player.addCardToDeckFromDiscardPile(card);
                }
            }player.changeContainer(player.getDiscardPile() , player.getDeck() , card);
            //player.addCardToDeckFromDiscardPile(card);
        }
    }
}
