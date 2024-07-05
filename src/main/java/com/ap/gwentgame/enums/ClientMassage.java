package com.ap.gwentgame.enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum ClientMassage {
    ;
    private final String messageRegex;

    ClientMassage(String messageRegex) {
        this.messageRegex = messageRegex;
    }

    public Matcher getMatcher(String message) {
        return Pattern.compile(messageRegex).matcher(message);
    }

    }
