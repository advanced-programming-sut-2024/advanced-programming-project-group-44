package com.ap.gwentgame;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum ClientCommands {
    REGISTER_USER("register user"),
    VERIFY_USER("verify user (\\S+)"),
    LOGIN_USER("login user (\\S+) (\\S+)"),
    LOGOUT_USER("logout user"),
    GET_QUESTION("get question (\\S+)"),
    VALIDATE_ANSWER("validate answer (\\S+) (\\S+)"),
    EDIT_USER("edit user (\\S+) (\\S+) (\\S+)"),
    EDIT_PASSWORD("edit password (\\S+) (\\S+)"),
    REQUEST_RANDOM_GAME("GAME start random"),
    REQUEST_FRIEND_GAME("GAME start with friend (\\S+)"),
    REQUEST_TORNAMENT_GAME("GAME start tournament"),
    REQUEST_SPECTATE_GAME("GAME start spectate game (\\d+)"),
    REQUEST_REWATCH_GAME("GAME start rewatch game (\\d+)"),
    PLAY_CARD("GAME (\\d+) player (\\S+) play card (\\d+) to container (\\d+) with abilityInput (\\-?\\d+)"),
    PLAY_LEADER("GAME (\\d+) player (\\S+) play leader power with abilityInput (\\d+)"),
    PLAY_PASS("GAME (\\d+) player (\\S+) play pass");

    private final String messageRegex;

    ClientCommands(String messageRegex) {
        this.messageRegex = messageRegex;
    }

    public Matcher getMatcher(String message) {
        return Pattern.compile(messageRegex).matcher(message);
    }

    }
