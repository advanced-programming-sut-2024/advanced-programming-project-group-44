package com.ap.gwentgame.enums;

import com.ap.gwentgame.model.Leaders.Leader;

public enum LeaderData {
    ;
    private final String name;
    private final Leader leader;
    private final FactionType factionType;

    LeaderData(int number, String name, Leader leader, FactionType factionType) {
        this.name = name;
        this.leader = leader;
        this.factionType = factionType;
    }

    public String getName() {
        return name;
    }

    public Leader getLeader() {
        return leader;
    }

    public FactionType getFactionType() {
        return factionType;
    }
}
