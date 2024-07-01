package com.ap.gwentgame.enums;

import com.ap.gwentgame.model.Abilities.*;
import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Cards.UnitCard;

public enum AbilityType {
    BERSERKER, COMMANDERSHORN, DECOY, MARDROEME, MEDIC, MORALBOOST, MUSTER, SCORCH, SPY, TIGHTBOND, TRANSFORMERS, NONE;

    public Ability getAbility(Card card) {
        return switch (this) {
            case BERSERKER -> new Berserker(card);
            case COMMANDERSHORN -> new CommandersHorn(card);
            case DECOY -> new Decoy(card);
            case MARDROEME -> new Mardroeme(card);
            case MEDIC -> new Medic(card);
            case MORALBOOST -> new MoralBoost(card);
            case MUSTER -> new Muster(card);
            case SCORCH -> new Scorch(card);
            case SPY -> new Spy(card);
            case TIGHTBOND -> new TightBond(card);
            case TRANSFORMERS -> new Transformers(card);
            default -> null;
        };

    }
}
