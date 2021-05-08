package com.machine.coding.snl.model;

import java.util.HashMap;
import java.util.jar.JarEntry;

public class Board {

    private HashMap<Integer, Snake> snakes;

    private HashMap<Integer, Ladder> ladders;

    public Board() {
        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();
    }

    public void addSnake(int head, int tail){
        Snake snake = new Snake(head, tail);
        snakes.put(head, snake);
    }

    public void addLadder(int bottom, int top){
        Ladder ladder = new Ladder(top, bottom);
        ladders.put(bottom, ladder);
    }

    public HashMap<Integer, Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(HashMap<Integer, Snake> snakes) {
        this.snakes = snakes;
    }

    public HashMap<Integer, Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(HashMap<Integer, Ladder> ladders) {
        this.ladders = ladders;
    }
}
