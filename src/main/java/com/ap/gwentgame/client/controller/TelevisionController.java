package com.ap.gwentgame.client.controller;

import com.ap.gwentgame.client.enums.assets.Backgrounds;
import com.ap.gwentgame.client.model.Game.GameData;
import com.ap.gwentgame.client.model.GameBox;
import com.ap.gwentgame.client.model.LiveBox;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.util.Date;
import java.util.List;

public class TelevisionController {
    @FXML
    private ScrollPane rightScrollPane;
    @FXML
    private ScrollPane leftScrollPane;

    @FXML
    private VBox rightVBox;
    @FXML
    private ImageView background;

    @FXML
    private VBox leftVBox;

    public void initialize() {
        background.setImage(Backgrounds.FRIEND_REQUEST.getImage());
        List<GameData> allGameData = getAllGameData();
        List<GameData> rightGames = allGameData.subList(0, allGameData.size() / 2);
        List<GameData> leftGames = allGameData.subList(allGameData.size() / 2, allGameData.size());

        // Add GameBoxes to rightVBox
        for (GameData gameData : rightGames) {
            LiveBox gameBox = new LiveBox(gameData);
            rightVBox.getChildren().add(gameBox);
        }

        // Add GameBoxes to leftVBox
        for (GameData gameData : leftGames) {
            GameBox gameBox = new GameBox(gameData);
            leftVBox.getChildren().add(gameBox);
        }
    }

    // Dummy method to simulate retrieval of GameData objects
    private List<GameData> getAllGameData() {
        // Replace with actual data retrieval logic
        return List.of(new GameData("acfsghadghWV", "Player B", new Date(), 100, 90, new int[]{30, 40, 30}, new int[]{25, 30, 35}, "Player B"),
                new GameData("Player A", "Player C", new Date(), 120, 80, new int[]{35, 40, 45}, new int[]{30, 25, 25}, "Player C"),
                new GameData("Player t", "Player B", new Date(), 49, 90, new int[]{30, 40, 30}, new int[]{25, 30, 35}, "Player B"),
                new GameData("Player f", "Player C", new Date(), 20, 80, new int[]{35, 40, 45}, new int[]{30, 25, 25}, "Player f")
        );

    }
}
