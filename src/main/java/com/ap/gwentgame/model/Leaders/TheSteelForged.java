package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.model.Cards.Weather;
import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.Game.Player;

import java.util.ArrayList;

public class TheSteelForged extends Leader{
    public TheSteelForged(String name){
        super(name);
    }

    @Override
    public void executeAbility(Board board){
        Player player = board.getCurrentPlayer();
        ArrayList<Weather> weatherCards = board.getWeatherCard();
        if(weatherCards != null){
            for(Weather weather : weatherCards){
                player.addWeatherCardToDiscardPile(weather);
                weather.stopAction(board);
            }
        }
    }
}
