package com.ap.gwentgame.client.controller.model.Abilities;

import com.ap.gwentgame.client.controller.model.Cards.Card;
import com.ap.gwentgame.client.controller.model.Game.Board;
import com.ap.gwentgame.client.controller.model.Game.Player;

import java.util.ArrayList;

public class Mardroeme extends Ability {

    public Mardroeme(Card card) {
        super(card);
    }

    @Override
    public void run(Board board) {
        Player player = board.getCurrentPlayer();
        int row = card.getPlacement().getRow();
        for(Card targetCard : player.getRows()[row].getItems()){
            if(targetCard.getAbility() instanceof Berserker){
                //TODO khersesh kon
            }
        }
    }
    @Override
    public void stop(Board board) {

    }
}
