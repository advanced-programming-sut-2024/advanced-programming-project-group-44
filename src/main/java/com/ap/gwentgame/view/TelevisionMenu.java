package com.ap.gwentgame.view;

import com.ap.gwentgame.enums.assets.FXMLs;
import com.ap.gwentgame.model.App;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class TelevisionMenu extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        App.setStage(stage);
        stage.setScene(FXMLs.TELEVISION_MENU.getScene());
        stage.show();

        startTerminal();
    }
    private void startTerminal() {
        try {
            Stage terminalStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ap/gwentgame/fxml/TerminalView.fxml"));
            VBox terminalRoot = loader.load();
            Scene terminalScene = new Scene(terminalRoot);
            terminalStage.setScene(terminalScene);
            terminalStage.setTitle("Terminal");
            terminalStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
