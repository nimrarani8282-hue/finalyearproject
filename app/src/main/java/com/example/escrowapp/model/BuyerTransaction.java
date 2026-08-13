package com.example.escrowapp.model;


public class BuyerTransaction {

    public enum Status { SECURED, RELEASED, DISPUTED }

    private String title;
    private String counterparty;
    private String date;
    private double amount;
    private Status status;

    public BuyerTransaction(String title, String counterparty, String date, double amount, Status status) {
        this.title = title;
        this.counterparty = counterparty;
        this.date = date;
        this.amount = amount;
        this.status = status;
    }

    public String getTitle() { return title; }
    public String getCounterparty() { return counterparty; }
    public String getDate() { return date; }
    public double getAmount() { return amount; }
    public Status getStatus() { return status; }
}



