package com.ap.gwentgame.enums;

import com.ap.gwentgame.client.model.gameElements.Leader;

import static com.ap.gwentgame.enums.FactionType.*;

public enum LeaderCardData {
    THE_SIEGEMASTER("The SiegeMaster", NORTHERN_REALMS),
    THE_STEEL_FORGED("The Steel-Forged", NORTHERN_REALMS),
    KING_OF_TEMERIA("King of Temeria", NORTHERN_REALMS),
    LORD_COMMANDER_OF_THE_NORTH("Lord Commander of the North", NORTHERN_REALMS),
    SON_OF_MEDELL("Son of Medell", NORTHERN_REALMS),
    THE_WHITE_FLAME("The White Flame", NILFGAARDIAN_EMPIRE),
    HIS_IMPERIAL_MAJESTY("His Imperial Majesty", NILFGAARDIAN_EMPIRE),
    EMPEROR_OF_NILFGAARD("Emperor of Nilfgaard", NILFGAARDIAN_EMPIRE),
    THE_RELENTLESS("The Relentless", NILFGAARDIAN_EMPIRE),
    INVADER_OF_THE_NORTH("Invader of the North", NILFGAARDIAN_EMPIRE),
    BRINGER_OF_DEATH("Bringer of Death", MONSTERS),
    KING_OF_THE_WILD_HUNT("King of the wild Hunt", MONSTERS),
    DESTROYER_OF_WORLDS("Destroyer of Worlds", MONSTERS),
    COMMANDER_OF_THE_RED_RIDERS("Commander of the Red Riders", MONSTERS),
    THE_TREACHEROUS("The Treacherous", MONSTERS),
    QUEEN_OF_DOL_BLATHANNA("Queen of Dol Blathanna", SCOIATAEL),
    THE_BEAUTIFUL("The Beautiful", SCOIATAEL),
    DAISY_OF_THE_VALLEY("Daisy of the Valley", SCOIATAEL),
    PUREBLOOD_ELF("Pureblood Elf", SCOIATAEL),
    HOPE_OF_THE_AEN_SEIDHE("Hope of the Aen Seidhe", SCOIATAEL),
    CRACH_AN_CRAITE("Crach an Craite", SKELLIGE),
    KING_BRAN("King Bran", SKELLIGE);

    private final String name;
    private final FactionType factionType;

    LeaderCardData(String name, FactionType factionType) {
        this.name = name;
        this.factionType = factionType;
    }

    public Leader getLeader() {
        try {
            //convert constant names to camel case
            String[] nameParts = name.split("[ -]");
            StringBuilder leaderName = new StringBuilder();
            for (String part : nameParts) {
                leaderName.append(part.substring(0, 1).toUpperCase()).append(part.substring(1).toLowerCase());
            }
            Class<?> leaderClass = Class.forName("com.ap.gwentgame.client.model.Leaders." + leaderName);
            return (Leader) leaderClass.getDeclaredConstructor(String.class, FactionType.class).newInstance(name, factionType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
