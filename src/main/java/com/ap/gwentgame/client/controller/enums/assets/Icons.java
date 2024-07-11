package com.ap.gwentgame.client.controller.enums.assets;

import com.ap.gwentgame.client.controller.Utilities;
import javafx.scene.image.Image;

public enum Icons {
    BACK("Back.png"),
    MUTE("Mute.png"),
    UNMUTE("Unmute.png"),
    CARD_COUNT("CardCount.png"),
    LEADERS_ACTIVE("LeadersActive.png");

    private final String name;

    Icons(String name) {
        this.name = name;
    }

    public Image getImage() {
        return new Image(Utilities.getResourcePath("/images/icons/ + name"));
    }
}
