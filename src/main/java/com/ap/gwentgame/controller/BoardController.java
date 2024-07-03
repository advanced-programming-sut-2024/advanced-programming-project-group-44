package com.ap.gwentgame.controller;

import com.ap.gwentgame.enums.Placement;
import com.ap.gwentgame.enums.assets.Backgrounds;
import com.ap.gwentgame.enums.assets.Icons;
import com.ap.gwentgame.enums.assets.Items;
import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Cards.UnitCard;
import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.Game.Game;
import com.ap.gwentgame.model.Game.Player;
import com.ap.gwentgame.model.ItemContainer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.util.HashMap;


public class BoardController {
    private Board board;
    private AnchorPane pane;
    private Player player1;
    private Player player2;


    private Rectangle player1Row0Highlight;
    private Rectangle player1Row1Highlight;
    private Rectangle player1Row2Highlight;

    private Rectangle player1Special0Highlight;
    private Rectangle player1Special1Highlight;
    private Rectangle player1Special2Highlight;

    private Rectangle player2Row0Highlight;
    private Rectangle player2Row1Highlight;
    private Rectangle player2Row2Highlight;

    private Rectangle player2Special0Highlight;
    private Rectangle player2Special1Highlight;
    private Rectangle player2Special2Highlight;

    private Rectangle weatherHighlight;

    private final HashMap<ItemContainer<?>, Rectangle> highlights = new HashMap<>();

    @FXML
    private ImageView BoardImage;
    @FXML
    private ImageView Player2CardCount;
    @FXML
    private ImageView Player2GemOn;
    @FXML
    private ImageView Player2GemOff;
    @FXML
    private ImageView Player1CardCount;
    @FXML
    private ImageView Player1GemOn;
    @FXML
    private ImageView Player1GemOff;
    @FXML
    private Label Player1Score;
    @FXML
    private Label Player2Score;
    @FXML
    private Label Player2Row2Score;
    @FXML
    private Label Player2Row1Score;
    @FXML
    private Label Player2Row0Score;
    @FXML
    private Label Player1Row2Score;
    @FXML
    private Label Player1Row1Score;
    @FXML
    private Label Player1Row0Score;
    @FXML
    private Label Player1CardCounter;
    @FXML
    private Label Player2CardCounter;
    @FXML
    private ImageView Player2LeadersActive;
    @FXML
    private ImageView Player1LeadersActive;


    public void initialize() {
        board = Game.getCurrentBoard();

        player1 = board.getPlayer1();
        player2 = board.getPlayer2();

        initializeSetImages();
        initializeContainers();
        updateLabels();


    }

    public void initializeContainers() {

        player1.getRows()[0].setVisuals(pane, 440, 329, 508, 80, 10, 0);
        player1Row0Highlight = new Rectangle(440, 329, 508, 80);
        pane.getChildren().add(player1Row0Highlight);
        highlights.put(player1.getRows()[0], player1Row0Highlight);
        player1.getRows()[1].setVisuals(pane, 440, 410, 508, 80, 10, 0);
        player1Row1Highlight = new Rectangle(440, 410, 508, 80);
        pane.getChildren().add(player1Row1Highlight);
        highlights.put(player1.getRows()[1], player1Row1Highlight);
        player1.getRows()[2].setVisuals(pane, 440, 496, 508, 80, 10, 0);
        player1Row2Highlight = new Rectangle(440, 496, 508, 80);
        pane.getChildren().add(player1Row2Highlight);
        highlights.put(player1.getRows()[2], player1Row2Highlight);

        player1.getSpecialCards()[0].setVisuals(pane, 358, 329, 80, 80, 10, 0);
        player1Special0Highlight = new Rectangle(358, 329, 80, 80);
        pane.getChildren().add(player1Special0Highlight);
        highlights.put(player1.getSpecialCards()[0], player1Special0Highlight);
        player1.getSpecialCards()[1].setVisuals(pane, 358, 410, 80, 80, 10, 0);
        player1Special1Highlight = new Rectangle(358, 410, 80, 80);
        pane.getChildren().add(player1Special1Highlight);
        highlights.put(player1.getSpecialCards()[1], player1Special1Highlight);
        player1.getSpecialCards()[2].setVisuals(pane, 358, 496, 80, 80, 10, 0);
        player1Special2Highlight = new Rectangle(358, 496, 80, 80);
        pane.getChildren().add(player1Special2Highlight);
        highlights.put(player1.getSpecialCards()[2], player1Special2Highlight);

        player1.getDiscardPile().setVisuals(pane, 968, 580, 67, 89, 10, 0);
        player1.getDeck().setVisuals(pane, 1080, 580, 67, 89, 10, 0);
        player1.getHand().setVisuals(pane, 357, 587, 594, 80, 10, 0);


        player2.getRows()[0].setVisuals(pane, 440, 234, 508, 80, 10, 0);
        player2Row0Highlight = new Rectangle(440, 234, 508, 80);
        pane.getChildren().add(player2Row0Highlight);
        highlights.put(player2.getRows()[0], player2Row0Highlight);
        player2.getRows()[1].setVisuals(pane, 440, 148, 508, 80, 10, 0);
        player2Row1Highlight = new Rectangle(440, 148, 508, 80);
        pane.getChildren().add(player2Row1Highlight);
        highlights.put(player2.getRows()[1], player2Row1Highlight);
        player2.getRows()[2].setVisuals(pane, 440, 68, 508, 80, 10, 0);
        player2Row2Highlight = new Rectangle(440, 68, 508, 80);
        pane.getChildren().add(player2Row2Highlight);
        highlights.put(player2.getRows()[2], player2Row2Highlight);

        player2.getSpecialCards()[0].setVisuals(pane, 358, 234, 80, 80, 10, 0);
        player2Special0Highlight = new Rectangle(358, 234, 80, 80);
        pane.getChildren().add(player2Special0Highlight);
        highlights.put(player2.getSpecialCards()[0], player2Special0Highlight);
        player2.getSpecialCards()[1].setVisuals(pane, 358, 148, 80, 80, 10, 0);
        player2Special1Highlight = new Rectangle(358, 148, 80, 80);
        pane.getChildren().add(player2Special1Highlight);
        highlights.put(player2.getSpecialCards()[1], player2Special1Highlight);
        player2.getSpecialCards()[2].setVisuals(pane, 358, 68, 80, 80, 10, 0);
        player2Special2Highlight = new Rectangle(358, 68, 80, 80);
        pane.getChildren().add(player2Special2Highlight);
        highlights.put(player2.getSpecialCards()[2], player2Special2Highlight);

        player2.getDiscardPile().setVisuals(pane, 968, 107, 67, 89, 10, 0);
        player2.getDeck().setVisuals(pane, 1080, 105, 67, 89, 10, 0);
        player2.getDeck().setVisuals(pane, 357, 587, 594, 80, 10, 0);
        player2.getHand().setVisible(false);

        board.getWeatherCards().setVisuals(pane, 86, 341, 177, 91, 10, 0);
        weatherHighlight = new Rectangle(86, 341, 177, 91);
        pane.getChildren().add(weatherHighlight);
        highlights.put(board.getWeatherCards(), weatherHighlight);
    }


