package com.ap.gwentgame.enums;

public enum SpecialCardData {
    DECOY("Decoy");
    private String name;

    SpecialCardData(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
