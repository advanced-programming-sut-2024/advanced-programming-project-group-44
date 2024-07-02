package com.ap.gwentgame.enums;

import com.ap.gwentgame.model.Abilities.Decoy;
import com.ap.gwentgame.model.Abilities.Mardroeme;
import com.ap.gwentgame.model.Cards.SpecialCard;
import com.ap.gwentgame.model.Cards.UnitCard;

import static com.ap.gwentgame.enums.FactionType.*;

public enum SpecialCardData {
    DECOY("Decoy", Placement.DECOY, AbilityType.DECOY, NEUTRAL,3),
    MARDROEM("Mardroeme", Placement.SPECIAL_PLACE,AbilityType.MARDROEME,SKELLIGE,3),
    SCORCH("Scorch", Placement.SCORCH,AbilityType.SCORCH,NEUTRAL, 3),
    COMMANDERS_HORN("Commander's Horn", Placement.SPECIAL_PLACE , AbilityType.COMMANDERSHORN ,NEUTRAL, 3);

    private final String name;
    private final Placement placement;
    private final AbilityType abilityType;
    private final FactionType factionType;
    private final int maxCount;

    SpecialCardData(String name, Placement placement, AbilityType abilityType, FactionType factionType, int maxCount) {
        this.name = name;
        this.placement = placement;
        this.abilityType = abilityType;
        this.factionType = factionType;
        this.maxCount = maxCount;
    }

    public SpecialCard getSpecialCard() {
        SpecialCard specialCard = new SpecialCard(name, placement, factionType);
        specialCard.setAbility(abilityType.getAbility(specialCard));
        return specialCard;
    }

    public int getMaxCount() {
        return maxCount;
    }
}
