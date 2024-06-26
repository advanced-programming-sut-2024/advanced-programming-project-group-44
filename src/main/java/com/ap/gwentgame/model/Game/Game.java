package com.ap.gwentgame.model.Game;

import com.ap.gwentgame.model.*;
import com.ap.gwentgame.model.Factions.Faction;
import com.ap.gwentgame.model.Leaders.Leader;


public class Game {
    private static Board currentBoard;
    private static User user1;
    private static User user2;
    private static Faction faction1;
    private static Faction faction2;
    private static Leader leader1;
    private static Leader leader2;

    public void createNewBoard(){
        currentBoard = new Board(new Player(user1, faction1, leader1), new Player(user2, faction2, leader2));
    }

    public Board getCurrentBoard() {
        return currentBoard;
    }

    public static void setUser1(User user1) {
        Game.user1 = user1;
    }

    public static void setUser2(User user2) {
        Game.user2 = user2;
    }

    public static void setFaction1(Faction faction1) {
        Game.faction1 = faction1;
    }

    public static void setFaction2(Faction faction2) {
        Game.faction2 = faction2;
    }

    public static void setLeader1(Leader leader1) {
        Game.leader1 = leader1;
    }

    public static void setLeader2(Leader leader2) {
        Game.leader2 = leader2;
    }
}
