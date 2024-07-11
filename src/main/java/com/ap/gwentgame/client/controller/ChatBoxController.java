package com.ap.gwentgame.client.controller;


import com.ap.gwentgame.client.enums.assets.Icons;
import com.ap.gwentgame.client.model.MessageBox;
import com.ap.gwentgame.client.model.gameElements.Board;
import javafx.application.Platform;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;


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

    private String replyMessage = null;


    private Board board;
    private MainMenuController mainMenuController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chatBoxStackPane.setVisible(false);
        boxPane.setPadding(new Insets(10, 10, 10, 10));
        setImages();

    }

    @FXML
    private void sendMessage() {
        String message = messageField.getText();
        //String loggedinUser = App.getLoggedinUser().getNickName();
        createMessage("player1", message);
    }

    private void createMessage(String loggedinUser, String message) {
        if (!message.isEmpty()) {
            MessageBox messageBox = new MessageBox(loggedinUser, message);
            boxPane.getChildren().add(messageBox);
            messageField.clear();
        }
        if (scrollPane.getContent() instanceof Region) {
            Region content = (Region) scrollPane.getContent();
            content.heightProperty().addListener((observable, oldValue, newValue) -> {
                Platform.runLater(() -> scrollPane.setVvalue(1.0));
            });
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
        back.setImage(Icons.BACK.getImage());
        send.setImage(Icons.SEND.getImage());
    }


}
