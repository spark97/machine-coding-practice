package com.machine.coding.splitwise.service;

import com.machine.coding.splitwise.model.Balance;
import com.machine.coding.splitwise.model.Expense;

import java.util.ArrayList;
import java.util.List;

public class ExpenseService {

    private static ExpenseService instance;

    private List<Expense> expenses;

    private UserService userService;

    private ExpenseService(){
        expenses = new ArrayList<>();
        userService = UserService.getInstance();
    }

    public static ExpenseService getInstance(){
        if(instance == null)
            instance = new ExpenseService();
        return instance;
    }

    public void addExpense(Expense expense) throws Exception {
        expense.validate();
        expenses.add(expense);
        process(expense);
    }

    private void process(Expense expense){
        String paidBy = expense.getPaidBy();
        List<String> users = expense.getUsers();
        List<Double> finalAmounts = expense.getFinalAmounts();
        for(int i=0; i<users.size(); i++){
            if(users.get(i).equals(paidBy))
                continue;
            String owedUser = users.get(i);
            Double amount = finalAmounts.get(i);
            Balance currBalance = userService.getUser(paidBy).getOwedBalance().get(owedUser);
            if(currBalance == null){
                currBalance = new Balance(paidBy, owedUser, amount);
                userService.getUser(paidBy).getOwedBalance().put(owedUser, currBalance);
            }
            else
                currBalance.setAmount(currBalance.getAmount()+amount);

            currBalance = userService.getUser(owedUser).getOwedBalance().get(paidBy);
            if(currBalance == null){
                currBalance = new Balance(owedUser, paidBy, -1*amount);
                userService.getUser(owedUser).getOwedBalance().put(paidBy, currBalance);
            }
            else
                currBalance.setAmount(currBalance.getAmount()-amount);

        }
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
