package com.ap.gwentgame.model.Abilities;

import com.ap.gwentgame.controller.ControllerUtilities;
import com.ap.gwentgame.model.gameElementViews.BoardView;
import com.ap.gwentgame.model.gameElementViews.PlayerView;
import com.ap.gwentgame.model.gameElements.Card;
import com.ap.gwentgame.model.gameElements.Board;

public class ImpenetrableFog extends Ability{
    public ImpenetrableFog(Card card) {
        super(card);
    }

    @Override
    public void run(BoardView boardView, int index) {
        PlayerView playerView = boardView.getCurrentPlayer();
        PlayerView opponentView = boardView.getOpponentPlayer();
        ControllerUtilities.weatherAbility(playerView , 1);
        ControllerUtilities.weatherAbility(opponentView , 1);
    }

}
