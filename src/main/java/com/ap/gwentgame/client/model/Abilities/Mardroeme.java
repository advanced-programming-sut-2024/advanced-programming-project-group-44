package com.ap.gwentgame.client.model.Abilities;

import com.ap.gwentgame.client.enums.UnitCardData;
import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import com.ap.gwentgame.client.model.gameElementViews.CardView;
import com.ap.gwentgame.client.model.gameElementViews.PlayerView;
import com.ap.gwentgame.client.model.gameElements.Card;

public class Mardroeme extends Ability {
    @Override
    public void run(BoardView boardView, int index, CardView cardView) {
        PlayerView player = boardView.getCurrentPlayer();
        int row = ((Card)cardView.getItem()).getPlacement().getRow();
        for (CardView targetCardView : player.getRowViews()[row].getCardViews()) {
            if (((Card) targetCardView.getItem()).getAbility() instanceof Berserker) {
                targetCardView.setItem(UnitCardData.BERSERKER.getUnitCard());
                targetCardView.initializeGraphic();
            }
        }
    }


}
