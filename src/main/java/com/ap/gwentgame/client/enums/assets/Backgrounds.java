package com.ap.gwentgame.client.enums.assets;

import com.ap.gwentgame.client.controller.ControllerUtilities;
import javafx.scene.image.Image;

public enum Backgrounds {
    BOARD("Board.png"),
    START_MENU("StartMenu.png"),
    REGISTER_MENU("RegisterMenu.png"),
    LOGIN_MENU("LoginMenu.png"),
    MAIN_MENU("MainMenu.png"),
    PROFILE_MENU("ProfileMenu.png"),
    EDIT_MENU("EditMenu.png"),
    GAME_HISTORY("GameHistory.png"),
    PREGAME_MENU("PreGameMenu.png"),
    WAITING_SCREEN("WaitingScreen.png"),;

    private final String name;

    Backgrounds(String name) {
        this.name = name;
    }

    public Image getImage() {
        return new Image(ControllerUtilities.getResourcePath("images/backgrounds/" + name));
    }
}
