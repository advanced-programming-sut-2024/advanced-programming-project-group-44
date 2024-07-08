package com.ap.gwentgame;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum ClientCommands {
    //Game <ID> Player <Player Number> play card <hand index> to regular row <row index>
    //Game <ID> Player <Player Number> play card <hand index> to weather place <hand index>
    //Game <ID> Player <Player Number> play leader power
    //Game <ID> Player <Player Number> play pass
    //start game with friend <nickname>
    //start game with random
    //broadcast live game <GameID>
    //broadcast previous game <GameID>
    //register user
    //login user <username> <password>
    //edit user <username> <nickname> <email>
    REGISTER_USER("register user"),
    LOGIN_USER("login user (\\S+) (\\S+)"),
    EDIT_USER("edit user (\\S+) (\\S+) (\\S+)"),
    ;



    private final String messageRegex;

    ClientCommands(String messageRegex) {
        this.messageRegex = messageRegex;
    }

    public Matcher getMatcher(String message) {
        return Pattern.compile(messageRegex).matcher(message);
    }

    }
