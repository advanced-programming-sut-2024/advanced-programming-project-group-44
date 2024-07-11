package com.ap.gwentgame.client.model.Abilities;

import com.ap.gwentgame.client.controller.Utilities;
import com.ap.gwentgame.client.model.Cards.Card;
import com.ap.gwentgame.client.model.Game.Board;
import com.ap.gwentgame.client.model.Game.Player;

public class SkelligeStorm extends Ability{
    public SkelligeStorm(Card card) {
        super(card);
    }

    @Override
    public void run(Board board) {
        Player player = board.getCurrentPlayer();
        Player opponent = board.getOpponentPlayer();
        Utilities.weatherAbility(player , 1);
        Utilities.weatherAbility(opponent , 1);
        Utilities.weatherAbility(player , 2);
        Utilities.weatherAbility(opponent , 2);
    }

    @Override
    public void stop(Board board) {
        Player player = board.getCurrentPlayer();
        Player opponent = board.getOpponentPlayer();
        Utilities.stopWeatherAbility(player , 1);
        Utilities.stopWeatherAbility(opponent , 1);
        Utilities.stopWeatherAbility(player , 2);
        Utilities.stopWeatherAbility(opponent , 2);
    }
}
