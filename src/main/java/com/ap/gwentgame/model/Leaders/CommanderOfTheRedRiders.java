package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Cards.Weather;
import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.Game.Player;
import com.ap.gwentgame.model.ItemContainer;

import java.util.ArrayList;

public class CommanderOfTheRedRiders extends Leader{
    public CommanderOfTheRedRiders(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(Board board, String abilityInput){
        Player player = board.getCurrentPlayer();
        ItemContainer<Card> deckCards = player.getDeck();
        for(Card card : deckCards.getItems()){
            if(card instanceof Weather){
                /*TODO show the card?
                Card choosenCard = ...
                choosenCard.executeAction(board);*/
            }
        }
    }

//    public String getAbilityInput(){
//        return
//    }
}
