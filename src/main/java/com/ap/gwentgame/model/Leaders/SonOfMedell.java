package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.Utilities;
import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Cards.UnitCard;
import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.Game.Player;

import java.io.UTFDataFormatException;

public class SonOfMedell extends Leader {
    public SonOfMedell(String name) {
        super(name);
    }

    @Override
    public void executeAbility(Board board) {
        Player opponent = board.getOpponentPlayer();
        int score = Utilities.calculateScoreOfRowNotHero(opponent , 1);
        int maxScore = Utilities.calculateMaxScoreOfRowNotHero(opponent , 1);
        if (score >= 10) {
            for (Card card : opponent.getRows()[1]) {
                if (card instanceof UnitCard && !((UnitCard) card).isHero()
                        && ((UnitCard) card).getScore() == maxScore) {
                    opponent.addCardToDiscardPile(card, 1);
                }
            }
        }
    }
}
