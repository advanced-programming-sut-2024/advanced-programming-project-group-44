package com.ap.gwentgame.client.model.Abilities;

import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import com.ap.gwentgame.client.model.gameElementViews.CardView;
import com.ap.gwentgame.client.model.gameElementViews.PlayerView;
import com.ap.gwentgame.client.model.gameElements.Card;
import com.ap.gwentgame.client.view.ViewUtilities;

import java.util.ArrayList;

public class Medic extends Ability{
    public Medic(Card card) {
        super(card);
    }

    @Override
    public void run(BoardView boardView, int index) {

        PlayerView playerView = boardView.getCurrentPlayer();
        ArrayList<CardView> discardCardsView = playerView.getDiscardPileView().getCardViews();
        CardView chosenCardView = discardCardsView.get(index);
        ViewUtilities.changeCardContainer(boardView.getGamePane() , playerView.getDeckView() , playerView.getHandView() , chosenCardView);
    }
}
