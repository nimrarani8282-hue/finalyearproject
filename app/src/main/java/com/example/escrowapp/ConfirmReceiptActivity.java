package com.example.escrowapp;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.escrowapp.R;
import com.google.android.material.appbar.MaterialToolbar;

public class ConfirmReceiptActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_receipt);

        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        toolbar.setNavigationOnClickListener(v -> finish());

        findViewById(R.id.btnConfirmItem1).setOnClickListener(v ->
                Toast.makeText(this, "Funds released for Order #8829", Toast.LENGTH_SHORT).show());

        findViewById(R.id.btnConfirmItem2).setOnClickListener(v ->
                Toast.makeText(this, "Funds released for Order #9012", Toast.LENGTH_SHORT).show());
    }
}
