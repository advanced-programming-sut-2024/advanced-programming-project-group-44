package com.ap.gwentgame.model.View;

import com.ap.gwentgame.model.Cards.Card;
import javafx.scene.Cursor;
import javafx.scene.control.Label;

public class PreGameCardView extends CardView {
    private transient Label countLabel;
    private int count;

    public PreGameCardView(Card card, int count) {
        super(card);
        this.countLabel = new Label(String.valueOf(count));
        initializeGraphic();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
        this.countLabel.setText(String.valueOf(count));
    }

    @Override
    public void initializeGraphic() {
        this.setCursor(Cursor.HAND);
        this.setHeight(278);
        this.setWidth(147);
        setImageView(getPreGameImage());


        countLabel.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #000000; -fx-font-size: 20px; -fx-font-weight: bold; -fx-padding: 5px;");
        this.getChildren().add(countLabel);
        countLabel.setLayoutX(120);
        countLabel.setLayoutY(10);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PreGameCardView preGameCardView) {
            return preGameCardView.getCard().getName().equals(card.getName());
        }
        return false;
    }
}
