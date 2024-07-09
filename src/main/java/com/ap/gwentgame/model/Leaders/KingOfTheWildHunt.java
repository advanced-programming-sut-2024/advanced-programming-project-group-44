package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.model.gameElementViews.BoardView;
import com.ap.gwentgame.model.gameElementViews.CardView;
import com.ap.gwentgame.model.gameElementViews.PlayerView;
import com.ap.gwentgame.model.gameElements.Board;
import com.ap.gwentgame.model.gameElements.Leader;

import java.util.ArrayList;

public class KingOfTheWildHunt extends Leader {
    public KingOfTheWildHunt(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(BoardView boardView, int index) {

        PlayerView player = boardView.getCurrentPlayer();
        ArrayList<CardView> discardPileCards = player.getDiscardPileView().getCardViews();
        /*TODO choose the card and the rest , card not hero
        Player player = board.getCurrentPlayer();
        Card choosenCard = chosencard???
        player.addCardToHandFromDiscardPile(card);*/
    }

}
