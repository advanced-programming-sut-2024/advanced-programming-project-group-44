package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.Game.Player;
import com.ap.gwentgame.model.ItemContainer;

import java.util.ArrayList;

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
