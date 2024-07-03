package com.ap.gwentgame.controller;

import com.ap.gwentgame.enums.*;
import com.ap.gwentgame.enums.assets.Backgrounds;
import com.ap.gwentgame.model.App;
import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Cards.PreGameCard;
import com.ap.gwentgame.model.Factions.*;
import com.ap.gwentgame.model.Game.Board;
import com.ap.gwentgame.model.Game.Game;
import com.ap.gwentgame.model.Game.Player;
import com.ap.gwentgame.model.ItemContainer;
import com.ap.gwentgame.model.Leaders.Leader;
import com.ap.gwentgame.view.BoardView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PreGameController implements Initializable {
    private final Monsters monsters = new Monsters();
    private final NilfgaardianEmpire nilfgaardianEmpire = new NilfgaardianEmpire();
    private final NorthernRealms northernRealms = new NorthernRealms();
    private final Scoiatael scoiaTael = new Scoiatael();
    private final Skellige skellige = new Skellige();
    private final ItemContainer<PreGameCard> addedCards = new ItemContainer<>();
    private Faction selectedFaction = null;
    private Leader selectedLeader = null;

    @FXML
    private ScrollPane factionCardsScroll;
    @FXML
    private ScrollPane selectedCardsScroll;
    @FXML
    private ImageView backgroundImage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        backgroundImage.setImage(Backgrounds.MAINBG.getImage());
        loadCards();
        loadLeaders();
        selectedCardsScroll.setContent(addedCards);
        setFactionCards(monsters);

        selectedCardsScroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        selectedCardsScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        factionCardsScroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        factionCardsScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        addedCards.setVisuals(selectedCardsScroll.getWidth(), selectedCardsScroll.getHeight(), 25, 25);
    }

    public void setFactionCards(Faction faction) {
        selectedFaction = faction;
        selectedFaction.getCards().setVisuals(factionCardsScroll.getWidth(), factionCardsScroll.getHeight(), 25, 25);
        factionCardsScroll.setContent(selectedFaction.getCards());
        for (PreGameCard preGameCard : selectedFaction.getCards().getItems()) {
            setFactionCardOnclick(preGameCard);
        }
    }

    public void setFactionCardOnclick(PreGameCard preGameCard) {
        preGameCard.setOnMouseClicked(event -> {
            preGameCard.setCount(preGameCard.getCount() - 1);
            if (preGameCard.getCount() == 0) {
                selectedFaction.getCards().remove(preGameCard);
            }

            PreGameCard addedCard = (PreGameCard) addedCards.findByName(preGameCard.getName());
            if (addedCard != null) {
                addedCard.setCount(addedCard.getCount() + 1);
            } else {
                addedCard = new PreGameCard(preGameCard.getCard(), 1);
                addedCard.initializeGraphic();
                setAddedCardOnClick(addedCard);
                addedCards.add(addedCard);
            }
        });
    }

    public void setAddedCardOnClick(PreGameCard preGameCard) {
        preGameCard.setOnMouseClicked(event -> {
            preGameCard.setCount(preGameCard.getCount() - 1);
            if (preGameCard.getCount() == 0) {
                addedCards.remove(preGameCard);
            }

            PreGameCard addedCard = (PreGameCard) selectedFaction.getCards().findByName(preGameCard.getName());
            if (addedCard != null) {
                addedCard.setCount(addedCard.getCount() + 1);
            } else {
                addedCard = new PreGameCard(preGameCard.getCard(), 1);
                addedCard.initializeGraphic();
                setFactionCardOnclick(addedCard);
                selectedFaction.getCards().add(addedCard);
            }
        });
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
            preGameCard.initializeGraphic();
            allPreGameCards.add(preGameCard);
        }

        for (SpecialCardData specialCardData : SpecialCardData.values()) {
            PreGameCard preGameCard = new PreGameCard(specialCardData.getSpecialCard(), specialCardData.getMaxCount());
            preGameCard.initializeGraphic();
            allPreGameCards.add(preGameCard);
        }

        for (WeatherCardData weatherCardData : WeatherCardData.values()) {
            PreGameCard preGameCard = new PreGameCard(weatherCardData.getWeatherCard(), weatherCardData.getMaxCount());
            preGameCard.initializeGraphic();
            allPreGameCards.add(preGameCard);
        }

        return allPreGameCards;
    }

    @FXML
    private void prepareGame() {
        Player player = new Player(App.getLoggedinUser(), selectedFaction, selectedLeader, addedCards);
        Game.addPlayerToQueue(player);
        while (Game.getCurrentBoard() == null) {
            try {
                Thread.sleep(10000);
                System.out.println("Waiting for other player to join");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            BoardView boardView = new BoardView();
            boardView.start(App.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}