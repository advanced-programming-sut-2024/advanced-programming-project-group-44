package com.ap.gwentgame.model.View;

import com.ap.gwentgame.model.Cards.Card;
import javafx.scene.Cursor;

public class GameCardView extends CardView{
    public GameCardView(Card card) {
        super(card);
        initializeGraphic();
    }

    @Override
    public void initializeGraphic() {
        this.setCursor(Cursor.HAND);
        this.setHeight(80);
        this.setWidth(56);
        setImageView(getGameImage());
    }
}
