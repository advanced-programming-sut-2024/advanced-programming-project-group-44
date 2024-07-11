package com.ap.gwentgame.client.model.Abilities;

import com.ap.gwentgame.client.controller.ControllerUtilities;
import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import com.ap.gwentgame.client.model.gameElementViews.PlayerView;
import com.ap.gwentgame.client.model.gameElements.Card;

public class ClearWeather extends Ability{
    @Override
    public void run(BoardView boardView, int index, Card card) {
        PlayerView playerView = boardView.getCurrentPlayer();
        PlayerView opponentView = boardView.getAgainstPlayer();
        ControllerUtilities.stopWeatherAbility(playerView , 0);
        ControllerUtilities.stopWeatherAbility(opponentView , 0);
        ControllerUtilities.stopWeatherAbility(playerView , 1);
        ControllerUtilities.stopWeatherAbility(opponentView , 1);
        ControllerUtilities.stopWeatherAbility(playerView , 2);
        ControllerUtilities.stopWeatherAbility(opponentView , 2);
    }
}
