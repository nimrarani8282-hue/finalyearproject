package com.example.escrowapp;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.escrowapp.R;
import com.google.android.material.appbar.MaterialToolbar;

public class CreateTransactionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_transaction);

        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        toolbar.setNavigationOnClickListener(v -> finish());

        EditText etSeller = findViewById(R.id.etSeller);
        EditText etDescription = findViewById(R.id.etDescription);
        EditText etAmount = findViewById(R.id.etAmount);

        findViewById(R.id.btnCreateTransactionConfirm).setOnClickListener(v -> {
            if (etSeller.getText().toString().trim().isEmpty()
                    || etAmount.getText().toString().trim().isEmpty()) {
                Toast.makeText(this, "Seller aur Amount fill karein", Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(this, "Secure escrow transaction created", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}