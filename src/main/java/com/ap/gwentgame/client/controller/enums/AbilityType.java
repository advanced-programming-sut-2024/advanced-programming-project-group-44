package com.ap.gwentgame.client.controller.enums;

import com.ap.gwentgame.client.controller.model.Abilities.*;
import com.ap.gwentgame.client.controller.model.Cards.Card;

public enum AbilityType {
    BERSERKER, COMMANDERSHORN, DECOY, MARDROEME, MEDIC, MORALBOOST, MUSTER, SCORCH, SPY, TIGHTBOND, TRANSFORMERS, BITINGFROST, IMPENETRABLEFOG, SKELLIGESTORM, TORRENTIALRAIN, CLEARWEATHER, NONE;

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
            case BITINGFROST -> new BitingFrost(card);
            case IMPENETRABLEFOG -> new ImpenetrableFog(card);
            case SKELLIGESTORM -> new SkelligeStorm(card);
            case TORRENTIALRAIN -> new TorrentialRain(card);
            case CLEARWEATHER -> new ClearWeather(card);
            default -> null;
        };

    }
}
