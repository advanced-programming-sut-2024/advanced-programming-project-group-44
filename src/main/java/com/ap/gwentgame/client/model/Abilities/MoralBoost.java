package com.ap.gwentgame.client.model.Abilities;

import com.ap.gwentgame.client.model.Cards.Card;
import com.ap.gwentgame.client.model.Cards.UnitCard;
import com.ap.gwentgame.client.model.Game.Board;
import com.ap.gwentgame.client.model.Game.Player;

public class MoralBoost extends Ability{

    public MoralBoost(Card card) {
        super(card);
    }

    @Override
    public void run(Board board) {
        Player player = board.getCurrentPlayer();
        int row = card.getPlacement().getRow();
        for(Card targetCard : player.getRows()[row].getItems()){
            if (targetCard instanceof UnitCard unitcard && targetCard != card){
                unitcard.setScore(unitcard.getScore() + 1);
            }
        }
    }
    @Override
    public void stop(Board board) {

    }
}
