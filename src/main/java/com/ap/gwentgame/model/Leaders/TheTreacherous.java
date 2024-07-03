package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.model.Abilities.Spy;
import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Cards.UnitCard;
import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.Game.Player;

public class TheTreacherous extends Leader{
    public TheTreacherous(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(Board board){
        Player player = board.getCurrentPlayer();
        Player opponent = board.getOpponentPlayer();
        doubleSpyPower(player);
        doubleSpyPower(opponent);
    }
    //TODO spy?
    private void doubleSpyPower(Player player) {
        for(int i = 0 ; i < 2 ; i ++){
            for(Card card : player.getRows()[i].getItems()){
                if(card.getAbility() instanceof Spy){
                    if(card instanceof UnitCard){
                        ((UnitCard) card).setScore(((UnitCard) card).getScore() * 2);
                    }
                }
            }
        }
    }

}
