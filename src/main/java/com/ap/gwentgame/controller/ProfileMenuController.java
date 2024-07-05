package com.ap.gwentgame.controller;

import com.ap.gwentgame.model.Session;
import com.ap.gwentgame.view.EditMenu;
import com.ap.gwentgame.view.GameHistory;
import com.ap.gwentgame.view.MainMenu;
import com.ap.gwentgame.enums.assets.Icons;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ProfileMenuController {
    @FXML
    public ImageView ProfileImage;
    @FXML
    public Label username;
    @FXML
    public Label nickname;
    @FXML
    public Label highestPoint;
    @FXML
    public Label rank;
    @FXML
    public Label games;
    @FXML
    public Label wins;
    @FXML
    public Label losses;
    @FXML
    public Label draws;
    @FXML
    public ImageView back;

    public void initialize() {
        username.setText(Session.getLoggedInUser().getName());
        nickname.setText(Session.getLoggedInUser().getNickName());
        highestPoint.setText(String.valueOf(Session.getLoggedInUser().getHighestPoint()));
        rank.setText(String.valueOf(Session.getLoggedInUser().getRank()));
        games.setText(String.valueOf(Session.getLoggedInUser().getGamesPlayed()));
        wins.setText(String.valueOf(Session.getLoggedInUser().getWins()));
        losses.setText(String.valueOf(Session.getLoggedInUser().getLosses()));
        draws.setText(String.valueOf(Session.getLoggedInUser().getDraws()));
        back.setImage(Icons.BACK.getImage());
    }

    public void goToEditMenu(MouseEvent mouseEvent) {
        try {
            EditMenu editMenu = new EditMenu();
            editMenu.start(Session.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToGameHistory(MouseEvent mouseEvent) {
        try {
            GameHistory gameHistory = new GameHistory();
            gameHistory.start(Session.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void backToStartMenu(MouseEvent mouseEvent) {
        try {
            MainMenu mainMenu = new MainMenu();
            mainMenu.start(Session.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}