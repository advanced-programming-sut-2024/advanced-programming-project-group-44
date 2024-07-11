package com.ap.gwentgame.client.model.Leaders;

import com.ap.gwentgame.client.controller.Utilities;
import com.ap.gwentgame.client.enums.FactionType;
import com.ap.gwentgame.client.model.Cards.Card;
import com.ap.gwentgame.client.model.Cards.UnitCard;
import com.ap.gwentgame.client.model.Game.Board;
import com.ap.gwentgame.client.model.Game.Player;

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
            for (Card card : opponent.getRows()[2].getItems()) {
                if (card instanceof UnitCard && !((UnitCard) card).isHero()
                        && ((UnitCard) card).getScore() == maxScore) {
                    opponent.changeContainer(opponent.getRows()[2] , opponent.getDiscardPile() , card);
                    //opponent.addCardToDiscardPile(card, 2);
                }
            }
        }
    }
}
