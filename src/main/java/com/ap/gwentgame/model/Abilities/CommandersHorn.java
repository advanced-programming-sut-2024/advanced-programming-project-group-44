package com.ap.gwentgame.model.Abilities;

import com.ap.gwentgame.model.gameElementViews.BoardView;
import com.ap.gwentgame.model.gameElementViews.PlayerView;
import com.ap.gwentgame.model.gameElements.Card;
import com.ap.gwentgame.model.gameElements.Board;
import com.ap.gwentgame.model.gameElements.UnitCard;

public class CommandersHorn extends Ability{
    public CommandersHorn(Card card) {
        super(card);
    }

    @Override
    public void run(BoardView boardView, int index) {

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
        //TODO do barabar kardan harkarti ke badesh too oon radif miad
    }

}
