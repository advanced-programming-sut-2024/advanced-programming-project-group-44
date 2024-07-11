package com.ap.gwentgame.model.Abilities;

import com.ap.gwentgame.model.gameElementViews.BoardView;
import com.ap.gwentgame.model.gameElementViews.CardView;
import com.ap.gwentgame.model.gameElementViews.PlayerView;
import com.ap.gwentgame.model.gameElementViews.UnitCardView;
import com.ap.gwentgame.model.gameElements.Card;
import com.ap.gwentgame.model.gameElements.Board;

public class Mardroeme extends Ability {

    public Mardroeme(Card card) {
        super(card);
    }

    @Override
    public void run(BoardView boardView, int index) {
        PlayerView player = boardView.getCurrentPlayer();
        int row = card.getPlacement().getRow();
        for(CardView targetCardView : player.getRowViews()[row].getCardViews()){
            if(((Card)targetCardView.getItem()).getAbility() instanceof Berserker){
                //TODO khersesh kon
            }
        }
    }


}
