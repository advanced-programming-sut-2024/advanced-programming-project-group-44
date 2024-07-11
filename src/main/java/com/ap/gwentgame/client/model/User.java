package com.ap.gwentgame.client.model;

import com.ap.gwentgame.client.enums.Question;
import com.ap.gwentgame.client.model.gameElements.Card;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "email")
    private String email;

    @Column(name = "games_played")
    private int gamesPlayed;

    @Column(name = "highest_point")
    private int highestPoint;

    @Column(name = "rank")
    private int rank;

    @Column(name = "wins")
    private int wins;

    @Column(name = "draws")
    private int draws;

    @Column(name = "losses")
    private int losses;

    @Enumerated(EnumType.STRING)
    @Column(name = "question")
    private Question question;

    @Column(name = "answer")
    private String answer;

    @ElementCollection
    @CollectionTable(name = "user_deck", joinColumns = @JoinColumn(name = "user_id"))
    private List<Card> deck;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private List<GameLog> gameHistory;

    public User() {
        this.deck = new ArrayList<>();
        this.gameHistory = new ArrayList<>();
    }

    public User(String name, String password, String nickName, String email, Question question, String answer) {
        this.name = name;
        this.password = password;
        this.nickName = nickName;
        this.email = email;
        this.question = question;
        this.answer = answer;
        this.gamesPlayed = 0;
        this.highestPoint = 0;
        this.rank = 0;
        this.wins = 0;
        this.draws = 0;
        this.losses = 0;
        this.deck = new ArrayList<>();
        this.gameHistory = new ArrayList<>();
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getHighestPoint() {
        return highestPoint;
    }

    public void setHighestPoint(int highestPoint) {
        this.highestPoint = highestPoint;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public Question getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public List<Card> getDeck() {
        return deck;
    }

    public List<GameLog> getGameHistory() {
        return gameHistory;
    }
}
