package com.ap.gwentgame.server;

import com.ap.gwentgame.client.model.User;

import java.util.ArrayList;

public class Database {
    private static ArrayList<User> users = new ArrayList<>();

    public static User findUserByUsername(String username){
        for(User user : users){
            if(user.getName().equals(username)){
                return user;
            }
        }
        return null;
    }

    public static User findUserByNickname(String nickname){
        for(User user : users){
            if(user.getNickName().equals(nickname)){
                return user;
            }
        }
        return null;
    }

    public static User findUserByEmail(String email){
        for(User user : users){
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }

    public static void addUser(User user){
        users.add(user);
    }
}
