package com.ap.gwentgame.client.controller;

import com.ap.gwentgame.enums.*;
import com.ap.gwentgame.enums.assets.Backgrounds;
import com.ap.gwentgame.model.Session;
import com.ap.gwentgame.model.View.CardViewContainer;
import com.ap.gwentgame.model.View.PreGameCardView;
import com.ap.gwentgame.model.Faction;
import com.ap.gwentgame.model.Factions.*;
import com.ap.gwentgame.model.Game.GameManager;
import com.ap.gwentgame.model.Game.Player;
import com.ap.gwentgame.model.Leader;
import com.ap.gwentgame.view.GameView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PreGameMenuController implements Initializable {
    private final Monsters monsters = new Monsters();
    private final NilfgaardianEmpire nilfgaardianEmpire = new NilfgaardianEmpire();
    private final NorthernRealms northernRealms = new NorthernRealms();
    private final Scoiatael scoiaTael = new Scoiatael();
    private final Skellige skellige = new Skellige();
    private final CardViewContainer<PreGameCardView> addedCards = new CardViewContainer<>();
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
        for (PreGameCardView preGameCardView : selectedFaction.getCards().getCardViews()) {
            setFactionCardOnclick(preGameCardView);
        }
    }

    public void setFactionCardOnclick(PreGameCardView preGameCardView) {
        preGameCardView.setOnMouseClicked(event -> {
            preGameCardView.setCount(preGameCardView.getCount() - 1);
            if (preGameCardView.getCount() == 0) {
                selectedFaction.getCards().remove(preGameCardView);
            }

            PreGameCardView addedCard = (PreGameCardView) addedCards.findByName(preGameCardView.getCard().getName());
            if (addedCard != null) {
                addedCard.setCount(addedCard.getCount() + 1);
            } else {
                addedCard = new PreGameCardView(preGameCardView.getCard(), 1);
                addedCard.initializeGraphic();
                setAddedCardOnClick(addedCard);
                addedCards.add(addedCard);
            }
        });
    }

    public void setAddedCardOnClick(PreGameCardView preGameCardView) {
        preGameCardView.setOnMouseClicked(event -> {
            preGameCardView.setCount(preGameCardView.getCount() - 1);
            if (preGameCardView.getCount() == 0) {
                addedCards.remove(preGameCardView);
            }

            PreGameCardView addedCard = (PreGameCardView) selectedFaction.getCards().findByName(preGameCardView.getCard().getName());
            if (addedCard != null) {
                addedCard.setCount(addedCard.getCount() + 1);
            } else {
                addedCard = new PreGameCardView(preGameCardView.getCard(), 1);
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
        ArrayList<PreGameCardView> allPreGameCardViews = getPreGameCards();

        for (PreGameCardView preGameCardView : allPreGameCardViews) {
            switch (preGameCardView.getCard().getFactionType()) {
                case MONSTERS: {
                    monsters.getCards().add(preGameCardView);
                    break;
                }
                case NILFGAARDIAN_EMPIRE: {
                    nilfgaardianEmpire.getCards().add(preGameCardView);
                    break;
                }
                case NORTHERN_REALMS: {
                    northernRealms.getCards().add(preGameCardView);
                    break;
                }
                case SCOIATAEL: {
                    scoiaTael.getCards().add(preGameCardView);
                    break;
                }
                case SKELLIGE: {
                    skellige.getCards().add(preGameCardView);
                    break;
                }
                case NEUTRAL: {
                    monsters.getCards().add(preGameCardView);
                    nilfgaardianEmpire.getCards().add(preGameCardView);
                    northernRealms.getCards().add(preGameCardView);
                    scoiaTael.getCards().add(preGameCardView);
                    skellige.getCards().add(preGameCardView);
                    break;
                }
            }
        }
    }

    private ArrayList<PreGameCardView> getPreGameCards() {
        ArrayList<PreGameCardView> allPreGameCardViews = new ArrayList<>();

        for (UnitCardData unitCardData : UnitCardData.values()) {
            PreGameCardView preGameCardView = new PreGameCardView(unitCardData.getUnitCard(), unitCardData.getMaxCount());
            preGameCardView.initializeGraphic();
            allPreGameCardViews.add(preGameCardView);
        }

        for (SpecialCardData specialCardData : SpecialCardData.values()) {
            PreGameCardView preGameCardView = new PreGameCardView(specialCardData.getSpecialCard(), specialCardData.getMaxCount());
            preGameCardView.initializeGraphic();
            allPreGameCardViews.add(preGameCardView);
        }

        for (WeatherCardData weatherCardData : WeatherCardData.values()) {
            PreGameCardView preGameCardView = new PreGameCardView(weatherCardData.getWeatherCard(), weatherCardData.getMaxCount());
            preGameCardView.initializeGraphic();
            allPreGameCardViews.add(preGameCardView);
        }

        return allPreGameCardViews;
    }

    @FXML
    private void prepareGame() {
        Player player = new Player(Session.getLoggedInUser(), selectedFaction, selectedLeader, addedCards);
        GameManager.addPlayerToQueue(player);
        while (GameManager.getGameDataById(0) == null) {
            try {
                Thread.sleep(10000);
                System.out.println("Waiting for other player to join");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            GameView gameView = new GameView();
            gameView.start(Session.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}