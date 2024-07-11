package com.ap.gwentgame.client.controller.model.Abilities;

import com.ap.gwentgame.client.controller.Utilities;
import com.ap.gwentgame.client.controller.model.Cards.Card;
import com.ap.gwentgame.client.controller.model.Game.Board;
import com.ap.gwentgame.client.controller.model.Game.Player;

public class ImpenetrableFog extends Ability{
    public ImpenetrableFog(Card card) {
        super(card);
    }

    @Override
    public void run(Board board) {
        Player player = board.getCurrentPlayer();
        Player opponent = board.getOpponentPlayer();
        Utilities.weatherAbility(player , 1);
        Utilities.weatherAbility(opponent , 1);
    }
    @Override
    public void stop(Board board) {
        Player player = board.getCurrentPlayer();
        Player opponent = board.getOpponentPlayer();
        Utilities.stopWeatherAbility(player , 1);
        Utilities.stopWeatherAbility(opponent , 1);
    }
}
