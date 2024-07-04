package com.ap.gwentgame.model.View;

import com.ap.gwentgame.model.Cards.SpecialCard;

public class SpecialCardView extends GameCardView{
    public SpecialCardView(SpecialCard card) {
        super(card);
        initializeGraphic();
    }

    @Override
    public void initializeGraphic() {
        super.initializeGraphic();
        setImageView(getGameImage());
    }
}
