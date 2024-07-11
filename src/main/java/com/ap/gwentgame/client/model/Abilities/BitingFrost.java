package com.ap.gwentgame.client.model.Abilities;

import com.ap.gwentgame.client.controller.ControllerUtilities;
import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import com.ap.gwentgame.client.model.gameElementViews.PlayerView;
import com.ap.gwentgame.client.model.gameElements.Card;

public class BitingFrost extends Ability{
    public BitingFrost(Card card) {
        super(card);
    }

    @Override
    public void run(BoardView boardView, int index) {
        PlayerView playerView = boardView.getCurrentPlayer();
        PlayerView opponentView = boardView.getOpponentPlayer();
        ControllerUtilities.weatherAbility(playerView , 0);
        ControllerUtilities.weatherAbility(opponentView , 0);
    }
}
