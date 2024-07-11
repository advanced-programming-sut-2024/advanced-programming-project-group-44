package com.ap.gwentgame.client.model.Leaders;

import com.ap.gwentgame.client.enums.FactionType;
import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import com.ap.gwentgame.client.model.gameElementViews.CardView;
import com.ap.gwentgame.client.model.gameElementViews.PlayerView;
import com.ap.gwentgame.client.model.gameElements.Leader;
import com.ap.gwentgame.client.view.ViewUtilities;

public class DestroyerOfWorlds extends Leader {
    public DestroyerOfWorlds(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(BoardView boardView, int index) {
        PlayerView playerView = boardView.getCurrentPlayer();
        CardView killCard1 = playerView.getHandView().getCardViews().get(index % 100);
        index = index / 100;
        CardView killCard2 = playerView.getHandView().getCardViews().get(index % 100);
        index = index / 100;
        CardView chosenCard = playerView.getDeckView().getCardViews().get(index % 100);
        ViewUtilities.changeCardContainer(false ,boardView, playerView.getHandView(),
                playerView.getDiscardPileView(), killCard1);
        ViewUtilities.changeCardContainer(false ,boardView, playerView.getHandView(),
                playerView.getDiscardPileView(), killCard2);
        ViewUtilities.changeCardContainer(false ,boardView, playerView.getDeckView(),
                playerView.getHandView(), chosenCard);
    }
}
