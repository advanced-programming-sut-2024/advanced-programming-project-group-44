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

public class RegisterMenu extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        App.setStage(stage);

        URL url = RegisterMenu.class.getResource("/com/ap/gwentgame/fxml/RegisterMenu.fxml");
        System.out.println(url);
        Pane root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}