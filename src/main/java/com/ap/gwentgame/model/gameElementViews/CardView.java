package com.ap.gwentgame.model.gameElementViews;

import com.ap.gwentgame.controller.ControllerUtilities;
import com.ap.gwentgame.model.gameElements.Card;
import com.ap.gwentgame.view.ViewUtilities;
import javafx.scene.Cursor;
import javafx.scene.image.Image;

public class CardView extends ItemView {
    public CardView(Card card) {
        super(card);
        initializeGraphic();
    }

    @Override
    public Image getImage() {
        String path = ControllerUtilities.getResourcePath("images/cards/game/" + ((Card)item).getFactionType().toString().toLowerCase() + "/" + item.getName().replaceAll("’", "").replaceAll("'", "") + ".jpg");
        return new Image(path);
    }

    @Override
    public void initializeGraphic() {
        super.initializeGraphic();
        this.setHeight(80);
        this.setWidth(56);
        ViewUtilities.setImageViewBackground(this, getImage());
    }
}
