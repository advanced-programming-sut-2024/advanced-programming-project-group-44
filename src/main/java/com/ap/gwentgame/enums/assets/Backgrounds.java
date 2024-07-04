package com.ap.gwentgame.enums.assets;

import javafx.scene.image.Image;

public enum Backgrounds {
    MAINBG("MainBG.png"),
    BOARD("B");

    private final String name;

    Backgrounds(String name) {
        this.name = name;
    }

    public Image getImage() {
        return new Image(ControllerUtilities.getResourcePath("images/backgrounds/" + name));
    }
}
