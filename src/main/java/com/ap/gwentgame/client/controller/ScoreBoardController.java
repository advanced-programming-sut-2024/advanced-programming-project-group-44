package com.ap.gwentgame.client.controller;

import com.ap.gwentgame.client.enums.Question;
import com.ap.gwentgame.client.model.Session;
import com.ap.gwentgame.client.model.User;
import com.ap.gwentgame.client.view.ProfileMenu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;

import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

public class ScoreBoardController implements Initializable {

    @FXML
    private TableView<User> scoreBoardTable;

    @FXML
    private TableColumn<User, String> playerNameColumn;

    @FXML
    private TableColumn<User, Integer> winCountColumn;

    @FXML
    private TableColumn<User, Integer> gamesPlayedColumn;

    @FXML
    private TableColumn<User, String> status;

    @FXML
    private TableColumn<User, Void> lastGameColumn;

    private ObservableList<User> userList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Update();

        scoreBoardTable.setItems(userList);
        playerNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        winCountColumn.setCellValueFactory(new PropertyValueFactory<>("wins"));
        gamesPlayedColumn.setCellValueFactory(new PropertyValueFactory<>("gamesPlayed"));

        addLastGameColumn();
    }

    private List<User> getSampleUsers() {
        User user = new User("Player1", "password1", "Player One", "player1@example.com", Question.QUESTION_1, "no");
        User user2 = new User("Player2", "password2", "Player Two", "player2@example.com", Question.QUESTION_2, "nooo");
        user.setWins(23);
        user2.setWins(15);
        user.setGamesPlayed(54);
        user2.setGamesPlayed(18);
        return List.of(
                user,
                user2
        );
    }

    public void Update() {
        userList = FXCollections.observableArrayList(getSampleUsers());
        userList.sort(Comparator.comparingInt(User::getWins).reversed());
    }

    private void addLastGameColumn() {
        Callback<TableColumn<User, Void>, TableCell<User, Void>> cellFactory = new Callback<TableColumn<User, Void>, TableCell<User, Void>>() {
            @Override
            public TableCell<User, Void> call(final TableColumn<User, Void> param) {
                final TableCell<User, Void> cell = new TableCell<User, Void>() {

                    private ImageView playIcon = new ImageView(new Image(getClass().getResourceAsStream("/images/play.png")));

                    private final Button playButton = new Button("", playIcon);
                    private final StackPane centeredPane = new StackPane(playButton);

                    {
                        playIcon.setFitWidth(20);
                        playIcon.setFitHeight(20);
                        playButton.setOnAction(event -> {
                            User user = getTableView().getItems().get(getIndex());
                            startLastGame(user);
                        });
                        centeredPane.setPrefHeight(Double.MAX_VALUE);
                        centeredPane.setPrefWidth(Double.MAX_VALUE);
                        StackPane.setAlignment(playButton,javafx.geometry.Pos.CENTER);
                    }


                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(playButton);
                        }
                    }
                };
                return cell;
            }
        };

        lastGameColumn.setCellFactory(cellFactory);
    }

    private void startLastGame(User user) {
        System.out.println("Starting last game for " + user.getName());
    }

    public void backToProfileMenu(MouseEvent mouseEvent) {
        try {
            ProfileMenu profileMenu = new ProfileMenu();
            profileMenu.start(Session.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
