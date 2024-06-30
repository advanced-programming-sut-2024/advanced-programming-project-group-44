package com.ap.gwentgame.model.Abilities;

import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.Game.Player;

import java.util.ArrayList;

public class Mardroeme extends Ability {

    public Mardroeme(Card card) {
        super(card);
    }

    @Override
    public void run(Board board) {
        Player player = board.getCurrentPlayer();
        int row = card.getPlacement().getRow();
        for(Card targetCard : player.getRows()[row]){
            if(targetCard.getAbility() instanceof Berserker){
                //TODO khersesh kon
            }
        }
    }
}
