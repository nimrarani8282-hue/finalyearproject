package com.example.escrowapp;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.escrowapp.R;
import com.example.escrowapp.adapter.TransactionAdapter;
import com.example.escrowapp.model.Transaction;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.List;

public class TransactionHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_history);

        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        toolbar.setNavigationOnClickListener(v -> finish());

        List<Transaction> all = new ArrayList<>();
        all.add(new Transaction("Web Design Package", 3400.00, "Jul 08, 2026", "COMPLETED"));
        all.add(new Transaction("SEO Consulting", 800.00, "Jul 05, 2026", "COMPLETED"));
        all.add(new Transaction("Logo Design System", 1200.00, "Jun 28, 2026", "COMPLETED"));
        all.add(new Transaction("Web Audit Service", 450.00, "Jun 20, 2026", "COMPLETED"));
        all.add(new Transaction("Brand Strategy Session", 950.00, "Jun 12, 2026", "COMPLETED"));
        all.add(new Transaction("Mobile App UI Kit", 2100.00, "Jun 02, 2026", "COMPLETED"));

        RecyclerView rv = findViewById(R.id.rvAllTransactions);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rv.setAdapter(new TransactionAdapter(all));
    }
}
