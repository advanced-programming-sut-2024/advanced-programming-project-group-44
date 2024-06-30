package com.ap.gwentgame.enums;

public enum SpecialCardData {
    DECOY("Decoy", FactionType.SCOIATAEL, 10);
    private final String name;
    private final FactionType factionType;
    private final int maxCount;

    SpecialCardData(String name, FactionType factionType, int maxCount) {
        this.name = name;
        this.factionType = factionType;
        this.maxCount = maxCount;
    }

    public String getName() {
        return name;
    }

    public FactionType getFactionType() {
        return factionType;
    }

    public int getMaxCount() {
        return maxCount;
    }
}
