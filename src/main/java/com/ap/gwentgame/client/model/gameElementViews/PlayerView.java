package com.ap.gwentgame.client.model.gameElementViews;

import com.ap.gwentgame.client.enums.Placement;
import com.ap.gwentgame.client.enums.assets.Icons;
import com.ap.gwentgame.client.enums.assets.Items;
import com.ap.gwentgame.client.model.Abilities.Spy;
import com.ap.gwentgame.client.model.Session;
import com.ap.gwentgame.client.model.gameElements.*;
import com.ap.gwentgame.client.view.ViewUtilities;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.HashMap;

public class PlayerView {
    private final Player player;
    private final int playerNumber;
    private final BoardView boardView;
    private final AnchorPane gamePane;

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

    private final ArrayList<CardViewContainer<? extends CardView, ? extends Card>> selectableContainers;

    public PlayerView(Player player, int playerNumber, BoardView boardView) {
        this.player = player;
        this.playerNumber = playerNumber;
        this.boardView = boardView;
        this.gamePane = boardView.getGamePane();

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

        this.selectableContainers = new ArrayList<>();
    }

    public Player getPlayer() {
        return player;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void initializePlayerView() {
        selectableContainers.add(boardView.getWeatherCards());
        selectableContainers.add(rowViews[0]);
        selectableContainers.add(rowViews[1]);
        selectableContainers.add(rowViews[2]);
        selectableContainers.add(specialCardViews[0]);
        selectableContainers.add(specialCardViews[1]);
        selectableContainers.add(specialCardViews[2]);

        initializeContainers();
        initializeInfo();
        initializeScoreLabels();
        initializeControls();
        initializeClickables();
    }

    public void initializeContainers() {
        if (isLocalPlayer()) {
            rowViews[0].setVisuals(gamePane, 440, 329, 508, 80, 10, 0);
            rowViews[1].setVisuals(gamePane, 440, 410, 508, 80, 10, 0);
            rowViews[2].setVisuals(gamePane, 440, 496, 508, 80, 10, 0);

            specialCardViews[0].setVisuals(gamePane, 358, 329, 80, 80, 10, 0);
            specialCardViews[1].setVisuals(gamePane, 358, 410, 80, 80, 10, 0);
            specialCardViews[2].setVisuals(gamePane, 358, 496, 80, 80, 10, 0);
        } else {
            rowViews[0].setVisuals(gamePane, 440, 234, 508, 80, 10, 0);
            rowViews[1].setVisuals(gamePane, 440, 148, 508, 80, 10, 0);
            rowViews[2].setVisuals(gamePane, 440, 68, 508, 80, 10, 0);

            specialCardViews[0].setVisuals(gamePane, 358, 234, 80, 80, 10, 0);
            specialCardViews[1].setVisuals(gamePane, 358, 148, 80, 80, 10, 0);
            specialCardViews[2].setVisuals(gamePane, 358, 68, 80, 80, 10, 0);
        }
    }

    public void initializeControls() {
        if (isLocalPlayer()) {
            discardPileView.setVisuals(gamePane, 968, 580, 67, 89, 10, 0);
            deckView.setVisuals(gamePane, 1080, 580, 67, 89, 10, 0);
            handView.setVisuals(gamePane, 357, 587, 594, 80, 10, 0);
            Button passButton = new Button("PASS");
            passButton.setPrefSize(50, 25);
            passButton.setLayoutX(210);
            passButton.setLayoutY(615);
        }
    }

    public void initializeClickables() {
        if (isLocalPlayer() && this == boardView.getCurrentPlayerView()) {
            for (CardView cardView : handView.getCardViews()) {
                cardView.setCursor(Cursor.HAND);
                cardView.setOnMouseClicked(event -> {
                    setCardHighlights(cardView);
                });
            }

            gamePane.setOnMouseClicked(event -> {
                if (event.getTarget() instanceof CardViewContainer<?,?>) {
                    deActivateAllContainers();
                }
            });
        } else if (isLocalPlayer()) {
            for (CardView cardView : handView.getCardViews()) {
                cardView.setCursor(Cursor.NONE);
                cardView.setOnMouseClicked(null);
            }
        }
    }

    private void setCardHighlights(CardView cardView) {
        PlayerView opponentPlayerView = boardView.getOpponentPlayerView();
        deActivateAllContainers();

        Card card = (Card) cardView.getItem();
        Placement placement = card.getPlacement();
        switch (placement) {
            case Placement.WEATHER -> {
                activateContainer(boardView.getWeatherCards());
            }

            case Placement.CLOSE_COMBAT -> {
                if (card.getAbility() instanceof Spy) {
                    activateContainer(opponentPlayerView.getRowViews()[0]);
                } else {
                    activateContainer(rowViews[0]);
                }
            }

            case Placement.RANGED_COMBAT -> {
                if (card.getAbility() instanceof Spy) {
                    activateContainer(opponentPlayerView.getRowViews()[1]);
                } else {
                    activateContainer(rowViews[1]);
                }
            }

            case Placement.SIEGE -> {
                if (card.getAbility() instanceof Spy) {
                    activateContainer(opponentPlayerView.getRowViews()[2]);
                } else {
                    activateContainer(rowViews[2]);
                }
            }

            case Placement.AGILE -> {
                activateContainer(rowViews[0]);
                activateContainer(rowViews[1]);
            }

            case Placement.SPECIAL_PLACE -> {
                activateContainer(specialCardViews[0]);
                activateContainer(specialCardViews[1]);
                activateContainer(specialCardViews[2]);
            }

            case Placement.DECOY -> {
                for (CardViewContainer<? extends CardView, ? extends Card> container : selectableContainers) {
                    activateContainer(container);
                }
            }
        }
    }

    private void deActivateAllContainers() {
        PlayerView opponentPlayerView = boardView.getOpponentPlayerView();
        ArrayList<CardViewContainer<? extends CardView, ? extends Card>> opponentSelectableContainers = opponentPlayerView.getSelectableContainers();

        for (CardViewContainer<? extends CardView, ? extends Card> container : selectableContainers) {
            deactivateContainer(container);
        }

        for (CardViewContainer<? extends CardView, ? extends Card> container : opponentSelectableContainers) {
            deactivateContainer(container);
        }
    }

    private void activateContainer(CardViewContainer<? extends CardView, ? extends Card> container) {
        container.setCursor(Cursor.HAND);
        container.setStyle("-fx-background-color: rgba(200, 150, 50, 0.5);");
    }

    private void deactivateContainer(CardViewContainer<? extends CardView, ? extends Card> container) {
        container.setCursor(Cursor.DEFAULT);
        container.setStyle("-fx-background-color: transparent;");
    }

    public void initializeInfo() {
        AnchorPane playerDataPane = new AnchorPane();
        playerDataPane.setPrefSize(190, 80);
        playerDataPane.setStyle("-fx-background-color: rgba(0, 0, 0, 0.5); -fx-border-color: black; -fx-border-width: 2; -fx-padding: 10;");

        Label playerNickName = new Label("Player 1");
        playerNickName.setPrefSize(90, 17);
        playerNickName.setStyle("-fx-text-fill: #f8b864; -fx-font-size: 18;");

        Label factionName = new Label(player.getFaction().getName());
        factionName.setPrefSize(90, 17);

        ImageView cardCountIcon = new ImageView(Icons.CARD_COUNT.getImage());
        cardCountIcon.setFitWidth(17);
        cardCountIcon.setFitHeight(23);

        handCardsCountLabel.setPrefSize(30, 20);
        handCardsCountLabel.setStyle("-fx-text-fill: #f8b864; -fx-font-size: 18;");
        handCardsCountLabel.setText(Integer.toString(player.getHand().size()));

        ImageView healthIcon1 = new ImageView(Items.GEM_ON.getImage());
        healthIcon1.setFitWidth(20);
        healthIcon1.setFitHeight(20);

        ImageView healthIcon2 = new ImageView(Items.GEM_ON.getImage());
        healthIcon2.setFitWidth(20);
        healthIcon2.setFitHeight(20);

        if (isLocalPlayer()) {
            leaderView.setLayoutX(90);
            leaderView.setLayoutY(585);
            gamePane.getChildren().add(leaderView);

            factionView.setLayoutX(18);
            factionView.setLayoutY(10);
            gamePane.getChildren().add(factionView);

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
            gamePane.getChildren().add(leaderView);

            factionView.setLayoutX(18);
            factionView.setLayoutY(10);
            gamePane.getChildren().add(factionView);

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
        gamePane.getChildren().add(playerDataPane);
        playerDataPane.getChildren().addAll(factionView, playerNickName, factionName, cardCountIcon, handCardsCountLabel, healthIcon1, healthIcon2);

    }

    public void initializeScoreLabels() {
        currentScoreLabel.setPrefSize(31, 38);
        currentScoreLabel.setStyle("-fx-text-fill: #000000; -fx-font-size: 16; -fx-font-weight: bold; -fx-alignment: center;");

        for (int i = 0; i < 3; i++) {
            scoreLabels[i].setPrefSize(31, 38);
            scoreLabels[i].setStyle("-fx-text-fill: #000000; -fx-font-size: 16; -fx-font-weight: bold; -fx-alignment: center;");
            scoreLabels[i].setText("0");
        }

        if (isLocalPlayer()) {
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
        gamePane.getChildren().addAll(currentScoreLabel, scoreLabels[0], scoreLabels[1], scoreLabels[2]);
    }

    public void updateScoreLabels() {
        ViewUtilities.changeNumber(currentScoreLabel, player.getCurrentScore());
        for (int i = 0; i < 3; i++) {
            ViewUtilities.changeNumber(scoreLabels[i], player.getRowScore(i));
        }
    }

    public CardViewContainer<CardView, Card> getDeckView() {
        return deckView;
    }

    public CardViewContainer<CardView, Card> getHandView() {
        return handView;
    }

    public CardViewContainer<CardView, Card> getDiscardPileView() {
        return discardPileView;
    }

    public CardViewContainer<CardView, Card>[] getRowViews() {
        return rowViews;
    }

    public CardViewContainer<CardView, Card>[] getSpecialCardViews() {
        return specialCardViews;
    }

    public LeaderView getLeaderView() {
        return leaderView;
    }

    public FactionView getFactionView() {
        return factionView;
    }

    public ArrayList<CardViewContainer<? extends CardView, ? extends Card>> getSelectableContainers() {
        return selectableContainers;
    }

    private boolean isLocalPlayer() {
        return player.getUser().getName().equals(Session.getLoggedInUser().getName());
    }
}
