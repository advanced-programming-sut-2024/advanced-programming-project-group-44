package com.ap.gwentgame.client.model.gameElements;

import com.ap.gwentgame.client.enums.FactionType;

public abstract class Leader extends Item {
    private final FactionType factionType;
    private boolean canAbilityBeExecuted;
    private boolean hasAbilityInput = false;

    public Leader(String name, FactionType factionType) {
        super(name);
        this.factionType = factionType;
        canAbilityBeExecuted = true;
    }

    public abstract void executeAbility(Board board);

    public FactionType getFactionType() {
        return factionType;
    }

    public void setCanAbilityBeExecuted(boolean canAbilityBeExecuted){
        this.canAbilityBeExecuted = canAbilityBeExecuted;
    }

    public boolean getCanAbilityBeExecuted(){
        return this.canAbilityBeExecuted;
    }

    public void setAbilityInput() {
        this.hasAbilityInput = true;
    }

    public boolean hasAbilityInput() {
        return this.hasAbilityInput;
    }
}
