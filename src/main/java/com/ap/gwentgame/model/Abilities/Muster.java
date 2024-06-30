package com.ap.gwentgame.model.Abilities;

import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.Game.Player;

import java.util.ArrayList;

public class Muster extends Ability{
    public Muster(Card card) {
        super(card);
    }

    @Override
    public void run(Board board) {
        Player player = board.getCurrentPlayer();
        ArrayList<Card> deckCards = player.getDeck();
        ArrayList<Card> handCards = player.getHand();
        //TODO
    }
}
