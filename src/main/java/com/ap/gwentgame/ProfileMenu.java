package com.ap.gwentgame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ProfileMenu extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        App.setStage(stage);
        URL url = getClass().getResource("/com/ap/gwentgame/fxml/ProfileMenu.fxml");
        Scene scene = new Scene(FXMLLoader.load(url));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
