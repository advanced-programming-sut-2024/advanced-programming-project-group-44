package com.ap.gwentgame;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
;

public enum ServerCommands {
    //Registration successful
    //Registration failed - nickname already taken
    //Registration failed - username already taken
    //Login successful
    //Login failed
    INVALID_MESSAGE("Invalid message"),
    REGISTRATION_SUCCESSFUL("Registration successful"),
    REGISTRATION_FAILED_NICKNAME_TAKEN("Registration failed - nickname already taken"),
    REGISTRATION_FAILED_USERNAME_TAKEN("Registration failed - username already taken"),
    REGISTRATION_FAILED_EMAIL_TAKEN("Registration failed - email already taken"),
    LOGIN_SUCCESSFUL("Login successful"),
    LOGIN_FAILED_INCORRECT_PASSWORD("Login failed - incorrect password"),
    LOGIN_FAILED_USER_NOT_FOUND("Login failed - user not found"),
    ;


    private final String messageRegex;

    ServerCommands(String messageRegex) {
        this.messageRegex = messageRegex;
    }

    public Matcher getMatcher(String message) {
        return Pattern.compile(messageRegex).matcher(message);
    }

    }
