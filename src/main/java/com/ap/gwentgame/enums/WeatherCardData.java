package com.ap.gwentgame.enums;

import com.ap.gwentgame.model.Cards.Weather;

public enum WeatherCardData {
    ;

    private final String name;
    private final FactionType factionType;
    private final AbilityType abilityType;
    private final int maxCount;

    WeatherCardData(String name, FactionType factionType, AbilityType abilityType, int maxCount) {
        this.name = name;
        this.factionType = factionType;
        this.abilityType = abilityType;
        this.maxCount = maxCount;
    }

    public Weather getWeatherCard() {
        Weather weather = new Weather(name, Placement.SPECIAL_PLACE, factionType);
        weather.setAbility(abilityType.getAbility(weather));
        return weather;
    }

    public int getMaxCount() {
        return maxCount;
    }
}
