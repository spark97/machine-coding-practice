package com.machine.coding.snl.model;

public class Player {

    private String name;

    private int currPos ;

    public Player(String name, int currPos) {
        this.name = name;
        this.currPos = currPos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrPos() {
        return currPos;
    }

    public void setCurrPos(int currPos) {
        this.currPos = currPos;
    }
}
