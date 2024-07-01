package com.ap.gwentgame.view;

import com.ap.gwentgame.controller.MusicController;
import com.ap.gwentgame.enums.assets.FXMLs;
import com.ap.gwentgame.model.App;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

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