package com.example.escrowapp.model;
public class ServiceRequest {
    private String clientName;
    private String description;
    private double amount;
    private boolean isCompany;

    public ServiceRequest(String clientName, String description, double amount, boolean isCompany) {
        this.clientName = clientName;
        this.description = description;
        this.amount = amount;
        this.isCompany = isCompany;
    }

    public String getClientName() { return clientName; }
    public String getDescription() { return description; }
    public double getAmount() { return amount; }
    public boolean isCompany() { return isCompany; }
}

