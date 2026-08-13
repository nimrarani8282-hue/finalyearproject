package com.example.escrowapp;
import com.example.escrowapp.R;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.escrowapp.R;
import com.example.escrowapp.adapter.BuyerTransactionAdapter;
import com.example.escrowapp.model.BuyerTransaction;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class BuyerDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyerdashboard);

        setupQuickActions();
        setupTransactionHistory();
        setupBottomNav();
    }

    private void setupQuickActions() {
        findViewById(R.id.cardCreateTransaction).setOnClickListener(v ->
                startActivity(new Intent(this, CreateTransactionActivity.class)));

        findViewById(R.id.cardPaymentSubmission).setOnClickListener(v ->
                startActivity(new Intent(this, PaymentSubmissionActivity.class)));

        findViewById(R.id.cardServiceRequest).setOnClickListener(v ->
                startActivity(new Intent(this, BuyerServiceRequest.class)));

        findViewById(R.id.cardConfirmReceipt).setOnClickListener(v ->
                startActivity(new Intent(this, ConfirmReceiptActivity.class)));

        findViewById(R.id.cardReviewFeedback).setOnClickListener(v ->
                startActivity(new Intent(this, ReviewFeedbackActivity.class)));

        findViewById(R.id.cardReportIssue).setOnClickListener(v ->
                startActivity(new Intent(this, ReportIssueActivity.class)));
    }

    private void setupTransactionHistory() {
        List<BuyerTransaction> recent = new ArrayList<>();
        recent.add(new BuyerTransaction("MacBook Pro M3 - Order #8829", "Seller: TechPioneer Ltd",
                "Oct 24, 2023", 2499.00, BuyerTransaction.Status.SECURED));
        recent.add(new BuyerTransaction("UI Design Refresh - Contract #441", "Freelancer: Alex Rivera",
                "Oct 21, 2023", 850.00, BuyerTransaction.Status.RELEASED));
        recent.add(new BuyerTransaction("Vintage Watch - Order #9012", "Seller: ClassicTime Pieces",
                "Oct 18, 2023", 1200.00, BuyerTransaction.Status.DISPUTED));

        RecyclerView rv = findViewById(R.id.rvBuyerTransactions);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new BuyerTransactionAdapter(recent));

        findViewById(R.id.btnViewAllBuyerTransactions).setOnClickListener(v ->
                startActivity(new Intent(this, TransactionHistoryActivity.class)));
    }

    private void setupBottomNav() {
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setSelectedItemId(R.id.nav_home);
        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                return true;
            } else if (id == R.id.nav_transactions) {
                startActivity(new Intent(this, TransactionHistoryActivity.class));
                return true;
            } else if (id == R.id.nav_wallet) {
                startActivity(new Intent(this, WalletActivity.class));
                return true;
            } else if (id == R.id.nav_profile) {
                startActivity(new Intent(this, ProfileActivity.class));
                return true;
            }
            return false;
        });
    }
}