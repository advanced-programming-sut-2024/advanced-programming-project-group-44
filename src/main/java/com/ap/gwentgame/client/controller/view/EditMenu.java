package com.ap.gwentgame.client.controller.view;

import com.ap.gwentgame.client.controller.enums.assets.FXMLs;
import com.ap.gwentgame.client.controller.model.App;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class EditMenu extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        App.setStage(stage);
        stage.setScene(FXMLs.EDIT_MENU.getScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
