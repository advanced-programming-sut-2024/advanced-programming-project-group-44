package com.ap.gwentgame.client.model.Cards;

import javafx.scene.Cursor;
import javafx.scene.image.ImageView;

public class PreGameCard extends Item {
    private final Card card;
    private int count;

    public PreGameCard(Card card, int count) {
        super(card.getName());
        this.card = card;
        this.count = count;
    }

    public Card getCard() {
        return card;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void initializeGraphic() {
        ImageView imageView = new ImageView(card.getPreGameImage());
        this.setHeight((this.getWidth() / 150) * this.getHeight());
        this.setWidth(150);
        imageView.setFitWidth(this.getWidth());
        imageView.setFitHeight(this.getHeight());
        this.getChildren().add(imageView);
        this.setCursor(Cursor.HAND);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PreGameCard preGameCard) {
            return preGameCard.getName().equals(this.getName());
        }
        return false;
    }
}
