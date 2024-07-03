package com.ap.gwentgame.model;

import com.ap.gwentgame.model.Cards.Item;
import com.ap.gwentgame.model.Cards.PreGameCard;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Collection;

public class ItemContainer<T extends Item> extends FlowPane {
    public ItemContainer() {
        this.orientationProperty().setValue(Orientation.HORIZONTAL);
    }

    public void setVisuals(Pane pane, double x, double y, double width, double height, double horizontalGap, double verticalGap) {
        this.setLayoutX(x);
        this.setLayoutY(y);
        this.setPrefWidth(width);
        this.setPrefHeight(height);
        this.setHgap(horizontalGap);
        this.setVgap(verticalGap);
        pane.getChildren().add(this);
    }

    public void setVisuals(double width, double height, double horizontalGap, double verticalGap) {
        this.setPrefWidth(width);
        this.setPrefHeight(height);
        this.setHgap(horizontalGap);
        this.setVgap(verticalGap);
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

    public boolean contains(PreGameCard preGameCard) {
        for (T item : getItems()) {
            if (item.equals(preGameCard)) {
                return true;
            }
        }
        return false;
    }

    public Item findByName(String name){
        for (T item : getItems()) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public int size() {
        return  this.getChildren().size();
    }

    public void addAll(ItemContainer<T> row) {
        this.getChildren().addAll(row.getChildren());
    }
    public void addAll(Collection<T> row) {
        this.getChildren().addAll(row);
    }
}
