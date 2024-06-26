package com.ap.gwentgame.enums.assets;

import javafx.scene.image.Image;

public enum Icons {
    BACK("Back.png"), MUTE("Mute.png"), UNMUTE("Unmute.png");
    private final String name;

    Icons(String name) {
        this.name = name;
    }

    public Image getImage() {
        String path = getClass().getResource("/com/ap/gwentgame/images/icons/" + name).toExternalForm();
        return new Image(path);
    }
}
