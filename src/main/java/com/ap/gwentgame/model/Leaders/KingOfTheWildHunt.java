package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.model.gameElementViews.BoardView;
import com.ap.gwentgame.model.gameElementViews.CardView;
import com.ap.gwentgame.model.gameElementViews.PlayerView;
import com.ap.gwentgame.model.gameElements.Board;
import com.ap.gwentgame.model.gameElements.Leader;
import com.ap.gwentgame.view.ViewUtilities;

import java.util.ArrayList;

public class KingOfTheWildHunt extends Leader {
    public KingOfTheWildHunt(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(BoardView boardView, int index) {

        PlayerView player = boardView.getCurrentPlayer();
        ArrayList<CardView> discardPileCards = player.getDiscardPileView().getCardViews();
        CardView chosenCardView = discardPileCards.get(index);
        ViewUtilities.changeCardContainer(boardView.getGamePane() , player.getDiscardPileView()
                , player.getHandView() , chosenCardView);
    }

}
