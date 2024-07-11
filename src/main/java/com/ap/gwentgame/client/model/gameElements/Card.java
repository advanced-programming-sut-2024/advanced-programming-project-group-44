package com.ap.gwentgame.client.model.gameElements;

import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.client.model.Abilities.Ability;
import com.ap.gwentgame.enums.Placement;

public abstract class Card extends Item {
    private Ability ability;
    private final Placement placement;
    private final FactionType factionType;

    public Card(String name, Placement placement, FactionType factionType) {
        super(name);
        this.placement = placement;
        this.factionType = factionType;
    }

    public void executeAction(Board board) {
        ability.run(board);
    }

    public void stopAction(Board board) {
        //ability.stop(board);
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    public Placement getPlacement() {
        return placement;
    }

    public FactionType getFactionType() {
        return factionType;
    }
}
