package com.ap.gwentgame.enums.assets;

import javafx.scene.image.Image;

public enum Backgrounds {
    MAINBG("MainBG.png");

    private final String name;

    Backgrounds(String name) {
        this.name = name;
    }

    public Image getImage() {
        String path = getClass().getResource("/com/ap/gwentgame/images/backgrounds/" + name).toExternalForm();
        return new Image(path);
    }
}
