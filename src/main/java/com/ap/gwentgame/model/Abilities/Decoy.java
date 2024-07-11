package com.ap.gwentgame.model.Abilities;

import com.ap.gwentgame.controller.ControllerUtilities;
import com.ap.gwentgame.model.gameElementViews.BoardView;
import com.ap.gwentgame.model.gameElementViews.CardView;
import com.ap.gwentgame.model.gameElementViews.PlayerView;
import com.ap.gwentgame.model.gameElements.Card;
import com.ap.gwentgame.model.gameElements.Board;
import com.ap.gwentgame.view.ViewUtilities;

public class Decoy extends Ability{

    public Decoy(Card card) {
        super(card);
    }

    @Override
    public void run(BoardView boardView, int index) {
        PlayerView playerView = boardView.getCurrentPlayer();
        CardView cardView = playerView.getRowViews()[card.getPlacement().getRow()].getCardViews().get(index);
        ViewUtilities.changeCardContainer(boardView.getGamePane() , playerView.getRowViews()[card.getPlacement().getRow()], playerView.getHandView() , cardView);
    }

}
