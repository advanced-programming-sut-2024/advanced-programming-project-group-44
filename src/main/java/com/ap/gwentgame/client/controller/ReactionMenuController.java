package com.ap.gwentgame.client.controller;


import com.ap.gwentgame.client.enums.assets.Icons;
import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class ReactionMenuController implements Initializable {

    @FXML
    private AnchorPane reactBoxAnchorPane;
    @FXML
    private ImageView back;
    @FXML
    private ImageView emoji1;
    @FXML
    private ImageView emoji2;
    @FXML
    private ImageView emoji3;
    @FXML
    private TextField inputField;
    @FXML
    private Button text1;
    @FXML
    private Button text2;
    @FXML
    private Button text3;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        reactBoxAnchorPane.setVisible(false);

    }

    private void createReactionMessage(String sender, String message, ImageView imageView) {
        Pane messageBox = new Pane();
        messageBox.setPrefSize(150, 60);
        messageBox.setBackground(new Background(new BackgroundFill(Color.rgb(0,0,0,0.5), CornerRadii.EMPTY, Insets.EMPTY)));
        Label label = new Label(sender);
        messageBox.getChildren().add(label);

        if (message != null) {
            Label messageLabel = new Label(message);
            messageLabel.setLayoutY(20);
            messageLabel.setLayoutX(50);
            messageBox.getChildren().add(messageLabel);
        } else {
            imageView.setLayoutY(20);
            imageView.setLayoutX(50);
            messageBox.getChildren().add(imageView);
        }

        messageBox.setLayoutY(110);
        messageBox.setLayoutX(1000);

        reactBoxAnchorPane.setVisible(false);

        PauseTransition pause = new PauseTransition(Duration.seconds(5));
        pause.setOnFinished(e -> reactBoxAnchorPane.getChildren().remove(messageBox));
        pause.play();
    }

    public void backToBoard(MouseEvent mouseEvent) {
        reactBoxAnchorPane.setVisible(false);
    }

    public void sendEmoji(MouseEvent mouseEvent) {
        switch (((Button) mouseEvent.getSource()).getId()) {
            case "likeEmoji":
                createReactionMessage("player1", null, emoji1);
                break;
            case "dislikeEmoji":
                createReactionMessage("player1", null, emoji2);
                break;
            case "heartEmoji":
                createReactionMessage("player1", null, emoji3);
                break;
        }
    }

    public void sendPrepareText(MouseEvent mouseEvent) {
        switch (((Button) mouseEvent.getSource()).getId()) {
            case "text1":
                createReactionMessage("player1", "Hi!", null);
                break;
            case "text2":
                createReactionMessage("player1", "Thanks", null);
                break;
            case "text3":
                createReactionMessage("player1", "Why?", null);
                break;
        }
    }

    public void sendText(MouseEvent mouseEvent) {
        if (inputField.getText().isEmpty() || inputField.getText().length() > 12) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid input");
            alert.setContentText("Please enter a valid message");
            alert.showAndWait();
            return;
        }
        String message = inputField.getText();
        createReactionMessage("player1", message, null);
    }

    public void openReactionBox() {
        reactBoxAnchorPane.setVisible(true);
    }

    public void setImages() {
        back.setImage(Icons.BACK.getImage());
        emoji1.setImage(Icons.LIKE.getImage());
        emoji2.setImage(Icons.DISLIKE.getImage());
        emoji3.setImage(Icons.HEART.getImage());
    }

}