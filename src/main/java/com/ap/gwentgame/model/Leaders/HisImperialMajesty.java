package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.Game.Player;

import java.lang.foreign.PaddingLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class HisImperialMajesty extends Leader{
    public HisImperialMajesty(String name){
        super(name);
    }

    @Override
    public void executeAbility(Board board){
        Player opponent = board.getOpponentPlayer();
        ArrayList<Card> handCardsOpponent = opponent.getHand();
        int handCardsOpponentNum = handCardsOpponent.size();
        ArrayList<Card> randomCards;
        if(handCardsOpponentNum < 4) randomCards = getRandomCards(handCardsOpponent , handCardsOpponentNum);
        else randomCards = getRandomCards(handCardsOpponent , 3);
        //TODO shoe them to the player

    }
    public static ArrayList<Card> getRandomCards(ArrayList<Card> list, int numberOfCards) {
        if (numberOfCards > list.size()) {
            throw new IllegalArgumentException("Number of cards requested exceeds the size of the list");
        }

        ArrayList<Card> copy = new ArrayList<>(list);
        Collections.shuffle(copy);

        ArrayList<Card> result = new ArrayList<>();
        for (int i = 0; i < numberOfCards; i++) {
            result.add(copy.get(i));
        }

        return result;
    }
}
