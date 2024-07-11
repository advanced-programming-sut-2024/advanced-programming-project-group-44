package com.ap.gwentgame.client.model.Abilities;

import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import com.ap.gwentgame.client.model.gameElementViews.CardView;
import com.ap.gwentgame.client.model.gameElementViews.PlayerView;
import com.ap.gwentgame.client.model.gameElements.Card;
import com.ap.gwentgame.client.view.ViewUtilities;

import java.util.ArrayList;

public class Medic extends Ability {
    @Override
    public void run(BoardView boardView, int index, Card card) {
        PlayerView playerView = boardView.getCurrentPlayer();
        ArrayList<CardView> discardCardsView = playerView.getDiscardPileView().getCardViews();
        CardView chosenCardView = discardCardsView.get(index);
        ViewUtilities.changeCardContainer(false, boardView, playerView.getDeckView(), playerView.getHandView(), chosenCardView);
    }
}
