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
import com.ap.gwentgame.client.view.WaitingScreenMenu;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Popup;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

public class PreGameMenuController implements Initializable {
    private final Monsters monsters = new Monsters();
    private final NilfgaardianEmpire nilfgaardianEmpire = new NilfgaardianEmpire();
    private final NorthernRealms northernRealms = new NorthernRealms();
    private final Scoiatael scoiatael = new Scoiatael();
    private final Skellige skellige = new Skellige();

    private final CardViewContainer<PreGameCardView, PreGameCard> addedCards = new CardViewContainer<>();
    private final CardViewContainer<PreGameCardView, PreGameCard> factionCards = new CardViewContainer<>();

    private Faction selectedFaction = null;
    private LeaderView selectedLeaderView = null;

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
        backgroundImage.setImage(Backgrounds.PREGAME_MENU.getImage());
        backButtonIcon.setImage(Icons.BACK.getImage());
        muteButtonIcon.setImage(Icons.UNMUTE.getImage());

        Faction.loadCards(monsters, nilfgaardianEmpire, northernRealms, scoiatael, skellige);
        Faction.loadLeaders(monsters, nilfgaardianEmpire, northernRealms, scoiatael, skellige);

        selectedCardsScroll.setContent(addedCards);
        factionCardsScroll.setContent(factionCards);

        setFaction(monsters);
        setLeaderView(monsters.getLeaderViews().get(0));

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
            Card card = ((PreGameCard) preGameCardView.getItem()).getCard();
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
        Faction.loadCards(monsters, nilfgaardianEmpire, northernRealms, scoiatael, skellige);

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

    public void setLeaderView(LeaderView leaderView) {
        if (selectedLeaderView != null) {
            selectedLeaderView.toPreGameMode();
            leaderPane.getChildren().remove(selectedLeaderView);
        }
        leaderView.toGameMode();
        selectedLeaderView = leaderView;
        leaderNameLabel.setText(selectedLeaderView.getItem().getName());
        leaderView.setLayoutX(22);
        leaderPane.getChildren().add(leaderView);
    }

    public void setFactionCardOnclick(PreGameCardView preGameCardView) {
        preGameCardView.setOnMouseClicked(event -> {
            selectCard(preGameCardView);
        });
    }

    public void setAddedCardOnClick(PreGameCardView preGameCardView) {
        preGameCardView.setOnMouseClicked(event -> {
            deselectCard(preGameCardView);
        });
    }

    private void deselectCard(PreGameCardView preGameCardView) {
        preGameCardView.setCount(preGameCardView.getCount() - 1);
        if (preGameCardView.getCount() == 0) {
            addedCards.remove(preGameCardView);
        }

        PreGameCardView addedCard = factionCards.findByName(preGameCardView.getItem().getName());
        if (addedCard != null) {
            addedCard.setCount(addedCard.getCount() + 1);
        } else {
            addedCard = new PreGameCardView(new PreGameCard(((PreGameCard) preGameCardView.getItem()).getCard(), 1));
            setFactionCardOnclick(addedCard);
            factionCards.add(addedCard);
        }

        updateLabels();
    }

