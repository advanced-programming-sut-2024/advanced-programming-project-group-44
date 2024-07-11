package com.ap.gwentgame.client.enums;



public enum Placement {
    CLOSE_COMBAT(new int[]{0}),
    RANGED_COMBAT(new int[]{1}),
    SIEGE(new int[]{2}),
    AGILE(new int[]{0, 1}),
    WEATHER(new int[]{7}),
    SPECIAL_PLACE(new int[]{4, 5, 6}),
    DECOY(new int[]{0, 1, 2, 3, 4, 5, 6, 7});

    private int row;
    private int[] allowedContainers;

    Placement(int[] allowedContainers) {
        this.allowedContainers = allowedContainers;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getRow() {
        return this.row;
    }

    public int[] getAllowedContainers() {
        return allowedContainers;
    }
}
