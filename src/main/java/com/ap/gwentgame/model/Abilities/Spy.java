package com.ap.gwentgame.model.Abilities;

import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.Game.Player;

import java.util.ArrayList;
import java.util.Random;

public class Spy extends Ability{
    public Spy(Card card) {
        super(card);
    }

    @Override
    public void run(Board board) {
        Player player = board.getCurrentPlayer();
        ArrayList<Card> deck = player.getDeck();
        Card randomCard = getRandomCard(deck);
        player.addCardToHandFromDeck(randomCard);
        //TODO run its ability
    }
    public static Card getRandomCard(ArrayList<Card> list) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }
}
