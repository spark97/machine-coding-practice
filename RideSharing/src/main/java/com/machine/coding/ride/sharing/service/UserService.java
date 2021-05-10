package com.machine.coding.ride.sharing.service;

import com.machine.coding.ride.sharing.model.User;
import com.machine.coding.ride.sharing.model.Vehicle;

import java.util.HashMap;

public class UserService {

    private HashMap<String, User> users;

    private static UserService instance;

    private UserService(){
        this.users = new HashMap<>();
    }

    public static UserService getInstance(){
        if(instance == null)
            instance = new UserService();
        return instance;
    }

    public void addUser(User user){
        this.users.put(user.getId(), user);
    }

    public User getUser(String id){
        return this.users.get(id);
    }

    public HashMap<String, User> getUsers(){
        return this.users;
    }


}
