package com.ap.gwentgame.client.model.Leaders;

import com.ap.gwentgame.client.controller.ControllerUtilities;
import com.ap.gwentgame.client.enums.FactionType;
import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import com.ap.gwentgame.client.model.gameElementViews.PlayerView;
import com.ap.gwentgame.client.model.gameElementViews.WeatherCardView;
import com.ap.gwentgame.client.model.gameElements.Leader;
import com.ap.gwentgame.client.model.gameElements.WeatherCard;
import com.ap.gwentgame.client.view.ViewUtilities;

import java.util.ArrayList;

public class TheSteelForged extends Leader {
    public TheSteelForged(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(BoardView boardView, int index) {
        PlayerView opponentView = boardView.getAgainstPlayerView();
        PlayerView playerView = boardView.getCurrentPlayer();
        ArrayList<WeatherCardView> weatherCardViews = boardView.getWeatherCards().getCardViews();
        if(weatherCardViews != null){
            for(WeatherCardView weatherCardView : weatherCardViews){
                if(((WeatherCard)weatherCardView.getItem()).getName().toLowerCase().contains("fog")){
                    ControllerUtilities.stopWeatherAbility(playerView , 1);
                    ControllerUtilities.stopWeatherAbility(opponentView , 1);
                    weatherCardView.setItem(null);
                } else if (((WeatherCard)weatherCardView.getItem()).getName().toLowerCase().contains("rain")) {
                    ControllerUtilities.stopWeatherAbility(playerView , 2);
                    ControllerUtilities.stopWeatherAbility(opponentView , 2);
                    weatherCardView.setItem(null);
                }else if(((WeatherCard)weatherCardView.getItem()).getName().toLowerCase().contains("storm")){
                    ControllerUtilities.stopWeatherAbility(playerView , 1);
                    ControllerUtilities.stopWeatherAbility(opponentView , 1);
                    ControllerUtilities.stopWeatherAbility(playerView , 2);
                    ControllerUtilities.stopWeatherAbility(opponentView , 2);
                    weatherCardView.setItem(null);
                }else if(((WeatherCard)weatherCardView.getItem()).getName().toLowerCase().contains("frost")){
                    ControllerUtilities.stopWeatherAbility(playerView , 0);
                    ControllerUtilities.stopWeatherAbility(opponentView , 0);
                    weatherCardView.setItem(null);
                }else
                weatherCardView.setItem(null);
            }
        }
    }


}