    private void selectCard(PreGameCardView preGameCardView) {
        preGameCardView.setCount(preGameCardView.getCount() - 1);
        if (preGameCardView.getCount() == 0) {
            factionCards.remove(preGameCardView);
        }

        PreGameCardView addedCard = addedCards.findByName(preGameCardView.getItem().getName());
        if (addedCard != null) {
            addedCard.setCount(addedCard.getCount() + 1);
        } else {
            addedCard = new PreGameCardView(new PreGameCard(((PreGameCard) preGameCardView.getItem()).getCard(), 1));
            setAddedCardOnClick(addedCard);
            addedCards.add(addedCard);
        }

        updateLabels();
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
        Deck deck = Deck.upload();
        if (deck != null) {
            FactionType factionType = deck.getFactionType();

            switch (factionType) {
                case MONSTERS -> setFaction(monsters);
                case NILFGAARDIAN_EMPIRE -> setFaction(nilfgaardianEmpire);
                case NORTHERN_REALMS -> setFaction(northernRealms);
                case SCOIATAEL -> setFaction(scoiatael);
                case SKELLIGE -> setFaction(skellige);
            }

            setLeaderView(new LeaderView(deck.getLeader()));


            for (PreGameCard preGameCard : deck.getPreGameCards()) {
                PreGameCardView preGameCardView = factionCards.findByName(preGameCard.getName());
                for (int i = 0; i < preGameCard.getCount(); i++) {
                    selectCard(preGameCardView);
                }
            }

            ViewUtilities.showInformationAlert("Deck uploaded", "Deck uploaded successfully!");
        }
    }


    public void downloadDeck(MouseEvent mouseEvent) {
        FactionType factionType;
        factionType = Faction.getFactionType(selectedFaction);
        Deck deck = new Deck(addedCards.getCards(), (Leader) selectedLeaderView.getItem(), factionType);
        Deck.download(deck);
    }

    public void LeaderViewSelector(MouseEvent mouseEvent) {
        for (LeaderView leaderView : selectedFaction.getLeaderViews()) {
            leaderView.toPreGameMode();
        }

        AtomicReference<ItemView> selectedLeaderReference = new AtomicReference<>(selectedLeaderView);
        Button submitButton = new Button();
        ViewUtilities.ItemSelector(mainPane, selectedFaction.getLeaderViews(), selectedLeaderReference, submitButton);
        submitButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            setLeaderView((LeaderView) selectedLeaderReference.get());
        });
    }

    public void FactionSelector(MouseEvent mouseEvent) {
        ArrayList<FactionView> factionsView = new ArrayList<>();
        factionsView.add(new FactionView(monsters));
        factionsView.add(new FactionView(nilfgaardianEmpire));
        factionsView.add(new FactionView(northernRealms));
        factionsView.add(new FactionView(scoiatael));
        factionsView.add(new FactionView(skellige));

        Button submitButton = new Button();
        AtomicReference<ItemView> selectedFactionReference = new AtomicReference<>(new FactionView(selectedFaction));
        ViewUtilities.ItemSelector(mainPane, factionsView, selectedFactionReference, submitButton);
        submitButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            setFaction((Faction) selectedFactionReference.get().getItem());
            setLeaderView(selectedFaction.getLeaderViews().get(0));
        });
    }

    @FXML
    private void prepareGame() {
        int countOfSpecialCards = Integer.parseInt(String.valueOf(numberOfSpecialCards.getText()).split("/")[0]);
        int countOfUnitCards = Integer.parseInt(String.valueOf(numberOfUnitCards.getText()).split("/")[0]);

        if (countOfSpecialCards > MAX_SPECIAL_CARDS) {
            ViewUtilities.showErrorAlert("Too many Special Card", "You can't chose more than 10 Special Card!");
            return;
        }
        if (countOfUnitCards < MIN_UNIT_CARDS) {
            ViewUtilities.showErrorAlert("Not enough Unit Card", "You have to choose at least 22 Unit Card!");
            return;
        }

        User user = Session.getLoggedInUser();
        Session.setLoggedInUser(user);
        Player player = new Player(user, selectedFaction, (Leader) selectedLeaderView.getItem(), addedCards);
        RequestSender.requestRandomGame(player);

        try {
            WaitingScreenMenu waitingScreenMenu = new WaitingScreenMenu();
            waitingScreenMenu.start(Session.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void backToMainMenu(MouseEvent mouseEvent) {
        try {
            MainMenu mainMenu = new MainMenu();
            mainMenu.start(Session.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void chooseFriendMenu(MouseEvent mouseEvent) {

}


    public void goToTournamentMenu(MouseEvent mouseEvent) {
    }
}