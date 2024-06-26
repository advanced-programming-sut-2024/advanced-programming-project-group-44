package com.ap.gwentgame.enums;


import com.ap.gwentgame.model.Abilities.Ability;

public enum UnitCardData {
    ;
    private final String name;
    private final int score;
    private final Placement placement;
    private final Ability ability;
    private final boolean isHero;
    private final boolean isExclusive;

    UnitCardData(String name, int score, Placement placement, Ability ability, boolean isHero, boolean isExclusive) {
        this.name = name;
        this.score = score;
        this.placement = placement;
        this.ability = ability;
        this.isHero = isHero;
        this.isExclusive = isExclusive;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public Placement getPlacement() {
        return placement;
    }

    public Ability getAbility() {
        return ability;
    }

    public boolean isHero() {
        return isHero;
    }

    public boolean isExclusive() {
        return isExclusive;
    }
}
