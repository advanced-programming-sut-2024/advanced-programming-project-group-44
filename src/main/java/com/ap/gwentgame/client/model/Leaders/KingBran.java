package com.ap.gwentgame.client.model.Leaders;

import com.ap.gwentgame.client.controller.ControllerUtilities;
import com.ap.gwentgame.client.enums.FactionType;
import com.ap.gwentgame.client.model.gameElementViews.*;
import com.ap.gwentgame.client.model.gameElements.Leader;
import com.ap.gwentgame.client.model.gameElements.UnitCard;
import com.ap.gwentgame.client.model.gameElements.WeatherCard;

public class KingBran extends Leader {
    public KingBran(String name, FactionType factionType) {
        super(name, factionType);
    }

    @Override
    public void executeAbility(BoardView boardView, int index) {
        PlayerView playerView = boardView.getCurrentPlayerView();
        PlayerView opponentView = boardView.getAgainstPlayerView();
        if (boardView.getWeatherCards().getCardViews() != null) {
            for (CardView weatherCardView : boardView.getWeatherCards().getCardViews()) {
                String weatherCardViewName = ((WeatherCard) weatherCardView.getItem()).getName().toLowerCase();
                if (weatherCardViewName.contains("fog")) {
                    weatherAbilityToHalf(playerView, 1);
                    weatherAbilityToHalf(opponentView, 1);
                } else if (weatherCardViewName.contains("rain")) {
                    weatherAbilityToHalf(playerView, 2);
                    weatherAbilityToHalf(opponentView, 2);
                } else if (weatherCardViewName.contains("storm")) {
                    weatherAbilityToHalf(playerView, 1);
                    weatherAbilityToHalf(opponentView, 1);
                    weatherAbilityToHalf(playerView, 2);
                    weatherAbilityToHalf(opponentView, 2);
                } else if (weatherCardViewName.contains("frost")) {
                    weatherAbilityToHalf(playerView, 0);
                    weatherAbilityToHalf(opponentView, 0);
                }
            }
        }
    }
    //TODO check the cards that come after

    public static void weatherAbilityToHalf(PlayerView playerView, int row) {
        for (CardView cardView : playerView.getRowViews()[row].getCardViews()) {
            if (cardView instanceof UnitCardView unitCardView && !((UnitCard) cardView.getItem()).isHero()) {
                unitCardView.setScore((((UnitCard) (cardView.getItem())).getInitialScore()) / 2);
            }
        }
    }


}
