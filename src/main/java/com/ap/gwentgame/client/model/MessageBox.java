package com.ap.gwentgame.client.model;

import com.ap.gwentgame.client.enums.assets.Icons;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MessageBox extends AnchorPane {
    private static String replyMessage;
    private String message;

    public MessageBox(String user, String message) {
        Button replyButton = new Button("Reply");
        replyButton.setOnMouseClicked(e -> {
            replyMessage = this.message;
        });

        Button reactionButton = new Button();

        ImageView imageView = new ImageView(Icons.LIKE.getImage());

        imageView.setFitHeight(20);
        imageView.setFitWidth(20);

        reactionButton.setGraphic(imageView);
        reactionButton.setText("0");
        reactionButton.setTextFill(Color.TRANSPARENT);

        reactionButton.setOnAction(event -> {
            reactionButton.setTextFill(Color.BLACK);
            int currentValue = Integer.parseInt(reactionButton.getText());
            reactionButton.setText(String.valueOf(currentValue + 1));
        });

        this.message = message;
        Label userLabel = new Label(user);
        userLabel.setPrefSize(145, 20);

        HBox userHBox = new HBox(userLabel, replyButton);
        userHBox.setSpacing(10);
        userHBox.setAlignment(Pos.CENTER_LEFT);

        Label replyBox = new Label();
        replyBox.setVisible(false);

        if (replyMessage != null) {
            replyBox.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-padding: 10;");
            replyBox.setText("reply to: " + replyMessage);
            replyBox.setVisible(true);
        }

        Label messageLabel = new Label(message);
        messageLabel.setPrefWidth(200);
        messageLabel.setWrapText(true);

        Label timeLabel = new Label();
        timeLabel.setPrefSize(150, 20);
        timeLabel.setAlignment(Pos.CENTER_RIGHT);
        updateCurrentTime(timeLabel);

        HBox buttomHbox = new HBox(reactionButton, timeLabel);
        userHBox.setAlignment(Pos.CENTER_LEFT);


        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.getChildren().addAll(userHBox, replyBox, messageLabel, buttomHbox);
        vbox.setFillWidth(true);
        vbox.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-padding: 10;");

        this.getChildren().add(vbox);
        this.setStyle("-fx-padding: 10;");
        this.setPrefWidth(200);

    }

    private void updateCurrentTime(Label label) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH : mm");
        String currentTime = LocalTime.now().format(formatter);
        label.setText(currentTime);
    }
}
