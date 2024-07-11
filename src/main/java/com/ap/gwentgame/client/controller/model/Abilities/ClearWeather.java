package com.ap.gwentgame.client.controller.model.Abilities;

import com.ap.gwentgame.client.controller.model.Cards.Card;
import com.ap.gwentgame.client.controller.model.Cards.Weather;
import com.ap.gwentgame.client.controller.model.Game.Board;
import com.ap.gwentgame.client.controller.model.ItemContainer;

public class ClearWeather extends Ability{
    public ClearWeather(Card card) {
        super(card);
    }

    @Override
    public void run(Board board) {
//        ItemContainer<Weather> weatherCards = board.getWeatherCards();
//        for(Weatherview card : weatherCards.getItems()){
//            card.stopAction(board);
//            weatherCards.remove(card);
//        }
    }
    @Override
    public void stop(Board board) {
    }
}
