package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Cards.UnitCard;
import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.Game.Player;

public class SonOfMedell extends Leader {
    public SonOfMedell(String name) {
        super(name);
    }

    @Override
    public void executeAbility(Board board) {
        Player opponent = board.getOpponentPlayer();
        int score = 0;
        int maxScore = 0;
        for (Card card : opponent.getRows()[1]) {
            if (card instanceof UnitCard && !((UnitCard) card).isHero()) {
                score += ((UnitCard) card).getScore();
                if (((UnitCard) card).getScore() > maxScore) maxScore = ((UnitCard) card).getScore();
            }
        }
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
