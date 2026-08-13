package com.example.escrowapp;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.escrowapp.R;
import com.google.android.material.appbar.MaterialToolbar;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        toolbar.setNavigationOnClickListener(v -> finish());

        findViewById(R.id.rowEditProfile).setOnClickListener(v ->
                Toast.makeText(this, "Edit Profile", Toast.LENGTH_SHORT).show());

        findViewById(R.id.rowPaymentMethods).setOnClickListener(v ->
                Toast.makeText(this, "Payment Methods", Toast.LENGTH_SHORT).show());

        findViewById(R.id.rowSecurity).setOnClickListener(v ->
                Toast.makeText(this, "Security Settings", Toast.LENGTH_SHORT).show());

        findViewById(R.id.rowLogout).setOnClickListener(v ->
                Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show());
    }
}
