package com.ap.gwentgame.view;

import com.ap.gwentgame.enums.assets.FXMLs;
import com.ap.gwentgame.model.App;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class ScoreBoardMenu extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        App.setStage(stage);
        stage.setScene(FXMLs.SCORE_BOARD.getScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
