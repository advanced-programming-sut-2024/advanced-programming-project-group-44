package com.ap.gwentgame.client.controller;

import com.ap.gwentgame.ServerMessage;
import com.ap.gwentgame.client.Client;
import com.ap.gwentgame.client.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class RequestSender {
    private static GsonBuilder builder = new GsonBuilder();
    private static Gson gson = builder.create();

    public static ServerMessage registerUser(User user) {
        String messageText = "register user";
        Client.sendRequest(messageText, user);
        return Client.getResponse();
    }

    public static ServerMessage loginUser(String username, String password) {
        String messageText = "login user" + " " + username + " " + password;
        Client.sendRequest(messageText);
        return Client.getResponse();
    }

    public static ServerMessage getQuestion(String username) {
        String messageText = "get question" + " " + username;
        Client.sendRequest(messageText);
        return Client.getResponse();
    }

    public static ServerMessage validateAnswer(String username, String answer) {
        String messageText = "validate answer" + " " + username + " " + answer;
        Client.sendRequest(messageText);
        return Client.getResponse();
    }

    public static ServerMessage editProfile(String username, String nickname, String email) {
        String messageText = "edit profile" + " " + username + " " + nickname + " " + email;
        Client.sendRequest(messageText);
        return Client.getResponse();
    }

    public static ServerMessage editPassword(String currentPassword, String newPassword) {
        String messageText = "edit password" + " " + currentPassword + " " + newPassword;
        Client.sendRequest(messageText);
        return Client.getResponse();
    }
}
