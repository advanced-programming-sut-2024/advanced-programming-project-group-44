package com.ap.gwentgame.client.controller;

import com.ap.gwentgame.client.controller.view.EditMenu;
import com.ap.gwentgame.client.controller.view.MainMenu;
import com.ap.gwentgame.client.controller.enums.assets.Icons;
import com.ap.gwentgame.client.controller.model.App;
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
        username.setText(App.getLoggedinUser().getName());
        nickname.setText(App.getLoggedinUser().getNickName());
        highestPoint.setText(String.valueOf(App.getLoggedinUser().getHighestPoint()));
        rank.setText(String.valueOf(App.getLoggedinUser().getRank()));
        games.setText(String.valueOf(App.getLoggedinUser().getGamesPlayed()));
        wins.setText(String.valueOf(App.getLoggedinUser().getWins()));
        losses.setText(String.valueOf(App.getLoggedinUser().getLosses()));
        draws.setText(String.valueOf(App.getLoggedinUser().getDraws()));
        back.setImage(Icons.BACK.getImage());
    }


    public void goToEditMenu(MouseEvent mouseEvent) {
        try {
            EditMenu editMenu = new EditMenu();
            editMenu.start(App.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToGameHistory(MouseEvent mouseEvent) {
        try {
            //GameHistory gameHistory = new GameHistory();
            //gameHistory.start(App.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void back(MouseEvent mouseEvent) {
        try {
            MainMenu mainMenu = new MainMenu();
            mainMenu.start(App.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}