package com.ap.gwentgame.client.view;

import com.ap.gwentgame.client.enums.assets.FXMLs;
import com.ap.gwentgame.client.model.Session;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class WaitingScreenMenu extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Session.setStage(stage);
        stage.setScene(FXMLs.WAITING_SCREEN.getScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
