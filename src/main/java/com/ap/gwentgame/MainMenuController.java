package com.ap.gwentgame;

import com.ap.gwentgame.enums.assets.Backgrounds;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MainMenuController {
    @FXML
    public ImageView MainImage;

    public void initialize() {
        MainImage.setImage(Backgrounds.MainBG.getImage());
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
            //TODO:  go to login menu
        } catch (Exception e) {
            e.printStackTrace();
    }
}}
