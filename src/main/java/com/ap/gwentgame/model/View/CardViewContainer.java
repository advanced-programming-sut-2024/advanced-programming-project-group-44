package com.ap.gwentgame.model.View;

import com.ap.gwentgame.model.Cards.Card;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class CardViewContainer<T extends CardView> extends FlowPane {
    private final ArrayList<? extends Card> cards;

    public <K extends Card> CardViewContainer(ArrayList<K> cards) {
        this.cards = cards;

        for (Card card : cards) {
            CardView cardView = CardView.getCardView(card);
            this.getChildren().add(cardView);
        }
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
    }

    public void remove(CardView cardView) {
        this.getChildren().remove(cardView);
    }

    public void clear() {
        this.getChildren().clear();
    }

    public ArrayList<T> getCardViews() {
        ArrayList<T> cardViews = new ArrayList<>();
        for (Node card : this.getChildren()) {
            cardViews.add((T) card);
        }
        return cardViews;
    }

    public ArrayList<? extends Card> getCards() {
        return cards;
    }

    public boolean contains(CardView cardView) {
        return this.getChildren().contains(cardView);
    }

    public T findByName(String name){
        for (T cardView : getCardViews()) {
            if (cardView.getCard().getName().equals(name)) {
                return cardView;
            }
        }
        return null;
    }
}
