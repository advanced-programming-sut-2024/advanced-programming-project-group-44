package com.ap.gwentgame.enums.assets;

import com.ap.gwentgame.controller.Utilities;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.net.URL;

public enum FXMLs {
    START_MENU("StartMenu.fxml"),
    MAIN_MENU("MainMenu.fxml"),
    REGISTER_MENU("RegisterMenu.fxml"),
    LOGIN_MENU("LoginMenu.fxml"),
    PROFILE_MENU("ProfileMenu.fxml"),
    EDIT_MENU("EditMenu.fxml"),
    GAME_HISTORY("GameHistory.fxml"),
    PREGAME_MENU("PreGameMenu.fxml"),
    BOARD("Board.fxml");

    private final String name;

    FXMLs(String name) {
        this.name = name;
    }

    public Scene getScene() {
        try {
            return new Scene(FXMLLoader.load(new URL(Utilities.getResourcePath("fxml/" + name))));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
