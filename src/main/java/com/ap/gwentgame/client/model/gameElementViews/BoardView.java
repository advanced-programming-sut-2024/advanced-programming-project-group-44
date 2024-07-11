package com.ap.gwentgame.client.model.gameElementViews;

import com.ap.gwentgame.client.controller.ChatBoxController;
import com.ap.gwentgame.client.controller.MusicController;
import com.ap.gwentgame.client.controller.ReactionMenuController;
import com.ap.gwentgame.client.enums.assets.Backgrounds;
import com.ap.gwentgame.client.enums.assets.Icons;
import com.ap.gwentgame.client.model.gameElements.Board;
import com.ap.gwentgame.client.model.gameElements.Card;
import com.ap.gwentgame.client.model.gameElements.Player;
import com.ap.gwentgame.client.model.gameElements.WeatherCard;
import com.ap.gwentgame.client.view.ViewUtilities;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.util.HashMap;

public class BoardView {
    private final Board board;
    private AnchorPane gamePane;

    private final PlayerView player1View;
    private final PlayerView player2View;
    private PlayerView currentPlayerView;
    private PlayerView opponentPlayerView;

    private String abilityInput;

    private ChatBoxController chatBoxController;
    private ReactionMenuController reactionMenuController;

    private final CardViewContainer<WeatherCardView, WeatherCard> weatherCards;

    public BoardView(Board board, AnchorPane gamePane) {
        this.board = board;
        this.gamePane = gamePane;

        Player player1 = board.getPlayer1();
        Player player2 = board.getPlayer2();

        this.player1View = new PlayerView(player1, 1, this);
        this.player2View = new PlayerView(player2, 2, this);
        this.currentPlayerView = player1View;
        this.opponentPlayerView = player2View;

        this.weatherCards = new CardViewContainer<>(board.getWeatherCards());

        initializeGameBoard();
        initializeChatButton();
        initializeMuteButtons();
        initializeReactionButton();

    }

    public void initializeGameBoard() {
        ViewUtilities.setImageViewBackground(gamePane, Backgrounds.BOARD.getImage());
        weatherCards.setVisuals(gamePane, 86, 341, 177, 91, 10, 0);
        player1View.initializePlayerView();
        player2View.initializePlayerView();
    }

    public void initializeChatButton() {
        Button chatButton = new Button();
        chatButton.setLayoutX(1050);
        chatButton.setLayoutY(20);
        chatButton.setPrefSize(30, 30);
        chatButton.setStyle("-fx-background-color: transparent;");
        ImageView chatButtonIcon = new ImageView(Icons.CHAT.getImage());
        chatButton.setOnMouseClicked(event -> {
            chatBoxController.openChatBox();
        });
        chatButton.setGraphic(chatButtonIcon);
        gamePane.getChildren().add(chatButton);
    }

    public void initializeReactionButton() {
        Button reactionButton = new Button();
        reactionButton.setLayoutX(1000);
        reactionButton.setLayoutY(20);
        reactionButton.setPrefSize(30, 30);
        reactionButton.setStyle("-fx-background-color: transparent;");
        ImageView reactionButtonIcon = new ImageView(Icons.REACT.getImage());
        reactionButton.setOnMouseClicked(event -> {
            reactionMenuController.openReactionBox();
        });
        reactionButton.setGraphic(reactionButtonIcon);
        gamePane.getChildren().add(reactionButton);
    }

    public void initializeMuteButtons() {
        Button muteButton = new Button();
        muteButton.setLayoutX(1100);
        muteButton.setLayoutY(20);
        muteButton.setPrefSize(30, 30);
        muteButton.setStyle("-fx-background-color: transparent;");
        ImageView muteButtonIcon = new ImageView();
        muteButton.setOnMouseClicked(event -> {
            if (MusicController.getInstance().getMediaPlayer().isMute()) {
                MusicController.getInstance().getMediaPlayer().setMute(false);
                muteButtonIcon.setImage(Icons.UNMUTE.getImage());
            } else {
                MusicController.getInstance().getMediaPlayer().setMute(true);
                muteButtonIcon.setImage(Icons.MUTE.getImage());
            }
        });
        gamePane.getChildren().add(muteButton);
    }


    public AnchorPane getGamePane() {
        return gamePane;
    }

    public PlayerView getCurrentPlayer() {
        return currentPlayerView;
    }

    public PlayerView getOpponentPlayer() {
        return opponentPlayerView;
    }

    public PlayerView getPlayer1() {
        return player1View;
    }

    public PlayerView getPlayer2() {
        return player2View;
    }

    public CardViewContainer<WeatherCardView, WeatherCard> getWeatherCards() {
        return weatherCards;
    }

    public String getAbilityInput() {
        return abilityInput;
    }

    public void setAbilityInput(String abilityInput) {
        this.abilityInput = abilityInput;
    }

    public PlayerView getCurrentPlayerView() {
        return currentPlayerView;
    }

    public PlayerView getOpponentPlayerView() {
        return opponentPlayerView;
    }

    public void updateScoreLabels() {
        player1View.updateScoreLabels();
        player2View.updateScoreLabels();
    }
}
