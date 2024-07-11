package com.ap.gwentgame.client.controller.model.Leaders;

import com.ap.gwentgame.client.controller.enums.FactionType;
import com.ap.gwentgame.client.controller.model.Cards.Card;
import com.ap.gwentgame.client.controller.model.Game.Board;
import com.ap.gwentgame.client.controller.model.Game.Player;
import com.ap.gwentgame.client.controller.model.ItemContainer;

public class TheRelentless extends Leader{
    public TheRelentless(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(Board board){
        Player opponent = board.getOpponentPlayer();
        ItemContainer<Card> discardPileCards = opponent.getDiscardPile();
        /*TODO the rest show them to player
        Player player = board.getCurrentPlayer();
        Card choosenCard = chosencard???
        player.getHand().add(choosenCard);
        opponent.getDeck().remove(choosenCard);
         */
    }
}
