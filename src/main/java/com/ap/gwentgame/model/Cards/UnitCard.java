package com.ap.gwentgame.model.Cards;

import com.ap.gwentgame.enums.Placement;
import com.ap.gwentgame.model.Abilities.Ability;

public class UnitCard extends Card{
    private final boolean isHero;
    private final boolean isExclusive;
    private final int score;

    public UnitCard(String name, int score, Placement placement, Ability ability, boolean isHero, boolean isExclusive){
        super(name, placement, ability);
        this.score = score;
        this.isHero = isHero;
        this.isExclusive = isExclusive;
    }

    public boolean isHero() {
        return isHero;
    }

    public boolean isExclusive() {
        return isExclusive;
    }

    public int getScore() {
        return score;
    }
}
