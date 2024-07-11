package com.ap.gwentgame.client.model.Abilities;

import com.ap.gwentgame.client.model.Cards.Card;
import com.ap.gwentgame.client.model.Cards.UnitCard;
import com.ap.gwentgame.client.model.Game.Board;
import com.ap.gwentgame.client.model.Game.Player;
import javafx.beans.binding.BooleanExpression;

public class Scorch extends Ability{
    public Scorch(Card card) {
        super(card);
    }

    @Override
    public void run(Board board) {
        Player opponent = board.getOpponentPlayer();
        int row = card.getPlacement().getRow();
        int scoreOfUnHeroCards = 0;
        int maxScore = 0;
        for (Card targetCard : opponent.getRows()[row].getItems()) {
            if (targetCard instanceof UnitCard){
                if(!((UnitCard) targetCard).isHero()){
                    UnitCard unitcard = ((UnitCard) targetCard);
                    scoreOfUnHeroCards += unitcard.getScore();
                    if(maxScore < unitcard.getScore()) maxScore = unitcard.getScore();
                }
            }
        }
        if(scoreOfUnHeroCards >= 10){
            for (Card targetCard : opponent.getRows()[row].getItems()) {
                if (targetCard instanceof UnitCard){
                    if(!((UnitCard) targetCard).isHero() &&
                            ((UnitCard) targetCard).getScore() == maxScore){
                        UnitCard unitcard = ((UnitCard) targetCard);
                        opponent.changeContainer(opponent.getRows()[row] , opponent.getDiscardPile() , unitcard);
                        //opponent.addCardToDiscardPile(unitcard , row);
                    }
                }
            }
        }
    }
    @Override
    public void stop(Board board) {

    }
}
