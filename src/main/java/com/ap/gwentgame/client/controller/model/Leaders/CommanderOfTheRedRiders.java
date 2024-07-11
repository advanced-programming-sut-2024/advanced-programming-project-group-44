package com.ap.gwentgame.client.controller.model.Leaders;

import com.ap.gwentgame.client.controller.enums.FactionType;
import com.ap.gwentgame.client.controller.model.Game.Board;

public class CommanderOfTheRedRiders extends Leader{
    @Override
    public void executeAbility(Board board) {

    }

    public CommanderOfTheRedRiders(String name, FactionType factionType) {
        super(name, factionType);
    }

//    @Override
//    public void executeAbility(Board board, String abilityInput){
//        Player player = board.getCurrentPlayer();
//        ItemContainer<Card> deckCards = player.getDeck();
//        for(Card card : deckCards.getItems()){
//            if(card instanceof Weather){
//                /*TODO show the card?
//                Card choosenCard = ...
//                choosenCard.executeAction(board);*/
//            }
//        }
//    }

//    public String getAbilityInput(){
//        return
//    }
}
