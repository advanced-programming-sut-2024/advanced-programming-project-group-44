package com.ap.gwentgame.client.view;

import com.ap.gwentgame.client.controller.ControllerUtilities;
import com.ap.gwentgame.client.enums.assets.FXMLs;
import com.ap.gwentgame.client.model.Session;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class TerminalMenu extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Stage terminalStage = new Stage();
        FXMLLoader loader = new FXMLLoader(new URL(ControllerUtilities.getResourcePath("fxml/TerminalView.fxml")));
        VBox terminalRoot = loader.load();
        Scene terminalScene = new Scene(terminalRoot);
        terminalStage.setScene(terminalScene);
        terminalStage.setTitle("Terminal");
        terminalStage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}
