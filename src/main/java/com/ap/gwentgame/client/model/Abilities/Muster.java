package com.ap.gwentgame.client.model.Abilities;

import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import com.ap.gwentgame.client.model.gameElementViews.CardView;
import com.ap.gwentgame.client.model.gameElementViews.PlayerView;
import com.ap.gwentgame.client.model.gameElements.Card;
import com.ap.gwentgame.client.model.gameElements.Board;
import com.ap.gwentgame.view.ViewUtilities;

import java.util.ArrayList;

public class Muster extends Ability{
    public Muster(Card card) {
        super(card);
    }

    @Override
    public void run(BoardView boardView, int index) {
        PlayerView playerView = boardView.getCurrentPlayer();
        ArrayList<CardView> deckCards = playerView.getDeckView().getCardViews();
        ArrayList<CardView> handCards = playerView.getHandView().getCardViews();
        String cardName = card.getName().split(" ")[0];
        for(CardView targetCardView : deckCards){
            if(((Card)targetCardView.getItem()).getAbility() instanceof Muster &&
                    targetCardView.getItem().getName().contains(cardName) &&
                    targetCardView.getItem() != card){
                ViewUtilities.changeCardContainer(boardView.getGamePane() , playerView.getDeckView() , playerView.getHandView() , targetCardView);
            }
        }
        for(CardView targetCardView : handCards){
            if(((Card)targetCardView.getItem()).getAbility() instanceof Muster &&
                    targetCardView.getItem().getName().contains(cardName) &&
                    targetCardView.getItem() != card){
                ViewUtilities.changeCardContainer(boardView.getGamePane() , playerView.getHandView() , playerView.getHandView() , targetCardView);
            }
        }
    }

}
