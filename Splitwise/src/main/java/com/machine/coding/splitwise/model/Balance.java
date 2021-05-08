package com.machine.coding.splitwise.model;

public class Balance {

    private String u1;

    private String u2;

    private Double amount;

    public Balance(String u1, String u2, Double amount) {
        this.u1 = u1;
        this.u2 = u2;
        this.amount = amount;
    }

    public String getU1() {
        return u1;
    }

    public void setU1(String u1) {
        this.u1 = u1;
    }

    public String getU2() {
        return u2;
    }

    public void setU2(String u2) {
        this.u2 = u2;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
