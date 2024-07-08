package com.ap.gwentgame.model.Abilities;

import com.ap.gwentgame.model.gameElementViews.BoardView;
import com.ap.gwentgame.model.gameElements.Card;
import javafx.scene.control.Button;

public abstract class Ability {
    protected Card card;

    public Ability(Card card){
        this.card = card;
    }

    public abstract void run(BoardView boardView, int index);
}
