package com.ap.gwentgame.model;

import com.ap.gwentgame.model.Game.GameData;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

public class GameBox extends HBox {
    private GameData gameData;
    private Button playButton;
    private Label playerOneLabel;
    private Label playerTwoLabel;
    public GameBox(GameData gameData){
        this.gameData = gameData;
        initialize();
        setLayout();


    }

    private void setLayout() {
        this.setPrefWidth(480);
        this.setPrefHeight(40);
        this.setPadding(new Insets(5, 10, 5, 10));
        this.setAlignment(Pos.CENTER);

        // Create regions to ensure button is centered
        Region leftSpacer = new Region();
        Region rightSpacer = new Region();

        // Set button properties
        playButton.setPrefWidth(50);
        playButton.setPrefHeight(20);
        playButton.setAlignment(Pos.CENTER);

        // Set label properties
        playerOneLabel.setPrefHeight(20);
        playerOneLabel.setMaxWidth(120); // Set maximum width for label
        playerOneLabel.setWrapText(false); // Disable text wrapping
        playerOneLabel.setAlignment(Pos.CENTER_LEFT);
        playerOneLabel.setText(getShortenedName(gameData.getOpponentName()));

        playerTwoLabel.setPrefHeight(20);
        playerTwoLabel.setMaxWidth(120); // Set maximum width for label
        playerTwoLabel.setWrapText(false); // Disable text wrapping
        playerTwoLabel.setAlignment(Pos.CENTER_RIGHT);
        playerTwoLabel.setText(getShortenedName(gameData.getPlayerName()));

        // Ensure labels expand to fill available space
        HBox.setHgrow(leftSpacer, Priority.ALWAYS);
        HBox.setHgrow(rightSpacer, Priority.ALWAYS);
        HBox.setMargin(playerTwoLabel, new Insets(0, 20, 0, 0));
        HBox.setMargin(playerOneLabel, new Insets(0, 0, 0, 20));

        // Add children in the correct order
        this.getChildren().addAll(playerOneLabel, leftSpacer, playButton, rightSpacer, playerTwoLabel);
    }

    public void initialize(){
        playButton = new Button("Play");
        playerOneLabel = new Label(gameData.getOpponentName());
        playerTwoLabel = new Label(gameData.getPlayerName());
    }

    private String getShortenedName(String name) {
        int maxLength = 10; // Adjust as needed
        if (name.length() > maxLength) {
            return name.substring(0, maxLength - 3) + "...";
        } else {
            return name;
        }
    }
}
