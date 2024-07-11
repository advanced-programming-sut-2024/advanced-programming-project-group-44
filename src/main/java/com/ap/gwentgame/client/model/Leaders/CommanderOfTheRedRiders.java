package com.ap.gwentgame.client.model.Leaders;

import com.ap.gwentgame.client.enums.FactionType;
import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import com.ap.gwentgame.client.model.gameElementViews.CardView;
import com.ap.gwentgame.client.model.gameElementViews.PlayerView;
import com.ap.gwentgame.client.model.gameElements.Card;
import com.ap.gwentgame.client.model.gameElements.Leader;

import java.util.ArrayList;

public class CommanderOfTheRedRiders extends Leader {
    public CommanderOfTheRedRiders(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(BoardView boardView, int index) {
        PlayerView playerView = boardView.getCurrentPlayer();
        ArrayList<CardView> deckCards = playerView.getDeckView().getCardViews();
        if(index != -1){
            CardView chosenWeatherCard = deckCards.get(index);
            ((Card)chosenWeatherCard.getItem()).getAbility().run(boardView , 0 , ((Card)chosenWeatherCard.getItem()));
        }
    }
}
