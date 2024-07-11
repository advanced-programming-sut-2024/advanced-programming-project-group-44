package com.ap.gwentgame.client.model.Abilities;

import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import com.ap.gwentgame.client.model.gameElementViews.CardView;
import com.ap.gwentgame.client.model.gameElementViews.PlayerView;
import com.ap.gwentgame.client.view.ViewUtilities;

import java.util.ArrayList;
import java.util.Random;

public class Spy extends Ability {
    @Override
    public void run(BoardView boardView, int index, CardView cardView) {
        PlayerView playerView = boardView.getCurrentPlayer();
        ArrayList<CardView> deckView = playerView.getDeckView().getCardViews();
        CardView randomCardView = getRandomCard(deckView);
        ViewUtilities.changeCardContainer(false, boardView, playerView.getDeckView(), playerView.getHandView(), randomCardView);
        deckView = playerView.getDeckView().getCardViews();
        CardView randomCardViewNum2 = getRandomCard(deckView);
        ViewUtilities.changeCardContainer(false, boardView, playerView.getDeckView(), playerView.getHandView(), randomCardViewNum2);
    }

    public static CardView getRandomCard(ArrayList<CardView> list) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }

}
