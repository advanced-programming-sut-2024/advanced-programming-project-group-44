package com.ap.gwentgame.view;

import com.ap.gwentgame.enums.assets.FXMLs;
import com.ap.gwentgame.model.App;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class FriendRequestMenu extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        App.setStage(stage);
        stage.setScene(FXMLs.FRIEND_REQUEST.getScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
