package com.ap.gwentgame.model.gameElementViews;

import com.ap.gwentgame.model.gameElements.Board;
import com.ap.gwentgame.model.gameElements.Player;
import javafx.scene.layout.AnchorPane;

public class BoardView {
    private final Board board;
    private AnchorPane gamePane;

    private final PlayerView player1View;
    private final PlayerView player2View;
    private PlayerView currentPlayer;
    private PlayerView opponentPlayer;

    private final CardViewContainer<WeatherCardView> weatherCards;

    public BoardView(Board board, Player player1, Player player2, AnchorPane gamePane){
        this.board = board;
        this.gamePane = gamePane;

        this.player1View = new PlayerView(player1, 1, gamePane);
        this.player2View = new PlayerView(player2, 2, gamePane);
        this.currentPlayer = player1View;
        this.opponentPlayer = player2View;

        this.weatherCards = new CardViewContainer<>(board.getWeatherCards());
    }

    public void initializeGameBoard(){
        player1View.initializePlayerContainers();
        player2View.initializePlayerContainers();
        weatherCards.setVisuals(gamePane, 86, 341, 177, 91, 10, 0);
    }
}
