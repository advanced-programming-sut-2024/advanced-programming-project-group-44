package com.ap.gwentgame.model;

import com.ap.gwentgame.model.Cards.Item;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.layout.FlowPane;

import java.util.ArrayList;

public class CardContainer<T extends Item> extends FlowPane {
    public CardContainer(int x, int y, int width, int height, int horizontalGap, int verticalGap) {
        super();
        this.setLayoutX(x);
        this.setLayoutY(y);
        this.setPrefWidth(width);
        this.setPrefHeight(height);
        this.setHgap(horizontalGap);
        this.setVgap(verticalGap);
        this.orientationProperty().setValue(Orientation.HORIZONTAL);
    }

    public void addCard(T card) {
        this.getChildren().add(card);
    }

    public void removeCard(T card) {
        this.getChildren().remove(card);
    }

    public void clear() {
        this.getChildren().clear();
    }

    public ArrayList<T> getCards() {
        ArrayList<T> cards = new ArrayList<>();
        for (int i = 0; i < this.getChildren().size(); i++) {
            Node node = this.getChildren().get(i);
            try {
                cards.add((T) node);
            } catch (ClassCastException e) {
                System.out.println("ClassCastException in CardContainer");
            }
        }
        return cards;
    }
}
