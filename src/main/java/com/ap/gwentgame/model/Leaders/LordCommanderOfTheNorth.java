package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.controller.ControllerUtilities;
import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.model.gameElementViews.BoardView;
import com.ap.gwentgame.model.gameElementViews.CardView;
import com.ap.gwentgame.model.gameElementViews.PlayerView;
import com.ap.gwentgame.model.gameElements.Board;
import com.ap.gwentgame.model.gameElements.Card;
import com.ap.gwentgame.model.gameElements.Leader;
import com.ap.gwentgame.model.gameElements.UnitCard;
import com.ap.gwentgame.view.ViewUtilities;

public class LordCommanderOfTheNorth extends Leader {
    public LordCommanderOfTheNorth(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(BoardView boardView, int index) {
        PlayerView opponent = boardView.getOpponentPlayer();
        int score = ControllerUtilities.calculateScoreOfRowNotHero(opponent, 2);
        int maxScore = ControllerUtilities.calculateMaxScoreOfRowNotHero(opponent, 2);
        if (score >= 10) {
            for (CardView cardView : opponent.getRowViews()[2].getCardViews()) {
                Card card = (Card) cardView.getItem();
                if (card instanceof UnitCard && !((UnitCard) card).isHero()
                        && ((UnitCard) card).getScore() == maxScore) {
                    ViewUtilities.changeCardContainer(boardView.getGamePane() , opponent.getRowViews()[2]
                            , opponent.getDiscardPileView() , cardView);
                }
            }
        }
    }

}
