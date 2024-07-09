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
    GET_QUESTION_FAILED_USER_NOT_FOUND("get question failed - user not found"),
    GET_QUESTION_SUCCESSFUL("get question successful"),
    VALIDATE_ANSWER_FAILED_INCORRECT_ANSWER("validate answer failed - incorrect answer"),
    VALIDATE_ANSWER_SUCCESSFUL("validate answer successful"),
    EDIT_PROFILE_SUCCESSFUL("edit profile successful"),
    EDIT_PROFILE_FAILED_NO_CHANGES("edit profile failed - no changes"),
    EDIT_PROFILE_FAILED_USERNAME_TAKEN("edit profile failed - username already taken"),
    EDIT_PROFILE_FAILED_NICKNAME_TAKEN("edit profile failed - nickname already taken"),
    EDIT_PROFILE_FAILED_EMAIL_TAKEN("edit profile failed - email already taken"),
    EDIT_PASSWORD_SUCCESSFUL("edit password successful"),
    EDIT_PASSWORD_FAILED_INCORRECT_PASSWORD("edit password failed - incorrect password"),
    EDIT_PASSWORD_FAILED_NO_CHANGES("edit password failed - no changes"),
    ;


    private final String messageRegex;

    ServerCommands(String messageRegex) {
        this.messageRegex = messageRegex;
    }

    public Matcher getMatcher(String message) {
        return Pattern.compile(messageRegex).matcher(message);
    }

}
