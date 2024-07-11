package com.ap.gwentgame.client.view;

import com.ap.gwentgame.client.enums.assets.FXMLs;

import com.ap.gwentgame.client.model.Session;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class ScoreBoardMenu extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Session.setStage(stage);
        stage.setScene(FXMLs.SCORE_BOARD.getScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
