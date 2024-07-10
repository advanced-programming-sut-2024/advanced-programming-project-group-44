package com.ap.gwentgame.model;

import com.ap.gwentgame.model.Game.GameData;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class LiveBox extends HBox {
    private GameData gameData;
    private Label playerOneLabel;
    private Label playerTwoLabel;
    private ImageView imageView;
    private Timeline imageUpdateTimeline;

    public LiveBox(GameData gameData) {
        this.gameData = gameData;
        initialize();
        setLayout();
        startImageUpdate();
    }

    private void setLayout() {
        this.setPrefWidth(480);
        this.setPrefHeight(100);
        this.setPadding(new Insets(5, 10, 5, 10));
        this.setAlignment(Pos.CENTER);


        Region leftSpacer = new Region();
        Region rightSpacer = new Region();

        VBox playerVbox = new VBox(10);

        playerOneLabel.setPrefHeight(20);
        playerOneLabel.setMaxWidth(120);
        playerOneLabel.setWrapText(false);
        playerOneLabel.setAlignment(Pos.CENTER);
        playerOneLabel.setText(getShortenedName(gameData.getOpponentName()));

        playerTwoLabel.setPrefHeight(20);
        playerTwoLabel.setMaxWidth(120);
        playerTwoLabel.setWrapText(false);
        playerTwoLabel.setAlignment(Pos.CENTER);
        playerTwoLabel.setText(getShortenedName(gameData.getPlayerName()));

        playerVbox.getChildren().addAll(playerOneLabel, playerTwoLabel);


        HBox.setHgrow(leftSpacer, Priority.ALWAYS);
        HBox.setHgrow(rightSpacer, Priority.ALWAYS);
        HBox.setMargin(playerTwoLabel, new Insets(10, 0, 0, 0));


        this.getChildren().addAll(imageView, playerVbox);
    }

    private void initialize() {
        playerOneLabel = new Label(gameData.getOpponentName());
        playerTwoLabel = new Label(gameData.getPlayerName());
        imageView = new ImageView();
        imageView.setFitWidth(50); // Adjust width
        imageView.setFitHeight(50); // Adjust height
        updateImage();
    }

    private String getShortenedName(String name) {
        int maxLength = 10; // Adjust as needed
        if (name.length() > maxLength) {
            return name.substring(0, maxLength - 3) + "...";
        } else {
            return name;
        }
    }

    private void updateImage() {
//        // Replace this with your image fetching logic
//        String imageUrl = fetchImageUrl();
//        Image image = new Image(imageUrl);
//        imageView.setImage(image);
    }
    private void startImageUpdate() {
        imageUpdateTimeline = new Timeline(new KeyFrame(Duration.seconds(30), event -> updateImage()));
        imageUpdateTimeline.setCycleCount(Timeline.INDEFINITE);
        imageUpdateTimeline.play();
    }
}
