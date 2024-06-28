package com.ap.gwentgame.model.Abilities;

import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.Game.Player;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Medic extends Ability{
    public Medic(Card card) {
        super(card);
    }

    @Override
    public void run(Board board) {
        Player player = board.getCurrentPlayer();
        ArrayList<Card> discardCards = player.getDiscardPile();
        Card randomCard = getRandomCard(discardCards);
        player.addCardToHand(randomCard);

    }
    public static Card getRandomCard(ArrayList<Card> list) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }
}
