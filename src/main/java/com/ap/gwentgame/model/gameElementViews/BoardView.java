package com.ap.gwentgame.model.gameElementViews;

import com.ap.gwentgame.controller.MusicController;
import com.ap.gwentgame.enums.assets.Backgrounds;
import com.ap.gwentgame.enums.assets.Icons;
import com.ap.gwentgame.model.gameElements.Board;
import com.ap.gwentgame.model.gameElements.Card;
import com.ap.gwentgame.model.gameElements.Player;
import com.ap.gwentgame.model.gameElements.WeatherCard;
import com.ap.gwentgame.view.ViewUtilities;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class BoardView {
    private final Board board;
    private AnchorPane gamePane;

    private final PlayerView player1View;
    private final PlayerView player2View;
    private PlayerView currentPlayerView;
    private PlayerView opponentPlayerView;

    private String abilityInput;

    private final CardViewContainer<WeatherCardView, WeatherCard> weatherCards;

    public BoardView(Board board, AnchorPane gamePane) {
        this.board = board;
        this.gamePane = gamePane;

        Player player1 = board.getPlayer1();
        Player player2 = board.getPlayer2();

        this.player1View = new PlayerView(player1, 1, gamePane);
        this.player2View = new PlayerView(player2, 2, gamePane);
        this.currentPlayerView = player1View;
        this.opponentPlayerView = player2View;

        this.weatherCards = new CardViewContainer<>(board.getWeatherCards());

        initializeGameBoard();
    }

    public void initializeGameBoard() {
        ViewUtilities.setImageViewBackground(gamePane, Backgrounds.BOARD.getImage());
        player1View.initializePlayerView();
        player2View.initializePlayerView();
        weatherCards.setVisuals(gamePane, 86, 341, 177, 91, 10, 0);
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

    public void initializeChatButton() {
        Button chatButton = new Button();
        chatButton.setLayoutX(1060);
        chatButton.setLayoutY(20);
        chatButton.setPrefSize(30, 30);
        chatButton.setStyle("-fx-background-color: transparent;");
        ImageView chatButtonIcon = new ImageView();
        //chatButtonIcon.setImage(Icons.CHAT.getImage());
        //set on mouse clicked event to open chat window

        chatButtonIcon.setFitWidth(30);
        chatButtonIcon.setFitHeight(30);
        chatButton.setGraphic(chatButtonIcon);
        gamePane.getChildren().add(chatButton);
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
}
