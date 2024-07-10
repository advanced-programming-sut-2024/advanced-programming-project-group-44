package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.model.gameElementViews.BoardView;
import com.ap.gwentgame.model.gameElementViews.PlayerView;
import com.ap.gwentgame.model.gameElementViews.WeatherCardView;
import com.ap.gwentgame.model.gameElements.Board;
import com.ap.gwentgame.model.gameElements.Leader;

import java.util.ArrayList;

public class TheSteelForged extends Leader {
    public TheSteelForged(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(BoardView boardView, int index) {
        PlayerView playerView = boardView.getCurrentPlayer();
        ArrayList<WeatherCardView> weatherCardViews = boardView.getWeatherCards().getCardViews();
        if(weatherCardViews != null){
            for(WeatherCardView weatherCardView : weatherCardViews){
                weatherCardView.stopAction(boardView);
            }
        }
    }


}
