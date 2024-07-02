package com.ap.gwentgame.model;

import com.ap.gwentgame.model.Cards.Item;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class ItemContainer<T extends Item> extends FlowPane {
    public ItemContainer() {
        this.orientationProperty().setValue(Orientation.HORIZONTAL);
    }

    public void setVisuals(Pane pane, int x, int y, int width, int height, int horizontalGap, int verticalGap) {
        this.setLayoutX(x);
        this.setLayoutY(y);
        this.setPrefWidth(width);
        this.setPrefHeight(height);
        this.setHgap(horizontalGap);
        this.setVgap(verticalGap);
        pane.getChildren().add(this);
    }

    public void add(T item) {
        this.getChildren().add(item);
    }

    public void remove(T item) {
        this.getChildren().remove(item);
    }

    public void clear() {
        this.getChildren().clear();
    }

    public ArrayList<T> getItems() {
        ArrayList<T> cards = new ArrayList<>();
        for (int i = 0; i < this.getChildren().size(); i++) {
            Node node = this.getChildren().get(i);
            try {
                if (node instanceof Item) {
                    cards.add((T) node);
                }
            } catch (ClassCastException e) {
                System.out.println("ClassCastException in ItemContainer");
            }
        }
        return cards;
    }
}
