package com.ap.gwentgame.server;

import com.ap.gwentgame.ClientCommands;
import com.ap.gwentgame.ClientMessage;
import com.ap.gwentgame.ServerMessage;
import com.ap.gwentgame.client.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;

public class UserHandler extends Thread {
    private static DataInputStream dataInputStream;
    private static DataOutputStream dataOutputStream;
    private static Socket socket;

    private static GsonBuilder builder = new GsonBuilder();
    private static Gson gson = builder.create();

    private User currentUser;

    public UserHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
             DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream())) {

            while (true) {
                ClientMessage clientMessage = gson.fromJson(dataInputStream.readUTF(), ClientMessage.class);
                if (clientMessage.getMessageText().equals("close")) {
                    break;
                }
                processRequest(clientMessage);
            }

            dataInputStream.close();
            dataOutputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processRequest(ClientMessage clientMessage){
        String messageText = clientMessage.getMessageText();

        Matcher matcher;
        if ((matcher = ClientCommands.REGISTER_USER.getMatcher(messageText)).matches()) {
            User user = gson.fromJson(matcher.group(1), User.class);
            System.out.println("kir");
            if (Database.findUserByUsername(user.getName()) != null) {
                sendResponse("Registration failed - username already taken");
                return;
            }
            if (Database.findUserByEmail(user.getEmail()) != null) {
                sendResponse("Registration failed - email already taken");
                return;
            }
            if (Database.findUserByNickname(user.getNickName()) != null) {
                sendResponse("Registration failed - nickname already taken");
                return;
            }

            Database.addUser(user);
            currentUser = user;
            sendResponse("Registration successful");
        }
    }

    private void sendResponse(String messageText) {
        try {
            ServerMessage serverMessage = new ServerMessage(messageText, null);
            dataOutputStream.writeUTF(gson.toJson(serverMessage));
            dataOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendResponse(String messageText, Object additionalObject) {
        try {
            ServerMessage serverMessage = new ServerMessage(messageText, gson.toJson(additionalObject));
            dataOutputStream.writeUTF(gson.toJson(serverMessage));
            dataOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        try (ServerSocket serverSocket = new ServerSocket(8000)) {
            while (true) {
                Socket socket = serverSocket.accept();
                executorService.submit(new UserHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}