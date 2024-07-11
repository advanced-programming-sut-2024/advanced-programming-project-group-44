package com.ap.gwentgame.client.controller;

import com.ap.gwentgame.client.controller.view.LoginMenu;
import com.ap.gwentgame.client.controller.view.ProfileMenu;
import com.ap.gwentgame.client.controller.enums.assets.Backgrounds;
import com.ap.gwentgame.client.controller.enums.assets.Icons;
import com.ap.gwentgame.client.controller.model.App;
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
            profileMenu.start(App.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void goToGameMenu(MouseEvent mouseEvent) {
        try {
            // TODO: go to pregame menu
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void logout(MouseEvent mouseEvent) {
        try {
            App.setLoggedinUser(null);
            LoginMenu loginMenu = new LoginMenu();
            loginMenu.start(App.getStage());
        } catch (Exception e) {
            e.printStackTrace();
    }
}

    public void mute(MouseEvent mouseEvent) {
        if (MusicController.getInstance().getMediaPlayer().isMute()) {
            MusicController.getInstance().getMediaPlayer().setMute(false);
            mute.setImage(Icons.UNMUTE.getImage());
        } else {
            MusicController.getInstance().getMediaPlayer().setMute(true);
            mute.setImage(Icons.MUTE.getImage());
        }
    }
}
