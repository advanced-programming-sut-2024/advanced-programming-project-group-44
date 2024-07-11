package com.ap.gwentgame.client.model.gameElementViews;

import com.ap.gwentgame.client.controller.RequestSender;
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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PlayerView {
    private final Player player;
    private final int playerNumber;
    private final BoardView boardView;
    private final AnchorPane gamePane;

    private final Button passButton;
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
    private final PlayerView otherPlayerView;

    private CardView selectedCardView;

    public PlayerView(Player player, int playerNumber, BoardView boardView) {
        this.player = player;
        this.playerNumber = playerNumber;
        this.boardView = boardView;
        this.gamePane = boardView.getGamePane();

        this.passButton = new Button("PASS");

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
        otherPlayerView = this.equals(boardView.getPlayer1View()) ? boardView.getPlayer2View() : boardView.getPlayer1View();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        PlayerView playerView = (PlayerView) obj;
        return player.getUser().getName().equals(playerView.player.getUser().getName());
    }

    public Player getPlayer() {
        return player;
    }

    public int getPlayerNumber() {
        return playerNumber;
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

    public boolean isLocalPlayer() {
        return player.getUser().getName().equals(Session.getLoggedInUser().getName());
    }

    public void initializePlayerView() {
        selectableContainers.add(rowViews[0]);
        selectableContainers.add(rowViews[1]);
        selectableContainers.add(rowViews[2]);
        selectableContainers.add(specialCardViews[0]);
        selectableContainers.add(specialCardViews[1]);
        selectableContainers.add(specialCardViews[2]);
        selectableContainers.add(boardView.getWeatherCards());

        initializeContainers();
        initializeInfo();
        initializeScoreLabels();
        if (isLocalPlayer()) {
            initializeControls();
            initializeClickables();
        }
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
        discardPileView.setVisuals(gamePane, 968, 580, 60, 89, 10, 0);
        deckView.setVisuals(gamePane, 1080, 580, 60, 89, -56, 0);
        handView.setVisuals(gamePane, 357, 587, 594, 80, 10, 0);


        /*Timeline timeline = new Timeline();
        double delay = 0;
        Set<Integer> usedIndices = new HashSet<>();
        Random rand = new Random();
        for (int i = 0; i < 9; i++) {
            KeyFrame keyFrame = new KeyFrame(Duration.seconds(delay), event -> {
                int randomIndex;
                do {
                    randomIndex = rand.nextInt(deckView.getCardViews().size());
                } while (usedIndices.contains(randomIndex));
                usedIndices.add(randomIndex);

                CardView cardView = deckView.getCardViews().get(randomIndex);
                ViewUtilities.changeCardContainer(false, boardView, deckView, handView, cardView);
            });
            timeline.getKeyFrames().add(keyFrame);
            delay += 1.1;
        }*/

        for (int i = 0; i < 9; i++) {
            int randomIndex = (int) (Math.random() * deckView.getCardViews().size());
            CardView cardView = deckView.getCardViews().get(randomIndex);
            handView.add(cardView);
            deckView.remove(cardView);
        }


        passButton.setPrefSize(50, 25);
        passButton.setLayoutX(210);
        passButton.setLayoutY(615);
        gamePane.getChildren().add(passButton);
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
        currentScoreLabel.setText("0");

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

    public void initializeClickables() {
        if (this == boardView.getCurrentPlayerView()) {
            for (CardView cardView : handView.getCardViews()) {
                cardView.setCursor(Cursor.HAND);
                cardView.setOnMouseClicked(event -> {
                    setCardHighlights(cardView);
                });
            }

            passButton.setVisible(true);
            passButton.setOnMouseClicked(event -> {
                RequestSender.playPass(player, boardView.getBoard().getID());
            });

        } else {
            for (CardView cardView : handView.getCardViews()) {
                cardView.setCursor(Cursor.DEFAULT);
                cardView.setOnMouseClicked(null);
            }

            passButton.setOnMouseClicked(null);
            passButton.setVisible(false);
        }
    }

    private void setCardHighlights(CardView cardView) {
        deActivateAllContainers();
        selectedCardView = cardView;

        Card card = (Card) cardView.getItem();
        Placement placement = card.getPlacement();

        if (card.getAbility() instanceof Spy) {
            for (int containerIndex : placement.getAllowedContainers()) {
                activateContainer(otherPlayerView.getSelectableContainers().get(containerIndex));
            }
        } else {
            for (int containerIndex : placement.getAllowedContainers()) {
                activateContainer(selectableContainers.get(containerIndex));
            }
        }

        cardView.setOnMouseClicked(event -> {
            deActivateAllContainers();
            cardView.setOnMouseClicked(event2 -> {
                setCardHighlights(cardView);
            });
        });
    }

    private void deActivateAllContainers() {
        selectedCardView = null;

        PlayerView opponentPlayerView = boardView.getAgainstPlayerView();
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
        container.setStyle("-fx-background-color: rgba(200, 150, 50, 0.2);");

        container.setOnMouseClicked(event -> {
            RequestSender.playCard(player, boardView.getBoard().getID(), handView.getCardViews().indexOf(selectedCardView), selectableContainers.indexOf(container), -1);
            deActivateAllContainers();
        });
    }

    private void deactivateContainer(CardViewContainer<? extends CardView, ? extends Card> container) {
        container.setCursor(Cursor.DEFAULT);
        container.setStyle("-fx-background-color: transparent;");
    }

    public void playCard(int cardIndex, int targetContainerIndex, int abilityInput) {
        CardView cardView = handView.getCardViews().get(cardIndex);
        Card card = (Card) cardView.getItem();

        CardViewContainer<?, ?> targetContainer = null;
        if (card.getAbility() instanceof Spy) {
            targetContainer = otherPlayerView.getSelectableContainers().get(targetContainerIndex);
        } else {
            targetContainer = selectableContainers.get(targetContainerIndex);
        }

        if (card.getPlacement() == Placement.DECOY) {
            //TODO
        }

        if (isLocalPlayer()) {
            ViewUtilities.changeCardContainer(false, boardView, handView, targetContainer, cardView);
        } else {
            ViewUtilities.changeCardContainer(true, boardView, handView, targetContainer, cardView);
        }

        card.getPlacement().setRow((targetContainerIndex + 1) % 3);
        card.executeAction(boardView, -1);

        if (!boardView.getAgainstPlayerView().getPlayer().hasPassed()) {
            boardView.changeTurn();
        }
    }

    public void playLeader(int abilityInput) {
        //TODO
    }

    public void playPass() {
        this.getPlayer().setPassed(true);
        boardView.changeTurn();
    }

    public void updateFromBoard(Board updatedBoard) {
        Player updatedPlayer;
        if (this.equals(boardView.getPlayer1View())) {
            updatedPlayer = updatedBoard.getPlayer1();
        } else {
            updatedPlayer = updatedBoard.getPlayer2();
        }

        handView.clear();
        for (Card card : updatedPlayer.getHand()) {
            if (card instanceof UnitCard unitCard) {
                handView.add(new UnitCardView(unitCard));
            } else if (card instanceof WeatherCard weatherCard) {
                handView.add(new WeatherCardView(weatherCard));
            } else if (card instanceof SpecialCard specialCard) {
                handView.add(new SpecialCardView(specialCard));
            }
        }

        deckView.clear();
        for (Card card : updatedPlayer.getDeck()) {
            if (card instanceof UnitCard unitCard) {
                deckView.add(new UnitCardView(unitCard));
            } else if (card instanceof WeatherCard weatherCard) {
                deckView.add(new WeatherCardView(weatherCard));
            } else if (card instanceof SpecialCard specialCard) {
                deckView.add(new SpecialCardView(specialCard));
            }
        }

        discardPileView.clear();
        for (Card card : updatedPlayer.getDiscardPile()) {
            if (card instanceof UnitCard unitCard) {
                deckView.add(new UnitCardView(unitCard));
            } else if (card instanceof WeatherCard weatherCard) {
                deckView.add(new WeatherCardView(weatherCard));
            } else if (card instanceof SpecialCard specialCard) {
                handView.add(new SpecialCardView(specialCard));
            }
        }
    }


}
