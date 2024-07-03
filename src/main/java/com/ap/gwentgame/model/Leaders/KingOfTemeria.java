package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Cards.UnitCard;
import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.Game.Player;

public class KingOfTemeria extends Leader{
    public KingOfTemeria(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(Board board){
        Player player = board.getCurrentPlayer();
        //TODO check the row & check if it also happens for the opponent
        for(Card card : player.getRows()[2].getItems()){
            if(card instanceof UnitCard && !(card.getName().contains("commander'sHorn")) &&
                    !((UnitCard) card).isHero()){
                ((UnitCard) card).setScore(((UnitCard) card).getScore() * 2);
            }
        }
    }
}
