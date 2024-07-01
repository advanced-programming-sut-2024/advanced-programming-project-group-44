package com.ap.gwentgame.enums;

import com.ap.gwentgame.model.Cards.SpecialCard;
import com.ap.gwentgame.model.Cards.UnitCard;

import static com.ap.gwentgame.enums.FactionType.*;

public enum SpecialCardData {
    DECOY("Decoy", Placement.DECOY, NEUTRAL, 3),
    MARDROEM("Mardroeme", SKELLIGE, 3),
    SCORCH("Scorch", NEUTRAL, 3),
    COMMANDERS_HORN("Commander's Horn", NEUTRAL, 3);

    private final String name;
    private final Placement placement;
    private final FactionType factionType;
    private final AbilityType abilityType;
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
        specialCard.setAbility(abilityType.getAbility(unitCard));
        return unitCard;
    }

    public int getMaxCount() {
        return maxCount;
    }
}
