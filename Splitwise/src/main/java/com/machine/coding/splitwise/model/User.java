package com.machine.coding.splitwise.model;

import java.util.HashMap;

public class User {

    private String id;

    private String name;

    private HashMap<String, Balance> owedBalance;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        owedBalance = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Balance> getOwedBalance() {
        return owedBalance;
    }

    public void setOwedBalance(HashMap<String, Balance> owedBalance) {
        this.owedBalance = owedBalance;
    }
}
