package com.ap.gwentgame.server;

import com.ap.gwentgame.ClientCommands;
import com.ap.gwentgame.ClientMessage;
import com.ap.gwentgame.ServerMessage;
import com.ap.gwentgame.client.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.w3c.dom.ls.LSOutput;

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
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private Socket socket;

    private User currentUser;

    private static GsonBuilder builder = new GsonBuilder();
    private static Gson gson = builder.create();

    public UserHandler(Socket socket) {
        this.socket = socket;
        try {
            this.dataInputStream = new DataInputStream(socket.getInputStream());
            this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                ClientMessage clientMessage = gson.fromJson(dataInputStream.readUTF(), ClientMessage.class);
                if (clientMessage.getMessageText().equals("close")) {
                    break;
                }
                processRequest(clientMessage);
            }
            closeConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeConnection() {
        try {
            dataInputStream.close();
            dataOutputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processRequest(ClientMessage clientMessage) {
        String messageText = clientMessage.getMessageText();

        Matcher matcher;
        if ((matcher = ClientCommands.REGISTER_USER.getMatcher(messageText)).matches()) {
            User user = gson.fromJson(clientMessage.getAdditionalText(), User.class);

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
            sendResponse("Registration successful");
            return;
        } else if ((matcher = ClientCommands.LOGIN_USER.getMatcher(messageText)).matches()) {
            String username = matcher.group(1);
            String password = matcher.group(2);

            User user = Database.findUserByUsername(username);

            if (user == null) {
                sendResponse("Login failed - user not found");
                return;
            }

            if (!user.getPassword().equals(password)) {
                sendResponse("Login failed - incorrect password");
                return;
            }

            System.out.println("salam");
            currentUser = user;
            sendResponse("Login successful", user);
            return;
        }


    }

    private void sendResponse(String messageText) {
        try {
            ServerMessage serverMessage = new ServerMessage(messageText, null);
            String felan = gson.toJson(serverMessage);
            builder.setPrettyPrinting();
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