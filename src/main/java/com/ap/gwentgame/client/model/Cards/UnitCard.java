package com.ap.gwentgame.client.model.Cards;

import com.ap.gwentgame.client.enums.FactionType;
import com.ap.gwentgame.client.enums.Placement;

public class UnitCard extends Card{
    private final boolean isHero;
    private int score;
    private final int initialScore;

    public UnitCard(String name, int score, Placement placement, FactionType factionType, boolean isHero){
        super(name, placement, factionType);
        this.score = score;
        this.initialScore = score;
        this.isHero = isHero;
    }

    public boolean isHero() {
        return isHero;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score){
        this.score = score;
    }
    public int getInitialScore(){
        return this.initialScore;
    }
}
