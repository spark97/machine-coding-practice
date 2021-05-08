package com.machine.coding.splitwise.service;

import com.machine.coding.splitwise.model.Balance;
import com.machine.coding.splitwise.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalanceService {

    private static BalanceService instance;

    private UserService userService;

    private BalanceService(){
        this.userService = UserService.getInstance();
    }

    public static BalanceService getInstance(){
        if(instance == null)
            instance = new BalanceService();
        return instance;
    }

    public List<Balance> getBalance(){
        HashMap<String, User> users = userService.getUsers();
        List<Balance> finalBalanceList = new ArrayList<>();
        for(Map.Entry<String, User> entry : users.entrySet()){
            finalBalanceList.addAll(getBalance(entry.getKey()));
        }
        return finalBalanceList;
    }

    public List<Balance> getBalance(String userId){
        User user = userService.getUser(userId);
        HashMap<String, User> users = userService.getUsers();
        List<Balance> finalBalanceList = new ArrayList<>();
        for(Map.Entry<String, User> entry : users.entrySet()){
            String key = entry.getKey();
            if(key.equals(userId))
                continue;
            Balance balance1 = user.getOwedBalance().getOrDefault(key, new Balance(userId, key, 0.0));
            Balance finalBalance = new Balance(userId, key, balance1.getAmount());
            finalBalanceList.add(finalBalance);
        }
        return finalBalanceList;
    }


}
