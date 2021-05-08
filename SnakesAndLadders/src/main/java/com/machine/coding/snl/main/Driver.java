package com.machine.coding.snl.main;

import com.machine.coding.snl.model.Board;
import com.machine.coding.snl.model.Player;

import java.util.ArrayList;
import java.util.List;

public class Driver {

    public static void main(String[] args) {

        Board board = new Board();

        board.addSnake(62,5);
        board.addSnake(33,6);
        board.addSnake(49,9);
        board.addSnake(88,16);
        board.addSnake(41,20);
        board.addSnake(56,53);
        board.addSnake(98,64);
        board.addSnake(93,73);
        board.addSnake(95,75);

        board.addLadder(2,37);
        board.addLadder(27,46);
        board.addLadder(10,32);
        board.addLadder(51,68);
        board.addLadder(61,79);
        board.addLadder(65,84);
        board.addLadder(71,91);
        board.addLadder(81,100);

        List<Player> playerList = new ArrayList<>();
        Player player = new Player("Gaurav", 0);
        playerList.add(player);
        player = new Player("Sagar", 0);
        playerList.add(player);

        SnakesAndLadders snakesAndLadders = new SnakesAndLadders(playerList, board);
        snakesAndLadders.playGame();

    }

}
