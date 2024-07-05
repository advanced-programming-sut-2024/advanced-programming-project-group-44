package com.ap.gwentgame.enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum ServerMessage {
    ;
    private final String messageRegex;

    ServerMessage(String messageRegex) {
        this.messageRegex = messageRegex;
    }

    public Matcher getMatcher(String message) {
        return Pattern.compile(messageRegex).matcher(message);
    }

    }
