package com.ap.gwentgame.client.model.Abilities;

import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import com.ap.gwentgame.client.model.gameElements.Card;

public abstract class Ability {
    private boolean hasAbilityInput = false;

    public Ability(){
    }

    public abstract void run(BoardView boardView, int index, Card card);

    public void setAbilityInput() {
        this.hasAbilityInput = true;
    }

    public boolean hasAbilityInput() {
        return this.hasAbilityInput;
    }

}
