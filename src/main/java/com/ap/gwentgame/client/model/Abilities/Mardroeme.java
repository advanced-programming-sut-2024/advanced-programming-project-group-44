package com.ap.gwentgame.client.model.Abilities;

import com.ap.gwentgame.client.enums.UnitCardData;
import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import com.ap.gwentgame.client.model.gameElementViews.CardView;
import com.ap.gwentgame.client.model.gameElementViews.PlayerView;
import com.ap.gwentgame.client.model.gameElementViews.UnitCardView;
import com.ap.gwentgame.client.model.gameElements.Card;
import com.ap.gwentgame.client.model.gameElements.UnitCard;

public class Mardroeme extends Ability {
    @Override
    public void run(BoardView boardView, int index, Card card) {
        PlayerView player = boardView.getCurrentPlayer();
        int row = card.getPlacement().getRow();
        for (CardView targetCardView : player.getRowViews()[row].getCardViews()) {
            if (((Card) targetCardView.getItem()).getAbility() instanceof Berserker) {
                targetCardView.setItem(UnitCardData.BERSERKER.getUnitCard());
                targetCardView.initializeGraphic();
            }
        }
    }


}
