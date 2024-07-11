package com.ap.gwentgame.client;

import com.ap.gwentgame.ClientMessage;
import com.ap.gwentgame.ServerMessage;
import com.ap.gwentgame.client.model.Abilities.Ability;
import com.ap.gwentgame.client.model.PropertyMarshallerAbstractTask;
import com.ap.gwentgame.client.model.gameElements.Card;
import com.ap.gwentgame.client.model.gameElements.Leader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.Socket;

public class Client {
    private static DataInputStream dataInputStream;
    private static DataOutputStream dataOutputStream;
    private static Socket socket;

    private static final GsonBuilder builder = new GsonBuilder().registerTypeAdapter(Card.class,
            new PropertyMarshallerAbstractTask()).registerTypeAdapter(Ability.class,
            new PropertyMarshallerAbstractTask()).registerTypeAdapter(Leader.class,
            new PropertyMarshallerAbstractTask());
    private static final Gson gson = builder.create();

    public static void start() {
        establishConnection();
    }

    private static void establishConnection() {
        try {
            Socket socket = new Socket("localhost", 2626);
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void closeConnection() {
        try {
            dataInputStream.close();
            dataOutputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendRequest(String messageText, Object additionalObject) {
        try {
            ClientMessage request = new ClientMessage(messageText, gson.toJson(additionalObject));
            dataOutputStream.writeUTF(gson.toJson(request));
            dataOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendRequest(String messageText) {
        try {
            ClientMessage request = new ClientMessage(messageText, null);
            dataOutputStream.writeUTF(gson.toJson(request));
            dataOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ServerMessage getResponse() {
        try {
            return gson.fromJson(dataInputStream.readUTF(), ServerMessage.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Client.start();
    }

    public static Gson getGson(){
        return gson;
    }
}
