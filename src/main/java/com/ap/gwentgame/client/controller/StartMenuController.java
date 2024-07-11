package com.ap.gwentgame.client.controller;

import com.ap.gwentgame.client.model.Session;
import com.ap.gwentgame.client.view.LoginMenu;
import com.ap.gwentgame.client.view.RegisterMenu;
import com.ap.gwentgame.client.enums.assets.Backgrounds;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class StartMenuController {
    public ImageView imageview;

    public void initialize() {
        imageview.setImage(Backgrounds.MAINBG.getImage());
    }

    public void goToRegisterMenu(MouseEvent mouseEvent) throws IOException {
        RegisterMenu registerMenu = new RegisterMenu();
        registerMenu.start(Session.getStage());
    }

    public void goToLoginMenu(MouseEvent mouseEvent) throws IOException {
        LoginMenu loginMenu = new LoginMenu();
        loginMenu.start(Session.getStage());
    }
}