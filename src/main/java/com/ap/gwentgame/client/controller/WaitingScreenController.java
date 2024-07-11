package com.ap.gwentgame.client.controller;

import com.ap.gwentgame.ServerMessage;
import com.ap.gwentgame.client.Client;
import com.ap.gwentgame.client.enums.assets.Backgrounds;
import com.ap.gwentgame.client.model.Session;
import com.ap.gwentgame.client.model.gameElements.Board;
import com.ap.gwentgame.client.view.GameMenu;
import com.ap.gwentgame.client.view.ViewUtilities;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

import static com.ap.gwentgame.ServerCommands.GAME_STARTED;

public class WaitingScreenController implements Initializable {

    @FXML
    private ImageView background;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        background.setImage(Backgrounds.WAITING_SCREEN.getImage());
        Platform.runLater(this::checkGameStatus);
    }

    private void checkGameStatus() {
        ServerMessage serverMessage = Client.getResponse();
        while (serverMessage == null) {
            serverMessage = Client.getResponse();
        }

        if (GAME_STARTED.getMatcher(serverMessage.getMessageText()).matches()) {
            Board board = Client.getGson().fromJson(serverMessage.getAdditionalText(), Board.class);
            Session.setCurrentBoard(board);
            GameMenu gameMenu = new GameMenu();
            try {
                gameMenu.start(Session.getStage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            checkGameStatus();
        }
    }
}
