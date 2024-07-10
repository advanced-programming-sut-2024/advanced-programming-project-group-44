package com.ap.gwentgame.server;

import com.ap.gwentgame.ClientCommands;
import com.ap.gwentgame.ClientMessage;
import com.ap.gwentgame.ServerMessage;
import com.ap.gwentgame.client.controller.ForgotPasswordMenuController;
import com.ap.gwentgame.client.model.Session;
import com.ap.gwentgame.client.model.User;
import com.ap.gwentgame.client.model.gameElements.Player;
import com.ap.gwentgame.client.view.ViewUtilities;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.scene.shape.StrokeLineCap;
import org.w3c.dom.ls.LSOutput;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;

public class UserHandler extends Thread {
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private Socket socket;

    private User currentUser;
    private Player currentPlayer;
    private int currentGameID;
    private static ArrayList<User> loggedInUsers = new ArrayList<>();

    private static GsonBuilder builder = new GsonBuilder();
    private static Gson gson = builder.create();

    private static final Queue<UserHandler> waitingPlayers = new LinkedList<>();
    private static final HashMap<Integer, UserHandler> gamePlayers = new HashMap<>();
    private static final HashMap<Integer, UserHandler> gameSpectators = new HashMap<>();
    private static int gameID = 0;


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

        System.out.println(messageText);
        Matcher matcher;
        if ((matcher = ClientCommands.REGISTER_USER.getMatcher(messageText)).matches()) {
            User user = gson.fromJson(clientMessage.getAdditionalText(), User.class);

            if (Database.findUserByUsername(user.getName()) != null) {
                sendResponse("registration failed - username already taken");
                return;
            }

            if (Database.findUserByEmail(user.getEmail()) != null) {
                sendResponse("registration failed - email already taken");
                return;
            }

            if (Database.findUserByNickname(user.getNickName()) != null) {
                sendResponse("registration failed - nickname already taken");
                return;
            }


            Database.addUser(user);
            currentUser = user;
            loggedInUsers.add(user);
            sendResponse("registration successful");
            return;
        }

        if ((matcher = ClientCommands.LOGIN_USER.getMatcher(messageText)).matches()) {
            String username = matcher.group(1);
            String password = matcher.group(2);

            User user = Database.findUserByUsername(username);

            if (user == null) {
                sendResponse("login failed - user not found");
                return;
            }

            if (!user.getPassword().equals(password)) {
                sendResponse("login failed - incorrect password");
                return;
            }

            currentUser = user;
            loggedInUsers.add(user);
            sendResponse("login successful", user);
            return;
        }

        if ((matcher = ClientCommands.GET_QUESTION.getMatcher(messageText)).matches()) {
            String username = matcher.group(1);
            User user = Database.findUserByUsername(username);
            if(user == null){
                sendResponse("user not found");
                return;
            }

            sendResponse("get question successful", user.getQuestion());
            return;
        }

        if((matcher = ClientCommands.VALIDATE_ANSWER.getMatcher(messageText)).matches()){
            String username = matcher.group(1);
            String answer = matcher.group(2);

            User user = Database.findUserByUsername(username);
            System.out.println(username + " " + answer);
            System.out.println(user.getAnswer());

            if(!user.getAnswer().equals(answer)){
                sendResponse("validate answer failed - incorrect answer");
                return;
            }

            sendResponse("validate answer successful", user);
            return;
        }

        if ((matcher = ClientCommands.EDIT_USER.getMatcher(messageText)).matches()) {
            String username = matcher.group(1);
            String nickname = matcher.group(2);
            String email = matcher.group(3);

            if (!currentUser.getName().equals(username) && !currentUser.getNickName().equals(nickname) && !currentUser.getEmail().equals(email)) {
                sendResponse("Edit failed - no changes");
                return;
            }

            for (User user : loggedInUsers) {
                if (user.getName().equals(username) && !user.equals(currentUser)) {
                    sendResponse("Edit failed - username already taken");
                    return;
                }
            }

            if (Database.findUserByEmail(email) != null) {
                sendResponse("Edit failed - email already taken");
                return;
            }

            if (Database.findUserByNickname(nickname) != null) {
                sendResponse("Edit failed - nickname already taken");
                return;
            }

            currentUser.setNickName(nickname);
            currentUser.setEmail(email);
            sendResponse("Edit successful");
            return;
        }

        if ((matcher = ClientCommands.EDIT_PASSWORD.getMatcher(messageText)).matches()) {
            String password = matcher.group(1);
            String newPassword = matcher.group(2);

            if (!currentUser.getPassword().equals(password)) {
                sendResponse("Edit failed - incorrect password");
                return;
            }

            if (currentUser.getPassword().equals(newPassword)) {
                sendResponse("Edit failed - no changes");
                return;
            }

            currentUser.setPassword(newPassword);
            sendResponse("Password changed successfully");
            return;
        }

        sendResponse("Invalid message");


    }

    private void sendResponse(String messageText) {
        try {
            ServerMessage serverMessage = new ServerMessage(messageText, null);
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
}