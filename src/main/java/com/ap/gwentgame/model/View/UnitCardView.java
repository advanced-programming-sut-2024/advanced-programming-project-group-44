package com.ap.gwentgame.model.View;

import com.ap.gwentgame.model.Cards.UnitCard;
import com.ap.gwentgame.view.ViewUtilities;
import javafx.scene.control.Label;

public class UnitCardView extends GameCardView {
    private Label scoreLabel;

    public UnitCardView(UnitCard card) {
        super(card);
        initializeGraphic();
    }

    @Override
    public void initializeGraphic() {
        super.initializeGraphic();
        scoreLabel = new Label(Integer.toString(((UnitCard)card).getScore()));
        scoreLabel.setLayoutX(0);
        scoreLabel.setLayoutY(0);
        scoreLabel.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #000000; -fx-font-size: 20px; -fx-font-weight: bold; -fx-padding: 5px;");
        this.getChildren().add(scoreLabel);
    }

    public void setScore(int score){
        ((UnitCard)card).setScore(score);
        ViewUtilities.changeNumber(scoreLabel, score);
    }
}
