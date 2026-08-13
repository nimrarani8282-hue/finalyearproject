package com.example.escrowapp;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.escrowapp.adapter.AdminTransactionAdapter;
import com.example.escrowapp.model.AdminTransaction;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.List;

public class EscrowHoldingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escrow_holdings);

        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        toolbar.setNavigationOnClickListener(v -> finish());

        List<AdminTransaction> holdings = new ArrayList<>();
        holdings.add(new AdminTransaction("#ESC-90744", "Jacob S.", 850.00, AdminTransaction.Status.SECURED));
        holdings.add(new AdminTransaction("#ESC-90599", "Fatima A.", 15200.00, AdminTransaction.Status.SECURED));
        holdings.add(new AdminTransaction("#ESC-90512", "Chris B.", 2400.00, AdminTransaction.Status.SECURED));
        holdings.add(new AdminTransaction("#ESC-90765", "Elena R.", 4200.00, AdminTransaction.Status.VERIFICATION));

        RecyclerView rv = findViewById(R.id.rvHoldings);
        rv.setLayoutManager(new LinearLayoutManager(this));
        List<AdminTransaction> list = new ArrayList<>();
        new AdminTransactionAdapter(list);
    }
}
