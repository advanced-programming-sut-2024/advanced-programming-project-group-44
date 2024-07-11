package com.ap.gwentgame.client.model.Abilities;

import com.ap.gwentgame.client.controller.ControllerUtilities;
import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import com.ap.gwentgame.client.model.gameElementViews.CardView;
import com.ap.gwentgame.client.model.gameElementViews.PlayerView;

public class TorrentialRain extends Ability{
    @Override
    public void run(BoardView boardView, int index, CardView cardView) {
        PlayerView player = boardView.getCurrentPlayer();
        PlayerView opponent = boardView.getOpponentPlayer();
        ControllerUtilities.weatherAbility(player, 2);
        ControllerUtilities.weatherAbility(opponent, 2);
    }

}
