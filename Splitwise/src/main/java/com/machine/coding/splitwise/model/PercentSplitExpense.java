package com.machine.coding.splitwise.model;

import java.util.ArrayList;
import java.util.List;

public class PercentSplitExpense extends Expense {

    public PercentSplitExpense(String paidBy, Double totalAmount, List<String> users, ExpenseType expenseType, List<Double> amounts) {
        super(paidBy, totalAmount, users, expenseType, amounts);
    }

    @Override
    public void validate() throws Exception {
        List<Double> finalAmounts = this.getAmounts();
        Double sum = 0.0;
        for(Double percent : finalAmounts){
            sum+=percent;
        }
        if(sum.doubleValue()!=100.0)
            throw new Exception("Sum of % doesn't add upto 100");
    }

    @Override
    public List<Double> getFinalAmounts() {
        List<Double> finalAmountList = new ArrayList<>();
        for(int i=0; i<this.getUsers().size(); i++){
            finalAmountList.add(this.getTotalAmount()*this.getAmounts().get(i)/100.0);
        }
        return finalAmountList;
    }
}
