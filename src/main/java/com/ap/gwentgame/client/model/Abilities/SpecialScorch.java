package com.ap.gwentgame.client.model.Abilities;

import com.ap.gwentgame.client.controller.ControllerUtilities;
import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import com.ap.gwentgame.client.model.gameElementViews.CardView;
import com.ap.gwentgame.client.model.gameElementViews.PlayerView;
import com.ap.gwentgame.client.model.gameElements.Card;
import com.ap.gwentgame.client.model.gameElements.UnitCard;
import com.ap.gwentgame.client.view.ViewUtilities;

public class SpecialScorch extends Ability {
    @Override
    public void run(BoardView boardView, int index, Card card) {
        PlayerView player = boardView.getCurrentPlayer();
        PlayerView opponent = boardView.getAgainstPlayer();
        int maxScorePlayer = findMaxScoreForEachPlayer(player);
        int maxScoreOpponent = findMaxScoreForEachPlayer(opponent);
        int maxScore = Math.max(maxScorePlayer, maxScoreOpponent);
        addMaxScoreCardToDiscard(opponent, maxScore , boardView);
        addMaxScoreCardToDiscard(player, maxScore , boardView);

    }

    public void addMaxScoreCardToDiscard(PlayerView playerView, int maxScore, BoardView boardView) {
        for (int i = 1; i <= 3; i++) {
            for (CardView targetCardView : playerView.getRowViews()[i].getCardViews()) {
                Card targetCard = (Card) targetCardView.getItem();
                if (targetCard instanceof UnitCard) {
                    if (!((UnitCard) targetCard).isHero() &&
                            ((UnitCard) targetCard).getScore() == maxScore) {
                        UnitCard unitcard = ((UnitCard) targetCard);
                        ViewUtilities.changeCardContainer(false, boardView, playerView.getRowViews()[targetCard.getPlacement().getRow()], playerView.getDiscardPileView(), targetCardView);
                    }
                }
            }
        }
    }

    public int findMaxScoreForEachPlayer(PlayerView playerView) {
        int maxScore = 0;
        for (int i = 1; i <= 3; i++) {
            if (maxScore < ControllerUtilities.calculateMaxScoreOfRowNotHero(playerView, i))
                maxScore = ControllerUtilities.calculateMaxScoreOfRowNotHero(playerView, i);
        }
        return maxScore;
    }

}
