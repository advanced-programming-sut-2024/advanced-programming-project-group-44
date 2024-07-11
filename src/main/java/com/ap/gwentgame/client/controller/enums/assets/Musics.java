package com.ap.gwentgame.client.controller.enums.assets;

import com.ap.gwentgame.client.controller.Utilities;
import javafx.scene.media.Media;

public enum Musics {
    STARTINGMUSIC("01. Totally Fine.mp3");

    private final String name;

    Musics(String name) {
        this.name = name;
    }

    public Media getMusic() {
        return new Media(Utilities.getResourcePath("/com/ap/gwentgame/music/" + name));
    }
}
