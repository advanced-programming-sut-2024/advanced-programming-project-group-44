package com.ap.gwentgame.client.enums.assets;

import com.ap.gwentgame.client.controller.Utilities;
import javafx.scene.image.Image;

public enum Backgrounds {
    MAINBG("MainBG.png");

    private final String name;

    Backgrounds(String name) {
        this.name = name;
    }



    public Image getImage() {
        return new Image(Utilities.getResourcePath("/images/backgrounds/" + name));
    }
}
