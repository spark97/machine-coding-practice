package com.machine.coding.splitwise.model;

import java.util.ArrayList;
import java.util.List;

public class EqualSplitExpense extends Expense {

    public EqualSplitExpense(String paidBy, Double totalAmount, List<String> users, ExpenseType expenseType, List<Double> amounts) {
        super(paidBy, totalAmount, users, expenseType, amounts);
    }

    @Override
    public void validate() throws Exception {

    }

    @Override
    public List<Double> getFinalAmounts() {
        List<Double> finalAmountList = new ArrayList<>();
        for(int i=0; i<this.getUsers().size(); i++){
            finalAmountList.add(this.getTotalAmount()/this.getUsers().size());
        }
        return finalAmountList;
    }
}
