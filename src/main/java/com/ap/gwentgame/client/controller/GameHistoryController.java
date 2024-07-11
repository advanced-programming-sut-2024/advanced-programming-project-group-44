package com.ap.gwentgame.client.controller;

import com.ap.gwentgame.client.model.App;
import com.ap.gwentgame.client.model.Game.GameData;
import com.ap.gwentgame.client.view.ProfileMenu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class GameHistoryController implements Initializable {

    @FXML
    private TableView<GameData> gameHistoryTable;

    @FXML
    private TableColumn<GameData, String> opponentColumn;

    @FXML
    private TableColumn<GameData, Integer> playerScoreColumn;

    @FXML
    private TableColumn<GameData, Integer> opponentScoreColumn;

    @FXML
    private TableColumn<GameData, Integer> playerScoreRound1Column;

    @FXML
    private TableColumn<GameData, Integer> playerScoreRound2Column;

    @FXML
    private TableColumn<GameData, Integer> playerScoreRound3Column;

    @FXML
    private TableColumn<GameData, Integer> opponentScoreRound1Column;

    @FXML
    private TableColumn<GameData, Integer> opponentScoreRound2Column;

    @FXML
    private TableColumn<GameData, Integer> opponentScoreRound3Column;

    @FXML
    private TableColumn<GameData, String> winnerColumn;

    @FXML
    private TableColumn<GameData, Date> dateColumn;

    private ObservableList<GameData> gameDataList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Set cell value factories for each column
        opponentColumn.setCellValueFactory(new PropertyValueFactory<>("opponentName"));
        playerScoreColumn.setCellValueFactory(new PropertyValueFactory<>("playerScore"));
        opponentScoreColumn.setCellValueFactory(new PropertyValueFactory<>("opponentScore"));
        playerScoreRound1Column.setCellValueFactory(new PropertyValueFactory<>("playerScoreRound1"));
        playerScoreRound2Column.setCellValueFactory(new PropertyValueFactory<>("playerScoreRound2"));
        playerScoreRound3Column.setCellValueFactory(new PropertyValueFactory<>("playerScoreRound3"));
        opponentScoreRound1Column.setCellValueFactory(new PropertyValueFactory<>("opponentScoreRound1"));
        opponentScoreRound2Column.setCellValueFactory(new PropertyValueFactory<>("opponentScoreRound2"));
        opponentScoreRound3Column.setCellValueFactory(new PropertyValueFactory<>("opponentScoreRound3"));
        winnerColumn.setCellValueFactory(new PropertyValueFactory<>("winner"));
        //dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));


        List<GameData> playerGameData = fetchDataFromDatabase("Player A");

        gameDataList.addAll(playerGameData);
        gameHistoryTable.setItems(gameDataList);
    }

    private List<GameData> fetchDataFromDatabase(String playerName) {
        return List.of(
                new GameData("Player A", "Player B", new Date(), 100, 90, new int[]{30, 40, 30}, new int[]{25, 30, 35}, "Player A"),
                new GameData("Player A", "Player C", new Date(), 120, 80, new int[]{35, 40, 45}, new int[]{30, 25, 25}, "Player C")

        );
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
