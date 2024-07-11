package com.ap.gwentgame.client.controller.model.Leaders;

import com.ap.gwentgame.client.controller.enums.FactionType;
import com.ap.gwentgame.client.controller.model.Cards.Card;
import com.ap.gwentgame.client.controller.model.Game.Board;
import com.ap.gwentgame.client.controller.model.Game.Player;
import com.ap.gwentgame.client.controller.model.ItemContainer;

public class HopeOfTheAenSeidhe extends Leader{
    public HopeOfTheAenSeidhe(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(Board board){
        Player player = board.getCurrentPlayer();
        ItemContainer<Card> agileCards = player.getRows()[0];
        agileCards.addAll(player.getRows()[1]);
        /*TODO hmmm?
        Card card = choosenCard...
        player.getRows()[i].remove(card);
        player.getRows()[j].add(card);*/
    }
}
