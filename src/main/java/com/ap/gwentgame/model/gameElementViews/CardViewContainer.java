package com.ap.gwentgame.model.gameElementViews;

import com.ap.gwentgame.model.gameElements.Card;
import com.ap.gwentgame.model.gameElements.Item;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class CardViewContainer<T extends ItemView, K extends Card> extends FlowPane {
    private final ArrayList<K> cards;

    public CardViewContainer(ArrayList<K> cards) {
        this.cards = cards;

        for (Card card : cards) {
            ItemView itemView = ItemView.getCardView(card);
            this.getChildren().add(itemView);
        }
    }

    public CardViewContainer() {
        this.cards = new ArrayList<>();
    }

    public void setVisuals(Pane pane, double x, double y, double width, double height, double horizontalGap, double verticalGap) {
        this.orientationProperty().setValue(Orientation.HORIZONTAL);
        this.setLayoutX(x);
        this.setLayoutY(y);
        this.setPrefWidth(width);
        this.setPrefHeight(height);
        this.setHgap(horizontalGap);
        this.setVgap(verticalGap);
        pane.getChildren().add(this);
    }

    public void setVisuals(double width, double height, double horizontalGap, double verticalGap) {
        this.orientationProperty().setValue(Orientation.HORIZONTAL);
        this.setPrefWidth(width);
        this.setPrefHeight(height);
        this.setHgap(horizontalGap);
        this.setVgap(verticalGap);
    }

    public void add(T cardView) {
        this.getChildren().add(cardView);
        cards.add((K) cardView.getItem());
    }

    public void remove(ItemView itemView) {
        this.getChildren().remove(itemView);
        cards.remove(itemView.getItem());
    }

    public void clear() {
        this.getChildren().clear();
        cards.clear();
    }

    public ArrayList<T> getCardViews() {
        ArrayList<T> cardViews = new ArrayList<>();
        for (Node card : this.getChildren()) {
            cardViews.add((T) card);
        }
        return cardViews;
    }

    public ArrayList<K> getCards() {
        return cards;
    }

    public boolean contains(ItemView itemView) {
        return this.getChildren().contains(itemView);
    }

    public T findByName(String name) {
        for (T cardView : getCardViews()) {
            if (cardView.getItem().getName().equals(name)) {
                return cardView;
            }
        }
        return null;
    }
}
