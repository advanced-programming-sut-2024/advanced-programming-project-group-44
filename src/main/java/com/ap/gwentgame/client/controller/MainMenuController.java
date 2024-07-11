package com.ap.gwentgame.client.controller;

import com.ap.gwentgame.ServerMessage;
import com.ap.gwentgame.client.view.*;
import com.ap.gwentgame.client.enums.assets.Backgrounds;
import com.ap.gwentgame.client.enums.assets.Icons;
import com.ap.gwentgame.client.model.Session;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

import static com.ap.gwentgame.ServerCommands.LOGOUT_SUCCESSFUL;

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
            ServerMessage responseMessage = RequestSender.logoutUser();
            String responseText = responseMessage.getMessageText();
            if (LOGOUT_SUCCESSFUL.getMatcher(responseText).matches()) {
                Session.setLoggedInUser(null);
                LoginMenu loginMenu = new LoginMenu();
                loginMenu.start(Session.getStage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void toggleMute(MouseEvent mouseEvent) {
        if (MusicController.getInstance().getMediaPlayer().isMute()) {
            MusicController.getInstance().getMediaPlayer().setMute(false);
            mute.setImage(Icons.UNMUTE.getImage());
        } else {
            MusicController.getInstance().getMediaPlayer().setMute(true);
            mute.setImage(Icons.MUTE.getImage());
        }
    }


    public void goToFriendRequestMenu(MouseEvent mouseEvent) {
        try {
            FriendRequestMenu friendRequestMenu = new FriendRequestMenu();
            friendRequestMenu.start(Session.getStage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void goToTelevisionMenu(MouseEvent mouseEvent) {
        try {
            TelevisionMenu televisionMenu = new TelevisionMenu();
            televisionMenu.start(Session.getStage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void runTerminal(MouseEvent mouseEvent) {
        try {
            TerminalMenu terminalMenu = new TerminalMenu();
            terminalMenu.start(Session.getStage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
