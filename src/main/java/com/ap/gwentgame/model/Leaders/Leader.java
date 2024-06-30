package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.model.Cards.Item;
import com.ap.gwentgame.model.Game.Board;

public abstract class Leader extends Item {
    private boolean canAbilityBeExecuted;
    public abstract void executeAbility(Board board);

    public Leader(String name) {
        super(name);
        canAbilityBeExecuted = true;
    }
    public void setCanAbilityBeExecuted(boolean canAbilityBeExecuted){
        this.canAbilityBeExecuted = canAbilityBeExecuted;
    }
    public boolean getCanAbilityBeExecuted(){
        return this.canAbilityBeExecuted;
    }
}
