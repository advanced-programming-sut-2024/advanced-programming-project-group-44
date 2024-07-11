package com.ap.gwentgame.client.model.Abilities;

import com.ap.gwentgame.client.enums.UnitCardData;
import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import com.ap.gwentgame.client.model.gameElementViews.CardView;

public class Transformers extends Ability {
    @Override
    public void run(BoardView boardView, int index, CardView cardView) {
       cardView.setItem(UnitCardData.KAYRAN.getUnitCard());
       cardView.initializeGraphic();
    }

}
