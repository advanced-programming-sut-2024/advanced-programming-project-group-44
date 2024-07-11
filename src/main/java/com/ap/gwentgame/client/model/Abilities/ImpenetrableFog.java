package com.ap.gwentgame.client.model.Abilities;

import com.ap.gwentgame.client.controller.ControllerUtilities;
import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import com.ap.gwentgame.client.model.gameElementViews.PlayerView;
import com.ap.gwentgame.client.model.gameElements.Card;

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
