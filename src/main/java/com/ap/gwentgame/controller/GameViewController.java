package com.ap.gwentgame.controller;

import com.ap.gwentgame.enums.assets.Backgrounds;
import com.ap.gwentgame.enums.assets.Icons;
import com.ap.gwentgame.enums.assets.Items;
import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Cards.UnitCard;
import com.ap.gwentgame.model.View.CardView;
import com.ap.gwentgame.model.View.CardViewContainer;
import com.ap.gwentgame.model.Game.GameData;
import com.ap.gwentgame.model.Game.GameManager;
import com.ap.gwentgame.model.Game.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;


public class GameViewController implements Initializable {
    private GameData game;
    private AnchorPane pane;
    private Player player1;
    private Player player2;
    private final HashMap<CardViewContainer<? extends CardView>, Rectangle> player1Containers = new HashMap<>();
    private final HashMap<CardViewContainer<? extends CardView>, Rectangle> player2Containers = new HashMap<>();

    private final CardViewContainer<CardView>[] player1Rows = new CardViewContainer[3];
    private final CardViewContainer<CardView>[] player2Rows = new CardViewContainer[3];
    private final CardViewContainer<CardView>[] player1Specials = new CardViewContainer[3];
    private final CardViewContainer<CardView>[] player2Specials = new CardViewContainer[3];
    private CardViewContainer<CardView> player1Hand;
    private CardViewContainer<CardView> player2Hand;
    private CardViewContainer<CardView> player1Deck;
    private CardViewContainer<CardView> player2Deck;
    private CardViewContainer<CardView> player1DiscardPile;
    private CardViewContainer<CardView> player2DiscardPile;
    private CardViewContainer<CardView> weatherCards;


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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        game = GameManager.getGameDataById(0);
        player1 = game.getPlayer1();
        player2 = game.getPlayer2();
        initializeSetImages();
        initializeContainers();
        initializeHighlights();
        updateLabels();
    }

    public void initializeContainers() {
        for (int i = 0; i < 3; i++) {
            player1Rows[i] = new CardViewContainer<>(player1.getRow(i));
            player2Rows[i] = new CardViewContainer<>(player2.getRow(i));
            player1Specials[i] = new CardViewContainer<>(player1.getRowSpecialCards(i));
            player2Specials[i] = new CardViewContainer<>(player2.getRowSpecialCards(i));
        }

        player1Hand = new CardViewContainer<>(player1.getHand());
        player2Hand = new CardViewContainer<>(player2.getHand());
        player1Deck = new CardViewContainer<>(player1.getDeck());
        player2Deck = new CardViewContainer<>(player2.getDeck());
        player1DiscardPile = new CardViewContainer<>(player1.getDiscardPile());
        player2DiscardPile = new CardViewContainer<>(player2.getDiscardPile());
        weatherCards = new CardViewContainer<>(game.getWeatherCards());

        player1Rows[0].setVisuals(pane, 440, 329, 508, 80, 10, 0);
        player1Rows[1].setVisuals(pane, 440, 410, 508, 80, 10, 0);
        player1Rows[2].setVisuals(pane, 440, 496, 508, 80, 10, 0);

        player1Specials[0].setVisuals(pane, 358, 329, 80, 80, 10, 0);
        player1Specials[1].setVisuals(pane, 358, 410, 80, 80, 10, 0);
        player1Specials[2].setVisuals(pane, 358, 496, 80, 80, 10, 0);

        player1DiscardPile.setVisuals(pane, 968, 580, 67, 89, 10, 0);
        player1Deck.setVisuals(pane, 1080, 580, 67, 89, 10, 0);
        player1Hand.setVisuals(pane, 357, 587, 594, 80, 10, 0);


        player2Rows[0].setVisuals(pane, 440, 234, 508, 80, 10, 0);
        player2Rows[1].setVisuals(pane, 440, 148, 508, 80, 10, 0);
        player2Rows[2].setVisuals(pane, 440, 68, 508, 80, 10, 0);

        player2Specials[0].setVisuals(pane, 358, 234, 80, 80, 10, 0);
        player2Specials[1].setVisuals(pane, 358, 148, 80, 80, 10, 0);
        player2Specials[2].setVisuals(pane, 358, 68, 80, 80, 10, 0);

        player2DiscardPile.setVisuals(pane, 968, 107, 67, 89, 10, 0);
        player2Deck.setVisuals(pane, 1080, 105, 67, 89, 10, 0);
        player2Hand.setVisuals(pane, 357, 587, 594, 80, 10, 0);

        weatherCards.setVisuals(pane, 86, 341, 177, 91, 10, 0);
    }

    public void initializeHighlights() {
        for (int i = 0; i < 3; i++) {
            generateHighlightRectangle(player1Rows[i], player1Containers);
            generateHighlightRectangle(player2Rows[i], player2Containers);
            generateHighlightRectangle(player1Specials[i], player1Containers);
            generateHighlightRectangle(player2Specials[i], player2Containers);
        }
        generateHighlightRectangle(player1Hand, player1Containers);
        generateHighlightRectangle(player2Hand, player2Containers);
        generateHighlightRectangle(player1Deck, player1Containers);
        generateHighlightRectangle(player2Deck, player2Containers);
        generateHighlightRectangle(player1DiscardPile, player1Containers);
        generateHighlightRectangle(player2DiscardPile, player2Containers);
        generateHighlightRectangle(weatherCards, player1Containers);
    }

    private void generateHighlightRectangle(CardViewContainer<? extends CardView> container, HashMap<CardViewContainer<? extends CardView>, Rectangle> highlights) {
        Rectangle rectangle = new Rectangle();
        rectangle.setVisible(false);
        rectangle.setLayoutX(container.getLayoutX());
        rectangle.setLayoutY(container.getLayoutY());
        rectangle.setWidth(container.getWidth());
        rectangle.setHeight(container.getHeight());
        pane.getChildren().add(rectangle);
        highlights.put(container, rectangle);
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
        int score = 0;
        for (Card card : player.getRows()[rowNum]) {
            if (card instanceof UnitCard) {
                score += ((UnitCard) card).getScore();
            }
        }
        return score;
    }

    public int calculateCountOfCard(Player player) {
        return player.getHand().size();
    }

    public void findCardPlaceOnClick(CardView cardview) {
        cardview.setOnMouseClicked(event -> {
            switch (cardview.getCard().getPlacement()) {

            }
        });
    }

    public <K extends CardView> void activateContainer(CardViewContainer<K> container, K item) {
        /*highlights.get(container).setVisible(true);
        container.setOnMouseClicked(event -> {
            highlights.get(container).setVisible(false);
            updateLabels();

        });*/
    }

}





