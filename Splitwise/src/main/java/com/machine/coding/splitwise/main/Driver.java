package com.machine.coding.splitwise.main;

import com.machine.coding.splitwise.model.*;
import com.machine.coding.splitwise.service.BalanceService;
import com.machine.coding.splitwise.service.ExpenseService;
import com.machine.coding.splitwise.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class Driver {

    public static void main(String[] args) throws Exception {

        ExpenseService expenseService = ExpenseService.getInstance();
        UserService userService = UserService.getInstance();
        BalanceService balanceService = BalanceService.getInstance();

        userService.addUser(new User("u1", "user1"));
        userService.addUser(new User("u2", "user2"));
        userService.addUser(new User("u3", "user3"));
        userService.addUser(new User("u4", "user4"));

        System.out.println("Showing all balances");
        print(balanceService.getBalance());
        System.out.println("Showing balances for u1");
        print(balanceService.getBalance("u1"));

        System.out.println("Add expense");
        List<String> users = new ArrayList<>();
        users.add("u1");
        users.add("u2");
        users.add("u3");
        users.add("u4");
        Expense expense = new EqualSplitExpense("u1", 1000.0, users, ExpenseType.EQUAL, null);
        expenseService.addExpense(expense);

        System.out.println("Showing balances for u4");
        print(balanceService.getBalance("u4"));
        System.out.println("Showing balances for u1");
        print(balanceService.getBalance("u1"));

        System.out.println("Add expense");
        List<String> users1 = new ArrayList<>();
        users1.add("u2");
        users1.add("u3");
        List<Double> amounts = new ArrayList<>();
        amounts.add(370.0);
        amounts.add(880.0);
        Expense expense2 = new ExactSplitExpense("u1", 1250.0, users1, ExpenseType.EXACT, amounts);
        expenseService.addExpense(expense2);

        System.out.println("Showing all balances");
        print(balanceService.getBalance());

        System.out.println("Add expense");
        List<String> users2 = new ArrayList<>();
        users2.add("u1");
        users2.add("u2");
        users2.add("u3");
        users2.add("u4");
        List<Double> amounts2 = new ArrayList<>();
        amounts2.add(40.0);
        amounts2.add(20.0);
        amounts2.add(20.0);
        amounts2.add(20.0);
        Expense expense3 = new PercentSplitExpense("u4", 1200.0, users2, ExpenseType.PERCENT, amounts2);
        expenseService.addExpense(expense3);

        System.out.println("Showing balances for u1");
        print(balanceService.getBalance("u1"));
        System.out.println("Showing all balances");
        print(balanceService.getBalance());

    }

    private static void print(List<Balance> balances){
        for(Balance balance : balances){
            if(balance.getAmount()==0)
                continue;
            if(balance.getAmount()>0)
                System.out.println(balance.getU2() + " owes " + balance.getU1() + " Rs " + balance.getAmount());
            else
                System.out.println(balance.getU1() + " owes " + balance.getU2() + " Rs " + -1*balance.getAmount());
        }
    }

}
