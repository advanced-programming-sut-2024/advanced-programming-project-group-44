package com.ap.gwentgame.enums.assets;

public enum Items {
    ;

    private final String name;

    Items(String name) {
        this.name = name;
    }

    public String getPath() {
        return "src/main/resources/assets/images/items/" + name;
    }
}
