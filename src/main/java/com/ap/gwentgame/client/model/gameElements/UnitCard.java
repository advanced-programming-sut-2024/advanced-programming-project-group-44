package com.ap.gwentgame.client.model.gameElements;

import com.ap.gwentgame.client.enums.FactionType;
import com.ap.gwentgame.client.enums.Placement;

import java.io.Serializable;

public class UnitCard extends Card implements Serializable {
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
