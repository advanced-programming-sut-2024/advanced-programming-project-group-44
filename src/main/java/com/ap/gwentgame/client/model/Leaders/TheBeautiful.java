package com.ap.gwentgame.client.model.Leaders;

import com.ap.gwentgame.client.enums.FactionType;
import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import com.ap.gwentgame.client.model.gameElementViews.CardView;
import com.ap.gwentgame.client.model.gameElementViews.PlayerView;
import com.ap.gwentgame.client.model.gameElementViews.UnitCardView;
import com.ap.gwentgame.client.model.gameElements.Card;
import com.ap.gwentgame.client.model.gameElements.Leader;
import com.ap.gwentgame.client.model.gameElements.UnitCard;

public class TheBeautiful extends Leader {
    public TheBeautiful(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(BoardView boardView, int index) {
        PlayerView player = boardView.getCurrentPlayer();
        for(CardView cardView : player.getRowViews()[1].getCardViews()){
            Card card = (Card) cardView.getItem();
            if(card instanceof UnitCard && !(card.getName().contains("commander'sHorn")) &&
                    !((UnitCard) card).isHero()){
                ((UnitCardView) cardView).setScore(((UnitCard) card).getScore() * 2);
            }
        }
    }

}
