package com.ap.gwentgame.model.Cards;

import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class PreGameCard extends Item {
    private final Card card;
    private Label count;

    public PreGameCard(Card card, int count) {
        super(card.getName());
        this.card = card;
        this.count = new Label(String.valueOf(count));
    }

    public Card getCard() {
        return card;
    }

    public int getCount() {
        return Integer.parseInt(count.getText());
    }

    public void setCount(int count) {
        this.count.setText(String.valueOf(count));
    }

    public void initializeGraphic() {
        ImageView imageView = new ImageView(card.getPreGameImage());
        this.setHeight(278);
        this.setWidth(147);
        imageView.setFitWidth(this.getWidth());
        imageView.setFitHeight(this.getHeight());
        this.getChildren().add(imageView);
        this.setCursor(Cursor.HAND);

        count.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #000000; -fx-font-size: 20px; -fx-font-weight: bold; -fx-padding: 5px;");
        this.getChildren().add(count);
        count.setLayoutX(120);
        count.setLayoutY(10);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PreGameCard preGameCard) {
            return preGameCard.getName().equals(this.getName());
        }
        return false;
    }
}
