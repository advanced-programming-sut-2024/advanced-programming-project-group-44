package com.ap.gwentgame.enums.assets;

import com.ap.gwentgame.StartMenu;
import com.ap.gwentgame.Utilities;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.net.URL;

public enum FXMLs {
    ;

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
