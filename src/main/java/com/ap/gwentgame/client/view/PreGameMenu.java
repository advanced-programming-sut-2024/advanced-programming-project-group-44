package com.ap.gwentgame.client.view;

import com.ap.gwentgame.client.Client;
import com.ap.gwentgame.client.enums.assets.FXMLs;
import com.ap.gwentgame.client.model.Session;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class PreGameMenu extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Client.start();
        Session.setStage(stage);
        stage.setScene(FXMLs.PREGAME_MENU.getScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
