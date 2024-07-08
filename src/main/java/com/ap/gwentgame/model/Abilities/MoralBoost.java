package com.ap.gwentgame.model.Abilities;

import com.ap.gwentgame.model.gameElementViews.BoardView;
import com.ap.gwentgame.model.gameElementViews.CardView;
import com.ap.gwentgame.model.gameElementViews.PlayerView;
import com.ap.gwentgame.model.gameElements.Card;
import com.ap.gwentgame.model.gameElements.Board;
import com.ap.gwentgame.model.gameElements.UnitCard;

public class MoralBoost extends Ability{

    public MoralBoost(Card card) {
        super(card);
    }

    @Override
    public void run(BoardView boardView, int index) {
        PlayerView playerView = boardView.getCurrentPlayer();
        int row = card.getPlacement().getRow();
        for(CardView targetCardView : playerView.getRowViews()[row].getCardViews()){
            if (targetCardView.getItem() instanceof UnitCard unitcard && targetCardView.getItem() != card){
                unitcard.setScore(unitcard.getScore() + 1);
                //TODO ??????????
            }
        }
    }
}
