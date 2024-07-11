package com.ap.gwentgame.client.model.Abilities;

import com.ap.gwentgame.client.controller.Utilities;
import com.ap.gwentgame.client.model.Cards.Card;
import com.ap.gwentgame.client.model.Cards.UnitCard;
import com.ap.gwentgame.client.model.Game.Board;
import com.ap.gwentgame.client.model.Game.Player;

public class SpecialScorch extends Ability {
    public SpecialScorch(Card card) {
        super(card);
    }

    @Override
    public void run(Board board) {
        Player player = board.getCurrentPlayer();
        Player opponent = board.getOpponentPlayer();
        int maxScorePlayer = findMaxScoreForEachPlayer(player);
        int maxScoreOpponent = findMaxScoreForEachPlayer(opponent);
        int maxScore = Math.max(maxScorePlayer, maxScoreOpponent);
        addMaxScoreCardToDiscard(opponent, maxScore);
        addMaxScoreCardToDiscard(player, maxScore);

    }

    public void addMaxScoreCardToDiscard(Player player, int maxScore) {
        for (int i = 1; i <= 3; i++) {
            for (Card targetCard : player.getRows()[i].getItems()) {
                if (targetCard instanceof UnitCard) {
                    if (!((UnitCard) targetCard).isHero() &&
                            ((UnitCard) targetCard).getScore() == maxScore) {
                        UnitCard unitcard = ((UnitCard) targetCard);
                        player.changeContainer(player.getRows()[i] , player.getDiscardPile() , unitcard);
                        //player.addCardToDiscardPile(unitcard, i);
                    }
                }
            }
        }
    }

    public int findMaxScoreForEachPlayer(Player player) {
        int maxScore = 0;
        for (int i = 1; i <= 3; i++) {
            if (maxScore < Utilities.calculateMaxScoreOfRowNotHero(player, i))
                maxScore = Utilities.calculateMaxScoreOfRowNotHero(player, i);
        }
        return maxScore;
    }

    @Override
    public void stop(Board board) {
//TODO
    }
}
