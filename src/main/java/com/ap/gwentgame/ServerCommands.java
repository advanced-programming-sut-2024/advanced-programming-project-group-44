package com.ap.gwentgame;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
;

public enum ServerCommands {
    INVALID_MESSAGE("invalid message"),
    REGISTRATION_SUCCESSFUL("registration successful"),
    REGISTRATION_FAILED_NICKNAME_TAKEN("registration failed - nickname already taken"),
    REGISTRATION_FAILED_USERNAME_TAKEN("registration failed - username already taken"),
    REGISTRATION_FAILED_EMAIL_TAKEN("registration failed - email already taken"),
    LOGIN_SUCCESSFUL("login successful"),
    LOGIN_FAILED_INCORRECT_PASSWORD("login failed - incorrect password"),
    LOGIN_FAILED_USER_NOT_FOUND("login failed - user not found"),
    LOGOUT_SUCCESSFUL("logout successful"),
    GET_QUESTION_FAILED_USER_NOT_FOUND("get question failed - user not found"),
    GET_QUESTION_SUCCESSFUL("get question successful"),
    VALIDATE_ANSWER_FAILED_INCORRECT_ANSWER("validate answer failed - incorrect answer"),
    VALIDATE_ANSWER_SUCCESSFUL("validate answer successful"),
    EDIT_USER_SUCCESSFUL("edit user successful"),
    EDIT_USER_FAILED_USERNAME_TAKEN("edit user failed - username already taken"),
    EDIT_USER_FAILED_NICKNAME_TAKEN("edit user failed - nickname already taken"),
    EDIT_USER_FAILED_EMAIL_TAKEN("edit user failed - email already taken"),
    EDIT_PASSWORD_SUCCESSFUL("edit password successful"),
    EDIT_PASSWORD_FAILED_INCORRECT_PASSWORD("edit password failed - incorrect password"),
    EDIT_PASSWORD_FAILED_NO_CHANGES("edit password failed - no changes"),
    GAME_STARTED("GAME started"),
    PLAY_CARD("GAME (\\d+) player (\\S+) play card (\\d+) to container (\\d+) with abilityInput (\\-?\\d+)"),
    PLAY_LEADER("GAME (\\d+) player (\\S+) play leader power with abilityInput (\\d+)"),
    PLAY_PASS("GAME (\\d+) player (\\S+) play pass");

    private final String messageRegex;

    ServerCommands(String messageRegex) {
        this.messageRegex = messageRegex;
    }

    public Matcher getMatcher(String message) {
        return Pattern.compile(messageRegex).matcher(message);
    }

}
