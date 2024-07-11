package com.ap.gwentgame.client.model.Abilities;

import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import com.ap.gwentgame.client.model.gameElements.Card;

public abstract class Ability {
    public Ability(){
    }

    public abstract void run(BoardView boardView, int index, Card card);
}
