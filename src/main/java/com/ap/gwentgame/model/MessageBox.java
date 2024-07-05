package com.ap.gwentgame.model;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class MessageBox extends AnchorPane {
    private int messageBoxId = 0;
    private HashMap<Integer, String> savedMessages = new HashMap<>();

    public MessageBox(String user, String message, boolean replyCheck, String replyUser, String replyMessage) {
        Label userLabel = new Label(user);
        userLabel.setPrefSize(200, 20);

        Button replyButton = new Button("Reply");
        replyButton.setId("reply-" + messageBoxId);
        replyButton.setOnAction(event -> handleReplyButtonClick(messageBoxId));

        HBox userHBox = new HBox(userLabel, replyButton);
        userHBox.setSpacing(10);
        userHBox.setAlignment(Pos.CENTER_LEFT);

        VBox replyVBox = new VBox();
        replyVBox.setVisible(false);

        if (replyCheck) {
            Label replyLabel = new Label("Reply:\n");
            Label replyUserLabel = new Label(replyUser);
            Label replyMessageLabel = new Label(replyMessage);
            replyVBox.getChildren().addAll(replyLabel, replyUserLabel, replyMessageLabel);
            replyVBox.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-padding: 10;");
            this.getChildren().add(replyVBox);
            replyVBox.setVisible(true);
        }
        Label messageLabel = new Label(message);
        messageLabel.setPrefWidth(200);
        messageLabel.setWrapText(true);
        Label timeLable = new Label();
        timeLable.setPrefSize(200, 20);
        timeLable.setAlignment(Pos.CENTER_RIGHT);

        updateCurrentTime(timeLable);
        VBox vbox = new VBox();
        vbox.getChildren().addAll(userLabel, messageLabel, new HBox(timeLable));
        vbox.setFillWidth(true);
        vbox.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-padding: 10;");

        this.getChildren().add(vbox);
        this.setStyle("-fx-padding: 10;");
        this.setPrefWidth(200);

        savedMessages.put(messageBoxId, message);
        messageBoxId++;
    }

    private void updateCurrentTime(Label label) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH : mm");
        String currentTime = LocalTime.now().format(formatter);
        label.setText(currentTime);
    }

    private void handleReplyButtonClick(int id) {
        String replyMessage = savedMessages.get(id);
        MessageBox messageBox = new MessageBox("Reply", replyMessage, true, "User", "Message");
    }


}
