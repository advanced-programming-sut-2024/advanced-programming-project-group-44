package com.ap.gwentgame.model.Abilities;

import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Cards.Weather;
import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.ItemContainer;

public class ClearWeather extends Ability{
    public ClearWeather(Card card) {
        super(card);
    }

    @Override
    public void run(Board board) {
        ItemContainer<Weather> weatherCards = board.getWeatherCards();
        for(Weather card : weatherCards.getItems()){
            card.stopAction(board);
            weatherCards.remove(card);
        }
    }
    @Override
    public void stop(Board board) {
    }
}
