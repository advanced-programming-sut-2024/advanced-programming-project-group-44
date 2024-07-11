package com.ap.gwentgame.client.model.Leaders;

import com.ap.gwentgame.client.enums.FactionType;
import com.ap.gwentgame.client.model.Cards.Card;
import com.ap.gwentgame.client.model.Game.Board;
import com.ap.gwentgame.client.model.Game.Player;
import com.ap.gwentgame.client.model.ItemContainer;

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
