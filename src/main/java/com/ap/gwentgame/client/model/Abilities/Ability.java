package com.ap.gwentgame.client.model.Abilities;

import com.ap.gwentgame.client.model.gameElements.Board;
import com.ap.gwentgame.client.model.gameElements.Card;

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
