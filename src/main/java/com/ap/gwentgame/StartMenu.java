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

//        Image icon = new Image(getClass().getResourceAsStream("/icon/rocket (3).png"));
//        stage.getIcons().add(icon);

        URL url = StartMenu.class.getResource("/com/ap/gwentgame/fxml/StartMenu.fxml");
        Pane root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}