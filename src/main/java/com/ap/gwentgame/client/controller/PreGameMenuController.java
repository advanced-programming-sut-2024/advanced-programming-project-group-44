package com.ap.gwentgame.client.controller;

import com.ap.gwentgame.client.enums.*;
import com.ap.gwentgame.client.enums.assets.Backgrounds;
import com.ap.gwentgame.client.enums.assets.Icons;
import com.ap.gwentgame.client.model.Session;
import com.ap.gwentgame.client.model.User;
import com.ap.gwentgame.client.model.gameElementViews.*;
import com.ap.gwentgame.client.model.gameElements.*;
import com.ap.gwentgame.client.model.Factions.*;
import com.ap.gwentgame.client.view.GameMenu;
import com.ap.gwentgame.client.view.MainMenu;
import com.ap.gwentgame.client.view.ViewUtilities;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

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
    @FXML
    private ImageView muteButtonIcon;
    @FXML
    private ImageView backButtonIcon;
    @FXML
    private Label factionNameLabel;
    @FXML
    private Label leaderNameLabel;
    @FXML
    public Pane leaderPane;
    @FXML
    public Pane factionPane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        backgroundImage.setImage(Backgrounds.MAINBG.getImage());
        backButtonIcon.setImage(Icons.BACK.getImage());
        muteButtonIcon.setImage(Icons.UNMUTE.getImage());

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

        updateLabels();
    }

    public void updateLabels() {
        int totalStrength = 0;
        int heroCardCount = 0;
        int unitCardCount = 0;
        int specialCardCount = 0;
        for (PreGameCardView preGameCardView : addedCards.getCardViews()) {
            Card card = (Card) preGameCardView.getItem();
            int cardCount = preGameCardView.getCount();
            if (card instanceof UnitCard unitCard) {
                unitCardCount += cardCount;
                if (unitCard.isHero()) {
                    heroCardCount += cardCount;
                }
                totalStrength += unitCard.getScore() * cardCount;
            } else {
                specialCardCount += cardCount;
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
        addedCards.clear();

        for (PreGameCardView preGameCardView : selectedFaction.getCardViews().getCardViews()) {
            PreGameCardView newPreGameCardView = preGameCardView.clone();
            factionCards.add(newPreGameCardView);
            setFactionCardOnclick(newPreGameCardView);
        }

        factionNameLabel.setText(selectedFaction.getName());
        FactionView factionView = new FactionView(selectedFaction);
        factionView.setLayoutX(22);
        factionPane.getChildren().add(factionView);
    }

    public void setLeader(Leader leader) {
        selectedLeader = leader;
        leaderNameLabel.setText(selectedLeader.getName());
        LeaderView leaderView = new LeaderView(selectedLeader);
        leaderView.setLayoutX(22);
        leaderPane.getChildren().add(leaderView);
    }

    public void setFactionCardOnclick(PreGameCardView preGameCardView) {
        preGameCardView.setOnMouseClicked(event -> {
            preGameCardView.setCount(preGameCardView.getCount() - 1);
            if (preGameCardView.getCount() == 0) {
                factionCards.remove(preGameCardView);
            }

            PreGameCardView addedCard = addedCards.findByName(preGameCardView.getItem().getName());
            if (addedCard != null) {
                addedCard.setCount(addedCard.getCount() + 1);
            } else {
                addedCard = new PreGameCardView((Card) preGameCardView.getItem(), 1);
                setAddedCardOnClick(addedCard);
                addedCards.add(addedCard);
            }

            updateLabels();
        });
    }

    public void setAddedCardOnClick(PreGameCardView preGameCardView) {
        preGameCardView.setOnMouseClicked(event -> {
            preGameCardView.setCount(preGameCardView.getCount() - 1);
            if (preGameCardView.getCount() == 0) {
                addedCards.remove(preGameCardView);
            }

            PreGameCardView addedCard = factionCards.findByName(preGameCardView.getItem().getName());
            if (addedCard != null) {
                addedCard.setCount(addedCard.getCount() + 1);
            } else {
                addedCard = new PreGameCardView((Card) preGameCardView.getItem(), 1);
                setFactionCardOnclick(addedCard);
                factionCards.add(addedCard);
            }

            updateLabels();
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
        int countOfSpecialCards = Integer.parseInt(String.valueOf(numberOfSpecialCards.getText()).split("/")[0]);
        int countOfUnitCards = Integer.parseInt(String.valueOf(numberOfUnitCards.getText()).split("/")[0]);

        if (countOfSpecialCards > MAX_SPECIAL_CARDS) {
            ViewUtilities.showErrorAlert("Too many Special Card", "You can't chose more than 10 Special Card!");
        }
        if (countOfUnitCards < MIN_UNIT_CARDS) {
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

    public void backToMainMenu(MouseEvent mouseEvent) {
        try {
            MainMenu mainMenu = new MainMenu();
            mainMenu.start(Session.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void toggleMute(MouseEvent mouseEvent) {
        if (MusicController.getInstance().getMediaPlayer().isMute()) {
            MusicController.getInstance().getMediaPlayer().setMute(false);
            muteButtonIcon.setImage(Icons.UNMUTE.getImage());
        } else {
            MusicController.getInstance().getMediaPlayer().setMute(true);
            muteButtonIcon.setImage(Icons.MUTE.getImage());
        }
    }

    public void uploadDeck(MouseEvent mouseEvent) {
        //TODO: Implement this method
    }

    public void downloadDeck(MouseEvent mouseEvent) {
        //TODO: Implement this method
    }

    public void LeaderSelector(MouseEvent mouseEvent) {
        ArrayList<LeaderView> leadersView = new ArrayList<>();

        for(Leader leader : selectedFaction.getLeaders()) {
            LeaderView leaderView = new LeaderView(leader);
            leadersView.add(leaderView);
        }

        AtomicReference<ItemView> selectedLeaderReference = new AtomicReference<>(new LeaderView(selectedLeader));
        Button submitButton = new Button();
        ViewUtilities.ItemSelector(mainPane, leadersView, selectedLeaderReference, submitButton);
        submitButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            setLeader((Leader) selectedLeaderReference.get().getItem());
        });
    }


    public void FactionSelector(MouseEvent mouseEvent) {
        ArrayList<FactionView> factionsView = new ArrayList<>();
        factionsView.add(new FactionView(monsters));
        factionsView.add(new FactionView(nilfgaardianEmpire));
        factionsView.add(new FactionView(northernRealms));
        factionsView.add(new FactionView(scoiaTael));
        factionsView.add(new FactionView(skellige));


        Button submitButton = new Button();
        AtomicReference<ItemView> selectedFactionReference = new AtomicReference<>(new FactionView(selectedFaction));
        ViewUtilities.ItemSelector(mainPane, factionsView, selectedFactionReference, submitButton);
        submitButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            setFaction((Faction) selectedFactionReference.get().getItem());
            setLeader(selectedFaction.getLeaders().get(0));
        });

    }
}