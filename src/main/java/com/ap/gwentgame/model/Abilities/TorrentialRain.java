package com.ap.gwentgame.model.Abilities;

import com.ap.gwentgame.controller.Utilities;
import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.Game.Player;

public class TorrentialRain extends Ability {
    public TorrentialRain(Card card) {
        super(card);
    }

    @Override
    public void run(Board board) {
        Player player = board.getCurrentPlayer();
        Player opponent = board.getOpponentPlayer();
        Utilities.weatherAbility(player, 2);
        Utilities.weatherAbility(opponent, 2);
    }

    @Override
    public void stop(Board board) {
        Player player = board.getCurrentPlayer();
        Player opponent = board.getOpponentPlayer();
        Utilities.stopWeatherAbility(player , 2);
        Utilities.stopWeatherAbility(opponent , 2);
    }
}
