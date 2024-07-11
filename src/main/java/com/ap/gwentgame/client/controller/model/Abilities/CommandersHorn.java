package com.ap.gwentgame.client.controller.model.Abilities;

import com.ap.gwentgame.client.controller.model.Cards.Card;
import com.ap.gwentgame.client.controller.model.Cards.UnitCard;
import com.ap.gwentgame.client.controller.model.Game.Board;
import com.ap.gwentgame.client.controller.model.Game.Player;

public class CommandersHorn extends Ability{
    public CommandersHorn(Card card) {
        super(card);
    }

    @Override
    public void run(Board board) {
        Player player = board.getCurrentPlayer();
        int row = card.getPlacement().getRow();
        for(Card targetCard : player.getRows()[row].getItems()){
            if (targetCard instanceof UnitCard){
                if(!((UnitCard) targetCard).isHero() && targetCard != card){
                    UnitCard unitcard = ((UnitCard) targetCard);
                    unitcard.setScore(unitcard.getScore() * 2);
                }
            }
        }
        //TODO do barabar kardan harkarti ke badesh too oon radif miad
    }
    @Override
    public void stop(Board board) {

    }
}
