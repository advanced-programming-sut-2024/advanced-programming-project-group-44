package com.ap.gwentgame.client.controller;

import com.ap.gwentgame.client.view.LoginMenu;
import com.ap.gwentgame.client.view.PreGameMenu;
import com.ap.gwentgame.client.view.ProfileMenu;
import com.ap.gwentgame.client.enums.assets.Backgrounds;
import com.ap.gwentgame.client.enums.assets.Icons;
import com.ap.gwentgame.client.model.Session;
import com.ap.gwentgame.client.view.ViewUtilities;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MainMenuController {
    @FXML
    public ImageView MainImage;
    @FXML
    public ImageView mute;
    @FXML
    public Button muteButton;

    public void initialize() {
        MainImage.setImage(Backgrounds.MAINBG.getImage());
        mute.setImage(Icons.UNMUTE.getImage());
    }

    @FXML
    public void goToProfileMenu(MouseEvent mouseEvent) {
        try {
            ProfileMenu profileMenu = new ProfileMenu();
            profileMenu.start(Session.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void goToGameMenu(MouseEvent mouseEvent) {
        try {
            PreGameMenu preGameMenu = new PreGameMenu();
            preGameMenu.start(Session.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void logout(MouseEvent mouseEvent) {
        try {
            Session.setLoggedInUser(null);
            LoginMenu loginMenu = new LoginMenu();
            loginMenu.start(Session.getStage());
        } catch (Exception e) {
            e.printStackTrace();
    }
}

    @FXML
    public void toggleMute(MouseEvent mouseEvent) {
       ViewUtilities.toggleMute(muteButton, mute);
    }
}
