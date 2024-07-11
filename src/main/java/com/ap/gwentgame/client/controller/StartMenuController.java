package com.ap.gwentgame.client.controller;

import com.ap.gwentgame.client.controller.view.LoginMenu;
import com.ap.gwentgame.client.controller.view.RegisterMenu;
import com.ap.gwentgame.client.controller.enums.assets.Backgrounds;
import com.ap.gwentgame.client.controller.model.App;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class StartMenuController {
    public ImageView imageview;

    public void initialize() {
        imageview.setImage(Backgrounds.MAINBG.getImage());
    }

    public void goToRegiser(MouseEvent mouseEvent) throws IOException {
        RegisterMenu registerMenu = new RegisterMenu();
        registerMenu.start(App.getStage());
    }

    public void goToLogin(MouseEvent mouseEvent) throws IOException {
        LoginMenu loginMenu = new LoginMenu();
        loginMenu.start(App.getStage());
    }
}