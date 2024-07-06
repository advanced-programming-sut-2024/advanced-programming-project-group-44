package com.ap.gwentgame.client.controller;

import com.ap.gwentgame.ServerMessage;
import com.ap.gwentgame.client.Client;
import com.ap.gwentgame.client.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class RequestSender {
    private static GsonBuilder builder = new GsonBuilder();
    private static Gson gson = builder.create();

    public static ServerMessage registerUser(User user){
        String messageText = "register user";
        Client.sendRequest(messageText, user);
        return Client.getResponse();
    }

    public static ServerMessage loginUser(String username, String password){
        String messageText = "login user" + " " + username + " " + password;
        Client.sendRequest(messageText);
        return Client.getResponse();
    }
}
