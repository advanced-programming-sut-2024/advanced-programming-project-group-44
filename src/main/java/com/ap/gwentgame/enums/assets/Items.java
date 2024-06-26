package com.ap.gwentgame.enums.assets;

import javafx.scene.image.Image;

public enum Items {
    ;

    private final String name;

    Items(String name) {
        this.name = name;
    }

    public Image getImage() {
        String path = getClass().getResource("/com/ap/gwentgame/images/items/" + name).toExternalForm();
        return new Image(path);
    }


}
