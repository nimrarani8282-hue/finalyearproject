package com.example.escrowapp;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.escrowapp.model.BuyerTransaction;
import com.example.escrowapp.adapter.BuyerTransactionAdapter;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.List;

public class BuyerTransactionHistory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer_transaction_history);

        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        toolbar.setNavigationOnClickListener(v -> finish());

        List<BuyerTransaction> all = new ArrayList<>();
        all.add(new BuyerTransaction("MacBook Pro M3 - Order #8829", "Seller: TechPioneer Ltd",
                "Oct 24, 2023", 2499.00, BuyerTransaction.Status.SECURED));
        all.add(new BuyerTransaction("UI Design Refresh - Contract #441", "Freelancer: Alex Rivera",
                "Oct 21, 2023", 850.00, BuyerTransaction.Status.RELEASED));
        all.add(new BuyerTransaction("Vintage Watch - Order #9012", "Seller: ClassicTime Pieces",
                "Oct 18, 2023", 1200.00, BuyerTransaction.Status.DISPUTED));
        all.add(new BuyerTransaction("Website SEO Audit - Contract #390", "Freelancer: Nadia Khan",
                "Oct 10, 2023", 450.00, BuyerTransaction.Status.RELEASED));
        all.add(new BuyerTransaction("Gaming Chair - Order #8770", "Seller: ComfortTech",
                "Oct 02, 2023", 320.00, BuyerTransaction.Status.RELEASED));

        RecyclerView rv = findViewById(R.id.rvAllBuyerTransactions);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new BuyerTransactionAdapter(all));
    }
}


