package com.ap.gwentgame.model.gameElementViews;

import com.ap.gwentgame.model.gameElements.*;
import com.ap.gwentgame.view.ViewUtilities;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public abstract class ItemView extends AnchorPane{
    protected final Item item;

    public ItemView(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void initializeGraphic() {
        this.setCursor(Cursor.HAND);
    }

    public abstract Image getImage();

    public static CardView getCardView(Card card) {
        if (card instanceof WeatherCard) {
            return new WeatherCardView((WeatherCard) card);
        }
        if (card instanceof SpecialCard) {
            return new SpecialCardView((SpecialCard) card);
        }
        if (card instanceof UnitCard) {
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

    public void setSize(double width, double height) {
        this.setPrefWidth(width);
        this.setPrefHeight(height);
        ImageView imageView = (ImageView) this.getChildren().get(0);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
    }
}
