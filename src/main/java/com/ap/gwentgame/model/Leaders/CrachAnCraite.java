package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.model.gameElementViews.BoardView;
import com.ap.gwentgame.model.gameElementViews.CardView;
import com.ap.gwentgame.model.gameElementViews.PlayerView;
import com.ap.gwentgame.model.gameElements.Board;
import com.ap.gwentgame.model.gameElements.Card;
import com.ap.gwentgame.model.gameElements.Leader;
import com.ap.gwentgame.model.gameElements.UnitCard;
import com.ap.gwentgame.view.ViewUtilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CrachAnCraite extends Leader {
    public CrachAnCraite(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(BoardView boardView, int index) {
        PlayerView playerView = boardView.getCurrentPlayer();
        ArrayList<CardView> discardPileCards = playerView.getDiscardPileView().getCardViews();
        Collections.shuffle(discardPileCards);
        for (CardView cardView : discardPileCards) {
            Card card = (Card) cardView.getItem();
            if (card instanceof UnitCard) {
                if (!((UnitCard) card).isHero()) {
                    ViewUtilities.changeCardContainer(boardView.getGamePane()
                            , playerView.getDiscardPileView()
                            , playerView.getDeckView() , cardView);
                }
            }
            ViewUtilities.changeCardContainer(boardView.getGamePane() ,
                    playerView.getDiscardPileView() ,
                    playerView.getDeckView() , cardView);
        }
    }
}
