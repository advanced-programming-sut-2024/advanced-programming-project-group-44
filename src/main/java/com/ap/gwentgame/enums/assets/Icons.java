package com.ap.gwentgame.enums.assets;

import javafx.scene.image.Image;

public enum Icons {
    ;
    private final String name;

    Icons(String name) {
        this.name = name;
    }

    public Image getImage() {
        String path = getClass().getResource("src/main/resources/assets/images/Icons/" + name).toExternalForm();
        return new Image(path);
    }
}
