package com.ap.gwentgame.model.Abilities;

import com.ap.gwentgame.controller.ControllerUtilities;
import com.ap.gwentgame.model.gameElementViews.BoardView;
import com.ap.gwentgame.model.gameElementViews.CardView;
import com.ap.gwentgame.model.gameElementViews.PlayerView;
import com.ap.gwentgame.model.gameElements.Card;
import com.ap.gwentgame.model.gameElements.Board;
import com.ap.gwentgame.model.gameElements.UnitCard;
import com.ap.gwentgame.view.ViewUtilities;

public class SpecialScorch extends Ability {
    public SpecialScorch(Card card) {
        super(card);
    }

    @Override
    public void run(BoardView boardView, int index) {
        PlayerView player = boardView.getCurrentPlayer();
        PlayerView opponent = boardView.getOpponentPlayer();
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
                        ViewUtilities.changeCardContainer(boardView.getGamePane(), playerView.getRowViews()[targetCard.getPlacement().getRow()], playerView.getDiscardPileView(), targetCardView);
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
