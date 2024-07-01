package com.ap.gwentgame.enums;

public enum FactionType {
    NEUTRAL, MONSTERS, NILFGAARDIAN_EMPIRE, NORTHERN_REALMS, SCOIATAEL, SKELLIGE;

    @Override
    public String toString() {
        return name().substring(0, 1).toUpperCase() + name().substring(1).toLowerCase();
    }
}
