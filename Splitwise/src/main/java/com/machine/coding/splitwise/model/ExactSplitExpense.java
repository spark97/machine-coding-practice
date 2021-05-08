package com.machine.coding.splitwise.model;

import java.util.ArrayList;
import java.util.List;

public class ExactSplitExpense extends Expense {

    public ExactSplitExpense(String paidBy, Double totalAmount, List<String> users, ExpenseType expenseType, List<Double> amounts) {
        super(paidBy, totalAmount, users, expenseType, amounts);
    }

    @Override
    public void validate() throws Exception {
        List<Double> finalAmounts = this.getAmounts();
        Double sum = 0.0;
        for(Double percent : finalAmounts){
            sum+=percent;
        }
        if(sum.doubleValue()!=this.getTotalAmount().doubleValue())
            throw new Exception("Individual amount doesn't add upto total amount " + sum + " " + this.getTotalAmount());
    }

    @Override
    public List<Double> getFinalAmounts() {
        List<Double> finalAmountList = new ArrayList<>();
        for(int i=0; i<this.getUsers().size(); i++){
            finalAmountList.add(this.getAmounts().get(i));
        }
        return finalAmountList;
    }
}
