package com.ap.gwentgame.client.view.viewController;


public class GameViewController{
    /*private Board game;
    private AnchorPane pane;
    private Player player1;
    private Player player2;
    private final HashMap<CardViewContainer<? extends ItemView, ? extends Card>, Rectangle> player1Containers = new HashMap<>();
    private final HashMap<CardViewContainer<? extends ItemView, ? extends Card>, Rectangle> player2Containers = new HashMap<>();

    private final CardViewContainer<ItemView>[] player1Rows = new CardViewContainer[3];
    private final CardViewContainer<ItemView>[] player2Rows = new CardViewContainer[3];
    private final CardViewContainer<ItemView>[] player1Specials = new CardViewContainer[3];
    private final CardViewContainer<ItemView>[] player2Specials = new CardViewContainer[3];
    private CardViewContainer<ItemView> player1Hand;
    private CardViewContainer<ItemView> player2Hand;
    private CardViewContainer<ItemView> player1Deck;
    private CardViewContainer<ItemView> player2Deck;
    private CardViewContainer<ItemView> player1DiscardPile;
    private CardViewContainer<ItemView> player2DiscardPile;
    private CardViewContainer<ItemView> weatherCards;


    @FXML
    private ImageView BoardImage;
    @FXML
    private ImageView Player2CardCount;
    @FXML
    private ImageView Player2GemOn;
    @FXML
    private ImageView Player2GemOff;
    @FXML
    private ImageView Player1CardCount;
    @FXML
    private ImageView Player1GemOn;
    @FXML
    private ImageView Player1GemOff;
    @FXML
    private Label Player1Score;
    @FXML
    private Label Player2Score;
    @FXML
    private Label Player2Row2Score;
    @FXML
    private Label Player2Row1Score;
    @FXML
    private Label Player2Row0Score;
    @FXML
    private Label Player1Row2Score;
    @FXML
    private Label Player1Row1Score;
    @FXML
    private Label Player1Row0Score;
    @FXML
    private Label Player1CardCounter;
    @FXML
    private Label Player2CardCounter;
    @FXML
    private ImageView Player2LeadersActive;
    @FXML
    private ImageView Player1LeadersActive;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        game = GameManager.getGameDataById(0);
        player1 = game.getPlayer1();
        player2 = game.getPlayer2();
        initializeSetImages();
        initializeContainers();
        initializeHighlights();
        updateLabels();
    }

    public void initializeContainers() {
        for (int i = 0; i < 3; i++) {
            player1Rows[i] = new CardViewContainer<>(player1.getRow(i));
            player2Rows[i] = new CardViewContainer<>(player2.getRow(i));
            player1Specials[i] = new CardViewContainer<>(player1.getRowSpecialCards(i));
            player2Specials[i] = new CardViewContainer<>(player2.getRowSpecialCards(i));
        }

        player1Hand = new CardViewContainer<>(player1.getHand());
        player2Hand = new CardViewContainer<>(player2.getHand());
        player1Deck = new CardViewContainer<>(player1.getDeck());
        player2Deck = new CardViewContainer<>(player2.getDeck());
        player1DiscardPile = new CardViewContainer<>(player1.getDiscardPile());
        player2DiscardPile = new CardViewContainer<>(player2.getDiscardPile());
        weatherCards = new CardViewContainer<>(game.getWeatherCards());


    }

    public void initializeHighlights() {
        for (int i = 0; i < 3; i++) {
            generateHighlightRectangle(player1Rows[i], player1Containers);
            generateHighlightRectangle(player2Rows[i], player2Containers);
            generateHighlightRectangle(player1Specials[i], player1Containers);
            generateHighlightRectangle(player2Specials[i], player2Containers);
        }
        generateHighlightRectangle(player1Hand, player1Containers);
        generateHighlightRectangle(player2Hand, player2Containers);
        generateHighlightRectangle(player1Deck, player1Containers);
        generateHighlightRectangle(player2Deck, player2Containers);
        generateHighlightRectangle(player1DiscardPile, player1Containers);
        generateHighlightRectangle(player2DiscardPile, player2Containers);
        generateHighlightRectangle(weatherCards, player1Containers);
    }

    private void generateHighlightRectangle(CardViewContainer<? extends ItemView> container, HashMap<CardViewContainer<? extends ItemView>, Rectangle> highlights) {
        Rectangle rectangle = new Rectangle();
        rectangle.setVisible(false);
        rectangle.setLayoutX(container.getLayoutX());
        rectangle.setLayoutY(container.getLayoutY());
        rectangle.setWidth(container.getWidth());
        rectangle.setHeight(container.getHeight());
        pane.getChildren().add(rectangle);
        highlights.put(container, rectangle);
    }

    public void initializeSetImages() {
        BoardImage.setImage(Backgrounds.BOARD.getImage());

        Player1CardCount.setImage(Icons.CARD_COUNT.getImage());
        Player1GemOn.setImage(Items.GEM_ON.getImage());
        Player1GemOff.setImage(Items.GEM_OFF.getImage());

        Player2CardCount.setImage(Icons.CARD_COUNT.getImage());
        Player2GemOn.setImage(Items.GEM_ON.getImage());
        Player2GemOff.setImage(Items.GEM_OFF.getImage());
    }

    public void updateLabels() {
        Player1Score.setText(String.valueOf(player1.getCurrentScore()));
        Player2Score.setText(String.valueOf(player2.getCurrentScore()));

        Player1Row0Score.setText(String.valueOf(calculateRowScore(player1, 0)));
        Player1Row1Score.setText(String.valueOf(calculateRowScore(player1, 1)));
        Player1Row2Score.setText(String.valueOf(calculateRowScore(player1, 2)));

        Player2Row0Score.setText(String.valueOf(calculateRowScore(player2, 0)));
        Player2Row1Score.setText(String.valueOf(calculateRowScore(player2, 1)));
        Player2Row2Score.setText(String.valueOf(calculateRowScore(player2, 2)));

        Player1CardCounter.setText(String.valueOf(calculateCountOfCard(player1)));
        Player2CardCounter.setText(String.valueOf(calculateCountOfCard(player2)));
    }

    public int calculateRowScore(Player player, int rowNum) {
        int score = 0;
        for (Card card : player.getRows()[rowNum]) {
            if (card instanceof UnitCard) {
                score += ((UnitCard) card).getScore();
            }
        }
        return score;
    }

    public int calculateCountOfCard(Player player) {
        return player.getHand().size();
    }

    public void findCardPlaceOnClick(ItemView cardview) {

    }

    public <K extends ItemView> void activateContainer(CardViewContainer<K> container, K item) {
        /*highlights.get(container).setVisible(true);
        container.setOnMouseClicked(event -> {
            highlights.get(container).setVisible(false);
            updateLabels();

        });*/

}





