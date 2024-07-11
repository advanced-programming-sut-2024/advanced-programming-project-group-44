package com.ap.gwentgame.client.controller.view;

import com.ap.gwentgame.client.controller.MusicController;
import com.ap.gwentgame.client.controller.enums.assets.FXMLs;
import com.ap.gwentgame.client.controller.model.App;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class StartMenu extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        App.setStage(stage);
        stage.setScene(FXMLs.START_MENU.getScene());
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        MusicController.getInstance().play();
        launch();
    }

}