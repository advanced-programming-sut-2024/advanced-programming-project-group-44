package com.ap.gwentgame.controller;

import com.ap.gwentgame.enums.Question;
import com.ap.gwentgame.model.App;
import com.ap.gwentgame.model.User;
import com.ap.gwentgame.view.ProfileMenu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

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

    private ObservableList<User> userList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Update();

        // Populate TableView with sorted userList
        scoreBoardTable.setItems(userList);
        playerNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        winCountColumn.setCellValueFactory(new PropertyValueFactory<>("wins"));
        gamesPlayedColumn.setCellValueFactory(new PropertyValueFactory<>("gamesPlayed"));
    }

    private List<User> getSampleUsers() {
        User user = new User("Player1", "password1", "Player One", "player1@example.com", Question.QUESTION_1 , "no");
        User user2 = new User("Player2", "password2", "Player Two", "player2@example.com", Question.QUESTION_2 , "nooo");
        user.setWins(23);
        user2.setWins(15);
        user.setGamesPlayed(54);
        user2.setGamesPlayed(18);
        return List.of(
                user,
                user2
        );
    }

    public void Update(){
        userList = FXCollections.observableArrayList(getSampleUsers());
        userList.sort(Comparator.comparingInt(User::getWins).reversed());
    }

    public void backToProfileMenu(MouseEvent mouseEvent) {
        try {
            ProfileMenu profileMenu = new ProfileMenu();
            profileMenu.start(App.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
