package com.ap.gwentgame.model.gameElementViews;

import com.ap.gwentgame.enums.assets.Backgrounds;
import com.ap.gwentgame.model.gameElements.Board;
import com.ap.gwentgame.model.gameElements.Player;
import com.ap.gwentgame.model.gameElements.WeatherCard;
import com.ap.gwentgame.view.ViewUtilities;
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
        initializeGameBoard();
    }

    public void initializeGameBoard() {
        ViewUtilities.setImageViewBackground(gamePane, Backgrounds.BOARD.getImage());
        player1View.initializePlayerView();
        player2View.initializePlayerView();
        weatherCards.setVisuals(gamePane, 86, 341, 177, 91, 10, 0);
    }
}
