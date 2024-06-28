package com.ap.gwentgame.model.Abilities;

import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Cards.UnitCard;
import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.Game.Player;

public class TightBond extends Ability {
    public TightBond(Card card) {
        super(card);
    }

    @Override
    public void run(Board board) {
        Player player = board.getCurrentPlayer();
        int row = card.getPlacement().getRow();
        int countOfTightBondCards = 0;
        for (Card targetCard : player.getRows()[row]) {
            if (targetCard.getAbility() instanceof TightBond) {
                countOfTightBondCards++;
            }
        }
        int newScoreForTightBondCards = countOfTightBondCards * ((UnitCard) card).getScore();
        for (Card targetCard : player.getRows()[row]) {
            if (targetCard.getAbility() instanceof TightBond) {
                UnitCard unitcard = ((UnitCard) targetCard);
                unitcard.setScore(newScoreForTightBondCards);
            }
        }
    }
}
