package com.ap.gwentgame.client.controller.model.Cards;

import javafx.scene.layout.AnchorPane;

public class Item extends AnchorPane {
    private final String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
