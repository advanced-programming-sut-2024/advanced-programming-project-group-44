package com.ap.gwentgame.enums.assets;

public enum Backgrounds {
    MainBG("mainBG.jpg");

    private final String name;

    Backgrounds(String name) {
        this.name = name;
    }

    public String getPath() {
        return "src/main/resources/assets/images/backgrounds/" + name;
    }
}
