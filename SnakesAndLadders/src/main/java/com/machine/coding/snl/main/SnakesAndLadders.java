package com.machine.coding.snl.main;

import com.machine.coding.snl.model.Board;
import com.machine.coding.snl.model.Ladder;
import com.machine.coding.snl.model.Player;
import com.machine.coding.snl.model.Snake;

import java.util.List;
import java.util.Random;

public class SnakesAndLadders {

    private List<Player> players;

    private Board board;

    public SnakesAndLadders(List<Player> players, Board board) {
        this.players = players;
        this.board = board;
    }

    public void playGame(){
        Random random = new Random();
        boolean win = false;
        while(!win){
            for(Player player : players){
                int diceValue = random.nextInt(6)+1;
                int currPosition = player.getCurrPos();
                int newPosition = currPosition + diceValue;
               if(isSnakeHead(newPosition)){
                    Snake snake = board.getSnakes().get(newPosition);
                    newPosition = snake.getTail();
                    player.setCurrPos(newPosition);
                }else if(isLadderBottom(newPosition)){
                    Ladder ladder = board.getLadders().get(newPosition);
                    newPosition = ladder.getTop();
                    player.setCurrPos(newPosition);
                }else{
                    newPosition = newPosition>100?currPosition:newPosition;
                    player.setCurrPos(newPosition);
                }
               printMovement(player, diceValue, currPosition, newPosition);
               if(newPosition==100){
                   printWin(player);
                   win = true;
                   break;
               }
            }
        }
    }

    private void printWin(Player player){
        System.out.println(player.getName() + " wins the game.");
    }

    private void printMovement(Player player, int diceValue, int currPosition, int newPosition){
        System.out.println(player.getName() + " rolled a " + diceValue + " and moved from " + currPosition + " to " + newPosition);
    }

    private boolean isSnakeHead(int position){
        if(board.getSnakes().containsKey(position))
            return true;
        return false;
    }

    private boolean isLadderBottom(int position){
        if(board.getLadders().containsKey(position))
            return true;
        return false;
    }



}
