package com.ap.gwentgame.client.view;

import com.ap.gwentgame.client.model.Session;
import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import com.ap.gwentgame.client.model.gameElements.Board;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class GameMenu extends Application {
    private BoardView boardView;

    @Override
    public void start(Stage stage) throws IOException {
        AnchorPane gamePane = new AnchorPane();
        gamePane.setPrefHeight(800);
        gamePane.setPrefWidth(1200);
        boardView = new BoardView(Session.getCurrentBoard(), gamePane);
        Scene gameScene = new Scene(gamePane, 1200, 800);
        stage.setScene(gameScene);
        stage.show();
        boardView.startListening();
    }

    public static void main(String[] args) {
        launch();
    }
}
