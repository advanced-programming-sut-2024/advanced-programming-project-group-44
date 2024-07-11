package com.ap.gwentgame.client.controller;

import com.ap.gwentgame.client.model.Session;
import com.ap.gwentgame.client.view.ProfileMenu;
import javafx.scene.input.MouseEvent;

public class GameHistoryController {

    public void backToProfileMenu(MouseEvent mouseEvent) {
        try {
            ProfileMenu profileMenu = new ProfileMenu();
            profileMenu.start(Session.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
