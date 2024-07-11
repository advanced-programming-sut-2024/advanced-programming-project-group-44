package com.ap.gwentgame.client.model.gameElementViews;

import com.ap.gwentgame.client.model.gameElements.Card;
import com.ap.gwentgame.client.model.gameElements.Item;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class CardViewContainer<T extends ItemView, K extends Item> extends CustomFlowPane {
    private final ArrayList<K> cards;

    public CardViewContainer(ArrayList<K> cards) {
        this.cards = cards;

        for (Item card : cards) {
            ItemView itemView = ItemView.getCardView((Card) card);
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
        cardView.setTranslateX(0);
        cardView.setTranslateY(0);
        cards.add((K) cardView.getItem());
    }

    public void remove(T cardView) {
        this.getChildren().remove(cardView);
        cards.remove((K) cardView.getItem());
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
