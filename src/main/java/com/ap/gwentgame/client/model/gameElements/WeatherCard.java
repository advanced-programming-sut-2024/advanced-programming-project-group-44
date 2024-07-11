package com.ap.gwentgame.client.model.gameElements;

import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.enums.Placement;

public class WeatherCard extends SpecialCard{
    public WeatherCard(String name, Placement placement, FactionType factionType){
        super(name, placement, factionType);
    }

    public void stopAction(){

    }
}
