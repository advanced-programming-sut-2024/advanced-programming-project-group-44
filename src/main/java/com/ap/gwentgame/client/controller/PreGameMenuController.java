package com.ap.gwentgame.client.controller;

import com.ap.gwentgame.client.enums.*;
import com.ap.gwentgame.client.enums.assets.Backgrounds;
import com.ap.gwentgame.client.model.Session;
import com.ap.gwentgame.client.model.User;
import com.ap.gwentgame.client.model.gameElementViews.CardViewContainer;
import com.ap.gwentgame.client.model.gameElementViews.LeaderView;
import com.ap.gwentgame.client.model.gameElementViews.PreGameCardView;
import com.ap.gwentgame.client.model.gameElements.*;
import com.ap.gwentgame.client.model.Factions.*;
import com.ap.gwentgame.client.view.GameMenu;
import com.ap.gwentgame.client.view.ViewUtilities;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PreGameMenuController implements Initializable {
    private final Monsters monsters = new Monsters();
    private final NilfgaardianEmpire nilfgaardianEmpire = new NilfgaardianEmpire();
    private final NorthernRealms northernRealms = new NorthernRealms();
    private final Scoiatael scoiaTael = new Scoiatael();
    private final Skellige skellige = new Skellige();
    private final CardViewContainer<PreGameCardView, Card> addedCards = new CardViewContainer<>();;
    private Faction selectedFaction = null;
    private Leader selectedLeader = LeaderCardData.THE_STEEL_FORGED.getLeader();

    @FXML
    private ScrollPane factionCardsScroll;
    @FXML
    private ScrollPane selectedCardsScroll;
    @FXML
    private ImageView backgroundImage;
    @FXML
    private AnchorPane mainPane;

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
        selectedFaction.getCardViews().setVisuals(factionCardsScroll.getWidth(), factionCardsScroll.getHeight(), 25, 25);
        factionCardsScroll.setContent(selectedFaction.getCardViews());
        for (PreGameCardView preGameCardView : selectedFaction.getCardViews().getCardViews()) {
            setFactionCardOnclick(preGameCardView);
        }
    }

    public void setFactionCardOnclick(PreGameCardView preGameCardView) {
        preGameCardView.setOnMouseClicked(event -> {
            System.out.println(preGameCardView.getCount() - 1);
            preGameCardView.setCount(preGameCardView.getCount() - 1);
            if (preGameCardView.getCount() == 0) {
                selectedFaction.getCardViews().remove(preGameCardView);
            }

            PreGameCardView addedCard = addedCards.findByName(preGameCardView.getItem().getName());
            if (addedCard != null) {
                addedCard.setCount(addedCard.getCount() + 1);
            } else {
                addedCard = new PreGameCardView((Card) preGameCardView.getItem(), 1);
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

            PreGameCardView addedCard = selectedFaction.getCardViews().findByName(preGameCardView.getItem().getName());
            if (addedCard != null) {
                addedCard.setCount(addedCard.getCount() + 1);
            } else {
                addedCard = new PreGameCardView((Card) preGameCardView.getItem(), 1);
                setFactionCardOnclick(addedCard);
                selectedFaction.getCardViews().add(addedCard);
            }
        });
    }

    private void loadLeaders() {
        for (LeaderCardData leaderCardData : LeaderCardData.values()) {
            LeaderView leaderView = new LeaderView(leaderCardData.getLeader());
            switch (((Leader)leaderView.getItem()).getFactionType()) {
                case MONSTERS: {
                    monsters.getLeaderViews().add(leaderView);
                    break;
                }
                case NILFGAARDIAN_EMPIRE: {
                    nilfgaardianEmpire.getLeaderViews().add(leaderView);
                    break;
                }
                case NORTHERN_REALMS: {
                    northernRealms.getLeaderViews().add(leaderView);
                    break;
                }
                case SCOIATAEL: {
                    scoiaTael.getLeaderViews().add(leaderView);
                    break;
                }
                case SKELLIGE: {
                    skellige.getLeaderViews().add(leaderView);
                    break;
                }
            }
        }
    }

    public void loadCards() {
        ArrayList<PreGameCardView> allPreGameCardViews = getPreGameCards();

        for (PreGameCardView preGameCardView : allPreGameCardViews) {
            switch (((Card)preGameCardView.getItem()).getFactionType()) {
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
                    scoiaTael.getCardViews().add(preGameCardView);
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
                    scoiaTael.getCardViews().add(preGameCardView.clone());
                    skellige.getCardViews().add(preGameCardView.clone());
                    break;
                }
            }
        }
    }

    private ArrayList<PreGameCardView> getPreGameCards() {
        ArrayList<PreGameCardView> allPreGameCardViews = new ArrayList<>();

        for (UnitCardData unitCardData : UnitCardData.values()) {
            PreGameCardView preGameCardView = new PreGameCardView(unitCardData.getUnitCard(), unitCardData.getMaxCount());
            allPreGameCardViews.add(preGameCardView);
        }

        for (SpecialCardData specialCardData : SpecialCardData.values()) {
            PreGameCardView preGameCardView = new PreGameCardView(specialCardData.getSpecialCard(), specialCardData.getMaxCount());
            allPreGameCardViews.add(preGameCardView);
        }

        for (WeatherCardData weatherCardData : WeatherCardData.values()) {
            PreGameCardView preGameCardView = new PreGameCardView(weatherCardData.getWeatherCard(), weatherCardData.getMaxCount());
            allPreGameCardViews.add(preGameCardView);
        }

        return allPreGameCardViews;
    }

    @FXML
    private void prepareGame() {
        User user = Session.getLoggedInUser();
        Player player1 = new Player(user, selectedFaction, selectedLeader, addedCards);
        Player player2 = new Player(user, selectedFaction, selectedLeader, addedCards);


        /*Session.setGameId(GameManager.addPlayerToQueue(player));

        while (GameManager.getGameDataById(0) == null) {
            try {
                Thread.sleep(10000);
                System.out.println("Waiting for other player to join");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/

        Board board = new Board(player1, player2);
        GameMenu gameMenu = new GameMenu();
        gameMenu.loadBoard(board);
    }

    public void selectLeader(MouseEvent mouseEvent) {
        LeaderView leaderView = (LeaderView) ViewUtilities.ItemSelector(mainPane, selectedFaction.getLeaderViews());
        if (leaderView != null) {
            selectedLeader = (Leader) leaderView.getItem();
        }
    }
}