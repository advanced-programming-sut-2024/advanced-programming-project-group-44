package com.ap.gwentgame.client.model.gameElementViews;

import com.ap.gwentgame.ServerMessage;
import com.ap.gwentgame.client.Client;
import com.ap.gwentgame.client.controller.ChatBoxController;
import com.ap.gwentgame.client.controller.MusicController;
import com.ap.gwentgame.client.controller.ReactionMenuController;
import com.ap.gwentgame.client.enums.assets.Backgrounds;
import com.ap.gwentgame.client.enums.assets.Icons;
import com.ap.gwentgame.client.model.GameLog;
import com.ap.gwentgame.client.model.gameElements.Board;
import com.ap.gwentgame.client.model.gameElements.Player;
import com.ap.gwentgame.client.model.gameElements.WeatherCard;
import com.ap.gwentgame.client.view.ViewUtilities;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.HashMap;
import java.util.regex.Matcher;

import static com.ap.gwentgame.ServerCommands.PLAY_PASS;
import static com.ap.gwentgame.ServerCommands.PLAY_CARD;

public class BoardView {
    private final Board board;
    private AnchorPane gamePane;

    private final PlayerView player1View;
    private final PlayerView player2View;
    private PlayerView currentPlayerView;
    private PlayerView againstPlayerView;

    private String abilityInput;

    private final CardViewContainer<WeatherCardView, WeatherCard> weatherCards;

    private ChatBoxController chatBoxController;
    private ReactionMenuController reactionMenuController;

    private int round = 0;

    public int getRound() {
        return round;
    }

    public BoardView(Board board, AnchorPane gamePane) {
        this.board = board;
        this.gamePane = gamePane;

        Player player1 = board.getPlayer1();
        Player player2 = board.getPlayer2();

        this.player1View = new PlayerView(player1, 1, this);
        this.player2View = new PlayerView(player2, 2, this);
        this.currentPlayerView = player1View;
        this.againstPlayerView = player2View;

        this.weatherCards = new CardViewContainer<>(board.getWeatherCards());

        initializeGameBoard();
        initializeChatButton();
        initializeMuteButtons();
        initializeReactionButton();
        chatBoxController = new ChatBoxController();
        reactionMenuController = new ReactionMenuController();
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
        chatButtonIcon.setFitHeight(20);
        chatButtonIcon.setFitWidth(20);
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
        reactionButtonIcon.setFitHeight(20);
        reactionButtonIcon.setFitWidth(20);
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

    public PlayerView getAgainstPlayer() {
        return againstPlayerView;
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

    public PlayerView getAgainstPlayerView() {
        return againstPlayerView;
    }

    public void updateScoreLabels() {
        player1View.updateScoreLabels();
        player2View.updateScoreLabels();
    }

    public PlayerView getPlayer2View() {
        return player2View;
    }

    public PlayerView getPlayer1View() {
        return player1View;
    }

    public void startListening() {
        Thread daemonThread = new Thread(() -> {
            while (true) {
                ServerMessage command = Client.getResponse();
                board.addCommand(command.getMessageText());
                Board updatedBoard = Client.getGson().fromJson(command.getAdditionalText(), Board.class);

                if (player1View.equals(currentPlayerView) && !player1View.isLocalPlayer()) {
                    player1View.updateFromBoard(updatedBoard);
                }

                if (player2View.equals(currentPlayerView) && !player2View.isLocalPlayer()) {
                    player2View.updateFromBoard(updatedBoard);
                }

                Matcher matcher;
                if ((matcher = PLAY_CARD.getMatcher(command.getMessageText())).matches()) {
                    int id = Integer.parseInt(matcher.group(1));
                    String playerName = matcher.group(2);
                    int cardIndex = Integer.parseInt(matcher.group(3));
                    int row = Integer.parseInt(matcher.group(4));
                    int abilityInput = Integer.parseInt(matcher.group(5));
                    PlayerView activePlayerView = playerName.equals(board.getPlayer1().getUser().getName()) ? player1View : player2View;
                    Platform.runLater(() -> activePlayerView.playCard(cardIndex, row, abilityInput));
                }

                if ((matcher = PLAY_PASS.getMatcher(command.getMessageText())).matches()) {
                    int id = Integer.parseInt(matcher.group(1));
                    String playerName = matcher.group(2);
                    PlayerView activePlayerView = playerName.equals(board.getPlayer1().getUser().getName()) ? player1View : player2View;
                    Platform.runLater(() -> activePlayerView.playPass());
                }
            }
        });
        daemonThread.setDaemon(true);
        daemonThread.start();
    }


    public void changeTurn() {
        if (player1View.getPlayer().hasPassed() && player2View.getPlayer().hasPassed()) {
            changeRound();
        }

        if (currentPlayerView == player1View) {
            currentPlayerView = player2View;
            againstPlayerView = player1View;
        } else {
            currentPlayerView = player1View;
            againstPlayerView = player2View;
        }

        player1View.initializeClickables();
        player2View.initializeClickables();
    }

    public Board getBoard() {
        return board;
    }

    public void changeRound(){
        player1View.discardRound();
        player2View.discardRound();
        round++;

        //select winner
        PlayerView winner = player1View.getPlayer().getCurrentScore() > player2View.getPlayer().getCurrentScore() ? player1View : player2View;
        PlayerView loser = player1View.getPlayer().getCurrentScore() > player2View.getPlayer().getCurrentScore() ? player2View : player1View;

        loser.loseRound();
        if (loser.getPlayer().getRemainingHealth() == 0){
            endGame(winner, loser);
            return;
        }

        player1View.getRandomHand();
        player2View.getRandomHand();
    }

    public void endGame(PlayerView winner, PlayerView loser){
        ViewUtilities.showInformationAlert("Game Over", winner.getPlayer().getUser().getName() + " has won the game!");
        player1View.endGame(winner.getPlayer());
        player2View.endGame(winner.getPlayer());
    }
}
