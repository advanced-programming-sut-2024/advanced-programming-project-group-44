package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.model.gameElementViews.BoardView;
import com.ap.gwentgame.model.gameElementViews.CardView;
import com.ap.gwentgame.model.gameElementViews.PlayerView;
import com.ap.gwentgame.model.gameElementViews.UnitCardView;
import com.ap.gwentgame.model.gameElements.Board;
import com.ap.gwentgame.model.gameElements.Card;
import com.ap.gwentgame.model.gameElements.Leader;
import com.ap.gwentgame.model.gameElements.UnitCard;

public class KingOfTemeria extends Leader {
    public KingOfTemeria(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(BoardView boardView, int index) {
        PlayerView player = boardView.getCurrentPlayer();
        //TODO check the row & check if it also happens for the opponent
        for(CardView cardView : player.getRowViews()[2].getCardViews()){
            Card card = (Card) cardView.getItem();
            if(card instanceof UnitCard && !(card.getName().contains("commander'sHorn")) &&
                    !((UnitCard) card).isHero()){
                ((UnitCardView) cardView).setScore(((UnitCard) card).getScore() * 2);
            }
        }
    }

}
