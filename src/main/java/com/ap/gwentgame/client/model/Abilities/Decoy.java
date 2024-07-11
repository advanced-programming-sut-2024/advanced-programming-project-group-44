package com.ap.gwentgame.client.model.Abilities;

import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import com.ap.gwentgame.client.model.gameElementViews.CardView;
import com.ap.gwentgame.client.model.gameElementViews.PlayerView;
import com.ap.gwentgame.client.model.gameElements.Card;
import com.ap.gwentgame.client.view.ViewUtilities;

public class Decoy extends Ability{

    public Decoy(Card card) {
        super(card);
    }

    @Override
    public void run(BoardView boardView, int index) {
        PlayerView playerView = boardView.getCurrentPlayer();
        CardView cardView = playerView.getRowViews()[card.getPlacement().getRow()].getCardViews().get(index);
        ViewUtilities.changeCardContainer(boardView.getGamePane() , playerView.getRowViews()[card.getPlacement().getRow()], playerView.getHandView() , cardView);
    }

}
