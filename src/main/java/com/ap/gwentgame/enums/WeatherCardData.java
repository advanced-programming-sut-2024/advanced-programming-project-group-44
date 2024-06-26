package com.ap.gwentgame.enums;

public enum WeatherCardData {
    RAIN(3), FOG(2), BITING_FROST(1);
    private final int targetRow;
    WeatherCardData(int targetRow){
        this.targetRow = targetRow;
    }

    public int getTargetRow() {
        return targetRow;
    }
}
