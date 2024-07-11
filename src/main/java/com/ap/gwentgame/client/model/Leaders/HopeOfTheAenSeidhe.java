package com.ap.gwentgame.client.model.Leaders;

import com.ap.gwentgame.client.enums.FactionType;
import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import com.ap.gwentgame.client.model.gameElementViews.CardView;
import com.ap.gwentgame.client.model.gameElementViews.PlayerView;
import com.ap.gwentgame.client.model.gameElements.Leader;

import java.util.ArrayList;

public class HopeOfTheAenSeidhe extends Leader {
    public HopeOfTheAenSeidhe(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(BoardView boardView, int index) {
        PlayerView player = boardView.getCurrentPlayer();
        ArrayList<CardView> agileCardViews = player.getRowViews()[0].getCardViews();
        agileCardViews.addAll(player.getRowViews()[1].getCardViews());
    }

}
