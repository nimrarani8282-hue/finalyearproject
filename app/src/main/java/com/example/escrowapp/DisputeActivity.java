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

public class DisputesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disputes);

        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        toolbar.setNavigationOnClickListener(v -> finish());

        List<AdminTransaction> disputes = new ArrayList<>();
        disputes.add(new AdminTransaction("#ESC-90812", "Marcus T.", 12500.00, AdminTransaction.Status.DISPUTED));
        disputes.add(new AdminTransaction("#ESC-90390", "Grace L.", 670.00, AdminTransaction.Status.DISPUTED));
        disputes.add(new AdminTransaction("#ESC-90201", "Tom H.", 2900.00, AdminTransaction.Status.DISPUTED));

        RecyclerView rv = findViewById(R.id.rvAllDisputes);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new AdminTransactionAdapter(disputes));
    }
}

