package com.ap.gwentgame.enums.assets;

import javafx.scene.image.Image;

public enum Backgrounds {
    MainBG("mainBG.jpg");

    private final String name;

    Backgrounds(String name) {
        this.name = name;
    }

    public Image getImage() {
        String path = getClass().getResource("src/main/resources/assets/images/backgrounds/" + name).toExternalForm();
        return new Image(path);
    }
}
