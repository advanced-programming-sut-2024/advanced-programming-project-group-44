package com.ap.gwentgame.enums.assets;

import javafx.scene.media.Media;

public enum Musics {
    STARTING_MUSIC("01. Totally Fine.mp3");

    private final String name;

    Musics(String name) {
        this.name = name;
    }

    public Media getMusic() {
        return new Media(ControllerUtilities.getResourcePath("/com/ap/gwentgame/music/" + name));
    }
}
