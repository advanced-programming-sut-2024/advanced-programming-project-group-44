package com.ap.gwentgame.client.model.Leaders;

import com.ap.gwentgame.client.enums.FactionType;
import com.ap.gwentgame.client.model.Cards.Card;
import com.ap.gwentgame.client.model.Cards.UnitCard;
import com.ap.gwentgame.client.model.Game.Board;
import com.ap.gwentgame.client.model.Game.Player;

public class BringerOfDeath extends Leader {
    public BringerOfDeath(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(Board board) {
        Player player = board.getCurrentPlayer();
        //TODO check the row & check if it also happens for the opponent
        for(Card card : player.getRows()[0].getItems()){
            if(card instanceof UnitCard && !(card.getName().contains("commander'sHorn")) &&
                    !((UnitCard) card).isHero()){
                ((UnitCard) card).setScore(((UnitCard) card).getScore() * 2);
            }
        }
    }
}
