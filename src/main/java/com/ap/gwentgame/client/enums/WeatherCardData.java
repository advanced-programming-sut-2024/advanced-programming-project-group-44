package com.ap.gwentgame.client.enums;

import com.ap.gwentgame.client.model.gameElements.WeatherCard;

public enum WeatherCardData {
    BITING_FROST("Biting Frost", FactionType.NEUTRAL, AbilityType.BITINGFROST, 1),
    IMPENETRABLE_FOG("Impenetrable Fog", FactionType.NEUTRAL, AbilityType.IMPENETRABLEFOG, 1),
    TORRENTIAL_RAIN("Torrential Rain", FactionType.NEUTRAL, AbilityType.TORRENTIALRAIN, 1),
    CLEAR_WEATHER("Clear Weather", FactionType.NEUTRAL, AbilityType.CLEARWEATHER, 1),
    SKELLIGE_STORM("Skellige Storm", FactionType.SKELLIGE, AbilityType.SKELLIGESTORM, 1);

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

    public WeatherCard getWeatherCard() {
        WeatherCard weatherCard = new WeatherCard(name, Placement.SPECIAL_PLACE, factionType);
        weatherCard.setAbility(abilityType.getAbility(weatherCard));
        return weatherCard;
    }

    public int getMaxCount() {
        return maxCount;
    }
}
