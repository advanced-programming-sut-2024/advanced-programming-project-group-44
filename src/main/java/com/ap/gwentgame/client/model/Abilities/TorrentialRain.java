package com.ap.gwentgame.client.model.Abilities;

import com.ap.gwentgame.client.controller.ControllerUtilities;
import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import com.ap.gwentgame.client.model.gameElementViews.PlayerView;
import com.ap.gwentgame.client.model.gameElements.Card;

public class TorrentialRain extends Ability{
    @Override
    public void run(BoardView boardView, int index, Card card) {
        PlayerView player = boardView.getCurrentPlayer();
        PlayerView opponent = boardView.getOpponentPlayer();
        ControllerUtilities.weatherAbility(player, 2);
        ControllerUtilities.weatherAbility(opponent, 2);
    }

}
