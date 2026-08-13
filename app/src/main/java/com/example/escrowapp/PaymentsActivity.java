package com.example.escrowapp;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.escrowapp.R;
import com.escrowapp.adapter.AdminTransactionAdapter;
import com.escrowapp.model.AdminTransaction;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.List;

public class PaymentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments);

        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        toolbar.setNavigationOnClickListener(v -> finish());

        List<AdminTransaction> payments = new ArrayList<>();
        payments.add(new AdminTransaction("#ESC-90765", "Elena R.", 4200.00, AdminTransaction.Status.VERIFICATION));
        payments.add(new AdminTransaction("#ESC-90701", "Daniel K.", 980.00, AdminTransaction.Status.VERIFICATION));
        payments.add(new AdminTransaction("#ESC-90688", "Priya M.", 3150.00, AdminTransaction.Status.VERIFICATION));
        payments.add(new AdminTransaction("#ESC-90744", "Jacob S.", 850.00, AdminTransaction.Status.SECURED));

        RecyclerView rv = findViewById(R.id.rvPayments);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new AdminTransactionAdapter(payments));
    }
}

