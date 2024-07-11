package com.ap.gwentgame.client.controller.model.Leaders;

import com.ap.gwentgame.client.controller.enums.FactionType;
import com.ap.gwentgame.client.controller.model.Cards.Card;
import com.ap.gwentgame.client.controller.model.Game.Board;
import com.ap.gwentgame.client.controller.model.Game.Player;
import com.ap.gwentgame.client.controller.model.ItemContainer;

import java.util.ArrayList;
import java.util.Random;

public class InvaderOfTheNorth extends Leader{
    public InvaderOfTheNorth(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(Board board){
        Player player = board.getCurrentPlayer();
        Player opponent = board.getOpponentPlayer();
        ItemContainer<Card> discardPileOpponent = opponent.getDiscardPile();
        Card card = getRandomCard(discardPileOpponent.getItems());
        opponent.changeContainer(opponent.getDiscardPile() , opponent.getHand() , card);
        //opponent.addCardToHandFromDiscardPile(card);
        card = getRandomCard(discardPileOpponent.getItems());
        player.changeContainer(player.getDiscardPile() , player.getHand() , card);
        //player.addCardToHandFromDiscardPile(card);//TODO check
    }
    public static Card getRandomCard(ArrayList<Card> list) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }
}
