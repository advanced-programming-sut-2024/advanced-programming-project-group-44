package com.ap.gwentgame.client.controller.model.Leaders;

import com.ap.gwentgame.client.controller.enums.FactionType;
import com.ap.gwentgame.client.controller.model.Cards.Weather;
import com.ap.gwentgame.client.controller.model.Game.Board;
import com.ap.gwentgame.client.controller.model.Game.Player;
import com.ap.gwentgame.client.controller.model.ItemContainer;

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
                //player.changeContainer(board.getWeatherCards() , player.getDiscardPile() , weather);
                //player.addWeatherCardToDiscardPile(weather);
                weather.stopAction(board);
            }
        }
    }
}
