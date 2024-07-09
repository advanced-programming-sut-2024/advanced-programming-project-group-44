package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.model.gameElementViews.BoardView;
import com.ap.gwentgame.model.gameElementViews.PlayerView;
import com.ap.gwentgame.model.gameElements.Board;
import com.ap.gwentgame.model.gameElements.Leader;

public class DestroyerOfWorlds extends Leader {
    public DestroyerOfWorlds(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(BoardView boardView, int index) {
        PlayerView playerView = boardView.getCurrentPlayer();
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
