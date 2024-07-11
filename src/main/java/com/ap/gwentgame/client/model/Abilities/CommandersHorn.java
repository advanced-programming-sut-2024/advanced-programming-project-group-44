package com.ap.gwentgame.client.model.Abilities;

import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import com.ap.gwentgame.client.model.gameElementViews.PlayerView;
import com.ap.gwentgame.client.model.gameElements.Card;
import com.ap.gwentgame.client.model.gameElements.UnitCard;

public class CommandersHorn extends Ability{
    @Override
    public void run(BoardView boardView, int index, Card card) {

        PlayerView player = boardView.getCurrentPlayer();
        int row = card.getPlacement().getRow();
        for(Card targetCard : player.getRowViews()[row].getCards()){
            if (targetCard instanceof UnitCard){
                if(!((UnitCard) targetCard).isHero() && targetCard != card){
                    UnitCard unitcard = ((UnitCard) targetCard);
                    unitcard.setScore(unitcard.getScore() * 2);
                }
            }
        }
    }

}
