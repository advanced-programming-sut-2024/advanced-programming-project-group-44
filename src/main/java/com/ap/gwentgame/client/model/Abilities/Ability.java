package com.ap.gwentgame.client.model.Abilities;

import com.ap.gwentgame.client.model.Cards.Card;
import com.ap.gwentgame.client.model.Game.Board;
import com.ap.gwentgame.client.model.Game.Player;

public abstract class Ability {
    protected Card card;

    public Ability(Card card){
        this.card = card;
    }

    public abstract void run(Board board);

    public abstract void stop(Board board);
}
