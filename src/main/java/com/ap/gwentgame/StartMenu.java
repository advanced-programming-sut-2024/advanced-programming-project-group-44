package com.ap.gwentgame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class StartMenu extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        App.setStage(stage);

        URL url = StartMenu.class.getResource("/com/ap/gwentgame/fxml/StartMenu.fxml");
        Pane root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);

        stage.show();
    }

    public static void main(String[] args) {
        MusicController.getInstance().play();
        launch();
    }

}