package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.Game.Player;

import java.util.ArrayList;

public class DestroyerOfWorlds extends Leader{
    public DestroyerOfWorlds(String name){
        super(name);
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
