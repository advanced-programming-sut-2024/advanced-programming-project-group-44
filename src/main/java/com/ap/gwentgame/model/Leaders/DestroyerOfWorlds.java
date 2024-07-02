package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.Game.Player;

public class DestroyerOfWorlds extends Leader{
    public DestroyerOfWorlds(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(Board board){
        Player player = board.getCurrentPlayer();
        /*TODO choose the cards
        Card firstChoosenCard = .... notHero
        Card secondChoosenCard = ... notHero
        player.addCardToDiscardPileFromHand(firstChoosenCard);
        player.addCardToDiscardPileFromHand(secondChoosenCard);
        Card chosenCardFromDeck = ....; notHero
        player.addCardToHandFromDeck(chosenCardFromDeck);
        */

    }
}
