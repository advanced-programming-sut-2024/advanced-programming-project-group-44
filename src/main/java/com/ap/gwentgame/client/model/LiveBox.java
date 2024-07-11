package com.ap.gwentgame.client.model;

import com.ap.gwentgame.client.model.Game.GameData;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class LiveBox extends VBox {
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
        this.setPrefWidth(250);
        this.setPrefHeight(150);
        this.setPadding(new Insets(2, 10, 5, 10));
        this.setAlignment(Pos.CENTER);


        Region spacer = new Region();
        Region rightSpacer = new Region();

        HBox playerVbox = new HBox(10);

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
        playerVbox.getChildren().addAll(playerOneLabel ,spacer , playerTwoLabel);
        playerVbox.setPadding(new Insets(5 , 0 , 0 , 0));

        Button playButton = new Button("", imageView);
        imageView.setFitHeight(140);
        imageView.setFitWidth(210);
        imageView.setImage(new Image(getClass().getResourceAsStream("/images/images.png")));
        //playButton.setOnAction();



        spacer.setMinWidth(120);
        VBox.setVgrow(spacer, Priority.ALWAYS);
        VBox.setVgrow(rightSpacer, Priority.ALWAYS);
        VBox.setMargin(playerTwoLabel, new Insets(0, 0, 20, 0));


        this.getChildren().addAll(imageView,  playerVbox);
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
