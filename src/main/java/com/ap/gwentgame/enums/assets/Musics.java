package com.ap.gwentgame.enums.assets;

import com.ap.gwentgame.controller.Utilities;
import javafx.scene.image.Image;
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
