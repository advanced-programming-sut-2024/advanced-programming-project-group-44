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

public class SonOfMedell extends Leader {
    public SonOfMedell(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(BoardView boardView, int index) {
        PlayerView opponentView = boardView.getOpponentPlayer();
        int score = ControllerUtilities.calculateScoreOfRowNotHero(opponentView , 1);
        if(score >= 10){
            int maxScore = ControllerUtilities.calculateMaxScoreOfRowNotHero(opponentView, 1);
            for (CardView cardView : opponentView.getRowViews()[1].getCardViews()) {
                Card card = (Card) cardView.getItem();
                if (card instanceof UnitCard && !((UnitCard) card).isHero()
                        && ((UnitCard) card).getScore() == maxScore) {
                    ViewUtilities.changeCardContainer(boardView.getGamePane() , opponentView.getRowViews()[1]
                            , opponentView.getDiscardPileView() , cardView);
                }
            }
        }
    }

}
