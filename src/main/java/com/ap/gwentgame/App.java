package com.ap.gwentgame;

import javafx.stage.Stage;

public class App {
    private Stage stage;
    private static App instance;

    private App(Stage stage) {
        this.stage = stage;
    }

    public static void runApplication(Stage stage) {
        instance = new App(stage);
    }

    public static App getInstance() {
        return instance;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