    public void initializeSetImages() {
        BoardImage.setImage(Backgrounds.BOARD.getImage());

        Player1CardCount.setImage(Icons.CARD_COUNT.getImage());
        Player1GemOn.setImage(Items.GEM_ON.getImage());
        Player1GemOff.setImage(Items.GEM_OFF.getImage());

        Player2CardCount.setImage(Icons.CARD_COUNT.getImage());
        Player2GemOn.setImage(Items.GEM_ON.getImage());
        Player2GemOff.setImage(Items.GEM_OFF.getImage());
    }

    public void updateLabels() {
        Player1Score.setText(String.valueOf(player1.getCurrentScore()));
        Player2Score.setText(String.valueOf(player2.getCurrentScore()));

        Player1Row0Score.setText(String.valueOf(calculateRowScore(player1, 0)));
        Player1Row1Score.setText(String.valueOf(calculateRowScore(player1, 1)));
        Player1Row2Score.setText(String.valueOf(calculateRowScore(player1, 2)));

        Player2Row0Score.setText(String.valueOf(calculateRowScore(player2, 0)));
        Player2Row1Score.setText(String.valueOf(calculateRowScore(player2, 1)));
        Player2Row2Score.setText(String.valueOf(calculateRowScore(player2, 2)));

        Player1CardCounter.setText(String.valueOf(calculateCountOfCard(player1)));
        Player2CardCounter.setText(String.valueOf(calculateCountOfCard(player2)));
    }

    public int calculateRowScore(Player player, int rowNum) {
        ItemContainer<Card> row = player.getRows()[rowNum];
        int score = 0;

        for (Card card : row.getItems()) {
            if (card instanceof UnitCard) {
                score += ((UnitCard) card).getScore();
            }
        }
        return score;
    }

    public int calculateCountOfCard(Player player) {
        ItemContainer<Card> Hand = player.getHand();
        int count = 0;
        for (Card card : Hand.getItems()) {
            count++;
        }
        return count;
    }

    public void findCardPlaceOnClick(Card card) {
        card.setOnMouseClicked(event -> {
            switch (card.getPlacement()) {
                case CLOSE_COMBAT:
                    activateContainer(board.getCurrentPlayer().getRows()[0]);
                    break;
                case RANGED_COMBAT:
                    activateContainer(board.getCurrentPlayer().getRows()[1]);
                    break;
                case SIEGE:
                    activateContainer(board.getCurrentPlayer().getRows()[2]);
                    break;
                case AGILE:
                    activateContainer(board.getCurrentPlayer().getRows()[0]);
                    activateContainer(board.getCurrentPlayer().getRows()[1]);
                    break;
                case WEATHER:
                    activateContainer(board.getWeatherCards());
                    break;
                case SPECIAL_PLACE:
                    activateContainer(board.getCurrentPlayer().getSpecialCards()[0]);
                    activateContainer(board.getCurrentPlayer().getSpecialCards()[1]);
                    activateContainer(board.getCurrentPlayer().getSpecialCards()[2]);
                    break;
                case DECOY:
                    if (board.getCurrentPlayer().getRows()[0].getItems().size() > 0) {
                        activateContainer(board.getCurrentPlayer().getRows()[0]);
                    } else if (board.getCurrentPlayer().getRows()[1].getItems().size() > 0) {
                        activateContainer(board.getCurrentPlayer().getRows()[1]);
                    } else if (board.getCurrentPlayer().getRows()[2].getItems().size() > 0) {
                        activateContainer(board.getCurrentPlayer().getRows()[2]);
                    }
                    break;
            }
        });
    }

    public void activateContainer(ItemContainer<?> container) {
        highlights.get(container).setVisible(true);
        container.setOnMouseClicked(event -> {

        });
    }
}





