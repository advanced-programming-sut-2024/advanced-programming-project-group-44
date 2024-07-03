package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Cards.Item;
import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.Game.Player;
import com.ap.gwentgame.model.ItemContainer;

import java.util.ArrayList;

public class KingOfTheWildHunt extends Leader{
    public KingOfTheWildHunt(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(Board board){
        Player player = board.getCurrentPlayer();
        ItemContainer<Card> discardPileCards = player.getDiscardPile();
        /*TODO choose the card and the rest , card not hero
        Player player = board.getCurrentPlayer();
        Card choosenCard = chosencard???
        player.addCardToHandFromDiscardPile(card);*/
    }
}
