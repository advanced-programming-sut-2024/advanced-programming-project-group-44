package com.ap.gwentgame.client;

import com.ap.gwentgame.ClientMessage;
import com.ap.gwentgame.ServerMessage;
import com.ap.gwentgame.client.view.StartMenu;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

public class Client {
    private static DataInputStream dataInputStream;
    private static DataOutputStream dataOutputStream;
    private static Socket socket;

    private static GsonBuilder gsonBuilder = new GsonBuilder();
    private static Gson gson = gsonBuilder.create();

    public static void start() {
        establishConnection();
    }

    private static void establishConnection() {
        try {
            Socket socket = new Socket("localhost", 6000);
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
        ClientMessage request = new ClientMessage(messageText, gson.toJson(additionalObject));
        try {
            dataOutputStream.writeUTF(gson.toJson(request));
            dataOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendRequest(String messageText) {
        ClientMessage request = new ClientMessage(messageText, null);
        try {
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
        StartMenu startMenu = new StartMenu();
        try {
            startMenu.start(new Stage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
