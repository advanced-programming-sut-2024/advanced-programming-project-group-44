package com.ap.gwentgame.model.Cards;

import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.enums.Placement;
import com.ap.gwentgame.model.Abilities.Ability;
import com.ap.gwentgame.model.Factions.Faction;

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
