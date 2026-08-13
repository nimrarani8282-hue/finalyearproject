package com.example.escrowapp;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.escrowapp.adapter.AdminUserAdapter;
import com.example.escrowapp.model.AdminUser;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.List;

public class UsersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        toolbar.setNavigationOnClickListener(v -> finish());

        List<AdminUser> users = new ArrayList<>();
        users.add(new AdminUser("Jeremy Stone", "Support Staff • Online", false));
        users.add(new AdminUser("Marcus T.", "Buyer • Joined Oct 2023", false));
        users.add(new AdminUser("Elena R.", "Seller • Joined Sep 2023", false));
        users.add(new AdminUser("Ray Fenton", "Buyer • Multiple disputes filed", true));
        users.add(new AdminUser("Nina Okafor", "Seller • Suspicious payout pattern", true));

        RecyclerView rv = findViewById(R.id.rvUsers);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new AdminUserAdapter(users));
    }
}

