package com.ap.gwentgame.enums;


import com.ap.gwentgame.model.Abilities.Ability;

import static com.ap.gwentgame.enums.AbilityType.*;
import static com.ap.gwentgame.enums.Placement.*;

public enum UnitCardData {
    DANDELION("Dandelion", 2, CLOSE_COMBAT, COMMANDERSHORN, false, false),
    YENNEFER_OF_VENGERBERG("Yennefer of Vengerberg", 7, RANGED_COMBAT, MEDIC, false, false),
    OLGIERD_VON_EVERC("Olgierd Von Everc", 6, AGILE, MORALBOOST, false, false),
    GAUNTER_ODIMM("Gaunter O’Dimm", 2, SIEGE, MUSTER, false, false),
    GAUNTER_ODIMM_DARKNESS("Gaunter O’DImm Darkness", 4, RANGED_COMBAT, MUSTER, false, false),
    VILLENTRETENMERTH("Villentretenmerth", 7, CLOSE_COMBAT, SCORCH, false, false),
    MYSTERIOUS_ELF("Mysterious Elf", 0, CLOSE_COMBAT, SPY, false, false),
    COW("Cow", 0, RANGED_COMBAT, TRANSFORMERS, false, false),
    EMIEL_REGIS("Emiel Regis", 5, CLOSE_COMBAT, NONE, false, false),
    GERALT_OF_RIVIA("Geralt of Rivia", 15, CLOSE_COMBAT, NONE, false, false),
    TRISS_MERIGOLD("Triss Merigold", 7, CLOSE_COMBAT, NONE, false, false),
    VESEMIR("Vesemir", 6, CLOSE_COMBAT, NONE, false, false),
    ZOLTAN_CHIVAY("Zoltan Chivay", 5, CLOSE_COMBAT, NONE, false, false),
    KAYRAN("Kayran", 8, AGILE, MORALBOOST, false, true),
    ARACHAS("Arachas", 4, CLOSE_COMBAT, MUSTER, false, true),
    ARACHAS_BEHEMOTH("Arachas Behemoth", 6, SIEGE, MUSTER, false, true),
    CRONE_BREWESS("Crone: Brewess", 6, CLOSE_COMBAT, MUSTER, false, true),
    CRONE_WEAVESS("Crone: Weavess", 6, CLOSE_COMBAT, MUSTER, false, true),
    CRONE_WHISPESS("Crone: Whispess", 6, CLOSE_COMBAT, MUSTER, false, true),
    GHOUL("Ghoul", 1, CLOSE_COMBAT, MUSTER, false, true),
    NEKKER("Nekker", 2, CLOSE_COMBAT, MUSTER, false, true),
    VAMPIRE_BRUXA("Vampire: Bruxa", 4, CLOSE_COMBAT, MUSTER, false, true),
    VAMPIRE_EKIMMARA("Vampire: Ekimmara", 4, CLOSE_COMBAT, MUSTER, false, true),
    VAMPIRE_FLEDER("Vampire: Fleder", 4, CLOSE_COMBAT, MUSTER, false, true),
    VAMPIRE_GARKAIN("Vampire: Garkain", 4, CLOSE_COMBAT, MUSTER, false, true),
    VAMPIRE_KATAKAN("Vampire: Katakan", 5, CLOSE_COMBAT, MUSTER, false, true),
    TOAD("Toad", 7, RANGED_COMBAT, SCORCH, false, true),
    BOTCHLING("Botchling", 4, CLOSE_COMBAT, NONE, false, true),
    CELAENO_HARPY("Celaeno Harpy", 2, AGILE, NONE, false, true),
    COCKATRICE("Cockatrice", 2, RANGED_COMBAT, NONE, false, true),
    DRAUG("Draug", 10, CLOSE_COMBAT, NONE, false, true),
    EARTH_ELEMENTAL("Earth Elemental", 6, SIEGE, NONE, false, true),
    ENDREGA("Endrega", 2, RANGED_COMBAT, NONE, false, true),
    FIEND("Fiend", 6, CLOSE_COMBAT, NONE, false, true),
    FIRE_ELEMENTAL("Fire Elemental", 6, SIEGE, NONE, false, true),
    FOGLET("Foglet", 2, CLOSE_COMBAT, NONE, false, true),
    FORKTAIL("Forktail", 5, CLOSE_COMBAT, NONE, false, true),
    FRIGHTENER("Frightener", 5, CLOSE_COMBAT, NONE, false, true),
    GARGOYLE("Gargoyle", 2, RANGED_COMBAT, NONE, false, true),
    GRAVE_HAG("Grave Hag", 5, RANGED_COMBAT, NONE, false, true),
    GRIFFIN("Griffin", 5, CLOSE_COMBAT, NONE, false, true),
    HARPY("Harpy", 2, AGILE, NONE, false, true),
    ICE_GIANT("Ice Giant", 5, SIEGE, NONE, false, true),
    IMLERITH("Imlerith", 10, CLOSE_COMBAT, NONE, false, true),
    LESHEN("Leshen", 10, CLOSE_COMBAT, NONE, false, true),
    PLAGUE_MAIDEN("Plague Maiden", 5, CLOSE_COMBAT, NONE, false, true),
    WEREWOLF("Werewolf", 5, CLOSE_COMBAT, NONE, false, true),
    WYVERN("Wyvern", 2, RANGED_COMBAT, NONE, false, true),
    ETOLIAN_AUXILIARY_ARCHERS_("Etolian Auxiliary Archers ", 1, RANGED_COMBAT, MEDIC, false, true),
    MENNO_COEHOORN("Menno Coehoorn", 10, CLOSE_COMBAT, MEDIC, false, true),
    SIEGE_TECHNICIAN("SIEGE Technician", 0, SIEGE, MEDIC, false, true),
    SHILARD_FITZ_OESTERLEN("Shilard Fitz-Oesterlen", 7, CLOSE_COMBAT, SPY, false, true),
    STEFAN_SKELLEN("Stefan Skellen", 9, CLOSE_COMBAT, SPY, false, true),
    VATTIER_DE_RIDEAUX("Vattier de Rideaux", 4, CLOSE_COMBAT, SPY, false, true),
    IMPERA_BRIGADE_GUARD("Impera Brigade Guard", 3, CLOSE_COMBAT, TIGHTBOND, false, true),
    NAUSICAA_CAVALRY_RIDER("Nausicaa Cavalry Rider", 2, CLOSE_COMBAT, TIGHTBOND, false, true),
    YOUNG_EMISSARY("Young Emissary", 5, CLOSE_COMBAT, TIGHTBOND, false, true),
    ALBRICH("Albrich", 2, RANGED_COMBAT, NONE, false, true),
    ASSIRE_VAR_ANAHID("Assire var Anahid", 6, RANGED_COMBAT, NONE, false, true),
    BLACK_INFANTRY_ARCHER("Black Infantry Archer", 10, RANGED_COMBAT, NONE, false, true),
    CAHIR_MAWR_DYFFRYN_AEP_CEALLACH("Cahir Mawr Dyffryn aep Ceallach", 6, CLOSE_COMBAT, NONE, false, true),
    CYNTHIA("Cynthia", 4, RANGED_COMBAT, NONE, false, true),
    FRINGILLA_VIGO("Fringilla Vigo", 6, RANGED_COMBAT, NONE, false, true),
    HEAVY_ZERRIKANIAN_FIRE_SCORPION("Heavy Zerrikanian Fire Scorpion", 10, SIEGE, NONE, false, true),
    LETHO_OF_GULET("Letho of Gulet", 10, CLOSE_COMBAT, NONE, false, true),
    MORTEISEN("Morteisen", 3, CLOSE_COMBAT, NONE, false, true),
    MORVRAN_VOORHIS("Morvran Voorhis", 10, SIEGE, NONE, false, true),
    PUTTKAMMER("Puttkammer", 3, RANGED_COMBAT, NONE, false, true),
    RAINFARN_("Rainfarn ", 4, CLOSE_COMBAT, NONE, false, true),
    RENUALD_AEP_MATSEN("Renuald aep Matsen", 5, RANGED_COMBAT, NONE, false, true),
    ROTTEN_MANGONEL("Rotten Mangonel", 3, SIEGE, NONE, false, true),
    SIEGE_ENGINEER("SIEGE Engineer", 6, SIEGE, NONE, false, true),
    SWEERS("Sweers", 2, RANGED_COMBAT, NONE, false, true),
    TIBOR_EGGEBRACHT("Tibor Eggebracht", 10, RANGED_COMBAT, NONE, false, true),
    VANHEMAR("Vanhemar", 4, RANGED_COMBAT, NONE, false, true),
    VREEMDE("Vreemde", 2, CLOSE_COMBAT, NONE, false, true),
    ZERRIKANIAN_FIRE_SCORPION("Zerrikanian Fire Scorpion", 5, SIEGE, NONE, false, true),
    DUN_BANNER_MEDIC("Dun Banner Medic", 5, SIEGE, MEDIC, false, true),
    KAEDWENI_SIEGE_EXPERT("Kaedweni SIEGE Expert", 1, SIEGE, MORALBOOST, false, true),
    PRINCE_STENNIS("Prince Stennis", 5, CLOSE_COMBAT, SPY, false, true),
    SIGISMUND_DIJKSTRA("Sigismund Dijkstra", 4, CLOSE_COMBAT, SPY, false, true),
    THALER("Thaler", 1, SIEGE, SPY, false, true),
    BLUE_STRIPES_COMMANDO("Blue Stripes Commando", 4, CLOSE_COMBAT, TIGHTBOND, false, true),
    CATAPULT("Catapult", 8, SIEGE, TIGHTBOND, false, true),
    DRAGON_HUNTER("Dragon Hunter", 5, RANGED_COMBAT, TIGHTBOND, false, true),
    POOR_FUCKING_INFANTRY("Poor Fucking Infantry", 1, CLOSE_COMBAT, TIGHTBOND, false, true),
    BALLISTA("Ballista", 6, SIEGE, NONE, false, true),
    DETHMOLD("Dethmold", 6, RANGED_COMBAT, NONE, false, true),
    ESTERAD_THYSSEN("Esterad Thyssen", 10, CLOSE_COMBAT, NONE, false, true),
    JOHN_NATALIS("John Natalis", 10, CLOSE_COMBAT, NONE, false, true),
    KEIRA_METZ("Keira Metz", 5, RANGED_COMBAT, NONE, false, true),
    PHILIPPA_EILHART("Philippa Eilhart", 10, RANGED_COMBAT, NONE, false, true),
    REDANIAN_FOOT_SOLDIER("Redanian Foot Soldier", 1, CLOSE_COMBAT, NONE, false, true),
    SABRINA_GLEVISSING("Sabrina Glevissing", 4, RANGED_COMBAT, NONE, false, true),
    SHELDON_SKAGGS("Sheldon Skaggs", 4, RANGED_COMBAT, NONE, false, true),
    SIEGE_TOWER("SIEGE Tower", 6, SIEGE, NONE, false, true),
    SIEGFRIED_OF_DENESLE("Siegfried of Denesle", 5, CLOSE_COMBAT, NONE, false, true),
    SÍLE_DE_TANSARVILLE("Síle de Tansarville", 5, RANGED_COMBAT, NONE, false, true),
    TREBUCHET("Trebuchet", 6, SIEGE, NONE, false, true),
    VERNON_ROCHE("Vernon Roche", 10, CLOSE_COMBAT, NONE, false, true),
    VES("Ves", 5, CLOSE_COMBAT, NONE, false, true),
    YARPEN_ZIRGRIN("Yarpen Zirgrin", 2, CLOSE_COMBAT, NONE, false, true),
    HAVEKAR_HEALER("Havekar Healer", 0, RANGED_COMBAT, MEDIC, false, true),
    ISENGRIM_FAOILTIARNA("Isengrim Faoiltiarna", 10, CLOSE_COMBAT, MORALBOOST, false, true),
    MILVA("Milva", 10, RANGED_COMBAT, MORALBOOST, false, true),
    DWARVEN_SKIRMISHER("Dwarven Skirmisher", 3, CLOSE_COMBAT, MUSTER, false, true),
    ELVEN_SKIRMISHER("Elven Skirmisher", 2, RANGED_COMBAT, MUSTER, false, true),
    HAVEKAR_SMUGGLER("Havekar Smuggler", 5, CLOSE_COMBAT, MUSTER, false, true),
    SCHIRRU("Schirru", 8, SIEGE, SCORCH, false, true),
    BARCLAY_ELS("Barclay Els", 6, AGILE, NONE, false, true),
    CIARAN_AEP("Ciaran aep", 3, AGILE, NONE, false, true),
    DENNIS_CRANMER("Dennis Cranmer", 6, CLOSE_COMBAT, NONE, false, true),
    DOL_BLATHANNA_ARCHER("Dol Blathanna Archer", 4, RANGED_COMBAT, NONE, false, true),
    DOL_BLATHANNA_SCOUT("Dol Blathanna Scout", 6, AGILE, NONE, false, true),
    EITHNE("Eithne", 10, RANGED_COMBAT, NONE, false, true),
    FILAVANDREL("Filavandrel", 6, AGILE, NONE, false, true),
    IDA_EMEAN_AEP("Ida Emean aep", 6, RANGED_COMBAT, NONE, false, true),
    IORVETH("Iorveth", 10, RANGED_COMBAT, NONE, false, true),
    MAHAKAMAN_DEFENDER("Mahakaman Defender", 5, CLOSE_COMBAT, NONE, false, true),
    RIORDAIN("Riordain", 1, RANGED_COMBAT, NONE, false, true),
    SEASENTHESSIS("Seasenthessis", 10, RANGED_COMBAT, NONE, false, true),
    TORUVIEL("Toruviel", 2, RANGED_COMBAT, NONE, false, true),
    VRIHEDD_BRIGADE_RECRUIT("Vrihedd Brigade Recruit", 4, RANGED_COMBAT, NONE, false, true),
    VRIHEDD_BRIGADE_VETERAN("Vrihedd Brigade Veteran", 5, AGILE, NONE, false, true),
    YAEVINN("Yaevinn", 6, AGILE, NONE, false, true),
    YOUNG_BERSERKER("Young Berserker", 2, RANGED_COMBAT, BERSERKER, false, true),
    DRAIG_BON_DHU("Draig Bon-Dhu", 2, SIEGE, NONE, false, true),
    ERMION("Ermion", 8, RANGED_COMBAT, MARDROEME, false, true),
    BIRNA_BRAN("Birna Bran", 2, CLOSE_COMBAT, MEDIC, false, true),
    OLAF("Olaf", 12, AGILE, MORALBOOST, false, true),
    VIDKAARL("Vidkaarl", 14, CLOSE_COMBAT, MORALBOOST, false, true),
    CERYS("Cerys", 10, CLOSE_COMBAT, MUSTER, false, true),
    LIGHT_LONGSHIP("Light Longship", 4, RANGED_COMBAT, MUSTER, false, true),
    CLAN_DIMUN_PIRATE("Clan Dimun Pirate", 6, RANGED_COMBAT, SCORCH, false, true),
    CLAN_AN_CRAITE("Clan An Craite", 6, CLOSE_COMBAT, TIGHTBOND, false, true),
    CLAN_DRUMMOND_SHIELDMAIDEN("Clan Drummond Shieldmaiden", 4, CLOSE_COMBAT, TIGHTBOND, false, true),
    WAR_LONGSHIP("War Longship", 6, SIEGE, TIGHTBOND, false, true),
    YOUNG_VIDKAARL("Young Vidkaarl", 8, RANGED_COMBAT, TIGHTBOND, false, true),
    KAMBI("Kambi", 11, CLOSE_COMBAT, TRANSFORMERS, false, true),
    BLUEBOY_LUGOS("Blueboy Lugos", 6, CLOSE_COMBAT, NONE, false, true),
    CLAN_BROKVAR_ARCHER("Clan Brokvar Archer", 6, RANGED_COMBAT, NONE, false, true),
    CLAN_TORDARROCH_ARMORSMITH("Clan Tordarroch Armorsmith", 4, CLOSE_COMBAT, NONE, false, true),
    DONAR_AN_HINDAR("Donar an Hindar", 4, CLOSE_COMBAT, NONE, false, true),
    HJALMAR("Hjalmar", 10, RANGED_COMBAT, NONE, false, true),
    HOLGER_BLACKHAND("Holger Blackhand", 4, SIEGE, NONE, false, true),
    MADMAN_LUGOS("Madman Lugos", 6, CLOSE_COMBAT, NONE, false, true),
    SVANRIGE("Svanrige", 4, CLOSE_COMBAT, NONE, false, true),
    UDALRYK("Udalryk", 4, CLOSE_COMBAT, NONE, false, true);
    private final String name;
    private final int score;
    private final Placement placement;
    private final AbilityType abilityType;
    private final boolean isHero;
    private final boolean isExclusive;

    UnitCardData(String name, int score, Placement placement, AbilityType abilityType, boolean isHero, boolean isExclusive) {
        this.name = name;
        this.score = score;
        this.placement = placement;
        this.abilityType = abilityType;
        this.isHero = isHero;
        this.isExclusive = isExclusive;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public Placement getPlacement() {
        return placement;
    }

    public AbilityType getAbilityType() {
        return abilityType;
    }

    public boolean isHero() {
        return isHero;
    }

    public boolean isExclusive() {
        return isExclusive;
    }
}
