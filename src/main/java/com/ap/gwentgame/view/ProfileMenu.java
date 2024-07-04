package com.ap.gwentgame.view;

import com.ap.gwentgame.enums.assets.FXMLs;
import com.ap.gwentgame.model.Session;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class ProfileMenu extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Session.setStage(stage);
        stage.setScene(FXMLs.PROFILE_MENU.getScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
