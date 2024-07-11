package com.ap.gwentgame.client.model.Leaders;

import com.ap.gwentgame.client.enums.FactionType;
import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import com.ap.gwentgame.client.model.gameElementViews.CardView;
import com.ap.gwentgame.client.model.gameElementViews.PlayerView;
import com.ap.gwentgame.client.model.gameElements.Leader;
import com.ap.gwentgame.client.view.ViewUtilities;

import java.util.ArrayList;

public class TheRelentless extends Leader {
    public TheRelentless(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(BoardView boardView, int index) {
        PlayerView opponentView = boardView.getAgainstPlayerView();
        PlayerView playerView = boardView.getCurrentPlayer();
        ArrayList<CardView> discardPileCardViews = opponentView.getDiscardPileView().getCardViews();
        CardView cardDiscardPile = discardPileCardViews.get(index);
        ViewUtilities.changeCardContainer(false , boardView ,
                opponentView.getDiscardPileView() , playerView.getHandView() , cardDiscardPile);
    }

}
