package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.model.gameElementViews.BoardView;
import com.ap.gwentgame.model.gameElementViews.CardView;
import com.ap.gwentgame.model.gameElementViews.PlayerView;
import com.ap.gwentgame.model.gameElements.Board;
import com.ap.gwentgame.model.gameElements.Leader;

import java.util.ArrayList;

public class TheRelentless extends Leader {
    public TheRelentless(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(BoardView boardView, int index) {
        PlayerView opponentView = boardView.getOpponentPlayer();
        ArrayList<CardView> discardPileCardViews = opponentView.getDiscardPileView().getCardViews();
        /*TODO the rest show them to player
        Player player = board.getCurrentPlayer();
        Card choosenCard = chosencard???
        player.getHand().add(choosenCard);
        opponent.getDeck().remove(choosenCard);
         */
    }

}
