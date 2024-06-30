package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Cards.UnitCard;
import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.Game.Player;

import java.util.ArrayList;

public class CrachAnCraite extends Leader {
    public CrachAnCraite(String name) {
        super(name);
    }

    @Override
    public void executeAbility(Board board) {
        //TODO bor zadan?
        Player player = board.getCurrentPlayer();
        ArrayList<Card> discardPileCards = player.getDiscardPile();
        for (Card card : discardPileCards) {
            if (card instanceof UnitCard) {
                if (!((UnitCard) card).isHero()) {
                    player.addCardToDeckFromDiscardPile(card);
                }
            }player.addCardToDeckFromDiscardPile(card);
        }
    }
}
