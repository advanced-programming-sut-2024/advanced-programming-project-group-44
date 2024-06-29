package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.model.Cards.Item;
import com.ap.gwentgame.model.Game.Board;

public abstract class Leader extends Item {
    public abstract void executeAbility(Board board);

    public Leader(String name) {
        super(name);
    }
}
