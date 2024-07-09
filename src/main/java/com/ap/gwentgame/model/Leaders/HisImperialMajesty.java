package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.model.gameElementViews.BoardView;
import com.ap.gwentgame.model.gameElementViews.CardView;
import com.ap.gwentgame.model.gameElementViews.PlayerView;
import com.ap.gwentgame.model.gameElements.Board;
import com.ap.gwentgame.model.gameElements.Leader;

import java.util.ArrayList;
import java.util.Collections;

public class HisImperialMajesty extends Leader {
    public HisImperialMajesty(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(BoardView boardView, int index) {
        PlayerView opponent = boardView.getOpponentPlayer();
        ArrayList<CardView> handCardsOpponent = opponent.getHandView().getCardViews();
        int handCardsOpponentNum = handCardsOpponent.size();
        ArrayList<CardView> randomCards;
        if (handCardsOpponentNum < 4) randomCards = getRandomCards(handCardsOpponent.getItems(), handCardsOpponentNum);
        else randomCards = getRandomCards(handCardsOpponent.getItems(), 3);
        //TODO show them to the player

    }

    public static ArrayList<Card> getRandomCards(ArrayList<Card> list, int numberOfCards) {
        if (numberOfCards > list.size()) {
            throw new IllegalArgumentException("Number of cards requested exceeds the size of the list");
        }
        ArrayList<Card> copy = new ArrayList<>(list);
        Collections.shuffle(copy);
        ArrayList<Card> result = new ArrayList<>();
        for (int i = 0; i < numberOfCards; i++) {
            result.add(copy.get(i));
        }
        return result;
    }
}


}
