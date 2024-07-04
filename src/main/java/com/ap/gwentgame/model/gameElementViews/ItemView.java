package com.ap.gwentgame.model.gameElementViews;

import com.ap.gwentgame.model.gameElements.Card;
import com.ap.gwentgame.model.gameElements.Item;
import com.ap.gwentgame.model.gameElements.SpecialCard;
import com.ap.gwentgame.model.gameElements.UnitCard;
import com.ap.gwentgame.view.ViewUtilities;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

public abstract class ItemView extends AnchorPane {
    protected final Item item;

    public ItemView(Item card) {
        this.item = card;
    }

    public Item getItem() {
        return item;
    }

    public void initializeGraphic(){
        this.setCursor(Cursor.HAND);
        ViewUtilities.setImageViewBackground(this, getImage());
    }

    public abstract Image getImage();

    public static ItemView getCardView(Card card) {
        if (card instanceof SpecialCard) {
            return new SpecialCardView((SpecialCard) card);
        } else if (card instanceof UnitCard) {
            return new UnitCardView((UnitCard) card);
        }
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ItemView itemView) {
            return itemView.getItem().getName().equals(item.getName());
        }
        return false;
    }
}
