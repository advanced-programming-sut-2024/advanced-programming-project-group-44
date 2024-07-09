package com.ap.gwentgame.client.enums.assets;

import com.ap.gwentgame.client.controller.ControllerUtilities;
import javafx.scene.media.Media;

public enum Musics {
    STARTING_MUSIC("01. Totally Fine.mp3");

    private final String name;

    Musics(String name) {
        this.name = name;
    }

    public Media getMusic() {
        return new Media(ControllerUtilities.getResourcePath("soundtracks/" + name));
    }
}
