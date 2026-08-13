package com.example.escrowapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.escrowapp.R;
import com.example.escrowapp.adapter.AdminTransactionAdapter;
import com.example.escrowapp.model.AdminTransaction;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class AdminDashboardActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        drawerLayout = findViewById(R.id.drawerLayout);

        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        if (toolbar != null) {
            toolbar.setNavigationOnClickListener(v -> {
                if (drawerLayout != null) {
                    drawerLayout.open();
                }
            });
        }

        setupCriticalIssues();
        setupDrawer();
    }

    private void setupCriticalIssues() {
        try {
            List<AdminTransaction> issues = new ArrayList<>();
            issues.add(new AdminTransaction("#ESC-90812", "Marcus T.", 12500.00, AdminTransaction.Status.DISPUTED));
            issues.add(new AdminTransaction("#ESC-90765", "Elena R.", 4200.00, AdminTransaction.Status.VERIFICATION));
            issues.add(new AdminTransaction("#ESC-90744", "Jacob S.", 850.00, AdminTransaction.Status.SECURED));

            RecyclerView rv = findViewById(R.id.rvCriticalIssues);
            if (rv != null) {
                rv.setLayoutManager(new LinearLayoutManager(this));
                rv.setAdapter(new AdminTransactionAdapter(issues));
            }

            // View All Disputes
            try {
                findViewById(R.id.btnViewAllDisputes).setOnClickListener(v ->
                        startActivity(new Intent(this, DisputesActivity.class)));
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Flagged Accounts
            try {
                findViewById(R.id.rowFlaggedAccounts).setOnClickListener(v ->
                        startActivity(new Intent(this, UsersActivity.class)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setupDrawer() {
        try {
            NavigationView navigationView = findViewById(R.id.navigationView);
            if (navigationView != null) {
                navigationView.setCheckedItem(R.id.nav_admin_dashboard);
                navigationView.setNavigationItemSelectedListener(item -> {
                    if (drawerLayout != null) {
                        drawerLayout.close();
                    }
                    int id = item.getItemId();
                    if (id == R.id.nav_admin_dashboard) {
                        return true;
                    } else if (id == R.id.nav_admin_payments) {
                        startActivity(new Intent(this, PaymentsActivity.class));
                        return true;
                    } else if (id == R.id.nav_admin_escrow_holdings) {
                        startActivity(new Intent(this, EscrowHoldingsActivity.class));
                        return true;
                    } else if (id == R.id.nav_admin_disputes) {
                        startActivity(new Intent(this, DisputesActivity.class));
                        return true;
                    } else if (id == R.id.nav_admin_users) {
                        startActivity(new Intent(this, UsersActivity.class));
                        return true;
                    } else if (id == R.id.nav_admin_reports) {
                        startActivity(new Intent(this, ReportsActivity.class));
                        return true;
                    } else if (id == R.id.nav_admin_settings) {
                        startActivity(new Intent(this, AdminSettingActivity.class));
                        return true;
                    } else if (id == R.id.nav_admin_logout) {
                        Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show();
                        return true;
                    }
                    return false;
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout != null && drawerLayout.isOpen()) {
            drawerLayout.close();
        } else {
            super.onBackPressed();
        }
    }
}