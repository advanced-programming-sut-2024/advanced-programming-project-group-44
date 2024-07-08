package com.ap.gwentgame.model.Abilities;

import com.ap.gwentgame.model.gameElementViews.BoardView;
import com.ap.gwentgame.model.gameElementViews.CardView;
import com.ap.gwentgame.model.gameElementViews.PlayerView;
import com.ap.gwentgame.model.gameElements.Card;
import com.ap.gwentgame.model.gameElements.Board;

import java.util.ArrayList;

public class Muster extends Ability{
    public Muster(Card card) {
        super(card);
    }

    @Override
    public void run(BoardView boardView, int index) {
        PlayerView player = boardView.getCurrentPlayer();
        ArrayList<CardView> deckCards = player.getDeckView().getCardViews();
        ArrayList<CardView> handCards = player.getHandView().getCardViews();
    }

}
