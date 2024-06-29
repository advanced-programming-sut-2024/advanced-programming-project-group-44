package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.model.Cards.Weather;
import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.Game.Player;

public class TheSteelForged extends Leader{
    public TheSteelForged(String name){
        super(name);
    }

    @Override
    public void executeAbility(Board board){
        Weather weatherCard = board.getWeatherCard();
        if(weatherCard != null){
            board.setWeatherCard(null);
            Player player = board.getCurrentPlayer();
            player.addWeatherCardToDiscardPile(weatherCard);
        }
    }
}
