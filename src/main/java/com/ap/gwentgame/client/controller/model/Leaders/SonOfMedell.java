package com.ap.gwentgame.client.controller.model.Leaders;

import com.ap.gwentgame.client.controller.Utilities;
import com.ap.gwentgame.client.controller.enums.FactionType;
import com.ap.gwentgame.client.controller.model.Cards.Card;
import com.ap.gwentgame.client.controller.model.Cards.UnitCard;
import com.ap.gwentgame.client.controller.model.Game.Board;
import com.ap.gwentgame.client.controller.model.Game.Player;

public class SonOfMedell extends Leader {
    public SonOfMedell(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(Board board) {
        Player opponent = board.getOpponentPlayer();
        int score = Utilities.calculateScoreOfRowNotHero(opponent , 1);
        int maxScore = Utilities.calculateMaxScoreOfRowNotHero(opponent , 1);
        if (score >= 10) {
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
