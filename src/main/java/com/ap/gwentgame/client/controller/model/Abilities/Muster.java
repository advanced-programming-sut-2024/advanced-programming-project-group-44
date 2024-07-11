package com.ap.gwentgame.client.controller.model.Abilities;

import com.ap.gwentgame.client.controller.model.Cards.Card;
import com.ap.gwentgame.client.controller.model.Game.Board;
import com.ap.gwentgame.client.controller.model.Game.Player;
import com.ap.gwentgame.client.controller.model.ItemContainer;

import java.util.ArrayList;

public class Muster extends Ability{
    public Muster(Card card) {
        super(card);
    }

    @Override
    public void run(Board board) {
        Player player = board.getCurrentPlayer();
        ItemContainer<Card> deckCards = player.getDeck();
        ItemContainer<Card> handCards = player.getHand();
        //TODO
    }
    @Override
    public void stop(Board board) {

    }
}
