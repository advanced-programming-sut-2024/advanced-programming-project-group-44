package com.ap.gwentgame.client.enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum ClientMassageText {
    //Game <ID> Player <Player Number> play card <hand index> to regular row <row index>
    //Game <ID> Player <Player Number> play card <hand index> to weather place <hand index>
    //Game <ID> Player <Player Number> play leader power
    //Game <ID> Player <Player Number> play pass
    //start game with friend <nickname>
    //start game with random
    //broadcast live game <GameID>
    //broadcast previous game <GameID>
    ;


    private final String messageRegex;

    ClientMassageText(String messageRegex) {
        this.messageRegex = messageRegex;
    }

    public Matcher getMatcher(String message) {
        return Pattern.compile(messageRegex).matcher(message);
    }

    }
