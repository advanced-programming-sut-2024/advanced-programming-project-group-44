package com.ap.gwentgame.controller;

import com.ap.gwentgame.enums.*;
import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Cards.PreGameCard;
import com.ap.gwentgame.model.Factions.*;
import com.ap.gwentgame.model.Game.Game;
import com.ap.gwentgame.model.ItemContainer;
import com.ap.gwentgame.model.Leaders.Leader;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PreGameController implements Initializable {
    private final Monsters monsters = new Monsters();
    private final NilfgaardianEmpire nilfgaardianEmpire = new NilfgaardianEmpire();
    private final NorthernRealms northernRealms = new NorthernRealms();
    private final Scoiatael scoiaTael = new Scoiatael();
    private final Skellige skellige = new Skellige();
    private final ItemContainer<Card> addedCards = new ItemContainer<>();
    private Leader selectedLeader;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadCards();
        loadLeaders();
    }

    private void loadLeaders() {
        for (LeaderCardData leaderCardData : LeaderCardData.values()) {
            Leader leader = leaderCardData.getLeader();
            switch (leader.getFactionType()) {
                case MONSTERS: {
                    monsters.getLeaders().add(leader);
                    break;
                }
                case NILFGAARDIAN_EMPIRE: {
                    nilfgaardianEmpire.getLeaders().add(leader);
                    break;
                }
                case NORTHERN_REALMS: {
                    northernRealms.getLeaders().add(leader);
                    break;
                }
                case SCOIATAEL: {
                    scoiaTael.getLeaders().add(leader);
                    break;
                }
                case SKELLIGE: {
                    skellige.getLeaders().add(leader);
                    break;
                }
            }
        }
    }

    public void loadCards() {
        ArrayList<PreGameCard> allPreGameCards = getPreGameCards();

        for (PreGameCard preGameCard : allPreGameCards) {
            switch (preGameCard.getCard().getFactionType()) {
                case MONSTERS: {
                    monsters.getCards().add(preGameCard);
                    break;
                }
                case NILFGAARDIAN_EMPIRE: {
                    nilfgaardianEmpire.getCards().add(preGameCard);
                    break;
                }
                case NORTHERN_REALMS: {
                    northernRealms.getCards().add(preGameCard);
                    break;
                }
                case SCOIATAEL: {
                    scoiaTael.getCards().add(preGameCard);
                    break;
                }
                case SKELLIGE: {
                    skellige.getCards().add(preGameCard);
                    break;
                }
                case NEUTRAL: {
                    monsters.getCards().add(preGameCard);
                    nilfgaardianEmpire.getCards().add(preGameCard);
                    northernRealms.getCards().add(preGameCard);
                    scoiaTael.getCards().add(preGameCard);
                    skellige.getCards().add(preGameCard);
                    break;
                }
            }
        }
    }

    private ArrayList<PreGameCard> getPreGameCards() {
        ArrayList<PreGameCard> allPreGameCards = new ArrayList<>();

        for (UnitCardData unitCardData : UnitCardData.values()) {
            PreGameCard preGameCard = new PreGameCard(unitCardData.getUnitCard(), unitCardData.getMaxCount());
            allPreGameCards.add(preGameCard);
        }

        for (SpecialCardData specialCardData : SpecialCardData.values()) {
            PreGameCard preGameCard = new PreGameCard(specialCardData.getSpecialCard(), specialCardData.getMaxCount());
            allPreGameCards.add(preGameCard);
        }

        for (WeatherCardData weatherCardData : WeatherCardData.values()) {
            PreGameCard preGameCard = new PreGameCard(weatherCardData.getWeatherCard(), weatherCardData.getMaxCount());
            allPreGameCards.add(preGameCard);
        }

        return allPreGameCards;
    }

    private void prepareGame() {

    }
}