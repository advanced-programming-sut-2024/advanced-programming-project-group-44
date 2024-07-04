package com.ap.gwentgame.model.Cards;

import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.enums.Placement;

public class UnitCard extends Card{
    private final boolean isHero;
    private final int initialScore;
    private int score;

    public UnitCard(String name, int score, Placement placement, FactionType factionType, boolean isHero){
        super(name, placement, factionType);
        this.initialScore = score;
        this.score = score;
        this.isHero = isHero;
    }

    public boolean isHero() {
        return isHero;
    }

    public int getInitialScore() {
        return initialScore;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score){
        this.score = score;
    }
}
