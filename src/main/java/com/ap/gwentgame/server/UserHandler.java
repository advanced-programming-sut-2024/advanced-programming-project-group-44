package com.ap.gwentgame.server;

import com.ap.gwentgame.ClientCommands;
import com.ap.gwentgame.ClientMessage;
import com.ap.gwentgame.ServerMessage;
import com.ap.gwentgame.client.model.Abilities.Ability;
import com.ap.gwentgame.client.model.PropertyMarshallerAbstractTask;
import com.ap.gwentgame.client.model.User;
import com.ap.gwentgame.client.model.gameElements.Card;
import com.ap.gwentgame.client.model.gameElements.Leader;
import com.ap.gwentgame.client.model.gameElements.Player;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;

public class UserHandler extends Thread {
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private Socket socket;

    private User currentUser;
    private Player currentPlayer;
    private BoardHandler currentBoardHandler;
    private static ArrayList<User> loggedInUsers = new ArrayList<>();

    private User verifyUser;
    private int verifyCode;

    private static final Queue<UserHandler> randomWaitingPlayers = new LinkedList<>();
    private static final HashMap<Integer, BoardHandler> games = new HashMap<>();
    private static int gameID = 0;

    private static final HashMap<User, User> friendRequests = new HashMap<>();

    private static final GsonBuilder builder = new GsonBuilder().registerTypeAdapter(Card.class,
            new PropertyMarshallerAbstractTask()).registerTypeAdapter(Ability.class,
            new PropertyMarshallerAbstractTask()).registerTypeAdapter(Leader.class,
            new PropertyMarshallerAbstractTask());
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

    public Player getPlayer() {
        return currentPlayer;
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

            verifyUser = user;
            SecureRandom random = new SecureRandom();
            verifyCode = Integer.parseInt(String.valueOf(100000 + random.nextInt(900000)));
            EmailSender emailSender = new EmailSender();
            emailSender.createEmailStructure(user.getEmail(), user, verifyCode);
            sendResponse("registration successful", user);
            return;
        }

        if ((matcher = ClientCommands.VERIFY_USER.getMatcher(messageText)).matches()) {
            String answerCode = matcher.group(1);

            if (verifyCode != Integer.parseInt(answerCode)) {
                sendResponse("verification failed - incorrect code");
                return;
            }

            Database.addUser(verifyUser);
            currentUser = verifyUser;
            loggedInUsers.add(verifyUser);
            verifyUser = null;
            verifyCode = 0;
            sendResponse("verification code successful", verifyUser);
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

            verifyUser = user;
            SecureRandom random = new SecureRandom();
            verifyCode = Integer.parseInt(String.valueOf(100000 + random.nextInt(900000)));
            EmailSender emailSender = new EmailSender();
            emailSender.createEmailStructure(user.getEmail(), user, verifyCode);
            sendResponse("login successful", user);
            return;
        }

        if ((matcher = ClientCommands.GET_QUESTION.getMatcher(messageText)).matches()) {
            String username = matcher.group(1);
            User user = Database.findUserByUsername(username);
            if (user == null) {
                sendResponse("user not found");
                return;
            }

            sendResponse("get question successful", user.getQuestion());
            return;
        }

        if ((matcher = ClientCommands.VALIDATE_ANSWER.getMatcher(messageText)).matches()) {
            String username = matcher.group(1);
            String answer = matcher.group(2);

            User user = Database.findUserByUsername(username);

            if (!user.getAnswer().equals(answer)) {
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

            User user;

            user = Database.findUserByUsername(username);
            if (user != null && user != currentUser) {
                sendResponse("edit user failed - username already taken");
                return;
            }

            user = Database.findUserByNickname(nickname);
            if (user != null && user != currentUser) {
                sendResponse("edit user failed - nickname already taken");
                return;
            }

            user = Database.findUserByEmail(email);
            if (user != null && user != currentUser) {
                sendResponse("edit user failed - email already taken");
                return;
            }

            currentUser.setName(username);
            currentUser.setNickName(nickname);
            currentUser.setEmail(email);
            sendResponse("edit user successful", currentUser);
            return;
        }

        if ((matcher = ClientCommands.EDIT_PASSWORD.getMatcher(messageText)).matches()) {
            String password = matcher.group(1);
            String newPassword = matcher.group(2);

            if (!currentUser.getPassword().equals(password)) {
                sendResponse("edit password failed - incorrect password");
                return;
            }

            if (currentUser.getPassword().equals(newPassword)) {
                sendResponse("edit password failed - no changes");
                return;
            }

            currentUser.setPassword(newPassword);
            sendResponse("edit password successful", currentUser);
            return;
        }


        if ((matcher = ClientCommands.REQUEST_RANDOM_GAME.getMatcher(messageText)).matches()) {
            currentPlayer = gson.fromJson(clientMessage.getAdditionalText(), Player.class);

            if (!randomWaitingPlayers.isEmpty()) {
                UserHandler player = randomWaitingPlayers.poll();
                BoardHandler boardHandler = new BoardHandler(this, player);
                games.put(gameID++, boardHandler);
                this.currentBoardHandler = boardHandler;
                player.currentBoardHandler = boardHandler;
                try {
                    this.sendResponse("GAME started", boardHandler.getCurrentBoard());
                    player.sendResponse("GAME started", boardHandler.getCurrentBoard());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                randomWaitingPlayers.add(this);
                sendResponse("Waiting for opponent");
            }
        }

        if ((matcher = ClientCommands.LOGOUT_USER.getMatcher(messageText)).matches()) {
            loggedInUsers.remove(currentUser);
            currentUser = null;
            currentPlayer = null;
            currentBoardHandler = null;
            sendResponse("logout successful");
            return;
        }

        if ((matcher = ClientCommands.FRIEND_REQUEST.getMatcher(messageText)).matches()) {
            sendResponse("Friend request sent");
            User friend = Database.findUserByUsername(matcher.group(1));
            friendRequests.put(currentUser, friend);
            return;
        }

        if ((matcher = ClientCommands.FRIEND_ACCEPT.getMatcher(messageText)).matches()) {
            sendResponse("Friend request accepted");
            User friend = Database.findUserByUsername(matcher.group(1));
            currentUser.addFriends(friend);
            friend.addFriends(currentUser);
            friendRequests.remove(friend);
            return;
        }

        if ((matcher = ClientCommands.FRIEND_DECLINE.getMatcher(messageText)).matches()) {
            sendResponse("Friend request declined");
            User friend = Database.findUserByUsername(matcher.group(1));
            friendRequests.remove(friend);
            return;
        }

        if ((matcher = ClientCommands.GET_ALL_FRIEND_REQUESTS.getMatcher(messageText)).matches()) {
            sendResponse("All friend requests", friendRequests);
            return;
        }

        sendResponse("Invalid message");


    }

    protected void sendResponse(String messageText) {
        try {
            ServerMessage serverMessage = new ServerMessage(messageText, null);
            builder.setPrettyPrinting();
            dataOutputStream.writeUTF(gson.toJson(serverMessage));
            dataOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void sendResponse(String messageText, Object additionalObject) {
        try {
            ServerMessage serverMessage = new ServerMessage(messageText, gson.toJson(additionalObject));
            dataOutputStream.writeUTF(gson.toJson(serverMessage));
            dataOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}