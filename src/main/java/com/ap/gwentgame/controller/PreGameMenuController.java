package com.ap.gwentgame.controller;

import com.ap.gwentgame.enums.*;
import com.ap.gwentgame.enums.assets.Backgrounds;
import com.ap.gwentgame.enums.assets.Icons;
import com.ap.gwentgame.model.Session;
import com.ap.gwentgame.model.User;
import com.ap.gwentgame.model.gameElementViews.CardViewContainer;
import com.ap.gwentgame.model.gameElementViews.PreGameCardView;
import com.ap.gwentgame.model.gameElements.*;
import com.ap.gwentgame.model.Factions.*;
import com.ap.gwentgame.view.GameMenu;
import com.ap.gwentgame.view.ViewUtilities;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import javax.swing.text.Utilities;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PreGameMenuController implements Initializable {
    private final Monsters monsters = new Monsters();
    private final NilfgaardianEmpire nilfgaardianEmpire = new NilfgaardianEmpire();
    private final NorthernRealms northernRealms = new NorthernRealms();
    private final Scoiatael scoiaTael = new Scoiatael();
    private final Skellige skellige = new Skellige();
    private final CardViewContainer<PreGameCardView, Card> addedCards = new CardViewContainer<>();
    private final CardViewContainer<PreGameCardView, Card> factionCards = new CardViewContainer<>();

    private Faction selectedFaction = null;
    private Leader selectedLeader = null;

    private final static int MIN_UNIT_CARDS = 22;
    private final static int MAX_SPECIAL_CARDS = 10;

    @FXML
    private ScrollPane factionCardsScroll;
    @FXML
    private ScrollPane selectedCardsScroll;
    @FXML
    private ImageView backgroundImage;
    @FXML
    private AnchorPane mainPane;
    @FXML
    private ImageView totalCardsCount;
    @FXML
    private ImageView unitCardsCount;
    @FXML
    private ImageView specialCardsCount;
    @FXML
    private ImageView totalCardsStrength;
    @FXML
    private ImageView heroCards;
    @FXML
    private Label totalCardsInDeck;
    @FXML
    private Label numberOfUnitCards;
    @FXML
    private Label numberOfSpecialCards;
    @FXML
    private Label numberOfAllCards;
    @FXML
    private Label heroCardsCount;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        backgroundImage.setImage(Backgrounds.MAINBG.getImage());

        loadCards();
        loadLeaders();

        selectedCardsScroll.setContent(addedCards);
        factionCardsScroll.setContent(factionCards);

        setFaction(monsters);
        setLeader(monsters.getLeaders().get(0));

        selectedCardsScroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        selectedCardsScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        factionCardsScroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        factionCardsScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        totalCardsCount.setImage(Icons.TOTAL_CARDS_COUNT.getImage());
        unitCardsCount.setImage(Icons.UNIT_CARDS_COUNT.getImage());
        specialCardsCount.setImage(Icons.SPECIAL_CARDS_COUNT.getImage());
        totalCardsStrength.setImage(Icons.TOTAL_CARD_STRENGTH.getImage());
        heroCards.setImage(Icons.HERO_CARDS_COUNT.getImage());

        addedCards.setVisuals(selectedCardsScroll.getWidth(), selectedCardsScroll.getHeight(), 25, 25);
        factionCards.setVisuals(factionCardsScroll.getWidth(), factionCardsScroll.getHeight(), 25, 25);
    }

    public void updateLabels() {
        int totalStrength = 0;
        int heroCardCount = 0;
        int unitCardCount = 0;
        int specialCardCount = 0;
        for (Card card : addedCards.getCards()) {
            if (card instanceof UnitCard unitCard) {
                unitCardCount++;
                if (unitCard.isHero()) {
                    heroCardCount++;
                }
                totalStrength += unitCard.getScore();
            } else {
                specialCardCount++;
            }
        }

        totalCardsInDeck.setText(String.valueOf(addedCards.getCards().size()));
        numberOfUnitCards.setText(unitCardCount + "/" + MIN_UNIT_CARDS);
        numberOfSpecialCards.setText(specialCardCount + "/" + MAX_SPECIAL_CARDS);
        numberOfAllCards.setText(String.valueOf(totalStrength));
        heroCardsCount.setText(String.valueOf(heroCardCount));
    }

    public void setFaction(Faction faction) {
        selectedFaction = faction;
        factionCards.clear();

        for (PreGameCardView cardView : selectedFaction.getCards().getCardViews()) {
            factionCards.add(cardView.clone());
        }
        for (PreGameCardView preGameCardView : selectedFaction.getCards().getCardViews()) {
            setFactionCardOnclick(preGameCardView);
        }
    }

    public void setLeader(Leader leader) {
        selectedLeader = leader;
    }

    public void setFactionCardOnclick(PreGameCardView preGameCardView) {
        preGameCardView.setOnMouseClicked(event -> {
            System.out.println(preGameCardView.getCount() - 1);
            preGameCardView.setCount(preGameCardView.getCount() - 1);
            if (preGameCardView.getCount() == 0) {
                selectedFaction.getCards().remove(preGameCardView);
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

            PreGameCardView addedCard = selectedFaction.getCards().findByName(preGameCardView.getItem().getName());
            if (addedCard != null) {
                addedCard.setCount(addedCard.getCount() + 1);
            } else {
                addedCard = new PreGameCardView((Card) preGameCardView.getItem(), 1);
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
            switch (((Card) preGameCardView.getItem()).getFactionType()) {
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
                    nilfgaardianEmpire.getCards().add(preGameCardView.clone());
                    northernRealms.getCards().add(preGameCardView.clone());
                    scoiaTael.getCards().add(preGameCardView.clone());
                    skellige.getCards().add(preGameCardView.clone());
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
        if (Integer.parseInt(String.valueOf(numberOfSpecialCards)) > MAX_SPECIAL_CARDS) {
            ViewUtilities.showErrorAlert("Too many Special Card", "You can't chose more than 10 Special Card!");
        }
        if (Integer.parseInt(String.valueOf(numberOfUnitCards)) < MIN_UNIT_CARDS) {
            ViewUtilities.showErrorAlert("Not enough Unit Card", "You have to choose at least 22 Unit Card!");
        }
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
}