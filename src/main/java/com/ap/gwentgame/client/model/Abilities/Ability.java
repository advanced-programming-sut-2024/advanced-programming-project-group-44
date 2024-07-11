package com.ap.gwentgame.client.model.Abilities;

import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import com.ap.gwentgame.client.model.gameElements.Card;
import javafx.scene.control.Button;

public abstract class Ability {
    protected Card card;
    private boolean hasAbilityInput = false;

    public Ability(Card card){
        this.card = card;
    }

    public abstract void run(BoardView boardView, int index);

    public void setAbilityInput() {
        this.hasAbilityInput = true;
    }

    public boolean hasAbilityInput() {
        return this.hasAbilityInput;
    }

}
