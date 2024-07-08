package com.ap.gwentgame.model.Abilities;

import com.ap.gwentgame.controller.Utilities;
import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Cards.UnitCard;
import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.Game.Player;
import com.ap.gwentgame.model.ItemContainer;

public class BitingFrost extends Ability {
    public BitingFrost(Cardview card) {
        super(card);
    }

    @Override
    public void run(Boardview board) {
        Player player = board.getCurrentPlayer();
        Player opponent = board.getOpponentPlayer();
        Utilities.weatherAbility(player , 0);
        Utilities.weatherAbility(opponent , 0);
    }
    @Override
    public void stop(Boardview board) {
        Player player = board.getCurrentPlayer();
        Player opponent = board.getOpponentPlayer();
        Utilities.stopWeatherAbility(player , 0);
        Utilities.stopWeatherAbility(opponent , 0);
    }
}
