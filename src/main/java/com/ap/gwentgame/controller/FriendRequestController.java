package com.ap.gwentgame.controller;

import com.ap.gwentgame.enums.Question;
import com.ap.gwentgame.model.FriendRequestBox;
import com.ap.gwentgame.model.User;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

import java.util.HashMap;
import java.util.Map;

public class FriendRequestController {

    @FXML
    private VBox friendRequestVbox;

    // Your HashMap that stores the friend requests
    private HashMap<User, User> friendRequestsMap = new HashMap<>();

    // Initialize the friend requests (for testing purposes)
    public void initialize() {
        // Simulated data for illustration
        User sender1 = new User("Sender1" , "oododo" , "nicNameeee" , "gdg@jfej.fjhbe" , Question.QUESTION_2 , "dd");
        User receiver1 = new User("Receiver1" , "swjhd" , "djdj" , "sdvhjsv" , Question.QUESTION_1 , "d");
        friendRequestsMap.put(sender1, receiver1);

        User sender2 = new User("Sender2" , "dmkf" , "sender2" , "df@dnlej.fw" , Question.QUESTION_3 , "de") ;
        User receiver2 = new User("Receiver2" , "dekij" , "dm" , "efcrwl" , Question.QUESTION_1 ,"fdw");
        friendRequestsMap.put(sender2, receiver2);

        // Populate the friendRequestVbox with FriendRequestBox instances
        populateFriendRequestVbox();
    }

    private void populateFriendRequestVbox() {
        friendRequestVbox.getChildren().clear(); // Clear existing content

        // Iterate over the HashMap entries
        for (Map.Entry<User, User> entry : friendRequestsMap.entrySet()) {
            User sender = entry.getKey();
            User receiver = entry.getValue();

            // Create a new FriendRequestBox instance for each entry
            FriendRequestBox friendRequestBox = new FriendRequestBox(sender.getNickName());
            friendRequestVbox.getChildren().add(friendRequestBox);
        }
    }
}
