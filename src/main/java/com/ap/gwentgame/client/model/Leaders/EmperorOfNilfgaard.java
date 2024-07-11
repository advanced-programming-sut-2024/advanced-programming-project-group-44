package com.ap.gwentgame.client.model.Leaders;

import com.ap.gwentgame.client.enums.FactionType;
import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import com.ap.gwentgame.client.model.gameElementViews.PlayerView;
import com.ap.gwentgame.client.model.gameElements.Leader;

public class EmperorOfNilfgaard extends Leader {
    public EmperorOfNilfgaard(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(BoardView boardView, int index) {
        PlayerView opponentView = boardView.getAgainstPlayerView();
        opponentView.getLeaderView().setItem(null);
    }


}
