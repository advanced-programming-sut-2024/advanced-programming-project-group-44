package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.controller.Utilities;
import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Cards.UnitCard;
import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.Game.Player;

public class QueenOfDolBlathanna extends Leader{
    public QueenOfDolBlathanna(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(Board board){
        Player opponent = board.getOpponentPlayer();
        int score = Utilities.calculateScoreOfRowNotHero(opponent , 0);
        if(score >= 10){
            int maxScore = Utilities.calculateMaxScoreOfRowNotHero(opponent, 1);
            for (Card card : opponent.getRows()[1].getItems()) {
                if (card instanceof UnitCard && !((UnitCard) card).isHero()
                        && ((UnitCard) card).getScore() == maxScore) {
                    opponent.changeContainer(opponent.getRows()[1] , opponent.getDiscardPile() , card);
                    //opponent.addCardToDiscardPile(card, 1);
                }
            }
        }
    }
}
