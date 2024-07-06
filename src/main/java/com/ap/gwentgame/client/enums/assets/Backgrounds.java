package com.ap.gwentgame.client.enums.assets;

import com.ap.gwentgame.client.controller.ControllerUtilities;
import javafx.scene.image.Image;

public enum Backgrounds {
    MAINBG("MainBG.png"),
    BOARD("Board.png");

    private final String name;

    Backgrounds(String name) {
        this.name = name;
    }

    public Image getImage() {
        return new Image(ControllerUtilities.getResourcePath("images/backgrounds/" + name));
    }
}
