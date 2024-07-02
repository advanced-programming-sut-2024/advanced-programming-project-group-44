package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.model.Cards.Item;
import com.ap.gwentgame.model.Game.Board;

public abstract class Leader extends Item {
    private final FactionType factionType;
    public abstract void executeAbility(Board board);
    private boolean canAbilityBeExecuted;

    public Leader(String name, FactionType factionType) {
        super(name);
        this.factionType = factionType;
        canAbilityBeExecuted = true;
    }

    public FactionType getFactionType() {
        return factionType;
    }

    public void setCanAbilityBeExecuted(boolean canAbilityBeExecuted){
        this.canAbilityBeExecuted = canAbilityBeExecuted;
    }

    public boolean getCanAbilityBeExecuted(){
        return this.canAbilityBeExecuted;
    }
}
