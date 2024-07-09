package com.ap.gwentgame.client.controller;

import com.ap.gwentgame.client.model.MessageBox;
import com.ap.gwentgame.client.model.Session;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ChatBoxController implements Initializable {

    @FXML
    private TextField messageField;
    @FXML
    private AnchorPane chatBoxStackPane;
    @FXML
    private VBox boxPane;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private ImageView back;
    @FXML
    private ImageView send;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chatBoxStackPane.setVisible(false);
        boxPane.setPadding(new Insets(10, 10, 10, 10));
    }

    @FXML
    private void sendMessage() {
        String message = messageField.getText();
        String loggedinUser = Session.getLoggedInUser().getNickName();
        createMessage(loggedinUser, message);
    }

    private void createMessage(String loggedinUser, String message) {
        if (!message.isEmpty()) {
            MessageBox messageBox = new MessageBox(loggedinUser, message);
            boxPane.getChildren().add(messageBox);
            messageField.clear();
        }
    }


    public void openChatBox() {
        chatBoxStackPane.setVisible(true);
    }

    public void closeChatBox() {
        chatBoxStackPane.setVisible(false);
    }

    @FXML
    private void handleEnterPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            sendMessage();
        }
    }

    public void setImages() {
        //back.setImage(Utilities.getImage("back.png"));
        //send.setImage(Utilities.getImage("send.png"));
    }


}
