package com.ap.gwentgame.client.model.Leaders;

import com.ap.gwentgame.client.enums.FactionType;
import com.ap.gwentgame.client.model.Cards.Weather;
import com.ap.gwentgame.client.model.Game.Board;
import com.ap.gwentgame.client.model.Game.Player;
import com.ap.gwentgame.client.model.ItemContainer;

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
