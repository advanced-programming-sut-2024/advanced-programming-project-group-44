package com.ap.gwentgame.client.controller.model.Abilities;

import com.ap.gwentgame.client.controller.Utilities;
import com.ap.gwentgame.client.controller.model.Cards.Card;
import com.ap.gwentgame.client.controller.model.Cards.UnitCard;
import com.ap.gwentgame.client.controller.model.Game.Board;
import com.ap.gwentgame.client.controller.model.Game.Player;
import com.ap.gwentgame.client.controller.model.ItemContainer;

public class BitingFrost extends Ability {
    @Override
    public void run(Board board) {

    }

    @Override
    public void stop(Board board) {

    }
    public BitingFrost(Card card) {
        super(card);
    }

//    @Override
//    public void run(Boardview board) {
//        Player player = board.getCurrentPlayer();
//        Player opponent = board.getOpponentPlayer();
//        Utilities.weatherAbility(player , 0);
//        Utilities.weatherAbility(opponent , 0);
//    }
//    @Override
//    public void stop(Boardview board) {
//        Player player = board.getCurrentPlayer();
//        Player opponent = board.getOpponentPlayer();
//        Utilities.stopWeatherAbility(player , 0);
//        Utilities.stopWeatherAbility(opponent , 0);
//    }
}
