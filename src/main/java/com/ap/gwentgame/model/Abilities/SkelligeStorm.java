package com.ap.gwentgame.model.Abilities;

import com.ap.gwentgame.controller.ControllerUtilities;
import com.ap.gwentgame.model.gameElementViews.BoardView;
import com.ap.gwentgame.model.gameElementViews.PlayerView;
import com.ap.gwentgame.model.gameElements.Card;
import com.ap.gwentgame.model.gameElements.Board;

public class SkelligeStorm extends Ability{
    public SkelligeStorm(Card card) {
        super(card);
    }

    @Override
    public void run(BoardView boardView, int index) {
        PlayerView playerView = boardView.getCurrentPlayer();
        PlayerView opponentView = boardView.getOpponentPlayer();
        ControllerUtilities.weatherAbility(playerView , 1);
        ControllerUtilities.weatherAbility(opponentView , 1);
        ControllerUtilities.weatherAbility(playerView , 2);
        ControllerUtilities.weatherAbility(opponentView , 2);
    }
//TODO stop
}
