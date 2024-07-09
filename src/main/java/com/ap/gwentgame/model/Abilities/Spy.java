package com.ap.gwentgame.model.Abilities;

import com.ap.gwentgame.model.gameElementViews.BoardView;
import com.ap.gwentgame.model.gameElementViews.CardView;
import com.ap.gwentgame.model.gameElementViews.PlayerView;
import com.ap.gwentgame.model.gameElements.Card;
import com.ap.gwentgame.model.gameElements.Board;
import com.ap.gwentgame.view.ViewUtilities;

import java.util.ArrayList;
import java.util.Random;

public class Spy extends Ability{
    public Spy(Card card) {
        super(card);
    }

    @Override
    public void run(BoardView boardView, int index) {
        PlayerView playerView = boardView.getCurrentPlayer();
        ArrayList<CardView> deckView = playerView.getDeckView().getCardViews();
        CardView randomCardView = getRandomCard(deckView);
        ViewUtilities.changeCardContainer(boardView.getGamePane() , playerView.getDeckView() , playerView.getHandView() , randomCardView);
        //TODO run its ability
    }
    public static CardView getRandomCard(ArrayList<CardView> list) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }

}
