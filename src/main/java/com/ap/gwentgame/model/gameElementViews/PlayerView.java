package com.ap.gwentgame.model.gameElementViews;

import com.ap.gwentgame.enums.assets.Icons;
import com.ap.gwentgame.enums.assets.Items;
import com.ap.gwentgame.model.gameElements.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class PlayerView {
    private final Player player;
    private final int playerNumber;
    private final AnchorPane boardPane;

    private final FactionView factionView;
    private final LeaderView leaderView;
    private final Label currentScoreLabel;
    private final Label handCardsCountLabel;

    private final Label[] scoreLabels = new Label[3];
    private final CardViewContainer<CardView, Card> deckView;
    private final CardViewContainer<CardView, Card> handView;
    private final CardViewContainer<CardView, Card> discardPileView;
    private final CardViewContainer<CardView, Card>[] rowViews;
    private final CardViewContainer<CardView, Card>[] specialCardViews;

    public PlayerView(Player player, int playerNumber, AnchorPane boardPane) {
        this.player = player;
        this.playerNumber = playerNumber;
        this.boardPane = boardPane;

        this.factionView = new FactionView(player.getFaction());
        this.leaderView = new LeaderView(player.getLeader());

        this.currentScoreLabel = new Label();
        this.scoreLabels[0] = new Label();
        this.scoreLabels[1] = new Label();
        this.scoreLabels[2] = new Label();

        this.handCardsCountLabel = new Label();

        this.deckView = new CardViewContainer<>(player.getDeck());
        this.handView = new CardViewContainer<>(player.getHand());
        this.discardPileView = new CardViewContainer<>(player.getDiscardPile());
        this.rowViews = new CardViewContainer[3];
        this.rowViews[0] = new CardViewContainer<>(player.getRows()[0]);
        this.rowViews[1] = new CardViewContainer<>(player.getRows()[1]);
        this.rowViews[2] = new CardViewContainer<>(player.getRows()[2]);
        this.specialCardViews = new CardViewContainer[3];
        this.specialCardViews[0] = new CardViewContainer<>(player.getSpecialCards()[0]);
        this.specialCardViews[1] = new CardViewContainer<>(player.getSpecialCards()[1]);
        this.specialCardViews[2] = new CardViewContainer<>(player.getSpecialCards()[2]);
    }

    public Player getPlayer() {
        return player;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void initializePlayerView() {
        initializeContainers();
        initializeInfo();
        initializeScoreLabels();
    }

    public void initializeContainers() {
        Button passButton = new Button("PASS");
        passButton.setPrefSize(50 , 25);
        passButton.setLayoutX(210);
        passButton.setLayoutY(615);

        if (playerNumber == 1) {
            rowViews[0].setVisuals(boardPane, 440, 329, 508, 80, 10, 0);
            rowViews[1].setVisuals(boardPane, 440, 410, 508, 80, 10, 0);
            rowViews[2].setVisuals(boardPane, 440, 496, 508, 80, 10, 0);

            specialCardViews[0].setVisuals(boardPane, 358, 329, 80, 80, 10, 0);
            specialCardViews[1].setVisuals(boardPane, 358, 410, 80, 80, 10, 0);
            specialCardViews[2].setVisuals(boardPane, 358, 496, 80, 80, 10, 0);

            discardPileView.setVisuals(boardPane, 968, 580, 67, 89, 10, 0);
            deckView.setVisuals(boardPane, 1080, 580, 67, 89, 10, 0);
            handView.setVisuals(boardPane, 357, 587, 594, 80, 10, 0);
        } else {
            rowViews[0].setVisuals(boardPane, 440, 234, 508, 80, 10, 0);
            rowViews[1].setVisuals(boardPane, 440, 148, 508, 80, 10, 0);
            rowViews[2].setVisuals(boardPane, 440, 68, 508, 80, 10, 0);

            specialCardViews[0].setVisuals(boardPane, 358, 234, 80, 80, 10, 0);
            specialCardViews[1].setVisuals(boardPane, 358, 148, 80, 80, 10, 0);
            specialCardViews[2].setVisuals(boardPane, 358, 68, 80, 80, 10, 0);

            discardPileView.setVisuals(boardPane, 968, 107, 67, 89, 10, 0);
            deckView.setVisuals(boardPane, 1080, 105, 67, 89, 10, 0);
            handView.setVisuals(boardPane, 357, 587, 594, 80, 10, 0);
            handView.setVisible(false);

            passButton.setVisible(false);
        }
    }

    public void initializeInfo() {
        AnchorPane playerDataPane = new AnchorPane();
        playerDataPane.setPrefSize(190, 80);
        playerDataPane.setStyle("-fx-background-color: rgba(0, 0, 0, 0.5); -fx-border-color: black; -fx-border-width: 2; -fx-padding: 10;");

        //Label playerNickName = new Label(player.getUser().getNickName());
        Label playerNickName = new Label("Player 1");
        playerNickName.setPrefSize(90, 17);
        playerNickName.setStyle("-fx-text-fill: #f8b864; -fx-font-size: 18;");

        Label factionName = new Label(player.getFaction().getName());
        factionName.setPrefSize(90, 17);

        ImageView cardCountIcon = new ImageView(Icons.CARD_COUNT.getImage());
        cardCountIcon.setFitWidth(17);
        cardCountIcon.setFitHeight(23);

        handCardsCountLabel.setPrefSize(20, 20);
        handCardsCountLabel.setStyle("-fx-text-fill: #f8b864; -fx-font-size: 18;");
        handCardsCountLabel.setText(Integer.toString(player.getHand().size()));

        ImageView healthIcon1 = new ImageView(Items.GEM_ON.getImage());
        healthIcon1.setFitWidth(20);
        healthIcon1.setFitHeight(20);

        ImageView healthIcon2 = new ImageView(Items.GEM_ON.getImage());
        healthIcon2.setFitWidth(20);
        healthIcon2.setFitHeight(20);

        if (playerNumber == 1) {
            leaderView.setLayoutX(90);
            leaderView.setLayoutY(585);
            boardPane.getChildren().add(leaderView);

            factionView.setLayoutX(80);
            factionView.setLayoutY(20);
            boardPane.getChildren().add(factionView);

            playerDataPane.setLayoutX(45);
            playerDataPane.setLayoutY(470);

            playerNickName.setLayoutX(80);
            playerNickName.setLayoutY(5);

            factionName.setLayoutX(80);
            factionName.setLayoutY(25);

            cardCountIcon.setLayoutX(80);
            cardCountIcon.setLayoutY(50);

            handCardsCountLabel.setLayoutX(100);
            handCardsCountLabel.setLayoutY(50);

            healthIcon1.setLayoutX(135);
            healthIcon1.setLayoutY(50);

            healthIcon2.setLayoutX(160);
            healthIcon2.setLayoutY(50);

        } else {
            leaderView.setLayoutX(90);
            leaderView.setLayoutY(110);
            boardPane.getChildren().add(leaderView);

            factionView.setLayoutX(20);
            factionView.setLayoutY(10);
            boardPane.getChildren().add(factionView);

            playerDataPane.setLayoutX(45);
            playerDataPane.setLayoutY(215);

            playerNickName.setLayoutX(80);
            playerNickName.setLayoutY(5);

            factionName.setLayoutX(80);
            factionName.setLayoutY(25);

            cardCountIcon.setLayoutX(80);
            cardCountIcon.setLayoutY(50);

            handCardsCountLabel.setLayoutX(100);
            handCardsCountLabel.setLayoutY(50);

            healthIcon1.setLayoutX(135);
            healthIcon1.setLayoutY(50);

            healthIcon2.setLayoutX(160);
            healthIcon2.setLayoutY(50);

        }
        boardPane.getChildren().add(playerDataPane);
        playerDataPane.getChildren().addAll(factionView, playerNickName, factionName, cardCountIcon, handCardsCountLabel, healthIcon1, healthIcon2);

    }

    public void initializeScoreLabels() {
        currentScoreLabel.setPrefSize(31, 38);
        currentScoreLabel.setStyle("-fx-text-fill: #000000; -fx-font-size: 16; -fx-font-weight: bold; -fx-alignment: center;");

        scoreLabels[0].setPrefSize(31, 38);
        scoreLabels[0].setStyle("-fx-text-fill: #000000; -fx-font-size: 16; -fx-font-weight: bold; -fx-alignment: center;");
        scoreLabels[1].setPrefSize(31, 38);
        scoreLabels[1].setStyle("-fx-text-fill: #000000; -fx-font-size: 16; -fx-font-weight: bold; -fx-alignment: center;");
        scoreLabels[2].setPrefSize(31, 38);
        scoreLabels[2].setStyle("-fx-text-fill: #000000; -fx-font-size: 16; -fx-font-weight: bold; -fx-alignment: center;");

        if (playerNumber == 1) {
            currentScoreLabel.setLayoutX(267);
            currentScoreLabel.setLayoutY(501);

            scoreLabels[0].setLayoutX(319);
            scoreLabels[0].setLayoutY(350);

            scoreLabels[1].setLayoutX(319);
            scoreLabels[1].setLayoutY(434);

            scoreLabels[2].setLayoutX(319);
            scoreLabels[2].setLayoutY(520);

        } else {
            currentScoreLabel.setLayoutX(267);
            currentScoreLabel.setLayoutY(250);

            scoreLabels[0].setLayoutX(319);
            scoreLabels[0].setLayoutY(258);

            scoreLabels[1].setLayoutX(319);
            scoreLabels[1].setLayoutY(171);

            scoreLabels[2].setLayoutX(319);
            scoreLabels[2].setLayoutY(90);
        }
        boardPane.getChildren().addAll(currentScoreLabel, scoreLabels[0], scoreLabels[1], scoreLabels[2]);

    }
}
