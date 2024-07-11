package com.ap.gwentgame.client.controller;

import com.ap.gwentgame.client.enums.assets.Backgrounds;
import com.ap.gwentgame.client.model.Session;
import com.ap.gwentgame.client.view.ProfileMenu;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class GameHistoryController implements Initializable {

    @FXML
    private ImageView background;

    @Override
    public void initialize(java.net.URL location, java.util.ResourceBundle resources) {
        background.setImage(Backgrounds.SCORE_BOARD.getImage());
    }
    public void backToProfileMenu(MouseEvent mouseEvent) {
        try {
            ProfileMenu profileMenu = new ProfileMenu();
            profileMenu.start(Session.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
