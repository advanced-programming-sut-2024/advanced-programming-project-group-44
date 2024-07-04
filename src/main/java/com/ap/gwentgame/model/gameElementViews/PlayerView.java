package com.ap.gwentgame.model.gameElementViews;

import com.ap.gwentgame.model.gameElements.*;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class PlayerView {
    private final Player player;
    private final int playerNumber;
    private final AnchorPane boardPane;

    private final FactionView factionView;
    private final LeaderView leaderView;
    private final Label currentScoreLabel;
    private final Label handCardsCountLabel;

    private final Label[] scoreLabels = new Label[3];
    private final CardViewContainer<CardView> deckView;
    private final CardViewContainer<CardView> handView;
    private final CardViewContainer<CardView> discardPileView;
    private final CardViewContainer<CardView>[] rowViews;
    private final CardViewContainer<CardView>[] specialCardViews;

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
        }
    }
}
