package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.Game.Player;

import java.util.ArrayList;
import java.util.Random;

public class InvaderOfTheNorth extends Leader{
    public InvaderOfTheNorth(String name){
        super(name);
    }

    @Override
    public void executeAbility(Board board){
        Player player = board.getCurrentPlayer();
        Player opponent = board.getOpponentPlayer();
        ArrayList<Card> discardPileOpponent = opponent.getDiscardPile();
        Card card = getRandomCard(discardPileOpponent);
        opponent.addCardToHandFromDiscardPile(card);
        card = getRandomCard(discardPileOpponent);
        player.addCardToHandFromDiscardPile(card);//TODO check
    }
    public static Card getRandomCard(ArrayList<Card> list) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }
}
