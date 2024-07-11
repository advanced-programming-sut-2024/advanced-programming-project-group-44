package com.ap.gwentgame.client.model.Leaders;

import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.client.model.Abilities.Spy;
import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import com.ap.gwentgame.client.model.gameElementViews.CardView;
import com.ap.gwentgame.client.model.gameElementViews.PlayerView;
import com.ap.gwentgame.client.model.gameElementViews.UnitCardView;
import com.ap.gwentgame.client.model.gameElements.*;

public class TheTreacherous extends Leader {
    public TheTreacherous(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(BoardView boardView, int index) {
        PlayerView playerView = boardView.getCurrentPlayer();
        PlayerView opponentView = boardView.getOpponentPlayer();
        doubleSpyPower(playerView);
        doubleSpyPower(opponentView);
    }

    private void doubleSpyPower(PlayerView playerView) {
        for (int i = 0; i < 2; i++) {
            for (CardView cardView : playerView.getRowViews()[i].getCardViews()) {
                if (((Card) cardView.getItem()).getAbility() instanceof Spy) {
                    Card card = (Card) cardView.getItem();
                    if (card instanceof UnitCard) {
                        ((UnitCardView) cardView).setScore(((UnitCard) card).getScore() * 2);
                    }
                }
            }
        }
    }
}
