package com.ap.gwentgame.client.model.Abilities;

import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import com.ap.gwentgame.client.model.gameElementViews.CardView;

public abstract class Ability {
    private boolean hasAbilityInput = false;

    public Ability(){
    }

    public abstract void run(BoardView boardView, int index, CardView cardView);

    public void setAbilityInput() {
        this.hasAbilityInput = true;
    }

    public boolean hasAbilityInput() {
        return this.hasAbilityInput;
    }

}
