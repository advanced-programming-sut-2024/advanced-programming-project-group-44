package com.ap.gwentgame.client.controller;

import com.ap.gwentgame.client.enums.Question;
import com.ap.gwentgame.client.model.User;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.HashMap;

public class FriendRequestController {

    @FXML
    private VBox friendRequestReceievedVbox;

    @FXML
    private VBox friendsSentVbox;
    private ArrayList<User> friends;
    private HashMap<User, User> friendRequestsMap = new HashMap<>();
    private User currentUser; // This should be the logged-in user

    @FXML
    public void initialize() {
        currentUser = new User("aryana", "dkfjhuhfrw", "ariaiaia", "dfkjrwb@gmail.cnjfsh", Question.QUESTION_1, ";fvhk");
        User sender1 = new User("Sender1", "oododo", "nicNameeee", "gdg@jfej.fjhbe", Question.QUESTION_2, "dd");
        User receiver1 = new User("Receiver1", "swjhd", "djdj", "sdvhjsv", Question.QUESTION_1, "d");
        friendRequestsMap.put(sender1, currentUser);

        User sender2 = new User("Sender2", "dmkf", "sender2", "df@dnlej.fw", Question.QUESTION_3, "de");
        User receiver2 = new User("Receiver2", "dekij", "dm", "efcrwl", Question.QUESTION_1, "fdw");
//        currentUser.addFriends(receiver2);
//        currentUser.addFriends(sender1);
        friendRequestsMap.put(sender2, currentUser);
        friendRequestsMap.put(currentUser, receiver1);
        friendRequestsMap.put(currentUser, receiver2);
        populateFriendRequests();
        //populateAllFriends();
    }

    private void populateFriendRequests() {
        for (HashMap.Entry<User, User> entry : friendRequestsMap.entrySet()) {
            User sender = entry.getKey();
            User receiver = entry.getValue();

            if (receiver.equals(currentUser)) {
                // Populate friend request received
                HBox requestBox = new HBox(10);
                requestBox.setPadding(new Insets(0, 0, 7, 0));
                Label senderNickname = new Label(sender.getNickName());
                Button acceptButton = new Button("Accept");
                Button declineButton = new Button("Decline");
                acceptButton.setOnAction(e -> acceptRequest(sender));
                declineButton.setOnAction(e -> declineRequest(sender));
                //senderNickname.setPadding(new Insets(0, 50, 0, 0));
                Region spacer = new Region();
                HBox.setHgrow(spacer, Priority.ALWAYS);
                spacer.setMinWidth(50);
                requestBox.getChildren().addAll(senderNickname, spacer, acceptButton, declineButton);
                friendRequestReceievedVbox.getChildren().add(requestBox);
            }

            if (sender.equals(currentUser)) {
                // Populate friend request sent
                HBox sentBox = new HBox(10);
                Label receiverNickname = new Label(receiver.getNickName());
                //ImageView pendingIcon = new ImageView(new Image(getClass().getResourceAsStream("images/clock.png"))); // Replace with actual image path
                Label pendingLabel = new Label("Pending...");
                Region spacer = new Region();
                HBox.setHgrow(spacer, Priority.ALWAYS);
                spacer.setMinWidth(50);
                pendingLabel.setPadding(new Insets(0, 0, 0, 50));
                sentBox.setPadding(new Insets(0, 0, 7, 0));

                sentBox.getChildren().addAll(receiverNickname, spacer, pendingLabel);
                friendsSentVbox.getChildren().add(sentBox);
            }

        }
    }
    private void populateAllFriends(){
        friends = currentUser.getFriends();
        for(User user :friends) {
            HBox friendsHbox = new HBox(10);
            Label friendNickname = new Label(user.getNickName());
            Region spacer = new Region();
            HBox.setHgrow(spacer, Priority.ALWAYS);
            spacer.setMinWidth(50);
            friendsHbox.setPadding(new Insets(0, 0, 7, 0));

            friendsHbox.getChildren().addAll(friendNickname, spacer);
            friendsSentVbox.getChildren().add(friendsHbox);
        }
    }

    private void acceptRequest(User sender) {
        System.out.println("Accepted friend request from " + sender.getNickName());
    }

    private void declineRequest(User sender) {
        System.out.println("Declined friend request from " + sender.getNickName());
    }

    public void search(MouseEvent mouseEvent) {
    }
}
