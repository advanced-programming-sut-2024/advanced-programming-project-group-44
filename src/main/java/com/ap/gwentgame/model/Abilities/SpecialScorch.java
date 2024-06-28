package com.ap.gwentgame.model.Abilities;

import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Cards.UnitCard;
import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.Game.Player;

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
        int maxScore= Math.max(maxScorePlayer, maxScoreOpponent);
        addMaxScoreCardToDiscard(opponent , maxScore);
        addMaxScoreCardToDiscard(player , maxScore);

    }

    public void addMaxScoreCardToDiscard(Player player , int maxScore){
        for(int i = 1 ; i <= 3 ; i++){
            for (Card targetCard : player.getRows()[i]) {
                if (targetCard instanceof UnitCard){
                    if(!((UnitCard) targetCard).isHero() &&
                            ((UnitCard) targetCard).getScore() == maxScore){
                        UnitCard unitcard = ((UnitCard) targetCard);
                        player.addCardToDiscardPile(unitcard , i);
                    }
                }
            }
        }
    }
    public int findMaxScoreForEachPlayer(Player player){
        int maxScore = 0;
        for(int i = 1 ; i <= 3 ; i++){
            for (Card targetCard : player.getRows()[i]) {
                if (targetCard instanceof UnitCard){
                    if(!((UnitCard) targetCard).isHero()){
                        UnitCard unitcard = ((UnitCard) targetCard);
                        if(maxScore < unitcard.getScore()) maxScore = unitcard.getScore();
                    }
                }
            }
        }
        return maxScore;
    }
}
