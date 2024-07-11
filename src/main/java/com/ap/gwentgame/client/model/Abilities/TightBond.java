package com.ap.gwentgame.client.model.Abilities;

import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import com.ap.gwentgame.client.model.gameElementViews.CardView;
import com.ap.gwentgame.client.model.gameElementViews.PlayerView;
import com.ap.gwentgame.client.model.gameElements.Card;
import com.ap.gwentgame.client.model.gameElements.UnitCard;

public class TightBond extends Ability {
    @Override
    public void run(BoardView boardView, int index, Card card) {
        PlayerView player = boardView.getCurrentPlayer();
        int row = card.getPlacement().getRow();
        int countOfTightBondCards = 0;
        for (CardView targetCardView: player.getRowViews()[row].getCardViews()) {
            Card targetCard = (Card) targetCardView.getItem();
            if (targetCard.getAbility() instanceof TightBond) {
                countOfTightBondCards++;
            }
        }
        int newScoreForTightBondCards = countOfTightBondCards * ((UnitCard) card).getInitialScore();
        for (Card targetCard : player.getRowViews()[row].getCards()) {
            if (targetCard.getAbility() instanceof TightBond) {
                UnitCard unitcard = ((UnitCard) targetCard);
                unitcard.setScore(newScoreForTightBondCards);
            }
        }
    }


}
