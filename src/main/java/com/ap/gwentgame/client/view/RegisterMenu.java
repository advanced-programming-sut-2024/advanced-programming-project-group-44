package com.ap.gwentgame.client.view;

import com.ap.gwentgame.client.enums.assets.FXMLs;
import com.ap.gwentgame.client.model.App;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterMenu extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        App.setStage(stage);
        stage.setScene(FXMLs.REGISTER_MENU.getScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}