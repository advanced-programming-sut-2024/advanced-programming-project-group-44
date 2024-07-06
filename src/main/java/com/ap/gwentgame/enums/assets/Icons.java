package com.ap.gwentgame.enums.assets;

import com.ap.gwentgame.controller.ControllerUtilities;
import javafx.scene.image.Image;

public enum Icons {
    BACK("Back.png"),
    MUTE("Mute.png"),
    UNMUTE("Unmute.png"),
    CARD_COUNT("CardCount.png"),
    LEADERS_ACTIVE("LeadersActive.png"),
    TOTAL_CARDS_COUNT("TotalCardsCount.png"),
    UNIT_CARDS_COUNT("UnitCardsCount.png"),
    SPECIAL_CARDS_COUNT("SpecialCardsCount.png"),
    TOTAL_CARD_STRENGTH("TotalCardStrength.png"),
    HERO_CARDS_COUNT("HeroCardsCount.png");

    private final String name;

    Icons(String name) {
        this.name = name;
    }

    public Image getImage() {
        return new Image(ControllerUtilities.getResourcePath("images/icons/" + name));
    }
}
