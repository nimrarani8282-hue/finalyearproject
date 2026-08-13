package com.example.escrowapp;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.escrowapp.R;
import com.google.android.material.appbar.MaterialToolbar;

public class DeliverySubmitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_submit);

        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        toolbar.setNavigationOnClickListener(v -> finish());

        findViewById(R.id.btnChooseFile).setOnClickListener(v ->
                Toast.makeText(this, "Open file picker", Toast.LENGTH_SHORT).show());

        findViewById(R.id.btnConfirmSubmit).setOnClickListener(v -> {
            Toast.makeText(this, "Delivery submitted to buyer", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}

