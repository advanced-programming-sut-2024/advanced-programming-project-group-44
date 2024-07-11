package com.ap.gwentgame.client.model.Leaders;

import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import com.ap.gwentgame.client.model.gameElementViews.CardView;
import com.ap.gwentgame.client.model.gameElementViews.PlayerView;
import com.ap.gwentgame.client.model.gameElements.Board;
import com.ap.gwentgame.client.model.gameElements.Card;
import com.ap.gwentgame.client.model.gameElements.Leader;
import com.ap.gwentgame.view.ViewUtilities;

import java.util.ArrayList;
import java.util.Collections;

public class HisImperialMajesty extends Leader {
    public HisImperialMajesty(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(BoardView boardView, int index) {
        int indexCard1 = index % 100;
        index = index/100;
        int indexCard2 = index % 100;
        index = index/100;
        int indexCard3 = index % 100;
        PlayerView opponent = boardView.getOpponentPlayer();
        ArrayList<CardView> handCardsOpponent = opponent.getHandView().getCardViews();
        CardView cardView1 = handCardsOpponent.get(indexCard1);
        CardView cardView2 = handCardsOpponent.get(indexCard2);
        CardView cardView3 = handCardsOpponent.get(indexCard3);

    }
}
