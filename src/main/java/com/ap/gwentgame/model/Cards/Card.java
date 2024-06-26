package com.ap.gwentgame.model.Cards;

import com.ap.gwentgame.model.Abilities.Ability;
import com.ap.gwentgame.enums.Placement;

public abstract class Card extends Item{
    private final Ability ability;

    private final Placement placement;

    public Card(String name, Placement placement, Ability ability){
        super(name);
        this.ability = ability;
        this.placement = placement;
    }
    public void executeAction(){
        ability.run();
    }

    public Ability getAbility() {
        return ability;
    }

    public Placement getPlacement() {
        return placement;
    }
}
