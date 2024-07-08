package com.ap.gwentgame.model.gameElements;

import com.ap.gwentgame.model.gameElementViews.CardViewContainer;
import com.ap.gwentgame.model.gameElementViews.LeaderView;
import com.ap.gwentgame.model.gameElementViews.PreGameCardView;

import java.util.ArrayList;

public class Faction extends Item {
    protected final ArrayList<LeaderView> leaderViews;
    protected final CardViewContainer<PreGameCardView, Card> cardViews;

    public Faction(String name) {
        super(name);
        leaderViews = new ArrayList<>();
        cardViews = new CardViewContainer<>();
    }

    public ArrayList<LeaderView> getLeaderViews() {
        return leaderViews;
    }

    public CardViewContainer<PreGameCardView, Card> getCardViews() {
        return cardViews;
    }
}
