package com.ap.gwentgame.enums;

import com.ap.gwentgame.model.Abilities.*;
import com.ap.gwentgame.model.gameElements.Card;

public enum AbilityType {
    BERSERKER, COMMANDERSHORN, DECOY, MARDROEME, MEDIC, MORALBOOST, MUSTER, SCORCH, SPY, TIGHTBOND, TRANSFORMERS, BITINGFROST, IMPENETRABLEFOG, SKELLIGESTORM, TORRENTIALRAIN, CLEARWEATHER, NONE;

    public Ability getAbility(Card card) {
        return switch (this) {
            case BERSERKER -> new Berserker();
            case COMMANDERSHORN -> new CommandersHorn();
            case DECOY -> new Decoy();
            case MARDROEME -> new Mardroeme();
            case MEDIC -> new Medic();
            case MORALBOOST -> new MoralBoost();
            case MUSTER -> new Muster();
            case SCORCH -> new Scorch();
            case SPY -> new Spy();
            case TIGHTBOND -> new TightBond();
            case TRANSFORMERS -> new Transformers();
            case BITINGFROST -> new BitingFrost();
            case IMPENETRABLEFOG -> new ImpenetrableFog();
            case SKELLIGESTORM -> new SkelligeStorm();
            case TORRENTIALRAIN -> new TorrentialRain();
            case CLEARWEATHER -> new ClearWeather();
            default -> null;
        };

    }
}
