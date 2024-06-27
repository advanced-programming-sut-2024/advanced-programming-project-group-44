package com.ap.gwentgame.enums.assets;

import javafx.scene.image.Image;
import javafx.scene.media.Media;

public enum Musics {
    STARTINGMUSIC("01. Totally Fine.mp3");

    private final String name;

    Musics(String name) {
        this.name = name;
    }

    public Media getMusic() {
        String path = getClass().getResource("/com/ap/gwentgame/soundtracks/" + name).toExternalForm();
        return new Media(path);
    }
}
