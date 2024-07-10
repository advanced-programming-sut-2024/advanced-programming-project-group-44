package com.ap.gwentgame.client.model.gameElements;

import com.ap.gwentgame.client.enums.*;
import com.ap.gwentgame.client.model.Factions.*;
import com.ap.gwentgame.client.model.gameElementViews.CardViewContainer;
import com.ap.gwentgame.client.model.gameElementViews.LeaderView;
import com.ap.gwentgame.client.model.gameElementViews.PreGameCardView;

import java.io.Serializable;
import java.util.ArrayList;

public class Faction extends Item implements Serializable {
    protected transient final ArrayList<LeaderView> leaderViews;
    protected transient final CardViewContainer<PreGameCardView, Card> cardViews;

    public Faction(String name) {
        super(name);
        leaderViews = new ArrayList<>();
        cardViews = new CardViewContainer<>();
    }

    public ArrayList<LeaderView> getLeaderViews() {
        return leaderViews;
    }

    public CardViewContainer<PreGameCardView, Card> getCardViews() {
        return cardViews;
    }

    public static void loadLeaders(Monsters monsters, NilfgaardianEmpire nilfgaardianEmpire, NorthernRealms northernRealms, Scoiatael scoiatael, Skellige skellige) {
        monsters.getLeaderViews().clear();
        nilfgaardianEmpire.getLeaderViews().clear();
        northernRealms.getLeaderViews().clear();
        scoiatael.getLeaderViews().clear();
        skellige.getLeaderViews().clear();
        for (LeaderCardData leaderCardData : LeaderCardData.values()) {
            Leader leader = leaderCardData.getLeader();
            switch (leader.getFactionType()) {
                case MONSTERS: {
                    monsters.getLeaderViews().add(new LeaderView(leader));
                    break;
                }
                case NILFGAARDIAN_EMPIRE: {
                    nilfgaardianEmpire.getLeaderViews().add(new LeaderView(leader));
                    break;
                }
                case NORTHERN_REALMS: {
                    northernRealms.getLeaderViews().add(new LeaderView(leader));
                    break;
                }
                case SCOIATAEL: {
                    scoiatael.getLeaderViews().add(new LeaderView(leader));
                    break;
                }
                case SKELLIGE: {
                    skellige.getLeaderViews().add(new LeaderView(leader));
                    break;
                }
            }
        }
    }

    public static void loadCards(Monsters monsters, NilfgaardianEmpire nilfgaardianEmpire, NorthernRealms northernRealms, Scoiatael scoiatael, Skellige skellige){
        ArrayList<PreGameCardView> allPreGameCardViews = getPreGameCards();
        monsters.getCardViews().clear();
        nilfgaardianEmpire.getCardViews().clear();
        northernRealms.getCardViews().clear();
        scoiatael.getCardViews().clear();
        skellige.getCardViews().clear();

        for (PreGameCardView preGameCardView : allPreGameCardViews) {
            switch (((PreGameCard) preGameCardView.getItem()).getCard().getFactionType()) {
                case MONSTERS: {
                    monsters.getCardViews().add(preGameCardView);
                    break;
                }
                case NILFGAARDIAN_EMPIRE: {
                    nilfgaardianEmpire.getCardViews().add(preGameCardView);
                    break;
                }
                case NORTHERN_REALMS: {
                    northernRealms.getCardViews().add(preGameCardView);
                    break;
                }
                case SCOIATAEL: {
                    scoiatael.getCardViews().add(preGameCardView);
                    break;
                }
                case SKELLIGE: {
                    skellige.getCardViews().add(preGameCardView);
                    break;
                }
                case NEUTRAL: {
                    monsters.getCardViews().add(preGameCardView);
                    nilfgaardianEmpire.getCardViews().add(preGameCardView.clone());
                    northernRealms.getCardViews().add(preGameCardView.clone());
                    scoiatael.getCardViews().add(preGameCardView.clone());
                    skellige.getCardViews().add(preGameCardView.clone());
                    break;
                }
            }
        }
    }

    private static ArrayList<PreGameCardView> getPreGameCards() {
        ArrayList<PreGameCardView> allPreGameCardViews = new ArrayList<>();

        for (UnitCardData unitCardData : UnitCardData.values()) {
            if (unitCardData.getMaxCount() == 0) {
                continue;
            }
            PreGameCardView preGameCardView = new PreGameCardView(new PreGameCard(unitCardData.getUnitCard(), unitCardData.getMaxCount()));
            allPreGameCardViews.add(preGameCardView);
        }

        for (SpecialCardData specialCardData : SpecialCardData.values()) {
            if (specialCardData.getMaxCount() == 0) {
                continue;
            }
            PreGameCardView preGameCardView = new PreGameCardView(new PreGameCard(specialCardData.getSpecialCard(), specialCardData.getMaxCount()));
            allPreGameCardViews.add(preGameCardView);
        }

        for (WeatherCardData weatherCardData : WeatherCardData.values()) {
            if (weatherCardData.getMaxCount() == 0) {
                continue;
            }
            PreGameCardView preGameCardView = new PreGameCardView(new PreGameCard(weatherCardData.getWeatherCard(), weatherCardData.getMaxCount()));
            allPreGameCardViews.add(preGameCardView);
        }

        return allPreGameCardViews;
    }

    public static FactionType getFactionType(Faction faction) {
        switch (faction.getName()){
            case "Monsters": {
                return FactionType.MONSTERS;
            }
            case "Nilfgaardian Empire": {
                return FactionType.NILFGAARDIAN_EMPIRE;
            }
            case "Northern Realms": {
                return FactionType.NORTHERN_REALMS;
            }
            case "Scoia'tael": {
                return FactionType.SCOIATAEL;
            }
            case "Skellige": {
                return FactionType.SKELLIGE;
            }
            default: {
                return FactionType.NEUTRAL;
            }
        }
    }
}
