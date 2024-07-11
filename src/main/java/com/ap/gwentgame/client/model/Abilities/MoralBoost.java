package com.ap.gwentgame.client.model.Abilities;

import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import com.ap.gwentgame.client.model.gameElementViews.CardView;
import com.ap.gwentgame.client.model.gameElementViews.PlayerView;
import com.ap.gwentgame.client.model.gameElementViews.UnitCardView;
import com.ap.gwentgame.client.model.gameElements.Card;
import com.ap.gwentgame.client.model.gameElements.UnitCard;

public class MoralBoost extends Ability{
    @Override
    public void run(BoardView boardView, int index, CardView cardView) {
        Card card = ((Card)cardView.getItem());
        PlayerView playerView = boardView.getCurrentPlayer();
        int row = card.getPlacement().getRow();
        for(CardView targetCardView : playerView.getRowViews()[row].getCardViews()){
            if (targetCardView instanceof UnitCardView unitcardView
                    && targetCardView.getItem() != card){
                unitcardView.setScore(((UnitCard)unitcardView.getItem()).getScore() + 1);
            }
        }
    }
}
