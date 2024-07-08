package com.ap.gwentgame.model.gameElementViews;

import com.ap.gwentgame.controller.ChatBoxController;
import com.ap.gwentgame.controller.MusicController;
import com.ap.gwentgame.enums.assets.Backgrounds;
import com.ap.gwentgame.enums.assets.Icons;
import com.ap.gwentgame.model.gameElements.Board;
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
    private PlayerView currentPlayer;
    private PlayerView opponentPlayer;

    private final CardViewContainer<WeatherCardView, WeatherCard> weatherCards;

    public BoardView(Board board, AnchorPane gamePane) {
        this.board = board;
        this.gamePane = gamePane;

        Player player1 = board.getPlayer1();
        Player player2 = board.getPlayer2();

        this.player1View = new PlayerView(player1, 1, gamePane);
        this.player2View = new PlayerView(player2, 2, gamePane);
        this.currentPlayer = player1View;
        this.opponentPlayer = player2View;

        this.weatherCards = new CardViewContainer<>(board.getWeatherCards());
        initializeMuteButtons();
        initializeChatButton();

        System.out.println("inja");

        initializeGameBoard();
    }

    public void initializeGameBoard() {
        ViewUtilities.setImageViewBackground(gamePane, Backgrounds.BOARD.getImage());
        player1View.initializePlayerView();
        player2View.initializePlayerView();
        weatherCards.setVisuals(gamePane, 86, 341, 177, 91, 10, 0);
    }

    public void initializeMuteButtons() {
        Button muteButton = new Button("mute");
        muteButton.setLayoutX(1100);
        muteButton.setLayoutY(20);
        muteButton.setPrefSize(30, 30);
        //muteButton.setStyle("-fx-background-color: transparent;");
        ImageView muteButtonIcon = new ImageView();
        muteButton.setOnMouseClicked(event -> {
            ViewUtilities.toggleMute(muteButton ,muteButtonIcon);
        });
        System.out.println("inja2");
        gamePane.getChildren().add(muteButton);
    }

    public void initializeChatButton() {
        Button chatButton = new Button("Chat");
        chatButton.setLayoutX(300);
        chatButton.setLayoutY(300);
        chatButton.setPrefSize(30, 30);
        //chatButton.setStyle("-fx-background-color: transparent;");
        ImageView chatButtonIcon = new ImageView();
        //chatButtonIcon.setImage(Icons.CHAT.getImage());
        chatButton.setOnMouseClicked(event -> {
            ChatBoxController chatBoxController = new ChatBoxController();
            chatBoxController.openChatBox();
        });
        chatButtonIcon.setFitWidth(30);
        chatButtonIcon.setFitHeight(30);
        gamePane.getChildren().add(chatButton);
    }

    public void initializeReactButton() {
        Button reactButton = new Button();
        reactButton.setLayoutX(1020);
        reactButton.setLayoutY(20);
        reactButton.setPrefSize(30, 30);
        reactButton.setStyle("-fx-background-color: transparent;");
        ImageView reactButtonIcon = new ImageView();
        //reactButtonIcon.setImage(Icons.REACT.getImage());
        reactButton.setOnMouseClicked(event -> {

        });
        reactButtonIcon.setFitWidth(30);
        reactButtonIcon.setFitHeight(30);
        gamePane.getChildren().add(reactButton);
    }

}
