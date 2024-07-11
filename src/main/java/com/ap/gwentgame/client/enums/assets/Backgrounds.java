package com.ap.gwentgame.client.enums.assets;

import com.ap.gwentgame.client.controller.ControllerUtilities;
import javafx.scene.image.Image;

public enum Backgrounds {
    BOARD("Board.png"),
    START_MENU("StartMenu.jpg"),
    REGISTER_MENU("RegisterMenu.jpg"),
    LOGIN_MENU("LoginMenu.jpg"),
    MAIN_MENU("MainMenu.jpg"),
    PROFILE_MENU("ProfileMenu.jpg"),
    EDIT_MENU("EditMenu.jpg"),
    GAME_HISTORY("GameHistory.jpg"),
    PREGAME_MENU("MainBG.png"),
    WAITING_SCREEN("WaitingScreen.jpg"),;

    private final String name;

    Backgrounds(String name) {
        this.name = name;
    }

    public Image getImage() {
        return new Image(ControllerUtilities.getResourcePath("images/backgrounds/" + name));
    }
}
