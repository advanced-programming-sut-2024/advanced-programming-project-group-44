package com.ap.gwentgame.client.controller;

import com.ap.gwentgame.ServerMessage;
import com.ap.gwentgame.client.Client;
import com.ap.gwentgame.client.model.User;
import com.ap.gwentgame.client.model.gameElements.Player;

public class RequestSender {
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

    public static ServerMessage logoutUser() {
        String messageText = "logout user";
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

    public static ServerMessage editUser(String username, String nickname, String email) {
        String messageText = "edit user" + " " + username + " " + nickname + " " + email;
        Client.sendRequest(messageText);
        return Client.getResponse();
    }


    public static ServerMessage editPassword(String currentPassword, String newPassword) {
        String messageText = "edit password" + " " + currentPassword + " " + newPassword;
        Client.sendRequest(messageText);
        return Client.getResponse();
    }

    public static void requestRandomGame(Player player) {
        String messageText = "GAME start random";
        Client.sendRequest(messageText, player);
    }
}
