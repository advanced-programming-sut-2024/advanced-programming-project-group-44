package com.ap.gwentgame.enums;

import com.ap.gwentgame.model.Leaders.Leader;

public enum LeaderData {
    ;
    private final int number;
    private final String name;
    private final Leader leader;

    LeaderData(int number, String name, Leader leader) {
        this.number = number;
        this.name = name;
        this.leader = leader;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Leader getLeader() {
        return leader;
    }
}
