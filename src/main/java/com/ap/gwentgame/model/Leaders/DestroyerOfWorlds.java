package com.ap.gwentgame.model.Leaders;

import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.model.gameElementViews.BoardView;
import com.ap.gwentgame.model.gameElementViews.CardView;
import com.ap.gwentgame.model.gameElementViews.PlayerView;
import com.ap.gwentgame.model.gameElements.Board;
import com.ap.gwentgame.model.gameElements.Card;
import com.ap.gwentgame.model.gameElements.Leader;
import com.ap.gwentgame.view.ViewUtilities;

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
        ViewUtilities.changeCardContainer(boardView.getGamePane(), playerView.getHandView(), playerView.getDiscardPileView(), killCard1);
        ViewUtilities.changeCardContainer(boardView.getGamePane(), playerView.getHandView(), playerView.getDiscardPileView(), killCard2);
        ViewUtilities.changeCardContainer(boardView.getGamePane(), playerView.getDeckView(), playerView.getHandView(), chosenCard);
    }
}
