package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.model.Cards.Item;

public abstract class Leader extends Item {
    public abstract void executeAbility();

    public Leader(String name) {
        super(name);
    }
}
