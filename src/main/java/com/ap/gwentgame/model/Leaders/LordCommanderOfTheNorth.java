package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.controller.Utilities;
import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Cards.UnitCard;
import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.Game.Player;

public class LordCommanderOfTheNorth extends Leader {
    public LordCommanderOfTheNorth(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(Board board) {
        Player opponent = board.getOpponentPlayer();
        int score = Utilities.calculateScoreOfRowNotHero(opponent, 2);
        int maxScore = Utilities.calculateMaxScoreOfRowNotHero(opponent, 2);
        if (score >= 10) {
            for (Card card : opponent.getRows()[2]) {
                if (card instanceof UnitCard && !((UnitCard) card).isHero()
                        && ((UnitCard) card).getScore() == maxScore) {
                    opponent.addCardToDiscardPile(card, 2);
                }
            }
        }
    }
}
