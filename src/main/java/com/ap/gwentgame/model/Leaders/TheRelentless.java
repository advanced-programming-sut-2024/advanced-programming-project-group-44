package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.model.gameElementViews.BoardView;
import com.ap.gwentgame.model.gameElementViews.CardView;
import com.ap.gwentgame.model.gameElementViews.PlayerView;
import com.ap.gwentgame.model.gameElements.Board;
import com.ap.gwentgame.model.gameElements.Card;
import com.ap.gwentgame.model.gameElements.Leader;
import com.ap.gwentgame.view.ViewUtilities;

import java.util.ArrayList;

public class TheRelentless extends Leader {
    public TheRelentless(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(BoardView boardView, int index) {
        PlayerView opponentView = boardView.getOpponentPlayer();
        PlayerView playerView = boardView.getCurrentPlayer();
        ArrayList<CardView> discardPileCardViews = opponentView.getDiscardPileView().getCardViews();
        CardView cardDiscardPile = discardPileCardViews.get(index);
        ViewUtilities.changeCardContainer(boardView.getGamePane() ,
                opponentView.getDiscardPileView() , playerView.getHandView() , cardDiscardPile);
    }

}
