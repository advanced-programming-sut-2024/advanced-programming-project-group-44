package com.ap.gwentgame.model.Abilities;

import com.ap.gwentgame.controller.ControllerUtilities;
import com.ap.gwentgame.model.gameElementViews.BoardView;
import com.ap.gwentgame.model.gameElementViews.PlayerView;
import com.ap.gwentgame.model.gameElements.Card;
import com.ap.gwentgame.model.gameElements.Board;
import com.ap.gwentgame.model.gameElements.Player;
import com.ap.gwentgame.view.ViewUtilities;

public class BitingFrost extends Ability{
    public BitingFrost(Card card) {
        super(card);
    }

    @Override
    public void run(BoardView boardView, int index) {
        PlayerView player = boardView.getCurrentPlayer();
        PlayerView opponent = boardView.getOpponentPlayer();
        //Object Utilities;
        ControllerUtilities.weatherAbility(player , 0);
        ControllerUtilities.weatherAbility(opponent , 0);
    }
}
