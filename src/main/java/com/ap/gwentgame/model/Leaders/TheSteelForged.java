package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.model.Cards.Weather;
import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.Game.Player;
import com.ap.gwentgame.model.ItemContainer;

import java.util.ArrayList;

public class TheSteelForged extends Leader{
    public TheSteelForged(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(Board board){
        Player player = board.getCurrentPlayer();
        ItemContainer<Weather> weatherCards = board.getWeatherCards();
        if(weatherCards != null){
            for(Weather weather : weatherCards.getItems()){
                player.addWeatherCardToDiscardPile(weather);
                weather.stopAction(board);
            }
        }
    }
}
