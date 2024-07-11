package com.ap.gwentgame.client.model.Leaders;

import com.ap.gwentgame.client.enums.FactionType;
import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import com.ap.gwentgame.client.model.gameElementViews.CardView;
import com.ap.gwentgame.client.model.gameElementViews.PlayerView;
import com.ap.gwentgame.client.model.gameElements.Card;
import com.ap.gwentgame.client.model.gameElements.Leader;
import com.ap.gwentgame.client.view.ViewUtilities;

import java.util.ArrayList;

public class TheSiegemaster extends Leader {
    public TheSiegemaster(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(BoardView boardView, int index) {
        PlayerView playerView = boardView.getCurrentPlayer();
        ArrayList<CardView> deckCardViews = playerView.getDeckView().getCardViews();
        for(CardView cardView : deckCardViews){
            Card card = (Card) cardView.getItem();
            if(card.getName().contains("fog")){
                ViewUtilities.changeCardContainer(boardView.getGamePane() ,
                        playerView.getDeckView() , boardView.getWeatherCards() , cardView);
            }
        }
    }

}
