package com.ap.gwentgame.model.Abilities;

import com.ap.gwentgame.controller.ControllerUtilities;
import com.ap.gwentgame.model.gameElementViews.BoardView;
import com.ap.gwentgame.model.gameElementViews.CardView;
import com.ap.gwentgame.model.gameElementViews.PlayerView;
import com.ap.gwentgame.model.gameElements.Card;
import com.ap.gwentgame.model.gameElements.Board;
import com.ap.gwentgame.model.gameElements.UnitCard;
import com.ap.gwentgame.view.ViewUtilities;

public class Scorch extends Ability {
    public Scorch(Card card) {
        super(card);
    }

    @Override
    public void run(BoardView boardView, int index) {
        PlayerView opponentView = boardView.getOpponentPlayer();
        int row = card.getPlacement().getRow();
        int scoreOfUnHeroCards = ControllerUtilities.calculateScoreOfRowNotHero(opponentView , row);
        int maxScore = ControllerUtilities.calculateMaxScoreOfRowNotHero(opponentView , row);
        if(scoreOfUnHeroCards >= 10){
            for(CardView targetCardView : opponentView.getRowViews()[row].getCardViews()){
                Card targetCard = (Card) targetCardView.getItem();
                if(targetCard instanceof UnitCard
                        && ((UnitCard) targetCard).getScore() == maxScore
                        && !((UnitCard) targetCard).isHero()){
                    ViewUtilities.changeCardContainer(boardView.getGamePane() , opponentView.getRowViews()[row] , opponentView.getDiscardPileView() , targetCardView);
                }
            }
        }
    }
}
