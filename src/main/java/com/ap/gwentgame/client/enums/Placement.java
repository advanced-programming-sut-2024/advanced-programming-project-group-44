package com.ap.gwentgame.client.enums;



public enum Placement {
    CLOSE_COMBAT,
    RANGED_COMBAT,
    SIEGE,
    AGILE,
    WEATHER,
    SPECIAL_PLACE,
    DECOY;

    private int row;

    public void setRow(int row) {
        this.row = row;
    }

    public int getRow() {
        return this.row;
    }
}
