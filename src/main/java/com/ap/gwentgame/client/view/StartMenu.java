package com.ap.gwentgame.client.view;

import com.ap.gwentgame.client.Client;
import com.ap.gwentgame.client.controller.ControllerUtilities;
import com.ap.gwentgame.client.controller.MusicController;
import com.ap.gwentgame.client.enums.assets.FXMLs;
import com.ap.gwentgame.client.model.Session;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class StartMenu extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Client.start();
        Session.setStage(stage);
        stage.setScene(FXMLs.START_MENU.getScene());
        stage.getScene().getStylesheets().add(ControllerUtilities.getResourcePath("CSS/style.css"));
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        MusicController.getInstance().play();
        launch();
    }

}