package com.ap.gwentgame;

import javafx.stage.Stage;

public class App {
    private static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        App.stage = stage;
    }

}
