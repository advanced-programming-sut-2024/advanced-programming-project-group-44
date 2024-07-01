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
    PREGAME_MENU("Game.fxml"),
    BOARD("Board.fxml");

    private final String name;

    FXMLs(String name) {
        this.name = name;
    }

    public Scene getScene() {
        try {
            String path = Utilities.getResourcePath("/com/ap/gwentgame/fxmls/" + name);
            return new Scene(FXMLLoader.load(new URL(path)));
        } catch (Exception e) {
            System.out.println("FXMLs.getScene() failed");
            return null;
        }

    }
}
