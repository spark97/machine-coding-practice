package com.machine.coding.splitwise.model;

import java.util.List;

public abstract class Expense {

    private String paidBy;

    private Double totalAmount;

    private List<String> users;

    private ExpenseType expenseType;

    private List<Double> amounts;

    public Expense(String paidBy, Double totalAmount, List<String> users, ExpenseType expenseType, List<Double> amounts) {
        this.paidBy = paidBy;
        this.totalAmount = totalAmount;
        this.users = users;
        this.expenseType = expenseType;
        this.amounts = amounts;
    }

    public abstract void validate() throws Exception;

    public abstract List<Double> getFinalAmounts();

    public String getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(String paidBy) {
        this.paidBy = paidBy;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }

    public List<Double> getAmounts() {
        return amounts;
    }

    public void setAmounts(List<Double> amounts) {
        this.amounts = amounts;
    }
}
