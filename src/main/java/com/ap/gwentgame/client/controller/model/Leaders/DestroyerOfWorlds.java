package com.ap.gwentgame.client.controller.model.Leaders;

import com.ap.gwentgame.client.controller.enums.FactionType;
import com.ap.gwentgame.client.controller.model.Game.Board;
import com.ap.gwentgame.client.controller.model.Game.Player;

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
