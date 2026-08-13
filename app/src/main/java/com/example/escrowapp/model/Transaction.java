package com.example.escrowapp.model;
public class Transaction {
    private String title;
    private double amount;
    private String date;
    private String status; // COMPLETED, PENDING, DISPUTED

    public Transaction(String title, double amount, String date, String status) {
        this.title = title;
        this.amount = amount;
        this.date = date;
        this.status = status;
    }

    public String getTitle() { return title; }
    public double getAmount() { return amount; }
    public String getDate() { return date; }
    public String getStatus() { return status; }
}

