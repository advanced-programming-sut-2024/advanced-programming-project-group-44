package com.ap.gwentgame.client.model.Leaders;

import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import com.ap.gwentgame.client.model.gameElementViews.CardView;
import com.ap.gwentgame.client.model.gameElementViews.PlayerView;
import com.ap.gwentgame.client.model.gameElements.Board;
import com.ap.gwentgame.client.model.gameElements.Leader;
import com.ap.gwentgame.view.ViewUtilities;

import java.util.ArrayList;
import java.util.Random;

public class InvaderOfTheNorth extends Leader {
    public InvaderOfTheNorth(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(BoardView boardView, int index) {
        PlayerView player = boardView.getCurrentPlayer();
        PlayerView opponent = boardView.getOpponentPlayer();
        ArrayList<CardView> discardPileOpponent = opponent.getDiscardPileView().getCardViews();
        CardView card = getRandomCard(discardPileOpponent);
        ViewUtilities.changeCardContainer(boardView.getGamePane(), opponent.getDiscardPileView(), opponent.getHandView(), card);
        card = getRandomCard(discardPileOpponent);
        ViewUtilities.changeCardContainer(boardView.getGamePane(), player.getDiscardPileView(), player.getHandView(), card);
    }

    public static CardView getRandomCard(ArrayList<CardView> list) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }
}
