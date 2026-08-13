package com.example.escrowapp;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.OnBackPressedCallback;

public class SellerDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_dashboard);

        initializeViews();
        setupBackNavigation();
    }

    private void initializeViews() {
        // Earnings Card Buttons
        Button btnWithdraw = findViewById(R.id.btnWithdraw);
        Button btnViewHistory = findViewById(R.id.btnViewHistory);

        if (btnWithdraw != null) {
            btnWithdraw.setOnClickListener(v -> onWithdrawFunds());
        }

        if (btnViewHistory != null) {
            btnViewHistory.setOnClickListener(v -> onViewHistory());
        }

        // Quick Action Buttons
        LinearLayout btnViewRequests = findViewById(R.id.btnViewRequests);
        LinearLayout btnReviews = findViewById(R.id.btnReviews);

        if (btnViewRequests != null) {
            btnViewRequests.setOnClickListener(v -> onViewRequests());
        }

        if (btnReviews != null) {
            btnReviews.setOnClickListener(v -> onViewReviews());
        }

        // Delivery Action Buttons
        TextView btnShipNow1 = findViewById(R.id.btnShipNow1);
        TextView btnTrack2 = findViewById(R.id.btnTrack2);
        TextView btnConfirm3 = findViewById(R.id.btnConfirm3);

        if (btnShipNow1 != null) {
            btnShipNow1.setOnClickListener(v -> onShipNow("Order #9921", "$499.00"));
        }

        if (btnTrack2 != null) {
            btnTrack2.setOnClickListener(v -> onTrackOrder("Order #9855"));
        }

        if (btnConfirm3 != null) {
            btnConfirm3.setOnClickListener(v -> onConfirmPickup("Order #9712"));
        }

        // Notifications Button
        Button btnNotifications = findViewById(R.id.btnNotifications);
        if (btnNotifications != null) {
            btnNotifications.setOnClickListener(v -> onNotificationsClicked());
        }

        // Bottom Navigation
        Button btnDashboard = findViewById(R.id.btnNavDashboard);
        Button btnTransactions = findViewById(R.id.btnNavTransactions);
        Button btnSettings = findViewById(R.id.btnNavSettings);

        if (btnDashboard != null) {
            btnDashboard.setOnClickListener(v -> onNavDashboard());
        }

        if (btnTransactions != null) {
            btnTransactions.setOnClickListener(v -> onNavTransactions());
        }

        if (btnSettings != null) {
            btnSettings.setOnClickListener(v -> onNavSettings());
        }

        // FAB Button
        Button fabAdd = findViewById(R.id.fabAdd);
        if (fabAdd != null) {
            fabAdd.setOnClickListener(v -> onFabClicked());
        }
    }

    private void setupBackNavigation() {
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
            }
        };
        getOnBackPressedDispatcher().addCallback(this, callback);
    }

    private void onWithdrawFunds() {
        Toast.makeText(this, "Withdraw Funds - Coming Soon", Toast.LENGTH_SHORT).show();
    }

    private void onViewHistory() {
        Toast.makeText(this, "View Withdrawal History", Toast.LENGTH_SHORT).show();
    }

    private void onViewRequests() {
        Toast.makeText(this, "View All Service Requests", Toast.LENGTH_SHORT).show();
    }

    private void onViewReviews() {
        Toast.makeText(this, "View All Reviews", Toast.LENGTH_SHORT).show();
    }

    private void onShipNow(String order, String amount) {
        Toast.makeText(this, "Ship Now: " + order + " (" + amount + ")", Toast.LENGTH_SHORT).show();
    }

    private void onTrackOrder(String order) {
        Toast.makeText(this, "Track Order: " + order, Toast.LENGTH_SHORT).show();
    }

    private void onConfirmPickup(String order) {
        Toast.makeText(this, "Confirm Pickup: " + order, Toast.LENGTH_SHORT).show();
    }

    private void onNotificationsClicked() {
        Toast.makeText(this, "Notifications", Toast.LENGTH_SHORT).show();
    }

    private void onNavDashboard() {
        // Already on dashboard
    }

    private void onNavTransactions() {
        Toast.makeText(this, "View Transactions", Toast.LENGTH_SHORT).show();
    }

    private void onNavSettings() {
        Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
    }

    private void onFabClicked() {
        Toast.makeText(this, "Add New Item", Toast.LENGTH_SHORT).show();
    }
}


