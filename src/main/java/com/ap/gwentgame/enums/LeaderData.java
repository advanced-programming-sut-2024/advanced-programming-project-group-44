package com.ap.gwentgame.enums;

import com.ap.gwentgame.model.Leaders.Leader;

public enum LeaderData {
    THE_SIEGEMASTER("The SiegeMaster", FactionType.NORTHERN_REALMS),
    THE_STEEL_FORGED("The Steel-Forged", FactionType.NORTHERN_REALMS),
    KING_OF_TEMERIA("King of Temeria", FactionType.NORTHERN_REALMS),
    LORD_COMMANDER_OF_THE_NORTH("Lord Commander of the North", FactionType.NORTHERN_REALMS),
    SON_OF_MEDELL("Son of Medell", FactionType.NORTHERN_REALMS),
    THE_WHITE_FLAME("The White Flame", FactionType.NILFGAARDIAN_EMPIRE),
    HIS_IMPERIAL_MAJESTY("His Imperial Majesty", FactionType.NILFGAARDIAN_EMPIRE),
    EMPEROR_OF_NILFGAARD("Emperor of Nilfgaard", FactionType.NILFGAARDIAN_EMPIRE),
    THE_RELENTLESS("The Relentless", FactionType.NILFGAARDIAN_EMPIRE),
    INVADER_OF_THE_NORTH("Invader of the North", FactionType.NILFGAARDIAN_EMPIRE),
    BRINGER_OF_DEATH("Bringer of Death", FactionType.MONSTERS),
    KING_OF_THE_WILD_HUNT("King of the wild Hunt", FactionType.MONSTERS),
    DESTROYER_OF_WORLDS("Destroyer of Worlds", FactionType.MONSTERS),
    COMMANDER_OF_THE_RED_RIDERS("Commander of the Red Riders", FactionType.MONSTERS),
    THE_TREACHEROUS("The Treacherous", FactionType.MONSTERS),
    QUEEN_OF_DOL_BLATHANNA("Queen of Dol Blathanna", FactionType.SCOIATAEL),
    THE_BEAUTIFUL("The Beautiful", FactionType.SCOIATAEL),
    DAISY_OF_THE_VALLEY("Daisy of the Valley", FactionType.SCOIATAEL),
    PUREBLOOD_ELF("Pureblood Elf", FactionType.SCOIATAEL),
    HOPE_OF_THE_AEN_SEIDHE("Hope of the Aen Seidhe", FactionType.SCOIATAEL),
    CRACH_AN_CRAITE("Crach an Craite", FactionType.SKELLIGE),
    KING_BRAN("King Bran", FactionType.SKELLIGE);

    private final String name;
    private final FactionType factionType;

    LeaderData(String name, FactionType factionType) {
        this.name = name;
        this.factionType = factionType;
    }

    public String getName() {
        return name;
    }

    public FactionType getFactionType() {
        return factionType;
    }
}
