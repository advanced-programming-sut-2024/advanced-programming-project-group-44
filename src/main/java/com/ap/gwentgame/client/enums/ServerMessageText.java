package com.ap.gwentgame.client.enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum ServerMessageText {
    ;
    private final String messageRegex;

    ServerMessageText(String messageRegex) {
        this.messageRegex = messageRegex;
    }

    public Matcher getMatcher(String message) {
        return Pattern.compile(messageRegex).matcher(message);
    }

    }
