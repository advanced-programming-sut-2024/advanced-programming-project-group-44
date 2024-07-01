package com.ap.gwentgame.enums.assets;

import com.ap.gwentgame.controller.Utilities;
import javafx.scene.image.Image;

public enum FactionImages {
    MONSTERS("Monsters.png"),
    NILFGAARD("Nilfgaard.png"),
    NORTHERN_REALMS("NorthernRealms.png"),
    SCOIATAEL("Scoiatael.png"),
    SKELLIGE("Skellige.png");

    private final String name;

    FactionImages(String name) {
        this.name = name;
    }

    public Image getImage() {
        return new Image(Utilities.getResourcePath("/images/factions/" + name));
    }
}
