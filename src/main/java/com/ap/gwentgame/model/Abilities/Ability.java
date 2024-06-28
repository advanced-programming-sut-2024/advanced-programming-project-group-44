package com.ap.gwentgame.model.Abilities;

import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.Game.Player;

public abstract class Ability {
    protected Card card;

    public Ability(Card card){
        this.card = card;
    }

    public abstract void run(Board board);
}
