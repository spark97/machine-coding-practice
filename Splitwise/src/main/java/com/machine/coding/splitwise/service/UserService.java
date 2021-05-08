package com.machine.coding.splitwise.service;

import com.machine.coding.splitwise.model.User;

import java.util.HashMap;

public class UserService {

    private static UserService instance;

    private HashMap<String, User> users;

    private UserService(){
        users = new HashMap<>();
    }

    public static UserService getInstance(){
        if(instance == null)
            instance = new UserService();
        return instance;
    }

    public void addUser(User user){
        String id = user.getId();
        users.put(id, user);
    }

    public User getUser(String id){
        return users.get(id);
    }

    public HashMap<String, User> getUsers() {
        return users;
    }

    public void setUsers(HashMap<String, User> users) {
        this.users = users;
    }
}
