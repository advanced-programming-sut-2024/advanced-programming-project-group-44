package com.ap.gwentgame.client.enums.assets;

import com.ap.gwentgame.client.controller.Utilities;
import javafx.scene.image.Image;

public enum Items {
    GEM_ON("GemOn.png"),
    GEM_OFF("GemOff.png");

    private final String name;

    Items(String name) {
        this.name = name;
    }

    public Image getImage() {
        return new Image(Utilities.getResourcePath("/images/items/" + name));
    }


}
