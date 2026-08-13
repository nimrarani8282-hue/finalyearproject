package com.example.escrowapp.model;
public class AdminTransaction {

    public enum Status { DISPUTED, VERIFICATION, SECURED }

    private String transactionId;
    private String userName;
    private double value;
    private Status status;

    public AdminTransaction(String transactionId, String userName, double value, Status status) {
        this.transactionId = transactionId;
        this.userName = userName;
        this.value = value;
        this.status = status;
    }

    public String getTransactionId() { return transactionId; }
    public String getUserName() { return userName; }
    public double getValue() { return value; }
    public Status getStatus() { return status; }
}

