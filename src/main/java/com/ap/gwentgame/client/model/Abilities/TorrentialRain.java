package com.ap.gwentgame.client.model.Abilities;

import com.ap.gwentgame.controller.ControllerUtilities;
import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import com.ap.gwentgame.client.model.gameElementViews.PlayerView;
import com.ap.gwentgame.client.model.gameElements.Card;
import com.ap.gwentgame.client.model.gameElements.Board;
import com.ap.gwentgame.view.ViewUtilities;

public class TorrentialRain extends Ability{
    public TorrentialRain(Card card) {
        super(card);
    }

    @Override
    public void run(BoardView boardView, int index) {
        PlayerView player = boardView.getCurrentPlayer();
        PlayerView opponent = boardView.getOpponentPlayer();
        ControllerUtilities.weatherAbility(player, 2);
        ControllerUtilities.weatherAbility(opponent, 2);
    }

}
