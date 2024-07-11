package com.ap.gwentgame.client.model.Leaders;

import com.ap.gwentgame.client.controller.ControllerUtilities;
import com.ap.gwentgame.client.enums.FactionType;
import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import com.ap.gwentgame.client.model.gameElementViews.CardView;
import com.ap.gwentgame.client.model.gameElementViews.PlayerView;
import com.ap.gwentgame.client.model.gameElements.Card;
import com.ap.gwentgame.client.model.gameElements.Leader;
import com.ap.gwentgame.client.model.gameElements.UnitCard;
import com.ap.gwentgame.client.view.ViewUtilities;

public class QueenOfDolBlathanna extends Leader {
    public QueenOfDolBlathanna(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(BoardView boardView, int index) {
        PlayerView opponentView = boardView.getAgainstPlayerView();
        int score = ControllerUtilities.calculateScoreOfRowNotHero(opponentView , 0);
        if(score >= 10){
            int maxScore = ControllerUtilities.calculateMaxScoreOfRowNotHero(opponentView, 1);
            for (CardView cardView : opponentView.getRowViews()[1].getCardViews()) {
                Card card = (Card) cardView.getItem();
                if (card instanceof UnitCard && !((UnitCard) card).isHero()
                        && ((UnitCard) card).getScore() == maxScore) {
                    ViewUtilities.changeCardContainer(false , boardView , opponentView.getRowViews()[1]
                            , opponentView.getDiscardPileView() , cardView);
                }
            }
        }
    }
}
