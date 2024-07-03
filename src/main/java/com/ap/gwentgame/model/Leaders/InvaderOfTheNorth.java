package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.Game.Player;
import com.ap.gwentgame.model.ItemContainer;

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
        opponent.addCardToHandFromDiscardPile(card);
        card = getRandomCard(discardPileOpponent.getItems());
        player.addCardToHandFromDiscardPile(card);//TODO check
    }
    public static Card getRandomCard(ArrayList<Card> list) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }
}
