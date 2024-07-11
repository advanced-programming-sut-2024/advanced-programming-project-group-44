package com.ap.gwentgame.view;

import com.ap.gwentgame.enums.assets.FXMLs;
import com.ap.gwentgame.client.model.Session;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginMenu extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Session.setStage(stage);
        stage.setScene(FXMLs.LOGIN_MENU.getScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}