package com.ap.gwentgame.client.controller.model;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

public class FriendRequestBox extends HBox {
    private Label friend;
    private String friendNickname;
    private Button yesButton;
    private Button noButton;

    public FriendRequestBox(String nickname){
        friendNickname = nickname;
        initialize();
        setLayout();
    }

    private void setLayout() {
        this.setPrefWidth(980);
        this.setPrefHeight(40);
        this.setPadding(new Insets(5 , 10 , 5 , 10));
        this.setAlignment(Pos.CENTER); // Align contents to the left

        // Create spacer for button alignment
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        // Create HBox for buttons
        HBox buttonsBox = new HBox(20); // 20px spacing between buttons
        buttonsBox.setAlignment(Pos.CENTER_RIGHT); // Align buttons to the right
        buttonsBox.getChildren().addAll(yesButton, noButton); // Add buttons

        // Add components to the FriendRequestBox with spacing
        this.getChildren().addAll(friend, spacer, buttonsBox);

        // Set spacing between buttonsBox and the right edge
        this.setMargin(buttonsBox, new Insets(0, 10, 0, 0)); // 10px margin on the right
    }

    private void initialize(){
        friend = new Label();
        friend.setText(friendNickname);

        yesButton = new Button("Yes");
        noButton = new Button("No");
    }
}
