package com.ap.gwentgame.enums.assets;

public enum Icons {
    ;
    private final String name;

    Icons(String name) {
        this.name = name;
    }

    public String getPath() {
        return "src/main/resources/assets/images/icons/" + name;
    }
}
