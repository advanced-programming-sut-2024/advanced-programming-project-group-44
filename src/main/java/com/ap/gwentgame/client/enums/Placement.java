package com.ap.gwentgame.client.enums;

import java.util.ArrayList;

public enum Placement {
    CLOSE_COMBAT(new int[]{1}),
    RANGED_COMBAT(new int[]{2}),
    SIEGE(new int[]{3}),
    AGILE(new int[]{1, 2}),
    WEATHER(new int[]{}),
    SPECIAL_PLACE(new int[]{1, 2, 3}),
    DECOY(new int[]{1, 2, 3}),
    SCORCH(new int[]{1, 2, 3});

    private final ArrayList<Integer> allowedRows;
    private int row;

    Placement(int[] allowedRowsList) {
        this.allowedRows = new ArrayList<Integer>();
        for (int i : allowedRowsList) {
            this.allowedRows.add(i);
        }
    }

    private boolean isPlaceAllowed(int row) {
        if (this.allowedRows.contains(row)) {
            return true;
        }
        return false;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getRow() {
        return this.row;
    }
}
