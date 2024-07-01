package com.ap.gwentgame.enums;

import static com.ap.gwentgame.enums.FactionType.*;

public enum SpecialCardData {
    DECOY("Decoy", ALL, 3),
    MARDROEM("Mardroeme", SKELLIGE, 3),
    SCORCH("Scorch", ALL, 3),
    COMMANDERS_HORN("Commander's Horn", ALL, 3);

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
