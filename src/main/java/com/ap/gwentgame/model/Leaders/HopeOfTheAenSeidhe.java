package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.model.gameElementViews.BoardView;
import com.ap.gwentgame.model.gameElementViews.CardView;
import com.ap.gwentgame.model.gameElementViews.PlayerView;
import com.ap.gwentgame.model.gameElements.Board;
import com.ap.gwentgame.model.gameElements.Card;
import com.ap.gwentgame.model.gameElements.Leader;

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
        /*TODO hmmm?
        Card card = choosenCard...
        player.getRows()[i].remove(card);
        player.getRows()[j].add(card);*/
    }

}
