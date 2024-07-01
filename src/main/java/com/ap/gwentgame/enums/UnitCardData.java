package com.ap.gwentgame.enums;

import com.ap.gwentgame.model.Cards.UnitCard;

import static com.ap.gwentgame.enums.AbilityType.*;
import static com.ap.gwentgame.enums.FactionType.*;
import static com.ap.gwentgame.enums.Placement.*;

public enum UnitCardData {
    DANDELION("Dandelion", 2, CLOSE_COMBAT, COMMANDERSHORN, NEUTRAL, 1, false),
    YENNEFER_OF_VENGERBERG("Yennefer of Vengerberg", 7, RANGED_COMBAT, MEDIC, NEUTRAL, 1, true),
    OLGIERD_VON_EVERC("Olgierd Von Everc", 6, AGILE, MORALBOOST, NEUTRAL, 1, false),
    GAUNTER_ODIMM("Gaunter O’Dimm", 2, SIEGE, MUSTER, NEUTRAL, 1, false),
    GAUNTER_ODIMM_DARKNESS("Gaunter O’DImm Darkness", 4, RANGED_COMBAT, MUSTER, NEUTRAL, 3, false),
    VILLENTRETENMERTH("Villentretenmerth", 7, CLOSE_COMBAT, SCORCH, NEUTRAL, 1, false),
    MYSTERIOUS_ELF("Mysterious Elf", 0, CLOSE_COMBAT, SPY, NEUTRAL, 1, true),
    COW("Cow", 0, RANGED_COMBAT, TRANSFORMERS, NEUTRAL, 1, false),
    EMIEL_REGIS("Emiel Regis", 5, CLOSE_COMBAT, NONE, NEUTRAL, 1, false),
    GERALT_OF_RIVIA("Geralt of Rivia", 15, CLOSE_COMBAT, NONE, NEUTRAL, 1, true),
    TRISS_MERIGOLD("Triss Merigold", 7, CLOSE_COMBAT, NONE, NEUTRAL, 1, true),
    VESEMIR("Vesemir", 6, CLOSE_COMBAT, NONE, NEUTRAL, 1, false),
    ZOLTAN_CHIVAY("Zoltan Chivay", 5, CLOSE_COMBAT, NONE, NEUTRAL, 1, false),
    KAYRAN("Kayran", 8, AGILE, MORALBOOST, MONSTERS, 1, true),
    ARACHAS("Arachas", 4, CLOSE_COMBAT, MUSTER, MONSTERS, 3, false),
    ARACHAS_BEHEMOTH("Arachas Behemoth", 6, SIEGE, MUSTER, MONSTERS, 1, false),
    CRONE__BREWESS("Crone: Brewess", 6, CLOSE_COMBAT, MUSTER, MONSTERS, 1, false),
    CRONE__WEAVESS("Crone: Weavess", 6, CLOSE_COMBAT, MUSTER, MONSTERS, 1, false),
    CRONE__WHISPESS("Crone: Whispess", 6, CLOSE_COMBAT, MUSTER, MONSTERS, 1, false),
    GHOUL("Ghoul", 1, CLOSE_COMBAT, MUSTER, MONSTERS, 3, false),
    NEKKER("Nekker", 2, CLOSE_COMBAT, MUSTER, MONSTERS, 3, false),
    VAMPIRE__BRUXA("Vampire: Bruxa", 4, CLOSE_COMBAT, MUSTER, MONSTERS, 1, false),
    VAMPIRE__EKIMMARA("Vampire: Ekimmara", 4, CLOSE_COMBAT, MUSTER, MONSTERS, 1, false),
    VAMPIRE__FLEDER("Vampire: Fleder", 4, CLOSE_COMBAT, MUSTER, MONSTERS, 1, false),
    VAMPIRE__GARKAIN("Vampire: Garkain", 4, CLOSE_COMBAT, MUSTER, MONSTERS, 1, false),
    VAMPIRE__KATAKAN("Vampire: Katakan", 5, CLOSE_COMBAT, MUSTER, MONSTERS, 1, false),
    TOAD("Toad", 7, RANGED_COMBAT, SCORCH, MONSTERS, 1, false),
    BOTCHLING("Botchling", 4, CLOSE_COMBAT, NONE, MONSTERS, 1, false),
    CELAENO_HARPY("Celaeno Harpy", 2, AGILE, NONE, MONSTERS, 1, false),
    COCKATRICE("Cockatrice", 2, RANGED_COMBAT, NONE, MONSTERS, 1, false),
    DRAUG("Draug", 10, CLOSE_COMBAT, NONE, MONSTERS, 1, true),
    EARTH_ELEMENTAL("Earth Elemental", 6, SIEGE, NONE, MONSTERS, 1, false),
    ENDREGA("Endrega", 2, RANGED_COMBAT, NONE, MONSTERS, 1, false),
    FIEND("Fiend", 6, CLOSE_COMBAT, NONE, MONSTERS, 1, false),
    FIRE_ELEMENTAL("Fire Elemental", 6, SIEGE, NONE, MONSTERS, 1, false),
    FOGLET("Foglet", 2, CLOSE_COMBAT, NONE, MONSTERS, 1, false),
    FORKTAIL("Forktail", 5, CLOSE_COMBAT, NONE, MONSTERS, 1, false),
    FRIGHTENER("Frightener", 5, CLOSE_COMBAT, NONE, MONSTERS, 1, false),
    GARGOYLE("Gargoyle", 2, RANGED_COMBAT, NONE, MONSTERS, 1, false),
    GRAVE_HAG("Grave Hag", 5, RANGED_COMBAT, NONE, MONSTERS, 1, false),
    GRIFFIN("Griffin", 5, CLOSE_COMBAT, NONE, MONSTERS, 1, false),
    HARPY("Harpy", 2, AGILE, NONE, MONSTERS, 1, false),
    ICE_GIANT("Ice Giant", 5, SIEGE, NONE, MONSTERS, 1, false),
    IMLERITH("Imlerith", 10, CLOSE_COMBAT, NONE, MONSTERS, 1, true),
    LESHEN("Leshen", 10, CLOSE_COMBAT, NONE, MONSTERS, 1, true),
    PLAGUE_MAIDEN("Plague Maiden", 5, CLOSE_COMBAT, NONE, MONSTERS, 1, false),
    WEREWOLF("Werewolf", 5, CLOSE_COMBAT, NONE, MONSTERS, 1, false),
    WYVERN("Wyvern", 2, RANGED_COMBAT, NONE, MONSTERS, 1, false),
    ETOLIAN_AUXILIARY_ARCHERS_("Etolian Auxiliary Archers ", 1, RANGED_COMBAT, MEDIC, NILFGAARDIAN_EMPIRE, 2, false),
    MENNO_COEHOORN("Menno Coehoorn", 10, CLOSE_COMBAT, MEDIC, NILFGAARDIAN_EMPIRE, 1, true),
    SIEGE_TECHNICIAN("SIEGE Technician", 0, SIEGE, MEDIC, NILFGAARDIAN_EMPIRE, 1, false),
    SHILARD_FITZ_OESTERLEN("Shilard Fitz-Oesterlen", 7, CLOSE_COMBAT, SPY, NILFGAARDIAN_EMPIRE, 1, false),
    STEFAN_SKELLEN("Stefan Skellen", 9, CLOSE_COMBAT, SPY, NILFGAARDIAN_EMPIRE, 1, false),
    VATTIER_DE_RIDEAUX("Vattier de Rideaux", 4, CLOSE_COMBAT, SPY, NILFGAARDIAN_EMPIRE, 1, false),
    IMPERA_BRIGADE_GUARD("Impera Brigade Guard", 3, CLOSE_COMBAT, TIGHTBOND, NILFGAARDIAN_EMPIRE, 4, false),
    NAUSICAA_CAVALRY_RIDER("Nausicaa Cavalry Rider", 2, CLOSE_COMBAT, TIGHTBOND, NILFGAARDIAN_EMPIRE, 3, false),
    YOUNG_EMISSARY("Young Emissary", 5, CLOSE_COMBAT, TIGHTBOND, NILFGAARDIAN_EMPIRE, 2, false),
    ALBRICH("Albrich", 2, RANGED_COMBAT, NONE, NILFGAARDIAN_EMPIRE, 1, false),
    ASSIRE_VAR_ANAHID("Assire var Anahid", 6, RANGED_COMBAT, NONE, NILFGAARDIAN_EMPIRE, 1, false),
    BLACK_INFANTRY_ARCHER("Black Infantry Archer", 10, RANGED_COMBAT, NONE, NILFGAARDIAN_EMPIRE, 2, false),
    CAHIR_MAWR_DYFFRYN_AEP_CEALLACH("Cahir Mawr Dyffryn aep Ceallach", 6, CLOSE_COMBAT, NONE, NILFGAARDIAN_EMPIRE, 1, false),
    CYNTHIA("Cynthia", 4, RANGED_COMBAT, NONE, NILFGAARDIAN_EMPIRE, 1, false),
    FRINGILLA_VIGO("Fringilla Vigo", 6, RANGED_COMBAT, NONE, NILFGAARDIAN_EMPIRE, 1, false),
    HEAVY_ZERRIKANIAN_FIRE_SCORPION("Heavy Zerrikanian Fire Scorpion", 10, SIEGE, NONE, NILFGAARDIAN_EMPIRE, 1, false),
    LETHO_OF_GULET("Letho of Gulet", 10, CLOSE_COMBAT, NONE, NILFGAARDIAN_EMPIRE, 1, true),
    MORTEISEN("Morteisen", 3, CLOSE_COMBAT, NONE, NILFGAARDIAN_EMPIRE, 1, false),
    MORVRAN_VOORHIS("Morvran Voorhis", 10, SIEGE, NONE, NILFGAARDIAN_EMPIRE, 1, true),
    PUTTKAMMER("Puttkammer", 3, RANGED_COMBAT, NONE, NILFGAARDIAN_EMPIRE, 1, false),
    RAINFARN_("Rainfarn ", 4, CLOSE_COMBAT, NONE, NILFGAARDIAN_EMPIRE, 1, false),
    RENUALD_AEP_MATSEN("Renuald aep Matsen", 5, RANGED_COMBAT, NONE, NILFGAARDIAN_EMPIRE, 1, false),
    ROTTEN_MANGONEL("Rotten Mangonel", 3, SIEGE, NONE, NILFGAARDIAN_EMPIRE, 1, false),
    SIEGE_ENGINEER("SIEGE Engineer", 6, SIEGE, NONE, NILFGAARDIAN_EMPIRE, 1, false),
    SWEERS("Sweers", 2, RANGED_COMBAT, NONE, NILFGAARDIAN_EMPIRE, 1, false),
    TIBOR_EGGEBRACHT("Tibor Eggebracht", 10, RANGED_COMBAT, NONE, NILFGAARDIAN_EMPIRE, 1, true),
    VANHEMAR("Vanhemar", 4, RANGED_COMBAT, NONE, NILFGAARDIAN_EMPIRE, 1, false),
    VREEMDE("Vreemde", 2, CLOSE_COMBAT, NONE, NILFGAARDIAN_EMPIRE, 1, false),
    ZERRIKANIAN_FIRE_SCORPION("Zerrikanian Fire Scorpion", 5, SIEGE, NONE, NILFGAARDIAN_EMPIRE, 1, false),
    DUN_BANNER_MEDIC("Dun Banner Medic", 5, SIEGE, MEDIC, NORTHERN_REALMS, 1, false),
    KAEDWENI_SIEGE_EXPERT("Kaedweni SIEGE Expert", 1, SIEGE, MORALBOOST, NORTHERN_REALMS, 3, false),
    PRINCE_STENNIS("Prince Stennis", 5, CLOSE_COMBAT, SPY, NORTHERN_REALMS, 1, false),
    SIGISMUND_DIJKSTRA("Sigismund Dijkstra", 4, CLOSE_COMBAT, SPY, NORTHERN_REALMS, 1, false),
    THALER("Thaler", 1, SIEGE, SPY, NORTHERN_REALMS, 1, false),
    BLUE_STRIPES_COMMANDO("Blue Stripes Commando", 4, CLOSE_COMBAT, TIGHTBOND, NORTHERN_REALMS, 3, false),
    CATAPULT("Catapult", 8, SIEGE, TIGHTBOND, NORTHERN_REALMS, 2, false),
    DRAGON_HUNTER("Dragon Hunter", 5, RANGED_COMBAT, TIGHTBOND, NORTHERN_REALMS, 3, false),
    POOR_FUCKING_INFANTRY("Poor Fucking Infantry", 1, CLOSE_COMBAT, TIGHTBOND, NORTHERN_REALMS, 4, false),
    BALLISTA("Ballista", 6, SIEGE, NONE, NORTHERN_REALMS, 2, false),
    DETHMOLD("Dethmold", 6, RANGED_COMBAT, NONE, NORTHERN_REALMS, 1, false),
    ESTERAD_THYSSEN("Esterad Thyssen", 10, CLOSE_COMBAT, NONE, NORTHERN_REALMS, 1, true),
    JOHN_NATALIS("John Natalis", 10, CLOSE_COMBAT, NONE, NORTHERN_REALMS, 1, true),
    KEIRA_METZ("Keira Metz", 5, RANGED_COMBAT, NONE, NORTHERN_REALMS, 1, false),
    PHILIPPA_EILHART("Philippa Eilhart", 10, RANGED_COMBAT, NONE, NORTHERN_REALMS, 1, true),
    REDANIAN_FOOT_SOLDIER("Redanian Foot Soldier", 1, CLOSE_COMBAT, NONE, NORTHERN_REALMS, 2, false),
    SABRINA_GLEVISSING("Sabrina Glevissing", 4, RANGED_COMBAT, NONE, NORTHERN_REALMS, 1, false),
    SHELDON_SKAGGS("Sheldon Skaggs", 4, RANGED_COMBAT, NONE, NORTHERN_REALMS, 1, false),
    SIEGE_TOWER("SIEGE Tower", 6, SIEGE, NONE, NORTHERN_REALMS, 1, false),
    SIEGFRIED_OF_DENESLE("Siegfried of Denesle", 5, CLOSE_COMBAT, NONE, NORTHERN_REALMS, 1, false),
    SÍLE_DE_TANSARVILLE("Síle de Tansarville", 5, RANGED_COMBAT, NONE, NORTHERN_REALMS, 1, false),
    TREBUCHET("Trebuchet", 6, SIEGE, NONE, NORTHERN_REALMS, 2, false),
    VERNON_ROCHE("Vernon Roche", 10, CLOSE_COMBAT, NONE, NORTHERN_REALMS, 1, true),
    VES("Ves", 5, CLOSE_COMBAT, NONE, NORTHERN_REALMS, 1, false),
    YARPEN_ZIRGRIN("Yarpen Zirgrin", 2, CLOSE_COMBAT, NONE, NORTHERN_REALMS, 1, false),
    HAVEKAR_HEALER("Havekar Healer", 0, RANGED_COMBAT, MEDIC, SCOIATAEL, 3, false),
    ISENGRIM_FAOILTIARNA("Isengrim Faoiltiarna", 10, CLOSE_COMBAT, MORALBOOST, SCOIATAEL, 1, true),
    MILVA("Milva", 10, RANGED_COMBAT, MORALBOOST, SCOIATAEL, 1, false),
    DWARVEN_SKIRMISHER("Dwarven Skirmisher", 3, CLOSE_COMBAT, MUSTER, SCOIATAEL, 3, false),
    ELVEN_SKIRMISHER("Elven Skirmisher", 2, RANGED_COMBAT, MUSTER, SCOIATAEL, 3, false),
    HAVEKAR_SMUGGLER("Havekar Smuggler", 5, CLOSE_COMBAT, MUSTER, SCOIATAEL, 3, false),
    SCHIRRU("Schirru", 8, SIEGE, SCORCH, SCOIATAEL, 1, false),
    BARCLAY_ELS("Barclay Els", 6, AGILE, NONE, SCOIATAEL, 1, false),
    CIARAN_AEP("Ciaran aep", 3, AGILE, NONE, SCOIATAEL, 1, false),
    DENNIS_CRANMER("Dennis Cranmer", 6, CLOSE_COMBAT, NONE, SCOIATAEL, 1, false),
    DOL_BLATHANNA_ARCHER("Dol Blathanna Archer", 4, RANGED_COMBAT, NONE, SCOIATAEL, 1, false),
    DOL_BLATHANNA_SCOUT("Dol Blathanna Scout", 6, AGILE, NONE, SCOIATAEL, 3, false),
    EITHNE("Eithne", 10, RANGED_COMBAT, NONE, SCOIATAEL, 1, true),
    FILAVANDREL("Filavandrel", 6, AGILE, NONE, SCOIATAEL, 1, false),
    IDA_EMEAN_AEP("Ida Emean aep", 6, RANGED_COMBAT, NONE, SCOIATAEL, 1, false),
    IORVETH("Iorveth", 10, RANGED_COMBAT, NONE, SCOIATAEL, 1, true),
    MAHAKAMAN_DEFENDER("Mahakaman Defender", 5, CLOSE_COMBAT, NONE, SCOIATAEL, 5, false),
    RIORDAIN("Riordain", 1, RANGED_COMBAT, NONE, SCOIATAEL, 1, false),
    SEASENTHESSIS("Seasenthessis", 10, RANGED_COMBAT, NONE, SCOIATAEL, 1, true),
    TORUVIEL("Toruviel", 2, RANGED_COMBAT, NONE, SCOIATAEL, 1, false),
    VRIHEDD_BRIGADE_RECRUIT("Vrihedd Brigade Recruit", 4, RANGED_COMBAT, NONE, SCOIATAEL, 1, false),
    VRIHEDD_BRIGADE_VETERAN("Vrihedd Brigade Veteran", 5, AGILE, NONE, SCOIATAEL, 2, false),
    YAEVINN("Yaevinn", 6, AGILE, NONE, SCOIATAEL, 1, false),
    BERSERKER("Berserker", 4, CLOSE_COMBAT, AbilityType.BERSERKER, SKELLIGE, 1, false),
    YOUNG_BERSERKER("Young Berserker", 2, RANGED_COMBAT, AbilityType.BERSERKER, SKELLIGE, 3, false),
    DRAIG_BON_DHU("Draig Bon-Dhu", 2, SIEGE, NONE, SKELLIGE, 1, false),
    ERMION("Ermion", 8, RANGED_COMBAT, MARDROEME, SKELLIGE, 1, true),
    BIRNA_BRAN("Birna Bran", 2, CLOSE_COMBAT, MEDIC, SKELLIGE, 1, false),
    OLAF("Olaf", 12, AGILE, MORALBOOST, SKELLIGE, 1, false),
    VIDKAARL("Vidkaarl", 14, CLOSE_COMBAT, MORALBOOST, SKELLIGE, 0, false),
    CERYS("Cerys", 10, CLOSE_COMBAT, MUSTER, SKELLIGE, 1, true),
    LIGHT_LONGSHIP("Light Longship", 4, RANGED_COMBAT, MUSTER, SKELLIGE, 3, false),
    CLAN_DIMUN_PIRATE("Clan Dimun Pirate", 6, RANGED_COMBAT, SCORCH, SKELLIGE, 1, false),
    CLAN_AN_CRAITE("Clan An Craite", 6, CLOSE_COMBAT, TIGHTBOND, SKELLIGE, 3, false),
    CLAN_DRUMMOND_SHIELDMAIDEN("Clan Drummond Shieldmaiden", 4, CLOSE_COMBAT, TIGHTBOND, SKELLIGE, 3, false),
    WAR_LONGSHIP("War Longship", 6, SIEGE, TIGHTBOND, SKELLIGE, 3, false),
    YOUNG_VIDKAARL("Young Vidkaarl", 8, RANGED_COMBAT, TIGHTBOND, SKELLIGE, 0, false),
    KAMBI("Kambi", 11, CLOSE_COMBAT, TRANSFORMERS, SKELLIGE, 1, true),
    BLUEBOY_LUGOS("Blueboy Lugos", 6, CLOSE_COMBAT, NONE, SKELLIGE, 1, false),
    CLAN_BROKVAR_ARCHER("Clan Brokvar Archer", 6, RANGED_COMBAT, NONE, SKELLIGE, 3, false),
    CLAN_TORDARROCH_ARMORSMITH("Clan Tordarroch Armorsmith", 4, CLOSE_COMBAT, NONE, SKELLIGE, 1, false),
    DONAR_AN_HINDAR("Donar an Hindar", 4, CLOSE_COMBAT, NONE, SKELLIGE, 1, false),
    HJALMAR("Hjalmar", 10, RANGED_COMBAT, NONE, SKELLIGE, 1, true),
    HOLGER_BLACKHAND("Holger Blackhand", 4, SIEGE, NONE, SKELLIGE, 1, false),
    MADMAN_LUGOS("Madman Lugos", 6, CLOSE_COMBAT, NONE, SKELLIGE, 1, false),
    SVANRIGE("Svanrige", 4, CLOSE_COMBAT, NONE, SKELLIGE, 1, false),
    UDALRYK("Udalryk", 4, CLOSE_COMBAT, NONE, SKELLIGE, 1, false);

    private final String name;
    private final int score;
    private final Placement placement;
    private final AbilityType abilityType;
    private final FactionType factionType;
    private final int maxCount;
    private final boolean isHero;

    UnitCardData(String name, int score, Placement placement, AbilityType abilityType, FactionType factionType, int maxCount, boolean isHero) {
        this.name = name;
        this.score = score;
        this.placement = placement;
        this.abilityType = abilityType;
        this.factionType = factionType;
        this.maxCount = maxCount;
        this.isHero = isHero;
    }

    public UnitCard getUnitCard() {
        UnitCard unitCard = new UnitCard(name, score, placement, factionType, isHero);
        unitCard.setAbility(abilityType.getAbility(unitCard));
        return unitCard;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public FactionType getFactionType() {
        return factionType;
    }
}
