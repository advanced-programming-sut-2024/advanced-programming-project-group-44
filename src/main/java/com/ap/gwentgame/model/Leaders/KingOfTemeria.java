package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.model.Abilities.CommandersHorn;
import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Cards.UnitCard;
import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.Game.Player;
import javafx.scene.layout.Pane;

public class KingOfTemeria extends Leader{
    public KingOfTemeria(String name){
        super(name);
    }

    @Override
    public void executeAbility(Board board){
        Player player = board.getCurrentPlayer();
        //TODO check the row & check if it also happens for the opponent
        for(Card card : player.getRows()[2]){
            if(card instanceof UnitCard && !(card.getName().contains("commander'sHorn")) &&
                    !((UnitCard) card).isHero()){
                ((UnitCard) card).setScore(((UnitCard) card).getScore() * 2);
            }
        }
    }
}
