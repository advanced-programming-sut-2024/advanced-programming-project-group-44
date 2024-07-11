package com.ap.gwentgame.client.view;

import com.ap.gwentgame.client.enums.assets.FXMLs;
import com.ap.gwentgame.client.model.App;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenu extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        App.setStage(stage);
        stage.setScene(FXMLs.MAIN_MENU.getScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
