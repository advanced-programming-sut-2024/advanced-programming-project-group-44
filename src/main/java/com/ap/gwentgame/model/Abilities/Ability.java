package com.ap.gwentgame.model.Abilities;

import com.ap.gwentgame.model.gameElements.Board;
import com.ap.gwentgame.model.gameElements.Card;

public abstract class Ability {
    private boolean hasAbilityInput = false;

    public Ability(){
    }

    public abstract void run(Board board, Card card);

    public void setAbilityInput() {
        this.hasAbilityInput = true;
    }

    public boolean hasAbilityInput() {
        return this.hasAbilityInput;
    }

}
