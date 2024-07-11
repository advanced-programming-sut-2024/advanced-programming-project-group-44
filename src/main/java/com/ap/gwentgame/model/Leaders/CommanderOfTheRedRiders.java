package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.model.gameElementViews.BoardView;
import com.ap.gwentgame.model.gameElementViews.CardView;
import com.ap.gwentgame.model.gameElementViews.PlayerView;
import com.ap.gwentgame.model.gameElements.Board;
import com.ap.gwentgame.model.gameElements.Card;
import com.ap.gwentgame.model.gameElements.Leader;
import com.ap.gwentgame.model.gameElements.WeatherCard;

import java.util.ArrayList;

public class CommanderOfTheRedRiders extends Leader {
    public CommanderOfTheRedRiders(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(BoardView boardView, int index) {
        PlayerView playerView = boardView.getCurrentPlayer();
        ArrayList<CardView> deckCards = playerView.getDeckView().getCardViews();
        //TODO nadashte bashe?
        if(index != null){
            CardView chosenWeatherCard = deckCards.get(index);
            //?chosenWeatherCard
        }
    }
}
