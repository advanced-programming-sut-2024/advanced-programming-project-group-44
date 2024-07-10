package com.ap.gwentgame.client.model.gameElements;

import com.ap.gwentgame.client.enums.FactionType;
import com.ap.gwentgame.client.enums.Placement;

import java.io.Serializable;

public class WeatherCard extends SpecialCard implements Serializable {
    public WeatherCard(String name, Placement placement, FactionType factionType){
        super(name, placement, factionType);
    }
}
