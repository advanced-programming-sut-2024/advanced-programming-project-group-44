package com.ap.gwentgame.view;

import com.ap.gwentgame.enums.assets.FXMLs;
import com.ap.gwentgame.client.model.Session;
import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import com.ap.gwentgame.client.model.gameElements.Board;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class GameMenu extends Application {
    private Scene gameScene;

    @Override
    public void start(Stage stage) throws IOException {
        Session.setStage(stage);
        stage.setScene(gameScene);
        stage.show();
    }

    public void loadBoard(Board board) {
        AnchorPane gamePane = new AnchorPane();
        gamePane.setPrefHeight(800);
        gamePane.setPrefWidth(1200);
        BoardView boardView = new BoardView(board, gamePane);
        gameScene = new Scene(gamePane, 1200, 800);
        try {
            this.start(Session.getStage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
