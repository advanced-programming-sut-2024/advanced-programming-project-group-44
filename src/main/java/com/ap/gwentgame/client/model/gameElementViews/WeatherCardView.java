package com.ap.gwentgame.client.model.gameElementViews;

import com.ap.gwentgame.client.controller.ControllerUtilities;
import com.ap.gwentgame.client.model.gameElements.SpecialCard;
import com.ap.gwentgame.client.model.gameElements.WeatherCard;

public class WeatherCardView extends SpecialCardView {
    public WeatherCardView(SpecialCard card) {
        super(card);
        initializeGraphic();
    }

    @Override
    public void initializeGraphic() {
        super.initializeGraphic();
    }

    public void stopAction(BoardView boardView) {
        WeatherCard weatherCard = (WeatherCard) this.getItem();

        switch (weatherCard.getName()){
            case "Biting Frost" :
                ControllerUtilities.stopWeatherAbility(boardView.getCurrentPlayer() , 0);
                break;
            case "Impenetrable Fog" :
                ControllerUtilities.stopWeatherAbility(boardView.getCurrentPlayer() , 1);
                break;
            case "Clear Weather" :
               // ControllerUtilities.stopWeatherAbility(boardView.getCurrentPlayer() , 0);
                //TODO checkThisssssssssssss
                break;
            case "Skellige Storm" :
                ControllerUtilities.stopWeatherAbility(boardView.getCurrentPlayer() , 1);
                ControllerUtilities.stopWeatherAbility(boardView.getCurrentPlayer() , 2);
                break;
            case "Torrential Rain" :
                ControllerUtilities.stopWeatherAbility(boardView.getCurrentPlayer() , 2);
                break;
        }
    }
}

