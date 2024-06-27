package com.ap.gwentgame;

import com.ap.gwentgame.enums.assets.Backgrounds;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
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